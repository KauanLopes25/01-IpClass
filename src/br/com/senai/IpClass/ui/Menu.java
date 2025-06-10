package br.com.senai.IpClass.ui;

import java.util.Scanner;

import br.com.senai.IpClass.model.Rede;

public class Menu {
	
	public static void mostrarMenu() {
		Rede rede = new Rede();
		Scanner reader = new Scanner(System.in);
		
		System.out.println("--------------------------------------");
		System.out.println("Bem vindo ao auxiliar de Rede do SENAI");
		System.out.println("--------------------------------------");
		System.out.println("Digite um IP com CIDR como no exemplo: 192.168.0.0/24");
		// recebendo ip
		
		rede.setIp(reader.nextLine());
		
		//resultado
		rede.definirClasse();
		rede.definirMaskPadraoDecimal();
		//rede.definirMaskPadraoBinario();
	    reader.close();
	}
}
