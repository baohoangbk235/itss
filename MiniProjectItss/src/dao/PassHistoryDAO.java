package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dto.PassHistoryDTO;
import util.ConnectionUtills;

//import java.util.List;

public class PassHistoryDAO {
	/**
	 * Lấy về danh sách lịch sử thông hành qua các nhà ga
	 * @return Trả về danh sách lịch sử thông hành
	 */
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
	
	/**
	 * Truy vấn Select tới bản passing_history
	 * @param sql Câu lệnh truy vấn Select
	 * @return Trả về 1 object PassHistoryDTO 
	 */
	public static PassHistoryDTO getInfoBySql(String sql) {
		PassHistoryDTO pass_history = new PassHistoryDTO();
		ConnectionUtills conUtil;
		try {
			conUtil = ConnectionUtills.getInstance();
            ResultSet rs = conUtil.excuteQuery(sql);
            while(rs.next()){
            	pass_history.setPass_id(rs.getInt("pass_id"));
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
	
	/**
	 * Lấy 1 bản ghi Lịch sử thông hành qua Id của vé/ticket đã được sử dụng
	 * @param id 
	 * @return Trả về 1 object PassHistoryDTO 
	 */
	public static PassHistoryDTO getInfoById(String id) {
		String sql = "select * from passing_history where id = \""+ id + "\" order by getin_time desc";
		return PassHistoryDAO.getInfoBySql(sql);
	}
	
	/**
	 * Lấy 1 bản ghi Lịch sử thông hành qua Id của nó
	 * @param id 
	 * @return Trả về 1 object PassHistoryDTO 
	 */
	public static PassHistoryDTO getInfoByPassId(int pass_id) {
		String sql = "select * from passing_history where pass_id = \""+ pass_id + "\"";
        return PassHistoryDAO.getInfoBySql(sql);
	}
	
	/**
	 * Lấy 1 bản ghi Lịch sử thôg qua Id của vé/card đã đi qua, điểm vào, và thời gian vào.
	 * @param id Id vé/thẻ
	 * @param getin_point Nhà ga đã vào
	 * @param getin_time Thời gian vào
	 * @return Trả về 1 object PassHistoryDTO 
	 */
	public static PassHistoryDTO getInfo(String id, String getin_point, Timestamp getin_time) {
		String sql = "select * from passing_history where id = \""+ id + "\" and getin_point = \""
					+ getin_point + "\" and getin_time = \""+ getin_time + "\"";
        return PassHistoryDAO.getInfoBySql(sql);
	}
	
	/**
	 * Cập nhật lại Lịch sử thông hành trong CSDL
	 * @param ph 1 object PassHistoryDTO  
	 */
	public static void updatePassHistoryById(PassHistoryDTO ph) {
		String sql = "update passing_history set id=?, getin_point=?, getout_point=?, pass_status=?, fare=?, getin_time=?, getout_time=? where pass_id=?";
		ConnectionUtills conUtil;
		try {
			conUtil = ConnectionUtills.getInstance();
			PreparedStatement pst = conUtil.getConnection().prepareStatement(sql);
			pst.setString(1, ph.getId());
			pst.setString(2, ph.getGetin_point());
			pst.setString(3, ph.getGetout_point());
			pst.setInt(4, ph.getStatus());
			pst.setFloat(5, ph.getFare());
			pst.setTimestamp(6, ph.getGetin_time());
			pst.setTimestamp(7, ph.getGetout_time());
			pst.setInt(8,ph.getPass_id());
			pst.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}

	}
	
	/**
	 * Chèn thêm vào Lịch sử thông hành trong CSDL
	 * @param ph 1 object PassHistoryDTO  
	 */
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
 
  