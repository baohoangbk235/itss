package dao;

import dto.Ticket24hDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.MysqlDataAccessHelper;

public class Ticket24hDAO {

    public static ArrayList<Ticket24hDTO> tk24All(){

        ArrayList<Ticket24hDTO> arr = new ArrayList<Ticket24hDTO>();
        String sql = "select * from ticket24h";
        MysqlDataAccessHelper mdah = new MysqlDataAccessHelper();
      
        try {
            mdah.open();
            ResultSet rs = mdah.excuteQuery(sql);
            while(rs.next()){
                Ticket24hDTO tk24= new Ticket24hDTO();
                tk24.setTk24_id(rs.getString("id"));
                tk24.setReleased_time(rs.getTimestamp("released_time"));
                tk24.setFirst_use(rs.getTimestamp("first_use"));
                tk24.setValid_time(rs.getTimestamp("valid_time"));
                tk24.setPrice(rs.getFloat("price"));
                arr.add(tk24);
            }
        } catch (SQLException ex) {
            mdah.displayError(ex);
        } finally{
            mdah.close();
        }
        return arr;
    }
}
