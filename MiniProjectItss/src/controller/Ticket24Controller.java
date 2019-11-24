package controller;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import dao.Ticket24hDAO;
import dto.Ticket24hDTO;

public class Ticket24Controller {
	public static List<Ticket24hDTO> getAll(){
        return Ticket24hDAO.getAll();
    }
	public static boolean checkTimeValidity(Ticket24hDTO ticket24h, Date date_now) {
		Timestamp timestamp1 = ticket24h.getReleased_time();
		Date realeasedDate = timestamp1;
		Timestamp timestamp2 = ticket24h.getValid_time();
		Date validDate = timestamp2;
		if (realeasedDate.getTime() <  date_now.getTime() && date_now.getTime() < validDate.getTime())
			return true;	
		return false;
	}
	
}
