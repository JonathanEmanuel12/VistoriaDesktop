package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Terreno;

public class TerrenoDAO {
	
	public boolean cadastrarTerreno(Terreno terreno)
	{
		Connection connection = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO terreno(ter_latitude, ter_longitude, ter_estado, ter_cidade, ter_bairro, ter_rua, ter_numero) VALUES (?, ?, ?, ?, ?, ?, ?);", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, terreno.getLatitude());
			ps.setString(2, terreno.getLongitude());
			ps.setString(3, terreno.getEstado());
			ps.setString(4, terreno.getCidade());
			ps.setString(5, terreno.getBairro());
			ps.setString(6, terreno.getRua());
			ps.setInt(7, terreno.getNumero());
			
	
			if(ps.executeUpdate() != 0)
			{
				return true;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
		
	}
	
	public List<Terreno> buscarTerrenosLivres() throws SQLException
	{
		Connection connection = ConnectionFactory.getConnection();
		
		String sql = "select * from terreno T\r\n" + 
				"left join vistoria V\r\n" + 
				"on T.ter_id = V.vis_ter_id\r\n" + 
				"where V.vis_ter_id IS NULL;";
		
		PreparedStatement comando = connection.prepareStatement(sql);
		
		ResultSet rs = null;
		rs = comando.executeQuery();
	
		ArrayList<Terreno> terrenos = new ArrayList<Terreno>();
		
		while(rs.next())
		{
			terrenos.add(toTerreno(rs));
		}

	return (terrenos.size()!=0) ? terrenos : null;

	}
	
	public Terreno 
	
	private Terreno toTerreno(ResultSet rs) throws SQLException
	{
		Terreno terreno = new Terreno();
		terreno.setId(rs.getInt("ter_id"));
		terreno.setLatitude(rs.getString("ter_latitude"));
		terreno.setLongitude(rs.getString("ter_longitude"));
		terreno.setEstado(rs.getString("ter_estado"));
		terreno.setCidade(rs.getString("ter_cidade"));
		terreno.setBairro(rs.getString("ter_bairro"));
		terreno.setRua(rs.getString("ter_rua"));
		terreno.setNumero(rs.getInt("ter_numero"));
		return terreno;
	}
	

}
