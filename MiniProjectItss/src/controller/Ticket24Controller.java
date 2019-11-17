package controller;
import dao.Ticket24hDAO;
import java.util.List;
import dto.Ticket24hDTO;
import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;

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
	
	public static void main(String[] args) throws ParseException {
		Ticket24hDAO a = new Ticket24hDAO();
		Ticket24hDTO b = a.getTk24ById("bab1246b02772bb0");
		Date date_now = new Date();
		System.out.println(Ticket24Controller.checkTimeValidity(b, date_now));
	}
}
