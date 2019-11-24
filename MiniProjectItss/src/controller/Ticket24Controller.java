package controller;
import java.sql.Timestamp;

import dao.PassHistoryDAO;
import dao.Ticket24hDAO;
import dto.PassHistoryDTO;
import dto.Ticket24hDTO;

public class Ticket24Controller extends ParentController {
	private Ticket24hDTO tk24;
	
	public Ticket24Controller(String id) {
		super();
		this.setId(id);
		this.tk24 = Ticket24hDAO.getTk24ById(this.getId());
	}

	public boolean checkTimeValidity() {
		
		Timestamp now = new Timestamp(System.currentTimeMillis());
		if (now.before(this.getTk24().getValid_time())) {
			return true;	
		}
		return false;
	}
	
	public void getInStationTk24(String stselect) {
		if(this.checkTimeValidity()) {
			this.setEnterpoint(String.valueOf(stselect.charAt(2)));
			PassHistoryDTO ph = new PassHistoryDTO(this.getId(),this.getEnterpoint());
			PassHistoryDAO.insertPassHistory(ph);
			PassHistoryDTO ph2 = PassHistoryDAO.getInfo(this.getId(), this.getEnterpoint(), ph.getGetin_time());
			this.getTk24().setLast_pass(ph2.getPass_id());
			Ticket24hDAO.updateTk24(this.getTk24());
		}else {
			System.out.println("Ve da qua thoi gian su dung");
		}
	}
	
	public void getOutStationTk24(String stselect) {
		PassHistoryDTO ph = PassHistoryDAO.getInfoByPassId(this.getTk24().getLast_pass());
		ph.setGetout_point(String.valueOf(stselect.charAt(2)));
		ph.setGetout_time(new Timestamp(System.currentTimeMillis()));
		ph.setStatus(0);
		PassHistoryDAO.updatePassHistoryById(ph);
		this.getTk24().setLast_pass(0);
		Ticket24hDAO.updateTk24(this.getTk24());
	}

	public Ticket24hDTO getTk24() {
		return tk24;
	}

	public void setTk24() {
		this.tk24 = Ticket24hDAO.getTk24ById(this.getId());
	}
	
}
