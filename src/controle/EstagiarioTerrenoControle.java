package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.table.TableCellRenderer;

import dao.ConnectionFactory;
import dao.TerrenoDAO;
import modelo.Terreno;
import modelo.Usuario;

public class EstagiarioTerrenoControle {
	

	public boolean inserirMedidasTerreno(String objId, double area)
	{
		
		Connection connection = ConnectionFactory.getConnection();
		int id ;
		id = Integer.parseInt(objId);
		try {
			PreparedStatement ps = connection.prepareStatement(" UPDATE TERRENO SET ter_area_=? where ter_id=?",		
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setDouble(1, area);
			ps.setInt(2, id);
			//ps.executeQuery();
			if(ps.executeUpdate() != 0)
			{
				return true;
			}

		} catch (Exception ex) {
			System.out.println("Erro na Classe DAO");
			ex.printStackTrace();

		}
		
		return false;
		
	}
	public List<Terreno> buscarTerrenosLivres()
	{
		TerrenoDAO dao = new TerrenoDAO();
		
		try
		{
			return dao.buscarTerrenosLivres();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
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
