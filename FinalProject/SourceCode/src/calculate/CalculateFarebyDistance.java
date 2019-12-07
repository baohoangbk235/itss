package calculate;

import config.Constants;
import dao.StationDAO;
import dto.StationDTO;

public class CalculateFarebyDistance implements CalculateFare{

	private String enterStation;
    private String exitStation;
    
    public CalculateFarebyDistance(String enterStation, String exitStation) {
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
    
	/**
     * Tính toán phí di chuyển dựa trên khoảng cách giữa ga vào và ga ra
     * @return số tiền tính theo đơn vị euro.
     */
	@Override
    public float calculate() {
        float distance = this.calculateDistance();
        if(distance <= Constants.BASE_DISTANCE) {
            return Constants.BASE_FARE;
        } else {
            float temp = (distance - Constants.BASE_DISTANCE) % Constants.EXTRA_DISTANCE;
            int quotient = (int)((distance - Constants.BASE_DISTANCE) / Constants.EXTRA_DISTANCE);
            if (temp != 0) {
                return Constants.BASE_FARE + (quotient + 1) * Constants.EXTRA_FARE;
            } else {
                return Constants.BASE_FARE + quotient * Constants.EXTRA_FARE;
            }
        }
    }
}
