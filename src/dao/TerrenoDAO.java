package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Terreno;

public class TerrenoDAO {
	
	public boolean inserirTerreno(Terreno terreno)
	{
		Connection connection = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO terrreno VALUES (?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, terreno.getLatitude());
			ps.setString(2, terreno.getLongitude());
			ps.setString(3, terreno.getEstado());
			ps.setString(4, terreno.getBairro());
			ps.setString(5, terreno.getRua());
			ps.setInt(6, terreno.getNumero());
			
	
			if(ps.executeUpdate() != 0)
			{
				return true;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
		
	}

}
