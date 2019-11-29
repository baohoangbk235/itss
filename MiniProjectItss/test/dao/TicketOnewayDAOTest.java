package dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import dto.TicketOnewayDTO;

public class TicketOnewayDAOTest {
	private TicketOnewayDTO tkow;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetTkowById() {
		tkow = TicketOnewayDAO.getTkowById("testticketoneway");
		assertEquals("OK", "testticketoneway", tkow.getTkow_id());
	}

	@Test
	public void testUpdateTkow() {
		tkow = TicketOnewayDAO.getTkowById("testticketoneway");
		tkow.setStatus(false);
		TicketOnewayDAO.updateTkow(tkow);
		TicketOnewayDTO tk2 = TicketOnewayDAO.getTkowById("testticketoneway");
		assertEquals(false, tk2.getStatus());
	}
}
