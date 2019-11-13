package dto;

import java.sql.Timestamp;

public class CardsDTO {

    private String card_id;
    private String owner_id;
    private Float balance;
    private Timestamp release_time;
    
    /**
     * @return the card_id
     */
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	/**
     * @return the owner_id
     */
	public String getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}
	/**
     * @return the Balance
     */
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	/**
     * @return the release_time
     */
	public Timestamp getRelease_time() {
		return release_time;
	}
	public void setRelease_time(Timestamp release_time) {
		this.release_time = release_time;
	}
}
