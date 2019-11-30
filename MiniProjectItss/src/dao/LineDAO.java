package src.dao;

public class LineDAO {
	public static List<StationDTO> getStationInLine(int LineID){
		List<StationDTO> arr = new ArrayList<StationDTO>();
		String sql = "select * from Lines where Lines.lineID = " + LineID + "order by Lines.ord";
		ConnectionUtills conUtil;
		try {
			conUtil = ConnectionUtills.getInstance();
            ResultSet rs = conUtil.excuteQuery(sql);
            LineDTO line= new LineDTO();
            line.setLineID(LineID);
            while(rs.next()){
                line.addStationList(rs.getInteger("station_id"));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return arr;
    }
}
