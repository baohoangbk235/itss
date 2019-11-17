package dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dto.Ticket24hDTO;

public class Ticket24hDAOTest {

	private Ticket24hDTO tk24;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetTk24ById() {
		tk24 = Ticket24hDAO.getTk24ById("bab1246b02772bb0");
		assertEquals("OK", "bab1246b02772bb0", tk24.getTk24_id());
	}

}
