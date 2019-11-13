package dao;

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
                tkow.setStart_station(rs.getInt("start_station"));
                tkow.setExit_station(rs.getInt("exit_station"));
                tkow.setPrice(rs.getFloat("price"));
                tkow.setStatus(rs.getBoolean("status"));
                arr.add(tkow);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        } 
        return arr;
    }
}
