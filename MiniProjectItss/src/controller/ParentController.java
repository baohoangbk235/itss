package controller;

import dao.StationDAO;
import dto.StationDTO;
import util.Constants;

public class ParentController {
	private String enterpoint;
	private String exitpoint;
	private String id;


	/**
	 * Kiểm tra số dư trong thẻ hoặc vé có đủ để trả phí cho chuyến đi hay không
	 * @param fare phí đi lại.
	 * @param balance số dư trong thẻ hoặc vé.
	 * @return Trả về true nếu số dư lớn hơn hoặc bằng phí đi lại, false nếu ngược lại
	 */
	public boolean checkBalance(double fare, double balance) {
		if (balance >= fare) {
			return true;
		} else {
			return false;
		}
	}

	public float caculateDistance() {
		StationDTO enterStation = StationDAO.getStationById(this.getEnterpoint());
		StationDTO exitStation = StationDAO.getStationById(this.getExitpoint());
		return Math.abs(exitStation.getDistance() - enterStation.getDistance());
	}

	public double caculateTripFare(float distance) {
		if(distance <= Constants.BASE_DISTANCE) {
			return Constants.BASE_FARE;
		} else {
			double temp = (distance - Constants.BASE_DISTANCE) % Constants.EXTRA_DISTANCE;
			int quotient = (int)((distance - Constants.BASE_DISTANCE) / Constants.EXTRA_DISTANCE);
			if (temp != 0) {
				return Constants.BASE_FARE + (quotient + 1) * Constants.EXTRA_FARE;
			} else {
				return Constants.BASE_FARE + quotient * Constants.EXTRA_FARE;
			}
		}
	}

	public String getEnterpoint() {
		return enterpoint;
	}
	public void setEnterpoint(String enterpoint) {
		this.enterpoint = enterpoint;
	}
	public String getExitpoint() {
		return exitpoint;
	}
	public void setExitpoint(String exitpoint) {
		this.exitpoint = exitpoint;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
