package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CardsDTO;
import util.ConnectionUtills;

public class CardsDAO {
	//private List<CardsDTO> arr = new ArrayList<CardsDTO>();
	
	public static List<CardsDTO> getAll(){
		List<CardsDTO> arr = new ArrayList<CardsDTO>();
		String sql = "select * from cards";
		ConnectionUtills conUtil;
		try {
			conUtil = ConnectionUtills.getInstance();
			//mdah.open();
            ResultSet rs = conUtil.excuteQuery(sql);
            while(rs.next()){
                CardsDTO card= new CardsDTO();
                card.setCard_id(rs.getString("id"));
                card.setOwner_id(rs.getString("owner_id"));
                card.setRelease_time(rs.getTimestamp("released_time"));
                card.setBalance(rs.getFloat("balance"));
                arr.add(card);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return arr;
    }
	
	public static void update(CardsDTO card) {
		String sql = "update cards set balance=? where id=?";
		ConnectionUtills conUtil;
		try {
			conUtil = ConnectionUtills.getInstance();
			PreparedStatement pst = conUtil.getConnection().prepareStatement(sql);
			pst.setFloat(1, card.getBalance()-3);
			pst.setString(2, card.getCard_id());
			pst.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
