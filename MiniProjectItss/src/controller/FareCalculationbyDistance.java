package controller;

import util.Constants;

public class FareCalculationbyDistance extends FareCalculation{

	public FareCalculationbyDistance(String enterStation, String exitStation) {
		super(enterStation, exitStation);
		// TODO Auto-generated constructor stub
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
