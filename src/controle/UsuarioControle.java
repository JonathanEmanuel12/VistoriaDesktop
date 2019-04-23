package controle;

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
		return "Falha na conex�o com o banco de dados";
	}
}