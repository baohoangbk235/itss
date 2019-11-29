package dao;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.List;
import org.junit.Test;
import dto.PassHistoryDTO;

public class PassHistoryDAOTest {
	private PassHistoryDTO ph;
	@Test
	public void testGetAll() {
		List<PassHistoryDTO> list = PassHistoryDAO.getAll();
		assertEquals("testpasshistory0",list.get(0).getId());
	}

	@Test
	public void testGetInfoById() {
		ph = PassHistoryDAO.getInfoById("testpasshistory0");
		assertEquals(0,ph.getPass_id());
	}

	@Test
	public void testGetInfoByPassId() {
		ph = PassHistoryDAO.getInfoByPassId(0);
		assertEquals("testpasshistory0",ph.getId());
	}

	@Test
	public void testGetInfo() {
		ph = PassHistoryDAO.getInfo("testpasshistory0", "a", new Timestamp(1574553600));
		assertEquals(0,ph.getPass_id());
	}

	@Test
	public void testUpdatePassHistoryById() {
		ph = PassHistoryDAO.getInfoByPassId(0);
		ph.setGetout_point("b");
		PassHistoryDAO.updatePassHistoryById(ph);
		PassHistoryDTO ph2 = PassHistoryDAO.getInfoByPassId(0);
		assertEquals("b",ph2.getGetout_point());
	}

}
