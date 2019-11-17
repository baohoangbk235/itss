package controller;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import dao.Ticket24hDAO;
import dto.Ticket24hDTO;

public class Ticket24ControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Ticket24hDTO b = Ticket24hDAO.getTk24ById("bab1246b02772bb0");
		Date date_now = new Date();
		boolean result = Ticket24Controller.checkTimeValidity(b, date_now);
		assertEquals(result, false);
	}
}
