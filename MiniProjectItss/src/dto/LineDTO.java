package src.dto;

public class LineDTO {
	static int lineNum;
	private int lineID;
	private List<Integer> ListStation;

	public static int getLineNum() {
		return lineNum;
	}
	public static void setLineNum(int lineNum) {
		LineDTO.lineNum = lineNum;
	}
	public int getLineID() {
		return lineID;
	}
	public void setLineID(int lineID) {
		this.lineID = lineID;
	}
	public List<Integer> getListStation() {
		return ListStation;
	}
	public void setListStation(List<Integer> listStation) {
		ListStation = listStation;
	}
	
	public void addStationList(Integer stationID) {
		this.ListStation.add(stationID)
	}
}
