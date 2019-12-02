package controller;

import calculate.CalculateFare;

public abstract class MustChargeFareController extends ParentController {
	private float fare;

	public MustChargeFareController() {
		super();
	}
	
	public abstract void getInStation(String stselect);
	public abstract void getOutStation(String stselect);

	public float getFare() {
		return fare;
	}
	public void setFare(CalculateFare cf) {
		this.fare = cf.calculate();
	}
	
	/**
	 * Kiểm tra số dư trong thẻ hoặc vé có đủ để trả phí cho chuyến đi hay không
	 * @param fare phí đi lại.
	 * @param balance số dư trong thẻ hoặc vé.
	 * @return Trả về true nếu số dư lớn hơn hoặc bằng phí đi lại, false nếu ngược lại
	 */
	public boolean checkFare(float p) {
		if ( p >= this.getFare()) {
			return true;
		} else {
			return false;
		}
	}
}
