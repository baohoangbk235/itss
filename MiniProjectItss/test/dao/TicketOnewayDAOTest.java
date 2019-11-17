package dao;

import static org.junit.Assert.*;

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
		tkow = TicketOnewayDAO.getTkowById("e8dc4081b13434b4");
		assertEquals("OK", "e8dc4081b13434b4", tkow.getTkow_id());
	}

}
