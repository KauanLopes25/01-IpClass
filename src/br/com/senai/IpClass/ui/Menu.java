package br.com.senai.IpClass.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import br.com.senai.IpClass.model.Rede;

public class Menu {
	
	
	//Atributo caixa de texto
	private JTextField txCalculadora;
	
	//Atributo caixa de informação
	private JLabel labelCalculadora;
	
	//Atributo botoes de operação
	private JButton btCalcular;
	private JButton btLimpar;
	
	//Atributo listas
	private JList listaIpInfo;
	private JList listaSubRede;
	
	//Atributo container de scroll
	private JScrollPane scrollIpInfo;
	private JScrollPane scrollSubRede;
	
	//Métodos
	public static void criarTela() {
		// Método para criação da tela
		JFrame tela = new JFrame();
		tela.setTitle("Calculadora de sub-rede IP");
		tela.setSize(1024, 632);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		
		//Formatando elementos label,textfield, list, scroll e button.
		JLabel labelCalculadora = new JLabel();
		labelCalculadora.setBounds(80, 20, 100, 20);
		labelCalculadora.setText("Direção IP:");
		
		JTextField txCalculadora = new JTextField();
		txCalculadora.setBounds(80, 40, 500, 50);
		txCalculadora.setFont(new Font("Arial", Font.PLAIN, 32));;
		
		//Criar os buttoms
		
		JButton btCalcular = new JButton();
		btCalcular.setBounds(660, 45, 100, 40);
		btCalcular.setText("Calcular");
		btCalcular.setFont(new Font("Arial", Font.PLAIN, 16));;
		
		JButton btLimpar = new JButton();
		btLimpar.setBounds(810, 45, 100, 40);
		btLimpar.setText("Limpar");
		btLimpar.setFont(new Font("Arial", Font.PLAIN, 16));;
		
		// Criar o JList que vai receber a tabuada
		JList listaIpInfo = new JList();
		listaIpInfo.setFont(new Font("Arial", Font.PLAIN, 16));
		
		//Criar container scroll painel
		JScrollPane scrollIpInfo = new JScrollPane(listaIpInfo);
		scrollIpInfo.setBounds(80, 130, 500, 150);
		
		
		// Obtendo referência do Container, o painel de conteudo da janela
		Container container = tela.getContentPane();
		
		// Adicionando elementos na janela
		container.add(labelCalculadora);
		container.add(txCalculadora);
		container.add(btCalcular);
		container.add(btLimpar);
		container.add(scrollIpInfo);
		
		btCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Rede rede = new Rede();
				String[] batata = rede.resultadoIpInfo(txCalculadora.getText());
				listaIpInfo.setListData(rede.resultadoIpInfo(txCalculadora.getText()));
			}
		});
		
		btLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txCalculadora.setText(null);
				listaIpInfo.setListData(new String[1]);
	
			}
		});
		
		tela.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void mostrarMenu() {
		// Método para testes de funcionalidades no console
		/*Scanner reader = new Scanner(System.in);
		
		System.out.println("--------------------------------------");
		System.out.println("Bem vindo ao auxiliar de Rede do SENAI");
		System.out.println("--------------------------------------");
		System.out.println("Digite um IP com CIDR como no exemplo: 192.168.0.0/24");
//		 recebendo ip
		
		rede.setIp(reader.nextLine());
		
		resultado
		rede.definirClasse();
		rede.definirMaskPadraoDecimal();
		rede.definirMaskPadraoBinario();
		rede.definirIpsDisponiveis();
	    reader.close();*/
	}
}
