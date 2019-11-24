package controller;

import java.sql.Timestamp;

import dao.CardsDAO;
import dao.PassHistoryDAO;
import dto.CardsDTO;
import dto.PassHistoryDTO;
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

	public boolean checkBalance() {
		if(card.getBalance()>=Constants.MIN_BALANCE) return true;
		else return false;
	}

	public void getInStationCard(String stselect) {
		if(this.checkBalance()) {
			this.setEnterpoint(String.valueOf(stselect.charAt(2)));
			PassHistoryDTO ph = new PassHistoryDTO(this.getId(),this.getEnterpoint());
			PassHistoryDAO.insertPassHistory(ph);
			PassHistoryDTO ph2 = PassHistoryDAO.getInfo(this.getId(), this.getEnterpoint(), ph.getGetin_time());
			this.getCard().setLast_pass(ph2.getPass_id());
			CardsDAO.updateCard(this.getCard());
		}else {
			System.out.println("So du tai khoan khong du");
		}
	}
	public void getOutStationCard(String stselect) {
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
		}else {
			System.out.println("Khong du tien yeu cau nap them");
		}
	}
	
	public CardsDTO getCard() {
		return card;
	}

	public void setCard() {
		this.card = CardsDAO.getCardById(this.getId());
	}
}

