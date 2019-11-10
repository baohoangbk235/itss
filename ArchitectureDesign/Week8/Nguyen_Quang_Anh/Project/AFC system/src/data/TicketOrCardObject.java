package data;

import java.sql.Time;

public class TicketOrCardObject {
    private String id;
    private double price;
    private Time releaseTime;
    private String getInPoint;
    private String getOutPoint;

    public TicketOrCardObject() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Time getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Time releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getGetInPoint() {
        return getInPoint;
    }

    public void setGetInPoint(String getInPoint) {
        this.getInPoint = getInPoint;
    }

    public String getGetOutPoint() {
        return getOutPoint;
    }

    public void setGetOutPoint(String getOutPoint) {
        this.getOutPoint = getOutPoint;
    }
}
