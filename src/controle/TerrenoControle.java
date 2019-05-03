package controle;

import dao.TerrenoDAO;
import modelo.Terreno;

public class TerrenoControle {
	
	public String inserirTerreno(Terreno terreno)
	{
		if(terreno.getLatitude().contains(" ") || terreno.getLongitude().contains(" "))
		{
			return "Verifique se os campos Latitude e Longitude estão corretos";
		}
		if(terreno.getEstado().isEmpty() || terreno.getCidade().isEmpty() || terreno.getBairro().isEmpty() || terreno.getRua().isEmpty() || (terreno.getNumero() == 0))
		{
			return "Verifique se os campos do endereço estão correntos";
		}
		
		TerrenoDAO  dao = new TerrenoDAO();
		if(dao.inserirTerreno(terreno))
		{
			return "Terreno adicionado com sucesso";
		}
		
		return "Falha no banco de dados";
	
	}

}
