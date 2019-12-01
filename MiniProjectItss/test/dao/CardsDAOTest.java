package dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dto.CardsDTO;

public class CardsDAOTest {
	private CardsDTO card;
	@Before
	public void setUp() throws Exception {
		card = new CardsDTO();
	}

	@Test
	public void testGetCardById() {
		card = CardsDAO.getCardById("testcard00000000");
		assertEquals("OK", "testcard00000000", card.getCard_id());
		
	}

	@Test
	public void testUpdateCard() {
		card = CardsDAO.getCardById("testcard00000000");
		card.setBalance(10);
		CardsDAO.updateCard(card);
		CardsDTO card1 = CardsDAO.getCardById("testcard00000000");
		assertEquals("OK", card1.getBalance(), card.getBalance(), 0);
	}

}
