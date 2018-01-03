package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args) {

	
		
		
		try {
			
			//Class.forName("com.mysql.jdbc.Driver").newInstance(); vor Java 7 oder bei Tomcat-Server
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/java2","root","");// TODO später zu Properties
			
			
			// Select
			
			showAll(con);
			
			
			/// Insert
			
			Statement insertStatement = con.createStatement();
			int n = insertStatement.executeUpdate("INSERT INTO designpattern (name, info) VALUES ('DAO' ,'Datenbankzugriff in KLasse kapseln' )");
			System.out.println(n);
			showAll(con);
			
			
			// Delete
			
			PreparedStatement deleteStatement = con.prepareStatement("DELETE FROM designpattern WHERE name =?");
			deleteStatement.setString(1, "DAO");
			deleteStatement.executeUpdate();
			System.out.println(deleteStatement.getUpdateCount());
			deleteStatement.close();
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// select
		

	}

	private static void showAll(Connection con) throws SQLException {
		Statement selectStatement = con.createStatement();
		
		ResultSet rs =    selectStatement.executeQuery("SELECT * FROM designpattern");
		
		while(rs.next()){
			int id = rs.getInt("id");
			String name = rs.getString("name"); 
			String info = rs.getString("info");
			
			System.out.printf("%d %s: %s \n",id,name,info);
		}
	}

}
