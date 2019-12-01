package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Ticket24hDTO;
import util.ConnectionUtills;

public class Ticket24hDAO {

	/**
	 * Lấy thông tin ticket 24h trong database theo id
	 * @param id Id vé 24h
	 * @return Trả về 1 object Ticket24hDTO
	 */
    public static Ticket24hDTO getTk24ById(String id){
		Ticket24hDTO tk24 = new Ticket24hDTO();
		String sql = "select * from ticket24h where id=\""+id+"\"";
		ConnectionUtills conUtil;
		try {
			conUtil = ConnectionUtills.getInstance();
            ResultSet rs = conUtil.excuteQuery(sql);
            while(rs.next()){
            	tk24.setTk24_id(rs.getString("id"));
                tk24.setReleased_time(rs.getTimestamp("released_time"));
                tk24.setFirst_use(rs.getTimestamp("first_use"));
                tk24.setValid_time(rs.getTimestamp("valid_time"));
                tk24.setPrice(rs.getFloat("price"));
                tk24.setLast_pass(rs.getInt("last_pass"));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return tk24;
    }
    
    /**
     * Cập nhật thông tin 1 ticket 24h vào database
     * @param tk24 Object Ticket24hDTO
     */
    public static void updateTk24(Ticket24hDTO tk24) {
		String sql = "update ticket24h set first_use=?, valid_time=?, last_pass=? where id=?";
		ConnectionUtills conUtil;
		try {
			conUtil = ConnectionUtills.getInstance();
			PreparedStatement pst = conUtil.getConnection().prepareStatement(sql);
			pst.setTimestamp(1, tk24.getFirst_use());
			pst.setTimestamp(2, tk24.getValid_time());
			pst.setInt(3, tk24.getLast_pass());
			pst.setString(4, tk24.getTk24_id());
			pst.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
