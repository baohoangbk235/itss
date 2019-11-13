package dao;

import dto.TicketOnewayDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.MysqlDataAccessHelper;

public class TicketOnewayDAO {

    public static ArrayList<TicketOnewayDTO> tkowAll(){

        ArrayList<TicketOnewayDTO> arr = new ArrayList<TicketOnewayDTO>();
        String sql = "select * from ticket_oneway";
        MysqlDataAccessHelper mdah = new MysqlDataAccessHelper();
      
        try {
            mdah.open();
            ResultSet rs = mdah.excuteQuery(sql);
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
        } catch (SQLException ex) {
            mdah.displayError(ex);
        } finally{
            mdah.close();
        }
        return arr;
    }
}
