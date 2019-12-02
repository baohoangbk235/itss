package controller;

import java.sql.Timestamp;

import calculate.CalculateFarebyDistance;
import dao.PassHistoryDAO;
import dao.StationDAO;
import dao.TicketOnewayDAO;
import dto.PassHistoryDTO;
import dto.StationDTO;
import dto.TicketOnewayDTO;
import gui.Screen;

public class TicketOwController extends MustChargeFareController {
	private TicketOnewayDTO tkow;

	public TicketOwController(String id) {
		super();
		this.setId(id);
		this.tkow = TicketOnewayDAO.getTkowById(this.getId());
	}

	/**
	 * Kiểm tra nhà ga muốn vào có nằm ngoài 2 nhà ga ghi trên vé hay không.
	 * @param enterst Id nhà ga muốn vào.
	 * @return Trả về true nếu không nằm ngoài, false nếu ngược lại
	 */
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

	/**
	 * Kiểm tra trạng thái sử dụng của ticket one-way
	 * @return Trả về true nếu vẫn còn trạng thái sử dụng, false nếu ngược lại
	 */
	public boolean checkStatus() {
		return this.getTkow().getStatus();
	}

	/**
	 * Ghi lại các thông tin của vé và nhà ga vào trong bảng
	 * passing_history khi hành khách đi vào.
	 * @param stselect id của nhà ga khi đi vào .
	 * @throws InterruptedException nếu có lỗi trong quá trình xử lý.
	 */
	@Override
	public void getInStation(String stselect){
		if(this.checkStatus()) {
			this.setEnterpoint(String.valueOf(stselect.charAt(2)));
			if(this.checkEnterStation(this.getEnterpoint())) {
				PassHistoryDTO ph = new PassHistoryDTO(this.getId(),this.getEnterpoint());
				PassHistoryDAO.insertPassHistory(ph);
				try {
					Screen.printOpenMess("Ticket one-way", this.getId(), this.getTkow().getPrice());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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

	/**
	 * Tính toán phí của chuyến đi và ghi lại thông tin của vé, nhà ga, phí cua chuyến đi
	 * vào trong bảng passing_history khi hành khách đi ra.
	 * @param stselect id của nhà ga khi đi ra .
	 * @throws InterruptedException nếu có lỗi trong quá trình xử lý.
	 */
	public void getOutStation(String stselect){
		PassHistoryDTO ph = PassHistoryDAO.getInfoById(this.getTkow().getTkow_id());
		this.setEnterpoint(ph.getGetin_point());
		this.setExitpoint(String.valueOf(stselect.charAt(2)));
		this.setFare(new CalculateFarebyDistance(this.getEnterpoint(), this.getExitpoint()));
		float price = this.getTkow().getPrice();
		if(this.checkFare(price)) {
			this.getTkow().setStatus(false);
			ph.setFare(this.getFare());
			ph.setGetout_point(this.getExitpoint());
			ph.setGetout_time(new Timestamp(System.currentTimeMillis()));
			ph.setStatus(0);
			PassHistoryDAO.updatePassHistoryById(ph);
			TicketOnewayDAO.updateTkow(this.getTkow());
			try {
				Screen.printOpenMess("Ticket one-way", this.getId(), this.getTkow().getPrice());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			Screen.printErrorMess("Ticket one-way", this.getId(), this.getTkow().getPrice(), this.getFare());
		}
	}

	public TicketOnewayDTO getTkow() {
		return tkow;
	}

	public void setTkow() {
		this.tkow = TicketOnewayDAO.getTkowById(this.getId());
	}

}
