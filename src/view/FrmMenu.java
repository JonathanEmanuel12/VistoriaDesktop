package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMenu {

	public FrmMenu()
	{

		JFrame janela = new JFrame("Menu - Vistoria");
		janela.setSize(400, 400);
		
		JPanel panel = new JPanel();
		janela.getContentPane().add(panel);
		
		JButton btnAddUsuario = new JButton("Add Usuário");
		btnAddUsuario.setBounds(68, 5, 120, 25);
		btnAddUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmCadastroUsuario();
				
			}
		});
		panel.setLayout(null);
		
		panel.add(btnAddUsuario);
		
		JButton btnAddTerreno = new JButton("Add Terreno");
		btnAddTerreno.setBounds(193, 5, 120, 25);
		btnAddTerreno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmCadastroTerreno();
				
			}
		});
		
		panel.add(btnAddTerreno);
		
		JButton btnVistoria = new JButton("Vistoria");
		btnVistoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmVistoria();
				
			}
		});
		btnVistoria.setSize(120, 25);
		btnVistoria.setLocation(148, 41);
		panel.add(btnVistoria);
		janela.setVisible(true);
		
		
		
	}

}
