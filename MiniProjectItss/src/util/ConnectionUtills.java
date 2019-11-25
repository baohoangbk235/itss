package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ConnectionUtills {

    private static ConnectionUtills instance;
    private Connection conn;

    private ConnectionUtills() throws SQLException {
    	try{
    		String serverTimezone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Ho_Chi_Minh";
 	       	Driver driver = new Driver(); 
 	       	DriverManager.registerDriver(driver);
 	       	String url = "jdbc:mysql://" + Constants.DB_HOST + ":" + Constants.DB_PORT + "/" + Constants.DB_DATABASE;
 	       	this.conn  = DriverManager.getConnection(url + serverTimezone, Constants.DB_USERNAME, Constants.DB_PASSWORD);

        } catch(SQLException ex){
            displayError(ex);
        }
    }

    public void displayError(SQLException ex){
        System.out.println(" Error Message:" + ex.getMessage());
        System.out.println(" SQL State:" + ex.getSQLState());
        System.out.println(" Error Code:" + ex.getErrorCode());
    }
    
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

    public static ConnectionUtills getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectionUtills();
        } else if (instance.getConnection().isClosed()) {
            instance = new ConnectionUtills();
        }

        return instance;
    }
}