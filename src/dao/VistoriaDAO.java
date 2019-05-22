package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Vistoria;

/**
 *
 * @author Caua
 */
public class VistoriaDAO {
    
    public boolean cadastrarVistoria(Vistoria vistoria) throws SQLException
	{
                
		Connection connection = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO ) "
                                + "VALUES (?, ?, ?, ?, ?, ?, ?);", PreparedStatement.RETURN_GENERATED_KEYS);
        
			ps.setString(1, vistoria.getId());
            ps.setString(2, vistoria.getEstagiarioResp());
			ps.setString(3, vistoria.getTerreno());
			ps.setString(4, vistoria.getDataEntrega());
			ps.setString(5, vistoria.getEstado());
			ps.setString(6, vistoria.getObservacoes());
			
				
	
			if(ps.executeUpdate() != 0)
			{
				return true;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
		
	}
	
	public List<Vistoria> buscarVistorias() throws SQLException
	{
		Connection connection = ConnectionFactory.getConnection();
		
		String sql = "select * from vistoria T\r\n";
		
		PreparedStatement comando = connection.prepareStatement(sql);
		
		ResultSet rs = null;
		rs = comando.executeQuery();
	
		ArrayList<Vistoria> vistorias = new ArrayList<Vistoria>();
		
		while(rs.next())
		{

                        Vistoria vistoria = new Vistoria();     
                        
			vistoria.setId(rs.getInt("vis_id"));
                        vistoria.setEstagiarioResp(rs.getInt("vis_estagiarioResp"));
                        vistoria.setTerreno(rs.getInt("vis_terreno"));
                        vistoria.setDate(rs.getDate("vis_dataEntrega"));
                        vistoria.setString(rs.getString("vis_estado"));
                        vistoria.setString(rs.getString("vis_observacoes"));
                       
		}

	return (vistorias.size()!=0) ? vistorias : null;

	}
}
