package TravelandTourism;

import java.sql.*;

public class Conn {
	
	Connection co ;
	Statement s ;
	Conn(){
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		co = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_and_tourism" , "root" , "Abhisql@2004");
		s = co.createStatement();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
	}
	 public Statement getStatement() {
	        return s;
	    }
	 public Connection getConnection() {
	        return co;
	    }

	public PreparedStatement prepareStatement(String query) {
		// TODO Auto-generated method stub
		return null;
	}


}
