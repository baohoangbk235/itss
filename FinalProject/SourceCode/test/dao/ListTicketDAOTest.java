package dao;

import static org.junit.Assert.*;
import org.junit.Test;
import dto.ListTicketDTO;

public class ListTicketDAOTest {
	@Test
	public void testGetTicketType() {
		ListTicketDTO tk = ListTicketDAO.getTicketType("testticketoneway");
		assertEquals("ticketoneway",tk.getType());
	}

}
