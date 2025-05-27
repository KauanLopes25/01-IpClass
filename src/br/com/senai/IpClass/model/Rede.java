package br.com.senai.IpClass.model;

public class Rede {
	private String ip;
	private int maskCidr = 24;
	private String maskPadraoDecimal;
	private int maskPadraoBinario;
	private String classe;
	
	public void setIp (String ip) {
		this.ip = ip;
	}
	
	public void setMaskCidr(int maskCidr) {
		this.maskCidr = maskCidr;
	}
	
	public void definirClasse() {
		String[] ipClasse = ip.split("\\."); // usa dois \\ porque . é um caractere especial em regex
		int octeto = Integer.parseInt(ipClasse[0]);
		if (octeto <= 127) {
			classe = "A";  
		} 
		else if (octeto >=128 && octeto <=191) {
			classe = "B";
		}
		else if (octeto >= 192 && octeto <=223) {
			classe = "C";
		} else {
			classe = "D";
		}
	}
	
	public void definirMaskPadraoDecimal() {
		String[] ipCidr = ip.split("/");
		int cidr = Integer.parseInt(ipCidr[1]);
		int[] mascara = new int[4];
		if (cidr <= 8) {
			
				mascara[0] = 1;
				for(int i = cidr; i > 1; i--) {
					mascara[0] = mascara[0]/2;
				}
			
		System.out.println("mascara decimal: "+mascara[0]+".0.0.0");
		}
	}
	
	public void definirMaskPadraoBinario() {
		
	}
	
	public void definirIpsDisponiveis() {
		
	}
	
}
