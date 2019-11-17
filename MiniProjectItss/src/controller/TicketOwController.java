package controller;

import java.util.List;

import dao.StationDAO;
import dao.TicketOnewayDAO;
import dto.StationDTO;
import dto.TicketOnewayDTO;

public class TicketOwController extends ParentController {

	public static List<TicketOnewayDTO> getAll(){
		return TicketOnewayDAO.getAll();
	}

	public static TicketOnewayDTO getTicket(String ID) { return TicketOnewayDAO.getTkowById(ID);}

	public boolean checkEnterStation(String stationID, TicketOnewayDTO oneWayTicket) {
		StationDTO enterStation = StationDAO.getStationById(stationID);
		StationDTO startStation = StationDAO.getStationById(oneWayTicket.getStart_station());
		StationDTO endStation = StationDAO.getStationById(oneWayTicket.getExit_station());
		if (enterStation.getDistance() >= startStation.getDistance() && endStation.getDistance() <= endStation.getDistance()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkStatus (TicketOnewayDTO oneWayTicket) {
		return oneWayTicket.getStatus();
	}

}
