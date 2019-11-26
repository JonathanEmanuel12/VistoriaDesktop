package testesControle;

import java.sql.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import controle.VistoriaControle;
import dao.TerrenoDAO;
import dao.UsuarioDAO;
import modelo.Terreno;
import modelo.Usuario;
import modelo.Vistoria;

class testeVistoriaControle {

	@Test
	void testCriarVistoria() {
		VistoriaControle controle = new VistoriaControle();
		
		java.util.Date dataEntrega = new java.util.Date();
		Date dataEntregaSQL = new Date(dataEntrega.getTime());
		
		Usuario estagiarioResp = new UsuarioDAO().buscarUsuario(9);
		
		Terreno terreno = new TerrenoDAO().buscarTerreno(5);
	
		Vistoria vistoria = new Vistoria();
		
		vistoria.setDataEntrega(dataEntregaSQL);
		vistoria.setObsevacoes("Vistoria Urgente");
		vistoria.setEstagiarioResp(estagiarioResp);
		vistoria.setTerreno(terreno);
		Assertions.assertEquals(true, controle.criarVistoria(vistoria));
	}

	@Test
	void testCriarVistoriaSemTerreno() {
		VistoriaControle controle = new VistoriaControle();
		
		java.util.Date dataEntrega = new java.util.Date();
		Date dataEntregaSQL = new Date(dataEntrega.getTime());
		
		Usuario estagiarioResp = new UsuarioDAO().buscarUsuario(9);
		
		Vistoria vistoria = new Vistoria();
		
		vistoria.setDataEntrega(dataEntregaSQL);
		vistoria.setObsevacoes("Vistoria Urgente");
		vistoria.setEstagiarioResp(estagiarioResp);
		Assertions.assertEquals(false, controle.criarVistoria(vistoria));
	}
	
	@Test
	void testCriarVistoriaSemEstagiario() {
		VistoriaControle controle = new VistoriaControle();
		
		java.util.Date dataEntrega = new java.util.Date();
		Date dataEntregaSQL = new Date(dataEntrega.getTime());
		
		Usuario estagiarioResp = null;
		

		Terreno terreno = new TerrenoDAO().buscarTerreno(5);
		
		Vistoria vistoria = new Vistoria();
		
		vistoria.setDataEntrega(dataEntregaSQL);
		vistoria.setObsevacoes("Vistoria Urgente");
		vistoria.setEstagiarioResp(estagiarioResp);
		vistoria.setTerreno(terreno);
		Assertions.assertEquals(false, controle.criarVistoria(vistoria));
	}
}
