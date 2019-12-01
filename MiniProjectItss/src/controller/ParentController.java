package controller;

public class ParentController {
	private String enterpoint;
	private String exitpoint;
	private String id;
	private FareCaculation caculation;


	public ParentController() {
		caculation = new FareCaculation(this.enterpoint,this.exitpoint);
	}

	/**
	 * Kiểm tra số dư trong thẻ hoặc vé có đủ để trả phí cho chuyến đi hay không
	 * @param fare phí đi lại.
	 * @param balance số dư trong thẻ hoặc vé.
	 * @return Trả về true nếu số dư lớn hơn hoặc bằng phí đi lại, false nếu ngược lại
	 */
	public boolean checkBalance(double fare, double balance) {
		if (balance >= fare) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Tính phí phải tra cho chuyến đi
	 * @return số tiền tính theo đơn vị euro
	 */
	public double caculateTripFare() { return this.caculation.caculateFareByDistance(); }

	public String getEnterpoint() {
		return enterpoint;
	}
	public void setEnterpoint(String enterpoint) {
		this.enterpoint = enterpoint;
	}
	public String getExitpoint() {
		return exitpoint;
	}
	public void setExitpoint(String exitpoint) {
		this.exitpoint = exitpoint;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public FareCaculation getCaculation() { return caculation; }
	public void setCaculation(FareCaculation caculation) { this.caculation = caculation; }

}
