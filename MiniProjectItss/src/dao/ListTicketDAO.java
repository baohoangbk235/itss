package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import dto.ListTicketDTO;
import util.ConnectionUtills;

public class ListTicketDAO {
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
			e.printStackTrace();
		}
        return ticket;
	}
}
