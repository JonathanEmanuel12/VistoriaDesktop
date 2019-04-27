package view;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FrmLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame janela = new JFrame("Login - Vistoria");
		janela.setSize(400, 400);
		
		
		JPanel panel = new JPanel();
		janela.getContentPane().add(panel);
		
		JLabel lblLogin = new JLabel("Login:");
		panel.add(lblLogin);
		
		JTextField txtLogin = new JTextField(15);
		panel.add(txtLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		panel.add(lblSenha);
		
		JPasswordField pwdSenha = new JPasswordField(15);
		panel.add(pwdSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmMenu();
				janela.dispose();
				
			}
		});
		
		
		panel.add(btnEntrar);
		
		
		
		janela.setVisible(true);
				
	}

}
