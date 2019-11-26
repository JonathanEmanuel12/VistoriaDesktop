package testesControle;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import controle.TerrenoControle;
import dao.TerrenoDAO;
import modelo.Terreno;

class testesTerrenoControle {
	
	TerrenoControle controle = new TerrenoControle();
	Terreno terreno = new Terreno();

	@Test
	void testCadastrarTerrenoLatitudeIncorreta() {
		terreno.setLatitude("56°46´´8 ´L");
		terreno.setLongitude("54°46´´55´S");
		terreno.setEstado("Minas Gerais");
		terreno.setCidade("Extrema");
		terreno.setBairro("Roseira2");
		terreno.setRua("Francisco Constantino");
		terreno.setNumero(21);
		
		Assertions.assertEquals("Verifique se os campos Latitude e Longitude estão preenchidos", controle.cadastrarTerreno(terreno));
	}
	
	@Test
	void testCadastrarTerrenoEnderecoIncorreto() {
		terreno.setLatitude("56°46´´88´L");
		terreno.setLongitude("54°46´´55´S");
		terreno.setEstado("Minas Gerais");
		terreno.setCidade("");
		terreno.setBairro("Roseira2");
		terreno.setRua("Francisco Constantino");
		terreno.setNumero(21);
		
		Assertions.assertEquals("Verifique se os campos do endereço estão preenchidos", controle.cadastrarTerreno(terreno));
	}
	
	@Test
	void testCadastrarTerreno() {
		terreno.setLatitude("56°46´´88´L");
		terreno.setLongitude("54°46´´55´S");
		terreno.setEstado("Minas Gerais");
		terreno.setCidade("Extrema");
		terreno.setBairro("Roseira2");
		terreno.setRua("Francisco Constantino");
		terreno.setNumero(21);
		
		Assertions.assertEquals("Terreno adicionado com sucesso", controle.cadastrarTerreno(terreno));
	}

	@Test
	void testBuscarTerrenosLivres() {
		
		TerrenoDAO dao = new TerrenoDAO();
		List<Terreno> terrenos = null;
		
		terrenos = dao.buscarTerrenosLivres();
		
		Assertions.assertEquals(terrenos.size(), controle.buscarTerrenosLivres().size());
		
	}

}
