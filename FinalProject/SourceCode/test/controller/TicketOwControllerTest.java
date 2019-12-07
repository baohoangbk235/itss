package controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TicketOwControllerTest {
	private static TicketOwController tkow;
	@Before
	public void setUp() throws Exception {
		tkow = new TicketOwController("testticketoneway");
	}

	@Test
	public void testCheckEnterStation() {
		assertEquals(false,tkow.checkEnterStation("i"));
	}

	@Test
	public void testCheckStatus() {
		assertEquals(false,tkow.checkStatus());
	}

}
