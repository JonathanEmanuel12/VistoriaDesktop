package testesControle;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import controle.EstagiarioTerrenoControle;
import dao.TerrenoDAO;
import dao.VistoriaDAO;
import modelo.Terreno;
import modelo.Vistoria;


class testeEstagiarioTerrenoControle {

	EstagiarioTerrenoControle controle = new EstagiarioTerrenoControle();

	
	@Test
	void testInserirMedidasTerrenInvalida() {
		Assertions.assertEquals(false, controle.inserirMedidasTerreno(5, 0));
	}
	
	@Test
	void testInserirMedidasTerrenoValida() {
		Assertions.assertEquals(true, controle.inserirMedidasTerreno(5, 2000));
	}

	@Test
	void testBuscarTerrenosLivres() {
		
		TerrenoDAO dao = new TerrenoDAO();
		List<Terreno> terrenos = dao.buscarTerrenosLivres();
		
		Assertions.assertEquals(terrenos.size(), controle.buscarTerrenosLivres().size());
	}

	@Test
	void testBuscarTerreno() {
		VistoriaDAO dao = new VistoriaDAO();
		
		Vistoria vistoria = dao.buscarVistoria();
		Terreno terreno = vistoria.getTerreno();
		
		Assertions.assertEquals(terreno.getId(), controle.buscarTerreno().getId());
	}

}
