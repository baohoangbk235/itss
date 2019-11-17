package controller;
import dao.Ticket24hDAO;
import java.util.List;
import dto.Ticket24hDTO;
import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Ticket24Controller {
	public static List<Ticket24hDTO> getAll(){
        return Ticket24hDAO.getAll();
    }
	public boolean checkTimeValidity(Ticket24hDTO ticket24h, Date date_now) {
		Timestamp timestamp1 = ticket24h.getReleased_time();
		Date realeasedDate = timestamp1;
		Timestamp timestamp2 = ticket24h.getValid_time();
		Date validDate = timestamp2;
		if (realeasedDate.getTime() <  date_now.getTime() && date_now.getTime() < validDate.getTime())
			return true;	
		return false;
	}
	
	public static void main(String[] args) throws ParseException {
		List<Ticket24hDTO> listTickets = Ticket24hDAO.getAll();
		java.util.Date inTime1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("05/23/2018 16:55:52");
		for(int i=0; i<listTickets.size(); i++) {
			System.out.println(listTickets.get(i).getTk24_id());
			if (listTickets.get(i).getValid_time() != null){
				Timestamp timestamp = listTickets.get(i).getValid_time();
				Date date = timestamp;
				if (inTime1.getTime() < date.getTime()) {
					System.out.println(date);
				}
			}	
			
		}
	}
}
