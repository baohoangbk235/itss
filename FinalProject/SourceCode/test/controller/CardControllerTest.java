package controller;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CardControllerTest {

	@Test
	public void testCheckBalance() {
		CardController cardcontrol = new CardController("testcard00000000");
		assertEquals(true,cardcontrol.checkBalance());
	}

}
