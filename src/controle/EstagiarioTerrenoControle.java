package controle;

import java.sql.SQLException;
import java.util.List;

import dao.TerrenoDAO;
import dao.VistoriaDAO;
import modelo.Terreno;
import modelo.Vistoria;

public class EstagiarioTerrenoControle {
	
	public boolean inserirMedidasTerreno(int id, double area)
	{
		TerrenoDAO dao = new TerrenoDAO();
		if(area > 0)
		{
			return dao.inserirMedidasTerreno(id, area);
		} 
		return false;
	}
	
	public List<Terreno> buscarTerrenosLivres()
	{
		TerrenoControle controle = new TerrenoControle();
		
		return controle.buscarTerrenosLivres();
	}
	
	public Terreno buscarTerreno()
	{
		VistoriaDAO vistoriaDAO = new VistoriaDAO();
		
		Vistoria vistoria = vistoriaDAO.buscarVistoria();
		
		return (vistoria!=null) ? vistoria.getTerreno() : null;
		
	}
	//metodo Daniel
	/*
	 * public ResultSet buscarTerrenosEstagiario() { Connection connection =
	 * ConnectionFactory.getConnection(); try { PreparedStatement ps = connection.
	 * prepareStatement("select ter_id, ter_latitude, ter_longitude, ter_estado, ter_cidade,"
	 * + "" + " ter_bairro, ter_rua, ter_numero\r\n" +
	 * ", ter_area_ from terreno inner join vistoria on terreno.ter_id=vistoria.vis_ter_id \r\n"
	 * + "where vistoria.vis_usu_id=?;", PreparedStatement.RETURN_GENERATED_KEYS);
	 * //ps.setInt(parameterIndex, x); ResultSet rs = null; rs = ps.executeQuery();
	 * 
	 * if(ps.executeUpdate() != 0) { return rs; }
	 * 
	 * } catch (Exception ex) { System.out.println("Erro na Classe DAO");
	 * ex.printStackTrace();
	 * 
	 * }
	 * 
	 * return null; }
	 */}
