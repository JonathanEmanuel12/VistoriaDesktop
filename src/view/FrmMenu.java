package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class FrmMenu {

	public FrmMenu()
	{

		JFrame janela = new JFrame("Menu - Vistoria");
		janela.setSize(400, 400);
		
		JPanel panel = new JPanel();
		janela.getContentPane().add(panel);
		panel.setLayout(null);
		
		JMenu menuTerreno = new JMenu("Terreno");
		
		JMenuItem itemTerreno = new JMenuItem("Cadastrar Terreno");
		itemTerreno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmCadastroTerreno();
			}
		});
		menuTerreno.add(itemTerreno);
		
		JMenu menuUsuario = new JMenu("Usuário");
		
		JMenuItem itemUsuario = new JMenuItem("Cadastrar Usuário");
		itemUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmCadastroUsuario();
			}
		});
		menuUsuario.add(itemUsuario);
		
		JMenu menuVistoria = new JMenu("Vistoria");
		
		JMenuItem itemVistoria = new JMenuItem("Criar Vistorias");
		itemVistoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmVistoria();
			}
		});
		menuVistoria.add(itemVistoria);
			
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 11, 334, 22);
		menuBar.add(menuTerreno);
		menuBar.add(menuUsuario);
		menuBar.add(menuVistoria);
		panel.add(menuBar);
		
		
		
		janela.setVisible(true);
		
		
		
	}
}
