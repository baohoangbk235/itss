package calculate;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import config.Constants;

public class CalculateFarebyDistanceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCalculateDistance() {
		CalculateFarebyDistance cal = new CalculateFarebyDistance("a", "b");
		float actuals = cal.calculateDistance();
		assertEquals("OK", 10, actuals, 0);
	}

	@Test
	public void testCalculate() {
		CalculateFarebyDistance cal = new CalculateFarebyDistance("a", "b");
		float distance = cal.calculateDistance();
		float price = cal.calculate();
		if(distance <= Constants.BASE_DISTANCE) {
			assertEquals("OK", price, Constants.BASE_FARE, 0);
        } else {
            float temp = (distance - Constants.BASE_DISTANCE) % Constants.EXTRA_DISTANCE;
            int quotient = (int)((distance - Constants.BASE_DISTANCE) / Constants.EXTRA_DISTANCE);
            if (temp != 0) {
            	assertEquals("OK", price, Constants.BASE_FARE + (quotient + 1) * Constants.EXTRA_FARE, 0);
            } else {
            	assertEquals("OK", price, Constants.BASE_FARE + quotient * Constants.EXTRA_FARE, 0); 
            }
        }
	}
}
