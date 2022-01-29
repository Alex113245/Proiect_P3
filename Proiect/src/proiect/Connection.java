package proiect;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/proiect";
		String username = "root";
		String password = "password";
		
		try {
			java.sql.Connection Connection = DriverManager.getConnection(url, username, password);
			System.out.println("Successfully connected!");
		} 
		
		catch (SQLException e) {
			System.out.println("Eroare");
			e.printStackTrace();
		}
	}
	
}
