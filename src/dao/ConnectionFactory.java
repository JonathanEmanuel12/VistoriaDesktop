package dao;


import java.sql.DriverManager;
import java.sql.SQLException;

import org.gjt.mm.mysql.Driver;

import java.sql.Connection;
import java.sql.Connection;



public class ConnectionFactory {
	
	public static final String URL = "jdbc:mysql://localhnost/ifsp_farmacia";
	public static final String USER = "root";
	public static final String PASS = "Bicicleta14";
	
	public static Connection getConnection()
	{
		try
		{
			DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection(URL, USER, PASS);
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
}
