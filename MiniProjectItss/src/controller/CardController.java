package controller;

import java.text.ParseException;

import dao.CardsDAO;
import dto.CardsDTO;
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

	public CardsDTO getCard() {
		return card;
	}

	public void setCard() {
		this.card = CardsDAO.getCardById(this.getId());
	}
	public static void main(String[] args) throws ParseException {
		CardController c = new CardController();
		System.out.println(c.checkBalance(2.7, 5.6));
	}
}

