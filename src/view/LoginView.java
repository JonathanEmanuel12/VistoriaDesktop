package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginView {

	static JFrame janela;
	static JPanel panel;
	static JLabel lblNome;
	static JTextField txtNome;
	static JLabel lblLogin;
	static JTextField txtLogin;
	static JLabel lblSenha;
	static JTextField txtSenha;
	static JLabel lblConfirmarSenha;
	static JTextField txtConfirmarSenha;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		janela = new JFrame("Login - Vistoria");
		panel = new JPanel();
		janela.add(panel);
		
		lblNome = new JLabel("Nome: ");
		panel.add(lblNome);
		
		txtNome = new JTextField();
		panel.add(txtNome);
		
		lblLogin = new JLabel("Login: ");
		panel.add(lblLogin);
		
		txtLogin = new JTextField();
		panel.add(txtLogin);
		
		lblSenha = new JLabel("Senha: ");
		panel.add(lblSenha);
		
		lblConfirmarSenha = new JLabel("Confirme sua senha: ");
		panel.add(lblConfirmarSenha);
			}


}
