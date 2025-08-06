package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	public static final String URL = "jdbc:mysql://localhost/mydb";
	public static final String USER = "admin";
	public static final String PASS = "Bicicleta14";
	
	public static Connection getConnection()
	{
		try
		{
			// return DriverManager.getConnection(URL, USER, PASS);
            String url = "jdbc:postgresql://localhost/lucid?user=postgres&password=98da4f&ssl=false";
            return DriverManager.getConnection(url);
            
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
}
