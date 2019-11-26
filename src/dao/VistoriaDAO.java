package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;
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
			PreparedStatement ps = connection.prepareStatement("INSERT INTO vistoria(vis_data_entrega, vis_usu_id, vis_ter_id, vis_estado) values(?, ?, ?, ?);", PreparedStatement.RETURN_GENERATED_KEYS);
			
			ps.setDate(1, vistoria.getDataEntrega());
            ps.setInt(2, vistoria.getEstagiarioResp().getId());
			ps.setInt(3, vistoria.getTerreno().getId());
			ps.setString(4, vistoria.getEstado());
			
				
	
			if(ps.executeUpdate() != 0)
			{
				return true;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
		
	}
	public Vistoria buscarVistoria()
	{
		Connection connection = ConnectionFactory.getConnection();
		
		String sql = "SELECT * FROM vistoria WHERE vis_usu_id = ? AND vis_estado = ?";
		
		PreparedStatement comando = null;
				
		try {
			comando = connection.prepareStatement(sql);
			comando.setInt(1, Usuario.usuarioAtual.getId());
			comando.setString(2, "Executando");
			
			ResultSet rs = null;
			rs = comando.executeQuery();
			
			if(rs.next())
			{
				return toVistoria(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
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
			vistorias.add(toVistoria(rs));                       
		}

		return (vistorias.size()!=0) ? vistorias : null;

	}
	
	private Vistoria toVistoria(ResultSet rs) throws SQLException
	{
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		TerrenoDAO terrenoDAO = new TerrenoDAO();
		
		Vistoria vistoria = new Vistoria();                 
		vistoria.setId(rs.getInt("vis_id"));
        vistoria.setEstagiarioResp(usuarioDAO.buscarUsuario(rs.getInt("vis_usu_id")));
        vistoria.setTerreno(terrenoDAO.buscarTerreno(rs.getInt("vis_ter_id")));
        vistoria.setDataEntrega(rs.getDate("vis_data_entrega"));
        vistoria.setEstado(rs.getString("vis_estado"));
        vistoria.setObsevacoes(rs.getString("vis_observacoes"));
        
        return vistoria;
	}
}
