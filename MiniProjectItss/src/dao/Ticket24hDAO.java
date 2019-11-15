package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Ticket24hDTO;
import util.ConnectionUtills;

public class Ticket24hDAO {

    public static List<Ticket24hDTO> getAll(){

        List<Ticket24hDTO> arr = new ArrayList<Ticket24hDTO>();
        String sql = "select * from ticket24h";
        ConnectionUtills conUtil;
        try {
            conUtil = ConnectionUtills.getInstance();
            ResultSet rs = conUtil.excuteQuery(sql);
            while(rs.next()){
                Ticket24hDTO tk24= new Ticket24hDTO();
                tk24.setTk24_id(rs.getString("id"));
                tk24.setReleased_time(rs.getTimestamp("released_time"));
                tk24.setFirst_use(rs.getTimestamp("first_use"));
                tk24.setValid_time(rs.getTimestamp("valid_time"));
                tk24.setPrice(rs.getFloat("price"));
                arr.add(tk24);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        } 
        return arr;
    }
    
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
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return tk24;
    }
    
    public static void updateTk24(Ticket24hDTO tk24) {
		String sql = "update ticket24h set first_use=?, valid_time=? where id=?";
		ConnectionUtills conUtil;
		try {
			conUtil = ConnectionUtills.getInstance();
			PreparedStatement pst = conUtil.getConnection().prepareStatement(sql);
			pst.setTimestamp(1, tk24.getFirst_use());
			pst.setTimestamp(2, tk24.getValid_time());
			pst.setString(3,tk24.getTk24_id());
			pst.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
