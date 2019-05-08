package controle;

import java.util.List;

import dao.UsuarioDAO;
import modelo.Usuario;

public class UsuarioControle {

	public String cadastrarUsuario(Usuario usuario)
	{
		UsuarioDAO dao = new UsuarioDAO();
		
		
		
		if(usuario.getLogin().length() < 4 || usuario.getLogin().length() > 8)
		{
			return "Login deve conter de 4 a 8 caracteres";
		}
		if(usuario.getSenha().length() < 4 || usuario.getLogin().length() > 8)
		{
			return "Senha deve conter de 4 a 8 caracteres";
		}
		if(dao.cadastrarUsuario(usuario))
		{
			return "Usuario cadastrado com sucesso";
		}
		return "Falha na conexão com o banco de dados";
	}
	public boolean buscarUsuario(String login, String senha)
	{
		UsuarioDAO dao = new UsuarioDAO();
		try
		{
			Usuario.usuarioAtual = dao.buscarUsuario(login, senha);
			if(Usuario.usuarioAtual != null)
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
	
	public List<Usuario> buscarEstagiariosLivres()
	{
		UsuarioDAO dao = new UsuarioDAO();
		
		try
		{
			return dao.buscarEstagiariosLivres();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
		
	}
}
