package data;

public class OneWayTicket extends TicketOrCardObject {
    private String startStation;
    private String endStation;
    public OneWayTicket() {

    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public double caculateFare() {
        return ;
    }

    public void getOneWayTicketInfo() {

    }
}
