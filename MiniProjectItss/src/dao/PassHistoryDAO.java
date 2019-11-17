package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.PassHistoryDTO;
import dto.StationDTO;
import util.ConnectionUtills;

//import java.util.List;

public class PassHistoryDAO<T> {
	public static List<PassHistoryDTO> getAll(){
		List<PassHistoryDTO> arr = new ArrayList<PassHistoryDTO>();
		String sql = "select * from station, station_distance where station.station_id = station_distance.station_id2";
		ConnectionUtills conUtil;
		try {
			conUtil = ConnectionUtills.getInstance();
            ResultSet rs = conUtil.excuteQuery(sql);
            while(rs.next()){
                PassHistoryDTO pass_history = new PassHistoryDTO();
                pass_history.setCheckinTime(rs.getTimestamp("checkinTime"));
                pass_history.setId(rs.getString("id"));
                pass_history.setSt_id(rs.getInt("st_id"));
                pass_history.setEnter(rs.getBoolean("enter"));
                arr.add(pass_history);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return arr;
    }
	public static PassHistoryDTO getInfoById(String id) {
		PassHistoryDTO pass_history = new PassHistoryDTO();
		String sql = "select * from pass_history where pass_history.id = \""+ id +
				"\"";
		ConnectionUtills conUtil;
		try {
			conUtil = ConnectionUtills.getInstance();
            ResultSet rs = conUtil.excuteQuery(sql);
            while(rs.next()){
            	pass_history.setCheckinTime(rs.getTimestamp("checkinTime"));
                pass_history.setId(rs.getString("id"));
                pass_history.setSt_id(rs.getInt("st_id"));
                pass_history.setEnter(rs.getBoolean("enter"));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return pass_history;
	}
	
	public static void updatePassHistoryById() {
		
	}
	
	public static void insertPassHistory() {
		
	}
}
 
  