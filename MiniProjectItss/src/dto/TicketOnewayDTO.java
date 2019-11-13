/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

import java.sql.Timestamp;

public class TicketOnewayDTO {

    private String tkow_id;
    private Timestamp released_time;
    private Float price;
    private Integer start_station;
    private Integer exit_station;
    private Boolean status;
    
	public String getTkow_id() {
		return tkow_id;
	}
	public void setTkow_id(String tkow_id) {
		this.tkow_id = tkow_id;
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
	public Integer getStart_station() {
		return start_station;
	}
	public void setStart_station(Integer start_station) {
		this.start_station = start_station;
	}
	public Integer getExit_station() {
		return exit_station;
	}
	public void setExit_station(Integer exit_station) {
		this.exit_station = exit_station;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
}
