package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import controle.EstagiarioTerrenoControle;
import controle.TerrenoControle;
import dao.TerrenoDAO;
import modelo.Terreno;
import modelo.Usuario;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
//
public class FrmEstagiarioVist {

	private static final Terreno Terreno = null;
	JFrame janela;
	JPanel lblDocumento;
	JLabel lblTerreno;
	JLabel lblArea;
	JTextField txtArea;
	private DefaultTableModel modelo = new DefaultTableModel();

	private JTable tabela;
	private JScrollPane scrollPane;
	private JTable table;
	
	public FrmEstagiarioVist() throws SQLException
	{
		janela = new JFrame("Vistoria - Minhas Vistorias");
		janela.setSize(679, 350);
		
		lblDocumento = new JPanel();
		janela.getContentPane().add(lblDocumento);
		lblDocumento.setLayout(null);
		
		lblTerreno = new JLabel("Informações do Terreno");
		lblTerreno.setBounds(10, 10, 117, 14);
		lblDocumento.add(lblTerreno);
		
		lblArea = new JLabel("Área: ");
		lblArea.setBounds(20, 105, 48, 14);
		lblDocumento.add(lblArea);
		
		txtArea = new JTextField(20);
		txtArea.setBounds(67, 102, 48, 20);
		lblDocumento.add(txtArea);
		
		JButton btnSalvarInformacoes = new JButton("Salvar informa\u00E7\u00F5es do Terreno");
		btnSalvarInformacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double medida;
				int coluna=0;
				int idTerreno;
				
				idTerreno = Integer.parseInt(table.getValueAt(table.getSelectedRow(), coluna).toString());
				Usuario usuario = Usuario.usuarioAtual;
				medida = Double.parseDouble(txtArea.getText());
				EstagiarioTerrenoControle controle = new EstagiarioTerrenoControle();
				
				if (controle.inserirMedidasTerreno(idTerreno, medida))
				{
					JOptionPane.showMessageDialog(null, "Medidas Inseridas!");
					zerarTabela();
					popularTabela(new EstagiarioTerrenoControle().buscarTerreno());
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Erro na inserção de Medidas!");
				}
			}
		});
		btnSalvarInformacoes.setBounds(10, 277, 186, 23);
		lblDocumento.add(btnSalvarInformacoes);
		
		criarTabela();
		popularTabela(new EstagiarioTerrenoControle().buscarTerreno());
		table = new JTable(modelo);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 36, 617, 45);
		lblDocumento.add(scrollPane);

		
		janela.setVisible(true);
		
		
	}
	
		/*TerrenoDAO ter = new TerrenoDAO();
		List<Terreno> terreno = new ArrayList<Terreno>();
		terreno = ter.buscarTerrenosLivres();
		while(terreno.iterator().hasNext()) {
			Terreno t = new Terreno();
			t = Terreno;
			int id = t.getId(); 
			String latitude = t.getLatitude();
			String longitude = t.getLongitude();
			String estado = t.getEstado();
			String cidade = t.getCidade();
			String bairro = t.getBairro();
			String rua = t.getRua();
			double area = t.getArea();
			
			modelo.addRow(new Object[] {id, latitude, longitude, estado, cidade, bairro, rua, area});
		}
		lblDocumento.add(tabelaTerrenos);*/
	private void criarTabela() throws SQLException
	{
		/*
		 * tabelaTerrenos = new JTable(modelo); tabelaTerrenos.setBounds(10, 35, 207,
		 * 245); //tentando definir colunas
		 */		
		modelo.addColumn("ID");
		modelo.addColumn("Latitude");
		modelo.addColumn("Longitude");
		modelo.addColumn("Estado");
		modelo.addColumn("Cidade");
		modelo.addColumn("Bairro");
		modelo.addColumn("Rua");
		modelo.addColumn("Area");
	}
		/*
		 * //Trazendo a lista de terrenos para popular tabela. 
		 * Estou tendo problema
		 * com conexão com o banco , Segue o erro gerado:
		 * 
		 * Establishing SSL connection without server's identity
		 * verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and
		 * 5.7.6+ requirements SSL connection must be established by default if explicit
		 * option isn't set. For compliance with existing applications not using SSL the
		 * verifyServerCertificate property is set to 'false'. You need either to
		 * explicitly disable SSL by setting useSSL=false, or set useSSL=true and
		 * provide truststore for server certificate verification.
		 */
		private void popularTabela(Terreno terreno)
		{
			if(terreno != null)
			{
				modelo.addRow(new Object[] {terreno.getId(), terreno.getLatitude(), terreno.getLongitude(), terreno.getEstado(),
						terreno.getCidade(), terreno.getBairro(), terreno.getRua(),terreno.getArea()});
			}
		}
		private void zerarTabela()
		{
			while(modelo.getRowCount() > 0)
			{
				modelo.removeRow(0);
			}
		}
}
