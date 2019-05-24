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
			
			ps.setInt(1, vistoria.getId());
            ps.setInt(2, vistoria.getEstagiarioResp().getId());
			ps.setInt(3, vistoria.getTerreno().getId());
			ps.setDate(4, vistoria.getDataEntrega());
			ps.setString(5, vistoria.getEstado());
			ps.setString(6, vistoria.getObsevacoes());
			
				
	
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
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		TerrenoDAO terrenoDAO = new TerrenoDAO();
		
		String sql = "select * from vistoria T\r\n";
		
		PreparedStatement comando = connection.prepareStatement(sql);
		
		ResultSet rs = null;
		rs = comando.executeQuery();
	
		ArrayList<Vistoria> vistorias = new ArrayList<Vistoria>();
		
		while(rs.next())
		{
            Vistoria vistoria = new Vistoria();                 
			vistoria.setId(rs.getInt("vis_id"));
            vistoria.setEstagiarioResp(usuarioDAO.buscarUsuario(rs.getInt("vis_estagiarioResp")));
            vistoria.setTerreno(terrenoDAO.buscarTerreno(rs.getInt("vis_terreno")));
            vistoria.setDataEntrega(rs.getDate("vis_dataEntrega"));
            vistoria.setEstado(rs.getString("vis_estado"));
            vistoria.setObsevacoes(rs.getString("vis_observacoes"));
                       
		}

	return (vistorias.size()!=0) ? vistorias : null;

	}
}
