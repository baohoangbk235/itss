package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import config.ConnectionUtills;
import dto.ListTicketDTO;

public class ListTicketDAO {
	/**
	 * Lấy thông tin vé từ bảng list_ticket
	 * @param id id vé
	 */
	public static ListTicketDTO getTicketType(String id) {
		ListTicketDTO ticket = new ListTicketDTO();
		String sql = "select * from list_ticket where id = \"" + id + "\"";
		ConnectionUtills conUtil;
		try {
			conUtil = ConnectionUtills.getInstance();
			ResultSet rs = conUtil.excuteQuery(sql);
			while(rs.next()){
                ticket.setId(rs.getString("id"));
                ticket.setType(rs.getString("type"));
            }
		} catch (SQLException e) {
			System.out.println("Id khong ton tai trong database");
			e.printStackTrace();
		}
        return ticket;
	}
}
