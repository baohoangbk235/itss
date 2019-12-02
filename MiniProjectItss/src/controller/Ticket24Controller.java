package controller;
import java.sql.Timestamp;

import dao.PassHistoryDAO;
import dao.Ticket24hDAO;
import dto.PassHistoryDTO;
import dto.Ticket24hDTO;
import gui.Screen;

public class Ticket24Controller extends HasValidTimeController {
	private Ticket24hDTO tk24;

	public Ticket24Controller(String id) {
		super();
		this.setId(id);
		this.tk24 = Ticket24hDAO.getTk24ById(this.getId());
	}

	/**
	 * Kiểm tra vé 24h còn thời hạn sử dụng không.
	 * @return Trả về true nếu còn hạn, false nếu ngược lại
	 */
	public boolean checkTimeValidity() {
		Timestamp now = new Timestamp(System.currentTimeMillis());
		if(this.getTk24().getFirst_use()== null) {
			this.getTk24().setFirst_use(now);
			this.getTk24().setValid_time(new Timestamp(now.getTime() + 86400000));
		}
		if (now.before(this.getTk24().getValid_time())) {
			return true;
		}
		return false;
	}

	/**
	 * Ghi lại các thông tin của vé và nhà ga vào trong bảng
	 * passing_history khi hành khách đi vào.
	 * @param stselect id của nhà ga khi đi vào .
	 * @throws InterruptedException nếu có lỗi trong quá trình xử lý.
	 */
	@Override
	public void getInStation(String stselect){
		if(this.checkTimeValidity()) {
			this.setEnterpoint(String.valueOf(stselect.charAt(2)));
			PassHistoryDTO ph = new PassHistoryDTO(this.getId(),this.getEnterpoint());
			PassHistoryDAO.insertPassHistory(ph);
			PassHistoryDTO ph2 = PassHistoryDAO.getInfo(this.getId(), this.getEnterpoint(), ph.getGetin_time());
			this.getTk24().setLast_pass(ph2.getPass_id());
			Ticket24hDAO.updateTk24(this.getTk24());
			try {
				Screen.printOpenMess("Ticket 24h", this.getId(), this.getTk24().getValid_time());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			Screen.printErrorMess("Ticket 24h", this.getId(), this.getTk24().getValid_time(),new Timestamp(System.currentTimeMillis()) );
		}
	}

	/**
	 * Ghi lại các thông tin của vé và nhà ga vào trong bảng
	 * passing_history khi hành khách đi ra.
	 * @param stselect id của nhà ga khi đi ra.
	 * @throws InterruptedException nếu có lỗi trong quá trình xử lý.
	 */
	@Override
	public void getOutStation(String stselect) {
		PassHistoryDTO ph = PassHistoryDAO.getInfoByPassId(this.getTk24().getLast_pass());
		ph.setGetout_point(String.valueOf(stselect.charAt(2)));
		ph.setGetout_time(new Timestamp(System.currentTimeMillis()));
		ph.setStatus(0);
		PassHistoryDAO.updatePassHistoryById(ph);
		this.getTk24().setLast_pass(0);
		Ticket24hDAO.updateTk24(this.getTk24());
		try {
			Screen.printOpenMess("Ticket 24h", this.getId(), this.getTk24().getValid_time());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public Ticket24hDTO getTk24() {
		return tk24;
	}

	public void setTk24() {
		this.tk24 = Ticket24hDAO.getTk24ById(this.getId());
	}
}
