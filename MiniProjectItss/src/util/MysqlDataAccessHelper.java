package util;

import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlDataAccessHelper {

   public Connection conn = null;
   // xu ly ngoai le khi tuong tac voi csdl
   public void displayError(SQLException ex){
       System.out.println(" Error Message:" + ex.getMessage());
       System.out.println(" SQL State:" + ex.getSQLState());
       System.out.println(" Error Code:" + ex.getErrorCode());
   }

   public void open(){// mo ket noi den csdl
       try{
	       Driver driver = new Driver();// nap driver
	       DriverManager.registerDriver(driver);// dang ky driver 
	       // Từ phiên bản Java6 driver sẽ tự động được tìm kiếm phù hợp nên có thể bỏ đi dòng 34,35.
	       //String url = "jdbc:mysql://localhost:3306/AFC_System";
	       String url = "jdbc:mysql://" + Constants.DB_HOST + ":" + Constants.DB_PORT + "/" + Constants.DB_DATABASE;
	       conn  = DriverManager.getConnection(url, Constants.DB_USERNAME, Constants.DB_PASSWORD);//tao ket noi den co so du lieu

       } catch(SQLException ex){// xu ly ngoai le
           displayError(ex);
       }
   }
   public void close(){// dong ket noi co so du lieu
       try {
           if(conn!=null)
               conn.close();
       } catch (SQLException ex) {
           displayError(ex);
       }
   }
   //tao va thuc thi cac cau lenh sql
   // cung cap thong tin trich rut tu csdl va cho phep truy xuat tung dong du lieu
   public ResultSet excuteQuery(String sql){// danh cho cau lenh select
       ResultSet rs = null;
       try {
           Statement stm = (Statement) conn.createStatement();
           rs = stm.executeQuery(sql);
       } catch (SQLException ex) {
           displayError(ex);
       }
       return rs;
   }

}
