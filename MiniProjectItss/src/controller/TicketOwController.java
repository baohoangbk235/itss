package controller;

import java.sql.Timestamp;

import dao.PassHistoryDAO;
import dao.StationDAO;
import dao.TicketOnewayDAO;
import dto.PassHistoryDTO;
import dto.StationDTO;
import dto.TicketOnewayDTO;
import gui.Screen;

public class TicketOwController extends ParentController {
	private TicketOnewayDTO tkow;

	public TicketOwController(String id) {
		super();
		this.setId(id);
		this.tkow = TicketOnewayDAO.getTkowById(this.getId());
	}

	public boolean checkEnterStation(String enterst) {
		StationDTO enterstation = StationDAO.getStationById(enterst);
		StationDTO startstation = StationDAO.getStationById(this.getTkow().getStart_station());
		StationDTO endstation = StationDAO.getStationById(this.getTkow().getExit_station());
		if (enterstation.getDistance() >= startstation.getDistance() && enterstation.getDistance() <= endstation.getDistance()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkStatus() {
		return this.getTkow().getStatus();
	}

	public void getInStationTkow(String stselect) throws InterruptedException {
		if(this.checkStatus()) {
			this.setEnterpoint(String.valueOf(stselect.charAt(2)));
			if(this.checkEnterStation(this.getEnterpoint())) {
				PassHistoryDTO ph = new PassHistoryDTO(this.getId(),this.getEnterpoint());
				PassHistoryDAO.insertPassHistory(ph);
				Screen.printOpenMess("Ticket one-way", this.getId(), this.getTkow().getPrice());
			}else {
				StationDTO st = StationDAO.getStationById(this.getEnterpoint());
				StationDTO st1 = StationDAO.getStationById(this.getTkow().getStart_station());
				StationDTO st2 = StationDAO.getStationById(this.getTkow().getExit_station());
				Screen.printErrorMessTkow2(this.getTkow().getTkow_id(), this.getTkow().getPrice(), st1.getSt_name(), st2.getSt_name(), st.getSt_name());
			}
		}else {
			Screen.printErrorMessTkow();
		}
	}
	
	public void getOutStationTkow(String stselect) throws InterruptedException {
		PassHistoryDTO ph = PassHistoryDAO.getInfoById(this.getTkow().getTkow_id());
		this.setEnterpoint(ph.getGetin_point());
		this.setExitpoint(String.valueOf(stselect.charAt(2)));
		double fare = this.caculateTripFare(this.caculateDistance());
		double price = this.getTkow().getPrice();
		if(this.checkBalance(fare,price)) {
			this.getTkow().setStatus(false);
			ph.setFare((float)fare);
			ph.setGetout_point(this.getExitpoint());
			ph.setGetout_time(new Timestamp(System.currentTimeMillis()));
			ph.setStatus(0);
			PassHistoryDAO.updatePassHistoryById(ph);
			TicketOnewayDAO.updateTkow(this.getTkow());
			Screen.printOpenMess("Ticket one-way", this.getId(), this.getTkow().getPrice());
		}else {
			Screen.printErrorMess("Ticket one-way", this.getId(), this.getTkow().getPrice(), (float) fare);
		}
	}
	
	public TicketOnewayDTO getTkow() {
		return tkow;
	}

	public void setTkow() {
		this.tkow = TicketOnewayDAO.getTkowById(this.getId());
	}

}
