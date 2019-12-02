package controller;

import dao.StationDAO;
import dto.StationDTO;

public abstract class FareCalculation {
    private String enterStation;
    private String exitStation;

    public FareCalculation(String enterStation, String exitStation) {
        this.enterStation = enterStation;
        this.exitStation = exitStation;
    }

    /**
     * Tính toán khoảng cách giữa ga vào và ga ra.
     * @return khoảng cách giữa hai ga tính theo đơn vị kilomet.
     */
    public float calculateDistance() {
        StationDTO enterStation = StationDAO.getStationById(this.enterStation);
        StationDTO exitStation = StationDAO.getStationById(this.exitStation);
        return Math.abs(exitStation.getDistance() - enterStation.getDistance());
    }
    
    public abstract float calculate();
}
