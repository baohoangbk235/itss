package dto;

import java.sql.Timestamp;

public class Ticket24hDTO {

    private String tk24_id;
    private Timestamp released_time;
    private float price;
    private Timestamp first_use;
    private Timestamp valid_time;
    private int last_pass;
	
    public String getTk24_id() {
		return tk24_id;
	}
	public void setTk24_id(String tk24_id) {
		this.tk24_id = tk24_id;
	}
	public Timestamp getReleased_time() {
		return released_time;
	}
	public void setReleased_time(Timestamp released_time) {
		this.released_time = released_time;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Timestamp getFirst_use() {
		return first_use;
	}
	public void setFirst_use(Timestamp first_use) {
		this.first_use = first_use;
	}
	public Timestamp getValid_time() {
		return valid_time;
	}
	public void setValid_time(Timestamp valid_time) {
		this.valid_time = valid_time;
	}
	public int getLast_pass() {
		return last_pass;
	}
	public void setLast_pass(int last_pass) {
		this.last_pass = last_pass;
	}
}
