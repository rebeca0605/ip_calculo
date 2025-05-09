package br.dev.rebeca.ip_calculo.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.dev.rebeca.ip_calculo.model.CalculoIp;

public class TelaCalculo {

	// Componentes visuais
	private JLabel lblEndIp;
	private JLabel lblCidr;
	private JLabel lblIp;
	private JLabel lblClasseIp;
	private JLabel lblMascaraDecimal;
	private JLabel lblMascaraBinaria;
	private JLabel lblIpsDisponiveis;
	private JLabel lblResultado;
	private JLabel lblResulIp;
	private JLabel lblResulClasseIp;
	private JLabel lblResulMascDec;
	private JLabel lblResulMascBin;
	private JLabel lblResulIpsDisp;
	private JLabel lblMensagemErro;

	private JTextField txtPrimeiroOcteto;
	private JTextField txtSegundoOcteto;
	private JTextField txtTerceiroOcteto;
	private JTextField txtQuartoOcteto;
	private JTextField txtCidr;

	private JButton buttonCalcular;
	private JButton buttonLimpar;

	public void criarTelaCalculoIp() {
		JFrame tela = new JFrame();
		tela.setSize(500, 450);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Calculadora de IP");
		tela.setLayout(null);
		tela.setResizable(false);
		tela.setLocationRelativeTo(null);

		lblEndIp = new JLabel();
		lblEndIp.setText("Endereço de Ip:");
		lblEndIp.setBounds(25, 10, 350, 35);
		lblEndIp.setFont(new Font("Arial", Font.BOLD, 15));

		// Usuário deve inserir o IP
		txtPrimeiroOcteto = new JTextField();
		txtPrimeiroOcteto.setBounds(25, 40, 65, 30);
		txtPrimeiroOcteto.setHorizontalAlignment(txtPrimeiroOcteto.CENTER);

		txtSegundoOcteto = new JTextField();
		txtSegundoOcteto.setBounds(95, 40, 65, 30);
		txtSegundoOcteto.setHorizontalAlignment(txtSegundoOcteto.CENTER);

		txtTerceiroOcteto = new JTextField();
		txtTerceiroOcteto.setBounds(165, 40, 65, 30);
		txtTerceiroOcteto.setHorizontalAlignment(txtTerceiroOcteto.CENTER);

		txtQuartoOcteto = new JTextField();
		txtQuartoOcteto.setBounds(235, 40, 65, 30);
		txtQuartoOcteto.setHorizontalAlignment(txtQuartoOcteto.CENTER);

		lblCidr = new JLabel();
		lblCidr.setText("CIDR:");
		lblCidr.setBounds(375, 10, 350, 35);
		lblCidr.setFont(new Font("Arial", Font.BOLD, 15));

		txtCidr = new JTextField();
		txtCidr.setBounds(375, 40, 85, 30);
		txtCidr.setHorizontalAlignment(txtCidr.CENTER);

		buttonCalcular = new JButton();
		buttonCalcular.setText("Calcular");
		buttonCalcular.setBounds(25, 100, 215, 30);
		buttonCalcular.setFont(new Font("Arial", Font.BOLD, 17));
		buttonCalcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					int primeiroOcteto = Integer.parseInt(txtPrimeiroOcteto.getText());
					int segundoOcteto = Integer.parseInt(txtSegundoOcteto.getText());
					int terceiroOcteto = Integer.parseInt(txtTerceiroOcteto.getText());
					int quartoOcteto = Integer.parseInt(txtQuartoOcteto.getText());
					int cidr = Integer.parseInt(txtCidr.getText());

					CalculoIp calculadora = new CalculoIp();
					calculadora.setOctetos(primeiroOcteto, segundoOcteto, terceiroOcteto, quartoOcteto);
					calculadora.setCidr(cidr);

					lblResulIp.setText(calculadora.ipFormato());
					lblResulClasseIp.setText(calculadora.classeIp());
					lblResulMascDec.setText(calculadora.calcMascaraDecimal());
					lblResulMascBin.setText(calculadora.calcMascaraBinaria());
					lblResulIpsDisp.setText(String.valueOf(calculadora.calcNumIpsDisponiveis()));

					lblMensagemErro.setText("");

				} catch (NumberFormatException ex) {

					lblMensagemErro
							.setText("<html>A calculadora só funcionará corretamente <br> com números válidos.<html>");

				}

			}
		});

		buttonLimpar = new JButton();
		buttonLimpar.setText("Limpar");
		buttonLimpar.setBounds(245, 100, 215, 30);
		buttonLimpar.setFont(new Font("Arial", Font.BOLD, 17));
		buttonLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				txtPrimeiroOcteto.setText("");
				txtSegundoOcteto.setText("");
				txtTerceiroOcteto.setText("");
				txtQuartoOcteto.setText("");

				txtCidr.setText("");

				lblResulIp.setText("");
				lblResulClasseIp.setText("");
				lblResulMascDec.setText("");
				lblResulMascBin.setText("");
				lblResulIpsDisp.setText("");

				lblMensagemErro.setText("");
			}
		});

		lblIp = new JLabel();
		lblIp.setText("IP:");
		lblIp.setBounds(25, 160, 350, 35);
		lblIp.setFont(new Font("Arial", Font.BOLD, 15));

		lblClasseIp = new JLabel();
		lblClasseIp.setText("Classe IP:");
		lblClasseIp.setBounds(25, 185, 350, 35);
		lblClasseIp.setFont(new Font("Arial", Font.BOLD, 15));

		lblMascaraDecimal = new JLabel();
		lblMascaraDecimal.setText("Másc. Decimal:");
		lblMascaraDecimal.setBounds(25, 210, 350, 35);
		lblMascaraDecimal.setFont(new Font("Arial", Font.BOLD, 15));

		lblMascaraBinaria = new JLabel();
		lblMascaraBinaria.setText("Másc. Binária:");
		lblMascaraBinaria.setBounds(25, 235, 350, 35);
		lblMascaraBinaria.setFont(new Font("Arial", Font.BOLD, 15));

		lblIpsDisponiveis = new JLabel();
		lblIpsDisponiveis.setText("IPS Disponíveis:");
		lblIpsDisponiveis.setBounds(25, 260, 350, 35);
		lblIpsDisponiveis.setFont(new Font("Arial", Font.BOLD, 15));

		lblMensagemErro = new JLabel();
		lblMensagemErro.setBounds(97, 310, 400, 40);
		lblMensagemErro.setForeground(Color.red);
		lblMensagemErro.setFont(new Font("Arial", Font.BOLD, 15));
		
		lblResultado = new JLabel();
		lblResultado.setBounds(360, 160, 350, 35);
		lblResultado.setFont(new Font("Arial", Font.BOLD, 15));
		
		lblResulIp = new JLabel();
		lblResulIp.setBounds(360, 160, 350, 35);
		lblResulIp.setFont(new Font("Arial", Font.BOLD, 15));
		
		lblResulClasseIp = new JLabel();
		lblResulClasseIp.setBounds(450, 185, 350, 35);
		lblResulClasseIp.setFont(new Font("Arial", Font.BOLD, 15));
		
		lblResulMascDec = new JLabel();
		lblResulMascDec.setBounds(370, 210, 350, 35);
		lblResulMascDec.setFont(new Font("Arial", Font.BOLD, 15));
		
		lblResulMascBin = new JLabel();
		lblResulMascBin.setBounds(207, 235, 350, 35);
		lblResulMascBin.setFont(new Font("Arial", Font.BOLD, 15));
		
		lblResulIpsDisp = new JLabel();
		lblResulIpsDisp.setBounds(440, 260, 350, 35);
		lblResulIpsDisp.setFont(new Font("Arial", Font.BOLD, 15));
		
		tela.getContentPane().add(lblEndIp);
		tela.getContentPane().add(txtPrimeiroOcteto);
		tela.getContentPane().add(txtSegundoOcteto);
		tela.getContentPane().add(txtTerceiroOcteto);
		tela.getContentPane().add(txtQuartoOcteto);
		tela.getContentPane().add(lblCidr);
		tela.getContentPane().add(txtCidr);
		tela.getContentPane().add(buttonCalcular);
		tela.getContentPane().add(buttonLimpar);
		tela.getContentPane().add(lblIp);
		tela.getContentPane().add(lblClasseIp);
		tela.getContentPane().add(lblMascaraDecimal);
		tela.getContentPane().add(lblMascaraBinaria);
		tela.getContentPane().add(lblIpsDisponiveis);
		tela.getContentPane().add(lblMensagemErro);
		tela.getContentPane().add(lblResultado);
		tela.getContentPane().add(lblResulIp);
		tela.getContentPane().add(lblResulClasseIp);
		tela.getContentPane().add(lblResulMascDec);
		tela.getContentPane().add(lblResulMascBin);
		tela.getContentPane().add(lblResulIpsDisp);

		// Tornar a tela visível
		tela.setVisible(true);
	}

}