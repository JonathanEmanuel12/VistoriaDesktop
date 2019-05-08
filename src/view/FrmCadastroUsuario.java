package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controle.UsuarioControle;
import modelo.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class FrmCadastroUsuario {


	
	
	public FrmCadastroUsuario()
	{
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
		JLabel lblMensagem;
		
		janela = new JFrame("Cadastro de Usuário - Vistoria");
		janela.setSize(391, 263);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		janela.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNome = new JLabel("Nome: ");
		lblNome.setBounds(81, 8, 59, 14);
		panel.add(lblNome);
		
		txtNome = new JTextField(15);
		txtNome.setBounds(152, 8, 141, 20);
		panel.add(txtNome);
		
		lblLogin = new JLabel("Login: ");
		lblLogin.setBounds(83, 33, 65, 14);
		panel.add(lblLogin);
		
		txtLogin = new JTextField(15);
		txtLogin.setBounds(152, 33, 141, 20);
		panel.add(txtLogin);
		
		lblSenha = new JLabel("Senha: ");
		lblSenha.setBounds(79, 57, 72, 14);
		panel.add(lblSenha);

		txtSenha = new JTextField(15);
		txtSenha.setBounds(152, 58, 141, 20);
		panel.add(txtSenha);

		
		lblConfirmarSenha = new JLabel("Confirme sua senha: ");
		lblConfirmarSenha.setBounds(12, 82, 136, 14);
		panel.add(lblConfirmarSenha);
		
		txtConfirmarSenha = new JTextField(15);
		txtConfirmarSenha.setBounds(152, 82, 141, 20);
		panel.add(txtConfirmarSenha);
		
		lblMensagem = new JLabel("");
		lblMensagem.setSize(359, 20);
		lblMensagem.setLocation(12, 204);
		panel.add(lblMensagem);
		
		JRadioButton rdbtnGestor = new JRadioButton("Gestor");
		rdbtnGestor.setBounds(73, 127, 109, 23);
		panel.add(rdbtnGestor);
		
		JRadioButton rdbtnEstagiario = new JRadioButton("Estagi\u00E1rio");
		rdbtnEstagiario.setBounds(184, 127, 109, 23);
		panel.add(rdbtnEstagiario);
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnGestor);
		btnGroup.add(rdbtnEstagiario);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtSenha.getText().equals(txtConfirmarSenha.getText()))
				{
					Usuario usuario = new Usuario();
					usuario.setNome(txtNome.getText());
					usuario.setLogin(txtLogin.getText());
					usuario.setSenha(txtSenha.getText());
					
					if(rdbtnGestor.isSelected())
					{
						System.out.println("Gestor");
						usuario.setTipo(1);
					}
					if(rdbtnEstagiario.isSelected()) 
					{
						System.out.println("Estagiário");
						usuario.setTipo(0);
					}
					
					if(usuario.getTipo() != -1)
					{
						UsuarioControle controle = new UsuarioControle();
						lblMensagem.setText(controle.cadastrarUsuario(usuario));
					}
				}
				else
				{
					lblMensagem.setText("Senha não confirmada");
				}
			}
		});
		btnSalvar.setBounds(143, 168, 93, 25);
		panel.add(btnSalvar);
		

		

		

		
		janela.setVisible(true);
		
			}
}
