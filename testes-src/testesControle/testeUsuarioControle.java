package testesControle;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import controle.UsuarioControle;
import dao.UsuarioDAO;
import modelo.Usuario;

class testeUsuarioControle {

	Usuario usuario = new Usuario();
	UsuarioControle controle = new UsuarioControle();
	
	@Test
	void testCadastrarUsuarioLoginMenor() {
		usuario.setLogin("mar");
		usuario.setNome("Mariano");
		usuario.setSenha("12345");
		usuario.setTipo(1);
		
		Assertions.assertEquals("Login deve conter de 4 a 8 caracteres", controle.cadastrarUsuario(usuario));
	}
	
	@Test
	void testCadastrarUsuarioSenhaMenor() {
		usuario.setLogin("mario");
		usuario.setNome("Mariano");
		usuario.setSenha("123");
		usuario.setTipo(1);
		
		Assertions.assertEquals("Senha deve conter de 4 a 8 caracteres", controle.cadastrarUsuario(usuario));
	}
	
	@Test
	void testCadastrarUsuarioLoginMaior() {
		usuario.setLogin("mariano123");
		usuario.setNome("Mariano");
		usuario.setSenha("12345");
		usuario.setTipo(1);
		
		Assertions.assertEquals("Login deve conter de 4 a 8 caracteres", controle.cadastrarUsuario(usuario));
	}
	
	@Test
	void testCadastrarUsuarioSenhaMaior() {
		usuario.setLogin("mario");
		usuario.setNome("Mariano");
		usuario.setSenha("1234567891");
		usuario.setTipo(1);
		
		Assertions.assertEquals("Senha deve conter de 4 a 8 caracteres", controle.cadastrarUsuario(usuario));
	}
	
	@Test
	void testCadastrarUsuario() {
		usuario.setLogin("mario");
		usuario.setNome("Mariano");
		usuario.setSenha("12345");
		usuario.setTipo(1);
		
		Assertions.assertEquals("Usuario cadastrado com sucesso", controle.cadastrarUsuario(usuario));
	}

	@Test
	void testBuscarUsuarioIncorreto() {
		String login = "mario89";
		String senha = "1234554";
		Assertions.assertEquals(false, controle.buscarUsuario(login, senha));
	}
	
	@Test
	void testBuscarUsuarioCorreto() {
		String login = "mario";
		String senha = "12345";
		Assertions.assertEquals(true, controle.buscarUsuario(login, senha));
	}

	@Test
	void testBuscarEstagiariosLivres() {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> estagiarios = null;
		
		estagiarios = dao.buscarEstagiariosLivres();
		
		Assertions.assertEquals(estagiarios, controle.buscarEstagiariosLivres());
	}

}
