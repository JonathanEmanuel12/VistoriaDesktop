package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmEstagiarioVist {

	JFrame janela;
	JPanel panel;
	JLabel lblTerreno;
	JTextArea txaTerreno;
	JLabel lblArea;
	JTextField txtArea;
	JButton btnSalvar;
	
	public FrmEstagiarioVist()
	{
		janela = new JFrame("Vistoria - Minhas Vistorias");
		janela.setSize(563, 384);
		
		panel = new JPanel();
		janela.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblTerreno = new JLabel("Informações do Terreno");
		lblTerreno.setBounds(10, 10, 117, 14);
		panel.add(lblTerreno);
		
		txaTerreno = new JTextArea(10, 20);
		txaTerreno.setBounds(10, 35, 170, 260);
		panel.add(txaTerreno);
		
		lblArea = new JLabel("Área: ");
		lblArea.setBounds(237, 40, 48, 14);
		panel.add(lblArea);
		
		txtArea = new JTextField(20);
		txtArea.setBounds(295, 37, 186, 20);
		panel.add(txtArea);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSalvar.setBounds(237, 311, 80, 23);
		panel.add(btnSalvar);
		
	}
}
