package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controle.TerrenoControle;
import modelo.Terreno;

public class FrmCadastroTerreno {

	public FrmCadastroTerreno()
	{
		JFrame janela = new JFrame("Cadastro de Terrenos - Vistoria");
		janela.setSize(400, 250);
		
		JPanel panel = new JPanel();
		janela.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLatitude = new JLabel("Latitude:");
		lblLatitude.setToolTipText("Preencher todos os caracteres. Exemplo: 99\u00B099\u00B4\u00B499\u00B4S");
		lblLatitude.setBounds(4, 8, 93, 14);
		panel.add(lblLatitude);
		
		
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("##°##´´##´U");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mascara.setValidCharacters("1234567890NSLO");

		JFormattedTextField fxtLatitude = new JFormattedTextField(mascara);
		fxtLatitude.setBounds(98, 5, 85, 20);
		panel.add(fxtLatitude);
		
		JLabel lblLongitude = new JLabel("Longitude:");
		lblLongitude.setToolTipText("Preencha todos os caracteres. Exemplo: 99\u00B099\u00B4\u00B499\u00B4L");
		lblLongitude.setBounds(197, 8, 99, 14);
		panel.add(lblLongitude);
		
		JFormattedTextField fxtLongitude = new JFormattedTextField(mascara);
		fxtLongitude.setBounds(289, 5, 85, 20);
		panel.add(fxtLongitude);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(4, 39, 59, 14);
		panel.add(lblEstado);
		
		JTextField txtEstado = new JTextField(15);
		txtEstado.setBounds(73, 33, 110, 20);
		panel.add(txtEstado);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(4, 67, 59, 14);
		panel.add(lblCidade);
		
		JTextField txtCidade = new JTextField(15);
		txtCidade.setBounds(73, 64, 110, 20);
		panel.add(txtCidade);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(4, 95, 59, 14);
		panel.add(lblBairro);
		
		JTextField txtBairro = new JTextField(15);
		txtBairro.setBounds(73, 92, 110, 20);
		panel.add(txtBairro);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(195, 36, 59, 14);
		panel.add(lblRua);
		
		JTextField txtRua = new JTextField(15);
		txtRua.setBounds(264, 33, 110, 20);
		panel.add(txtRua);
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setBounds(191, 64, 63, 14);
		panel.add(lblNumero);
		
		JTextField txtNumero = new JTextField(15);
		txtNumero.setBounds(264, 61, 110, 20);
		panel.add(txtNumero);
		
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setBounds(4, 191, 370, 20);	
		panel.add(lblMensagem);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Terreno terreno = new Terreno(fxtLatitude.getText(), fxtLongitude.getText(), txtEstado.getText(), txtCidade.getText(), txtBairro.getText(), txtRua.getText(), Integer.parseInt("0"+txtNumero.getText()));
				TerrenoControle controle = new TerrenoControle();
				lblMensagem.setText(controle.inserirTerreno(terreno));
			}
		});
		btnSalvar.setSize(93, 25);
		btnSalvar.setLocation(143, 169);
		panel.add(btnSalvar);
				
		janela.setVisible(true);
		
		
		
		
		
		
		
	}
}
