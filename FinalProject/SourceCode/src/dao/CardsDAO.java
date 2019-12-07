package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ConnectionUtills;
import dto.CardsDTO;

public class CardsDAO {
	/**
	 * Lấy về bản ghi card theo giá trị id truyền vào 
	 * @param id Định danh của card
	 * @return Trả về 1 object CardsDTO
	 */
	public static CardsDTO getCardById(String id){
		CardsDTO card = new CardsDTO();
		String sql = "select * from cards where id=\""+id+"\"";
		ConnectionUtills conUtil;
		try {
			conUtil = ConnectionUtills.getInstance();
            ResultSet rs = conUtil.excuteQuery(sql);
            while(rs.next()){
                card.setCard_id(rs.getString("id"));
                card.setOwner_id(rs.getString("owner_id"));
                card.setRelease_time(rs.getTimestamp("released_time"));
                card.setBalance(rs.getFloat("balance"));
                card.setLast_pass(rs.getInt("last_pass"));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return card;
    }
	
	/**
	 * Cập nhật thông tin thẻ vào database
	 * @param card object CardsDTO chứa thông tin của card
	 */
	public static void updateCard(CardsDTO card) {
		String sql = "update cards set balance=?,last_pass=? where id=?";
		ConnectionUtills conUtil;
		try {
			conUtil = ConnectionUtills.getInstance();
			PreparedStatement pst = conUtil.getConnection().prepareStatement(sql);
			pst.setFloat(1, card.getBalance());
			pst.setInt(2, card.getLast_pass());
			pst.setString(3, card.getCard_id());
			pst.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
