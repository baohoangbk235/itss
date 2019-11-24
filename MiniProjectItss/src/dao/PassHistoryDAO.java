package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.PassHistoryDTO;
import util.ConnectionUtills;

//import java.util.List;

public class PassHistoryDAO {
	public static List<PassHistoryDTO> getAll(){
		List<PassHistoryDTO> arr = new ArrayList<PassHistoryDTO>();
		String sql = "select * from passing_history";
		ConnectionUtills conUtil;
		try {
			conUtil = ConnectionUtills.getInstance();
            ResultSet rs = conUtil.excuteQuery(sql);
            while(rs.next()){
                PassHistoryDTO pass_history = new PassHistoryDTO();
                pass_history.setId(rs.getString("id"));
                pass_history.setGetin_point(rs.getString("getin_point"));
                pass_history.setGetout_point(rs.getString("getout_point"));
                pass_history.setStatus(rs.getInt("pass_status"));
                pass_history.setFare(rs.getFloat("fare"));
                pass_history.setGetin_time(rs.getTimestamp("getin_time"));
                pass_history.setGetout_time(rs.getTimestamp("getout_time"));
                arr.add(pass_history);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return arr;
    }
	public static PassHistoryDTO getInfoById(String id) {
		PassHistoryDTO pass_history = new PassHistoryDTO();
		String sql = "select * from passing_history where id = \""+ id + "\"";
		ConnectionUtills conUtil;
		try {
			conUtil = ConnectionUtills.getInstance();
            ResultSet rs = conUtil.excuteQuery(sql);
            while(rs.next()){
            	pass_history.setId(rs.getString("id"));
                pass_history.setGetin_point(rs.getString("getin_point"));
                pass_history.setGetout_point(rs.getString("getout_point"));
                pass_history.setStatus(rs.getInt("pass_status"));
                pass_history.setFare(rs.getFloat("fare"));
                pass_history.setGetin_time(rs.getTimestamp("getin_time"));
                pass_history.setGetout_time(rs.getTimestamp("getout_time"));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return pass_history;
	}
	
	public static void updatePassHistoryById(PassHistoryDTO ph) {
		String sql = "update passing_history set getin_point=?, getout_point=?, pass_status=?, fare=?, getin_time=?, getout_time=? where id=?";
		ConnectionUtills conUtil;
		try {
			conUtil = ConnectionUtills.getInstance();
			PreparedStatement pst = conUtil.getConnection().prepareStatement(sql);
			pst.setString(1, ph.getGetin_point());
			pst.setString(2, ph.getGetout_point());
			pst.setInt(3, ph.getStatus());
			pst.setFloat(4, ph.getFare());
			pst.setTimestamp(5, ph.getGetin_time());
			pst.setTimestamp(6, ph.getGetout_time());
			pst.setString(7,ph.getId());
			pst.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}

	}
	
	public static void insertPassHistory(PassHistoryDTO ph) {
		String sql = "insert into passing_history(id, getin_point, getout_point, pass_status, fare, getin_time, getout_time) values (?,?,?,?,?,?,?)";
		ConnectionUtills conUtil;
		try {
			conUtil = ConnectionUtills.getInstance();
			PreparedStatement pst = conUtil.getConnection().prepareStatement(sql);
			pst.setString(1,ph.getId());
			pst.setString(2, ph.getGetin_point());
			pst.setString(3, ph.getGetout_point());
			pst.setInt(4, ph.getStatus());
			pst.setFloat(5, ph.getFare());
			pst.setTimestamp(6, ph.getGetin_time());
			pst.setTimestamp(7, ph.getGetout_time());
			pst.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
 
  