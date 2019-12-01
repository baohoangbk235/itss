package controller;

import java.sql.Timestamp;

import dao.CardsDAO;
import dao.PassHistoryDAO;
import dto.CardsDTO;
import dto.PassHistoryDTO;
import gui.Screen;
import util.Constants;

public class CardController extends ParentController {
	private CardsDTO card;

	public CardController() {
		super();
	}

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
	public void getInStationCard(String stselect) throws InterruptedException {
		if(this.checkBalance()) {
			this.setEnterpoint(String.valueOf(stselect.charAt(2)));
			PassHistoryDTO ph = new PassHistoryDTO(this.getId(),this.getEnterpoint());
			PassHistoryDAO.insertPassHistory(ph);
			PassHistoryDTO ph2 = PassHistoryDAO.getInfo(this.getId(), this.getEnterpoint(), ph.getGetin_time());
			this.getCard().setLast_pass(ph2.getPass_id());
			CardsDAO.updateCard(this.getCard());
			Screen.printOpenMess("Prepaid card", this.getCard().getCard_id(), this.getCard().getBalance());
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
	public void getOutStationCard(String stselect) throws InterruptedException {
		PassHistoryDTO ph = PassHistoryDAO.getInfoByPassId(this.getCard().getLast_pass());
		this.setEnterpoint(ph.getGetin_point());
		this.setExitpoint(String.valueOf(stselect.charAt(2)));

		double fare = this.caculateTripFare(this.caculateDistance());
		double balance = this.getCard().getBalance();

		if(this.checkBalance(fare,balance)) {
			this.getCard().setBalance((float)(balance-fare));
			this.getCard().setLast_pass(0);
			ph.setFare((float)fare);
			ph.setGetout_point(this.getExitpoint());
			ph.setGetout_time(new Timestamp(System.currentTimeMillis()));
			ph.setStatus(0);
			PassHistoryDAO.updatePassHistoryById(ph);
			CardsDAO.updateCard(this.getCard());
			Screen.printOpenMess("Prepaid card", this.getCard().getCard_id(), this.getCard().getBalance());
		}else {
			Screen.printErrorMess("Prepaid card", this.getCard().getCard_id(), this.getCard().getBalance(), (float) fare);
		}
	}

	public CardsDTO getCard() {
		return card;
	}

	public void setCard() {
		this.card = CardsDAO.getCardById(this.getId());
	}
}

