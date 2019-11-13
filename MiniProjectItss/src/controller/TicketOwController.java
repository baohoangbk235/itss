package controller;

import java.util.List;
import dao.TicketOnewayDAO;
import dto.TicketOnewayDTO;

public class TicketOwController {

	public static List<TicketOnewayDTO> getAll(){
		return TicketOnewayDAO.getAll();
	}
}
