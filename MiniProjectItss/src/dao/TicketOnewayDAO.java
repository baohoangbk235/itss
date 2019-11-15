package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.TicketOnewayDTO;
import util.ConnectionUtills;

public class TicketOnewayDAO {

    public static List<TicketOnewayDTO> getAll(){

        List<TicketOnewayDTO> arr = new ArrayList<TicketOnewayDTO>();
        String sql = "select * from ticket_oneway";
        ConnectionUtills conUtil;
        try {
            conUtil = ConnectionUtills.getInstance();
            ResultSet rs = conUtil.excuteQuery(sql);
            while(rs.next()){
                TicketOnewayDTO tkow= new TicketOnewayDTO();
                tkow.setTkow_id(rs.getString("id"));
                tkow.setReleased_time(rs.getTimestamp("released_time"));
                tkow.setStart_station(rs.getString("start_station"));
                tkow.setExit_station(rs.getString("exit_station"));
                tkow.setPrice(rs.getFloat("price"));
                tkow.setStatus(rs.getBoolean("status"));
                arr.add(tkow);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        } 
        return arr;
    }
    
    public static TicketOnewayDTO getTkowById(String id){
		TicketOnewayDTO tkow = new TicketOnewayDTO();
		String sql = "select * from ticket_oneway where id=\""+id+"\"";
		ConnectionUtills conUtil;
		try {
			conUtil = ConnectionUtills.getInstance();
            ResultSet rs = conUtil.excuteQuery(sql);
            while(rs.next()){
            	tkow.setTkow_id(rs.getString("id"));
                tkow.setReleased_time(rs.getTimestamp("released_time"));
                tkow.setStart_station(rs.getString("start_station"));
                tkow.setExit_station(rs.getString("exit_station"));
                tkow.setPrice(rs.getFloat("price"));
                tkow.setStatus(rs.getBoolean("status"));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return tkow;
    }
    
    public static void updateTkow(TicketOnewayDTO tkow) {
		String sql = "update ticket_oneway set status=? where id=?";
		ConnectionUtills conUtil;
		try {
			conUtil = ConnectionUtills.getInstance();
			PreparedStatement pst = conUtil.getConnection().prepareStatement(sql);
			pst.setBoolean(1, tkow.getStatus());
			pst.setString(2,tkow.getTkow_id());
			pst.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
