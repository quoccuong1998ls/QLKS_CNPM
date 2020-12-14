package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.KhachHang;


public class DAO {
	  public static Connection conn;
    

	 public static Connection getSQLServerConnection() {
		 
		 try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=quanlykhachsan;"
                   + "username=sa;password=duc123456");
           
           //System.out.println("thanh cong");
       } catch (Exception e) {
           e.printStackTrace();
       }
		 return conn;
	 }
//	 public static void closeConnection(Connection c) {
//	        try {
//	            c.close();
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            // TODO: handle exception
//	        }
//	    }

	

	
}