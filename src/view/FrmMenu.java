package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame janela = new JFrame("Menu - Vistoria");
		janela.setSize(400, 400);
		
		JPanel panel = new JPanel();
		janela.getContentPane().add(panel);
		
		JButton btnAddUsuario = new JButton("Add Usuário");
		btnAddUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmCadastroUsuario();
				janela.dispose();
			}
		});
		
		panel.add(btnAddUsuario);
		
		
	}

}
