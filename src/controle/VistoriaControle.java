package controle;

import java.sql.SQLException;

import dao.VistoriaDAO;
import modelo.Vistoria;

public class VistoriaControle {
	public boolean criarVistoria(Vistoria vistoria)
	{
		VistoriaDAO dao = new VistoriaDAO();
		try 
		{
			return dao.cadastrarVistoria(vistoria);
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NullPointerException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
