package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginView {


	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame janela;
		JPanel panel;
		JLabel lblNome;
		JTextField txtNome;
		JLabel lblLogin;
		JTextField txtLogin;
		JLabel lblSenha;
		JTextField txtSenha;
		JLabel lblConfirmarSenha;
		JTextField txtConfirmarSenha;
		JButton btnSalvar;
		
		janela = new JFrame("Cadastro de Usu�rio - Vistoria");
		janela.setSize(375, 191);
		panel = new JPanel();
		janela.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNome = new JLabel("Nome: ");
		lblNome.setBounds(81, 8, 35, 14);
		panel.add(lblNome);
		
		txtNome = new JTextField(15);
		txtNome.setBounds(138, 5, 141, 20);
		panel.add(txtNome);
		
		lblLogin = new JLabel("Login: ");
		lblLogin.setBounds(83, 33, 33, 14);
		panel.add(lblLogin);
		
		txtLogin = new JTextField(15);
		txtLogin.setBounds(138, 30, 141, 20);
		panel.add(txtLogin);
		
		lblSenha = new JLabel("Senha: ");
		lblSenha.setBounds(79, 57, 37, 14);
		panel.add(lblSenha);

		txtSenha = new JTextField(15);
		txtSenha.setBounds(138, 55, 141, 20);
		panel.add(txtSenha);

		
		lblConfirmarSenha = new JLabel("Confirme sua senha: ");
		lblConfirmarSenha.setBounds(12, 82, 104, 14);
		panel.add(lblConfirmarSenha);
		
		txtConfirmarSenha = new JTextField(15);
		txtConfirmarSenha.setBounds(138, 79, 141, 20);
		panel.add(txtConfirmarSenha);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(149, 123, 63, 23);
		panel.add(btnSalvar);
		
		janela.setVisible(true);
		
			}


}
