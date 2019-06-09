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
	private JTextField txtDocumento;
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
		lblArea.setBounds(10, 248, 48, 14);
		lblDocumento.add(lblArea);
		
		txtArea = new JTextField(20);
		txtArea.setBounds(75, 245, 186, 20);
		lblDocumento.add(txtArea);
		
		JLabel lblNewLabel = new JLabel("Documento:");
		lblNewLabel.setBounds(10, 278, 59, 14);
		lblDocumento.add(lblNewLabel);
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(75, 276, 186, 20);
		lblDocumento.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		JButton btnSalvarInformacoes = new JButton("Salvar informa\u00E7\u00F5es do terreno");
		btnSalvarInformacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double medida; int id;  boolean x;  int coluna=0; String objId;
				objId = table.getValueAt(table.getSelectedRow(), coluna).toString();
				Usuario usuario = Usuario.usuarioAtual;
				medida = Double.parseDouble(txtArea.getText());
				EstagiarioTerrenoControle et = new EstagiarioTerrenoControle();
				x = et.inserirMedidasTerreno(objId, medida);
				if (x){
				JOptionPane.showMessageDialog(null, "Medidas Inseridas!");
				popularTabela(new TerrenoControle().buscarTerrenosLivres());
				}else {
					JOptionPane.showMessageDialog(null, "Erro na inserção de Medidas!");
				}
			}
		});
		btnSalvarInformacoes.setBounds(271, 274, 186, 23);
		lblDocumento.add(btnSalvarInformacoes);
		
		criarTabela();
		popularTabela(new TerrenoControle().buscarTerrenosLivres());
		table = new JTable(modelo);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 35, 617, 202);
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
		public void popularTabela(List<Terreno> terrenos)
		{
			for(Terreno terreno : terrenos)
			{
				modelo.addRow(new Object[] {terreno.getId(), terreno.getLatitude(), terreno.getLongitude(), terreno.getEstado(),
						terreno.getCidade(), terreno.getBairro(), terreno.getRua(),terreno.getArea()});
			}
		}
}
