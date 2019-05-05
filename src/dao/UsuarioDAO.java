package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Usuario;

public class UsuarioDAO {

	public boolean cadastrarUsuario(Usuario usuario)
	{
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO usuario(usu_nome, usu_login, usu_senha, usu_tipo) VALUES (?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setInt(4, usuario.getTipo());
	
			if(ps.executeUpdate() != 0)
			{
				return true;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;

	}
	
	public Usuario buscarUsuario(Usuario usuario) throws SQLException
	{
		Connection connection = ConnectionFactory.getConnection();
		
		String sql = "SELECT usu_id, usu_tipo FROM usuario WHERE login=? AND senha=?";
		
		PreparedStatement comando = connection.prepareStatement(sql);
		
		comando.setString(1, usuario.getLogin());
		comando.setString(2, usuario.getSenha());
		
		ResultSet rs = null;
		rs = comando.executeQuery();
		
		if(rs.next())
		{
			usuario.setId(rs.getInt("usu_id"));
			usuario.setTipo(rs.getInt("usu_tipo"));
			return usuario;
		}

	return null;
	}


}
