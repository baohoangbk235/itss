package controller;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class Ticket24ControllerTest {
	private static Ticket24Controller tk24;
	@Before
	public void setUp() throws Exception {
		tk24 = new Ticket24Controller("testticket24h000");
	}

	@Test
	public void test() {
		boolean result = tk24.checkTimeValidity();
		assertEquals(false,result);
	}
}
