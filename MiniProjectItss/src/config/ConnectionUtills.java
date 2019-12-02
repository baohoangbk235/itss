package config;

import java.sql.*;
import com.mysql.cj.jdbc.Driver;

/**
 * Tạo kết nối tới database, sử dụng JDBC, singleton pattern
 */
public class ConnectionUtills {
	
    private static ConnectionUtills instance;
    private Connection conn;

    /**
     * Khởi tạo Connection tới database
     * @throws SQLException
     */
    private ConnectionUtills() throws SQLException {
    	try{
    		String serverTimezone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Ho_Chi_Minh";
 	       	java.sql.Driver driver = new Driver();
 	       	DriverManager.registerDriver(driver);
 	       	String url = "jdbc:mysql://" + Constants.DB_HOST + ":" + Constants.DB_PORT + "/" + Constants.DB_DATABASE;
 	       	this.conn  = DriverManager.getConnection(url + serverTimezone, Constants.DB_USERNAME, Constants.DB_PASSWORD);

        } catch(SQLException ex){
            displayError(ex);
        }
    }

    /**
     * In lỗi nếu xảy ra vấn đề khi kết nối tới database
     * @param ex SQLException
     */
    public void displayError(SQLException ex){
        System.out.println(" Error Message:" + ex.getMessage());
        System.out.println(" SQL State:" + ex.getSQLState());
        System.out.println(" Error Code:" + ex.getErrorCode());
    }
    
    /**
     * Phương thức truy vấn vào database
     * @param sql Câu lệnh truy vấn MySql 
     * @return Trả về 1 ResultSet chứa kết quả truy vấn của câu lênh sql
     */
    public ResultSet excuteQuery(String sql){
        ResultSet rs = null;
        try {
            Statement stm = (Statement) this.conn.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            displayError(ex);
        }
        return rs;
    }
    
    public Connection getConnection() {
        return conn;
    }

    /**
     * Tạo mới connection tới database, hoặc khởi tạo lại nếu kết nối gián đoạn.
     * @return
     * @throws SQLException
     */
    public static ConnectionUtills getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectionUtills();
        } else if (instance.getConnection().isClosed()) {
            instance = new ConnectionUtills();
        }
        return instance;
    }
}