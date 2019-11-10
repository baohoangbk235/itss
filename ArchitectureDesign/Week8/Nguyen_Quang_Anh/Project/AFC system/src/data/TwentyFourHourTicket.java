package data;

import java.sql.Time;

public class TwentyFourHourTicket extends TicketOrCardObject {
    private Time firstTime;
    private Time validTime;
    public TwentyFourHourTicket() {

    }

    public void get24hTicketInfo() {

    }

    public Time getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Time firstTime) {
        this.firstTime = firstTime;
    }

    public Time getValidTime() {
        return validTime;
    }

    public void setValidTime(Time validTime) {
        this.validTime = validTime;
    }
}
