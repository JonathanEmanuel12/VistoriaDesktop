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
	
	public Usuario buscarUsuario(String login, String senha) throws SQLException
	{
		Connection connection = ConnectionFactory.getConnection();
		
		String sql = "SELECT * FROM usuario WHERE usu_login=? AND usu_senha=?";
		
		PreparedStatement comando = connection.prepareStatement(sql);
		
		comando.setString(1, login);
		comando.setString(2, senha);
		
		ResultSet rs = null;
		rs = comando.executeQuery();
		
		if(rs.next())
		{
			Usuario usuario = new Usuario();
			usuario.setId(rs.getInt("usu_id"));
			usuario.setNome(rs.getString("usu_nome"));
			usuario.setLogin(rs.getString("usu_login"));
			usuario.setSenha(rs.getString("usu_senha"));
			usuario.setTipo(rs.getInt("usu_tipo"));
			return usuario;
		}

	return null;
	}


}
