package controller;

import java.sql.Timestamp;
import calculate.CalculateFarebyDistance;
import config.Constants;
import dao.CardsDAO;
import dao.PassHistoryDAO;
import dto.CardsDTO;
import dto.PassHistoryDTO;
import gui.Screen;

public class CardController extends MustChargeFareController {
	private CardsDTO card;

	public CardController(String id) {
		super();
		this.setId(id);
		this.card = CardsDAO.getCardById(this.getId());
	}

	/**
	 * Kiểm tra số dư trong thẻ có lớn hơn số dư tối thiểu hay không.
	 * @return true nếu không ít hơn, false nếu ngược lại.
	 */
	public boolean checkBalance() {
		if(card.getBalance()>=Constants.MIN_BALANCE) return true;
		else return false;
	}


	/**
	 * Ghi lại các thông tin của thẻ và nhà ga vào trong bảng
	 * passing_history khi hành khách đi vào.
	 * @param stselect id của nhà ga khi đi vào .
	 * @throws InterruptedException nếu có lỗi trong quá trình xử lý.
	 */
	public void getInStation(String stselect) {
		if(this.checkBalance()) {
			this.setEnterpoint(String.valueOf(stselect.charAt(2)));
			PassHistoryDTO ph = new PassHistoryDTO(this.getId(),this.getEnterpoint());
			PassHistoryDAO.insertPassHistory(ph);
			PassHistoryDTO ph2 = PassHistoryDAO.getInfo(this.getId(), this.getEnterpoint(), ph.getGetin_time());
			this.getCard().setLast_pass(ph2.getPass_id());
			CardsDAO.updateCard(this.getCard());
			try {
				Screen.printOpenMess("Prepaid card", this.getCard().getCard_id(), this.getCard().getBalance());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			Screen.printErrorMessCard(this.getCard().getCard_id(), this.getCard().getBalance());
		}
	}

	/**
	 * Tính toán phí của chuyến đi và ghi lại các thông tin của thẻ, nhà ga, phí của chuyến đi
	 * vào trong bảng passing_history khi hành khách đi ra.
	 * @param stselect id của nhà ga khi đi ra .
	 * @throws InterruptedException nếu có lỗi trong quá trình xử lý.
	 */
	public void getOutStation(String stselect) {
		PassHistoryDTO ph = PassHistoryDAO.getInfoByPassId(this.getCard().getLast_pass());
		this.setEnterpoint(ph.getGetin_point());
		this.setExitpoint(String.valueOf(stselect.charAt(2)));
		this.setFare(new CalculateFarebyDistance(this.getEnterpoint(), this.getExitpoint()));
		if(this.checkFare(this.getCard().getBalance())) {
			this.getCard().setBalance((this.getCard().getBalance()-this.getFare()));
			this.getCard().setLast_pass(0);
			ph.setFare(this.getFare());
			ph.setGetout_point(this.getExitpoint());
			ph.setGetout_time(new Timestamp(System.currentTimeMillis()));
			ph.setStatus(0);
			PassHistoryDAO.updatePassHistoryById(ph);
			CardsDAO.updateCard(this.getCard());
			try {
				Screen.printOpenMess("Prepaid card", this.getCard().getCard_id(), this.getCard().getBalance());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			Screen.printErrorMess("Prepaid card", this.getCard().getCard_id(), this.getCard().getBalance(), this.getFare());
		}
	}

	public CardsDTO getCard() {
		return card;
	}

	public void setCard() {
		this.card = CardsDAO.getCardById(this.getId());
	}
}

