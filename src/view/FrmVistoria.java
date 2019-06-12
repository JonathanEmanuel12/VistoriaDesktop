package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controle.TerrenoControle;
import controle.UsuarioControle;
import controle.VistoriaControle;
import modelo.Terreno;
import modelo.Usuario;
import modelo.Vistoria;

public class FrmVistoria {

	JFrame janela;
	JPanel panel;
	JLabel lblTerrenos;
	private DefaultTableModel model;
	JTable tabTerrenos;
	JScrollPane scroll;
	JLabel lblEstagiarios;
	JComboBox<Usuario> cbxEstagiarios;
	JButton btnConfirmar;
	JLabel lblPrazo;
	JTextField txtPrazo;
	JLabel lblDataEntrega;
	List<Terreno> terrenos;
	Date dataEntregaSQL;
	
	
	
	
	public FrmVistoria()
	{
		janela = new JFrame("Criação de Vistorias - Vistoria");
		janela.setSize(534,528);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		janela.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblTerrenos = new JLabel("Terrenos Disponíveis");
		lblTerrenos.setBounds(208, 5, 101, 14);
		panel.add(lblTerrenos);
		
		criarTabela();
		terrenos = new TerrenoControle().buscarTerrenosLivres();
		popularTabela(terrenos);
		tabTerrenos = new JTable(model);
		scroll = new JScrollPane(tabTerrenos);
		scroll.setBounds(33, 24, 452, 335);
		panel.add(scroll);
		
		lblEstagiarios = new JLabel("Estagiários Disponíveis");
		lblEstagiarios.setBounds(33, 381, 148, 14);
		panel.add(lblEstagiarios);
		
		cbxEstagiarios = new JComboBox<Usuario>();
		cbxEstagiarios.setBounds(191, 377, 139, 22);
		popularComboBox();
		panel.add(cbxEstagiarios);
		
		lblPrazo = new JLabel("Prazo(em dias): ");
		lblPrazo.setBounds(33, 406, 111, 15);
		panel.add(lblPrazo);
		
		lblDataEntrega = new JLabel("");
		lblDataEntrega.setBounds(33, 432, 297, 15);
		panel.add(lblDataEntrega);
	
		txtPrazo = new JTextField();
		txtPrazo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				java.util.Date dataEntrega = new java.util.Date();
				dataEntrega.setDate(dataEntrega.getDate() + Integer.parseInt(txtPrazo.getText()));
				dataEntregaSQL = new Date(dataEntrega.getTime());
				String dia, mes, ano;
				ano = dataEntregaSQL.toString().substring(0, 4);
				mes = dataEntregaSQL.toString().substring(5,  7);
				dia = dataEntregaSQL.toString().substring(8);
				lblDataEntrega.setText("Data de Entrega: " + dia + "/" + mes + "/" + ano);
			}
		});
		txtPrazo.setBounds(191, 406, 139, 22);
		panel.add(txtPrazo);
	
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistoriaControle controle = new VistoriaControle();
				
				Vistoria vistoria = new Vistoria();
				vistoria.setDataEntrega(dataEntregaSQL);
				vistoria.setEstagiarioResp((Usuario)cbxEstagiarios.getSelectedItem());
				vistoria.setTerreno(terrenos.get(tabTerrenos.getSelectedRow()));
				
				if(controle.criarVistoria(vistoria))
				{
					System.out.println("Agora foi");
				}
			}
		});
		btnConfirmar.setBounds(175, 466, 107, 23);
		panel.add(btnConfirmar);
		
		
		janela.setVisible(true);
		
		
		
		
			
	}
	
	private void criarTabela()
	{
		model = new DefaultTableModel();
		model.addColumn("Estado");
		model.addColumn("Cidade");
		model.addColumn("Bairro");
		model.addColumn("Rua");
		model.addColumn("Número");
	}
	public void popularTabela(List<Terreno> terrenos)
	{
		for(Terreno terreno : terrenos)
		{
			model.addRow(new Object[] {terreno.getEstado(), terreno.getCidade(), terreno.getBairro(), terreno.getRua(), terreno.getNumero()});
		}
	}
	public void popularComboBox()
	{
		UsuarioControle controle =  new UsuarioControle();
		List<Usuario> estagiarios = controle.buscarEstagiariosLivres();
		
		for(Usuario estagiario : estagiarios)
		{
			cbxEstagiarios.addItem(estagiario);	
		}
		
	
	}
}