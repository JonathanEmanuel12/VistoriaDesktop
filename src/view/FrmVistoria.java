package view;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.TerrenoControle;
import controle.UsuarioControle;
import modelo.Terreno;
import modelo.Usuario;

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
		popularTabela(new TerrenoControle().buscarTerrenosLivres());
		tabTerrenos = new JTable(model);
		scroll = new JScrollPane(tabTerrenos);
		scroll.setBounds(33, 24, 452, 402);
		panel.add(scroll);
		
		lblEstagiarios = new JLabel("Estagiários Disponíveis");
		lblEstagiarios.setBounds(33, 435, 148, 14);
		panel.add(lblEstagiarios);
		
		cbxEstagiarios = new JComboBox<Usuario>();
		cbxEstagiarios.setBounds(211, 431, 98, 22);
		popularComboBox();
		panel.add(cbxEstagiarios);
		
		btnConfirmar = new JButton("Confirmar");
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