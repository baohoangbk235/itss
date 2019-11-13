package dao;

import dto.CardsDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.MysqlDataAccessHelper;

public class CardsDAO {

    public static ArrayList<CardsDTO> cardsAll(){

        ArrayList<CardsDTO> arr = new ArrayList<CardsDTO>();
        String sql = "select * from cards";
        MysqlDataAccessHelper mdah = new MysqlDataAccessHelper();
      
        try {
            mdah.open();
            ResultSet rs = mdah.excuteQuery(sql);
            while(rs.next()){
                CardsDTO card= new CardsDTO();
                card.setCard_id(rs.getString("id"));
                card.setOwner_id(rs.getString("owner_id"));
                card.setRelease_time(rs.getTimestamp("released_time"));
                card.setBalance(rs.getFloat("balance"));
                arr.add(card);
            }
        } catch (SQLException ex) {
            mdah.displayError(ex);
        } finally{
            mdah.close();
        }
        return arr;
    }
}
