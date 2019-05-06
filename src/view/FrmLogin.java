package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controle.UsuarioControle;
import modelo.Usuario;

public class FrmLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame janela = new JFrame("Login - Vistoria");
		janela.setSize(248, 146);
		
		
		JPanel panel = new JPanel();
		janela.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(11, 8, 47, 14);
		panel.add(lblLogin);
		
		JTextField txtLogin = new JTextField(15);
		txtLogin.setBounds(68, 5, 141, 20);
		panel.add(txtLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(11, 46, 47, 14);
		panel.add(lblSenha);
		
		JPasswordField pwdSenha = new JPasswordField(15);
		pwdSenha.setBounds(68, 43, 141, 20);
		panel.add(pwdSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(78, 71, 87, 25);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				UsuarioControle controle = new UsuarioControle();
				if(controle.buscarUsuario(txtLogin.getText(), String.valueOf(pwdSenha.getPassword())))
				{
					new FrmMenu();
					janela.dispose();
				}
				else
				{
					
				}
			}
		});
		
		
		panel.add(btnEntrar);
		
		
		
		janela.setVisible(true);
				
	}

}
