package controller;

import java.util.List;
import dao.Ticket24hDAO;
import dto.Ticket24hDTO;

public class Ticket24Controller {
	public static List<Ticket24hDTO> getAll(){
        return Ticket24hDAO.getAll();
    }
}
