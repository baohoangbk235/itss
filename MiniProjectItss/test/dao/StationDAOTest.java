package dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dto.StationDTO;

public class StationDAOTest {
	private StationDTO st;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStationById() {
		st = StationDAO.getStationById("a");
		StationDTO s = new StationDTO();
		s.setSt_id("a");
		s.setSt_name("Saint-Lazare");
		s.setDistance(0);
		assertEquals("OK", "a", st.getSt_id());
		assertEquals("OK", "Saint-Lazare", st.getSt_name());
		assertEquals(0, st.getDistance(),0);
		//assertEquals(s, st);
		}

}
