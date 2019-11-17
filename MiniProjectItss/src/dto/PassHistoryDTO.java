package dto;

import java.sql.Date;
import java.sql.Timestamp;

public class PassHistoryDTO {
	private String id;
	private boolean enter;
	private Timestamp checkinTime;
	private int st_id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public boolean isEnter() {
		return enter;
	}
	public void setEnter(boolean enter) {
		this.enter = enter;
	}
	public Timestamp getCheckinTime() {
		return checkinTime;
	}
	public void setCheckinTime(Timestamp checkinTime) {
		this.checkinTime = checkinTime;
	}
	public int getSt_id() {
		return st_id;
	}
	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}
	public void setCheckinTime(Date date) {
		// TODO Auto-generated method stub
		
	}
}
