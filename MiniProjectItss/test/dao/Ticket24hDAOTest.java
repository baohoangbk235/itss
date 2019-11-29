package dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import dto.Ticket24hDTO;

public class Ticket24hDAOTest {

	private Ticket24hDTO tk24;

	@Test
	public void testGetTk24ById() {
		tk24 = Ticket24hDAO.getTk24ById("testticket24h000");
		assertEquals("OK", "testticket24h000", tk24.getTk24_id());
	}
	
	@Test
	public void testUpdateTk24() {
		tk24 = Ticket24hDAO.getTk24ById("testticket24h000");
		tk24.setLast_pass(-1);
		Ticket24hDAO.updateTk24(tk24);
		Ticket24hDTO tk2 = Ticket24hDAO.getTk24ById("testticket24h000");
		assertEquals(-1, tk2.getLast_pass(),0);
	}

}
