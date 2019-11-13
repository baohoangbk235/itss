package dto;

import java.sql.Timestamp;

public class Ticket24hDTO {

    private String tk24_id;
    private Timestamp released_time;
    private Float price;
    private Timestamp first_use;
    private Timestamp valid_time;
	
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
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
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
}
