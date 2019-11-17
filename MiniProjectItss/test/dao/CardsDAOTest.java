package dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dto.CardsDTO;

public class CardsDAOTest {
	private CardsDTO card;
	@Before
	public void setUp() throws Exception {
		//arr = new ArrayList<CardsDTO>();
		//card = new CardsDTO();
	}

//	@Test
//	public void testGetAll() {
//		arr = CardsDAO.getAll();
//		assertArrayEquals(exp, arr);
//	}

	@Test
	public void testGetCardById() {
		card = CardsDAO.getCardById("cv34567er0abcdef");
		assertEquals("OK", "cv34567er0abcdef", card.getCard_id());
		
	}

//	@Test
//	public void testUpdateCard() {
//		CardsDAO.updateCard(card);
//	}

}
