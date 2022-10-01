package datalayer;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;






public class  ConnectionDB{
	

	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL="jdbc:mysql://localhost:3306/mydb";
	private static String USER="root";
	private static String PASS="Odin2_Hera1";
	//private static String X="jdbc:mysql://localhost:3306/mydb?user=root&password=Odin2_Hera1";




	public  Connection getConnection() {
			
	try {	
		
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL,USER,PASS);
		//return DriverManager.getConnection(X);
	}catch(SQLException |  ClassNotFoundException ex) {
		throw new RuntimeException("Connection Error ",ex);
	}
	}
		
		
				
	public static void closeConnection(Connection conn) {
		
		try {
			if(conn!=null) {
				conn.close();
			}
		}catch(SQLException ex) {
			Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE,null,ex);
			}
	}
	
	
	
public static void closeStatment(PreparedStatement st) {
		
		try {
			if(st!=null) {
				st.close();
			}
		}catch(SQLException ex) {
			Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE,null,ex);
			}
	}
	
	
	
	public static void closeConnection(Connection conn,PreparedStatement stmt) {
		
		closeConnection(conn);
		try {
			if(conn!=null) {
				stmt.close();
			}
		}catch(SQLException ex) {
			Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE,null,ex);
			}
	}
	
	
	
	
	public static void closeConnection(Connection conn,PreparedStatement stmt,ResultSet rs) {
		
		
		closeConnection(conn,stmt);
		try {
			if(conn!=null) {
				rs.close();
			}
		}catch(SQLException ex) {
			Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE,null,ex);
			}
	}
	
	
		
	}