package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.StationDTO;
import util.ConnectionUtills;

public class StationDAO {
		
	public static List<StationDTO> getAll(){
		List<StationDTO> arr = new ArrayList<StationDTO>();
		String sql = "select * from station, station_distance where station.station_id = station_distance.station_id2";
		ConnectionUtills conUtil;
		try {
			conUtil = ConnectionUtills.getInstance();
            ResultSet rs = conUtil.excuteQuery(sql);
            while(rs.next()){
                StationDTO station= new StationDTO();
                station.setSt_id(rs.getString("station_id"));
                station.setSt_name(rs.getString("st_name"));
                station.setDistance(rs.getFloat("distance"));
                arr.add(station);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return arr;
    }
	
	public static StationDTO getStationById(String id){
		StationDTO station = new StationDTO();
		String sql = "select * from station, station_distance where station.station_id = station_distance.station_id2 and station_id=\""+id+"\"";
		ConnectionUtills conUtil;
		try {
			conUtil = ConnectionUtills.getInstance();
            ResultSet rs = conUtil.excuteQuery(sql);
            while(rs.next()){
            	station.setSt_id(rs.getString("station_id"));
                station.setSt_name(rs.getString("st_name"));
                station.setDistance(rs.getFloat("distance"));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return station;
    }
}
