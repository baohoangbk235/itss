package dto;

import java.sql.Timestamp;

public class PassHistoryDTO {
	private int pass_id;
	private String id;
	private String getin_point;
	private String getout_point;
	private int status;
	private float fare;
	private Timestamp getin_time;
	private Timestamp getout_time;
	
	public PassHistoryDTO() {
		super();
	}
	
	public PassHistoryDTO(String id, String getin_point) {
		super();
		this.id = id;
		this.status=1;
		this.getin_point = getin_point;
		this.getin_time = new Timestamp(System.currentTimeMillis());
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGetin_point() {
		return getin_point;
	}
	public void setGetin_point(String getin_point) {
		this.getin_point = getin_point;
	}
	public String getGetout_point() {
		return getout_point;
	}
	public void setGetout_point(String getout_point) {
		this.getout_point = getout_point;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public float getFare() {
		return fare;
	}
	public void setFare(float fare) {
		this.fare = fare;
	}
	public Timestamp getGetin_time() {
		return getin_time;
	}
	public void setGetin_time(Timestamp getin_time) {
		this.getin_time = getin_time;
	}
	public Timestamp getGetout_time() {
		return getout_time;
	}
	public void setGetout_time(Timestamp getout_time) {
		this.getout_time = getout_time;
	}

	public int getPass_id() {
		return pass_id;
	}

	public void setPass_id(int pass_id) {
		this.pass_id = pass_id;
	}
	
	
}
