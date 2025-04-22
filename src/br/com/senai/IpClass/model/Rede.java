package br.com.senai.IpClass.model;

public class Rede {
	private String ip;
	private int maskCidr = 24;
	private double maskPadraoDecimal;
	private int maskPadraoBinario;
	private String classe;
	
	public void setIp (String ip) {
		this.ip = ip;
	}
	
	public void setMaskCidr(int maskCidr) {
		this.maskCidr = maskCidr;
	}
	
	public void definirClasse() {
		String[] partesIp = ip.split("\\."); // usa dois \\ porque . é um caractere especial em regex
		int octeto = Integer.parseInt(partesIp[0]);
		if (octeto <= 127) {
			classe = "A";
			System.out.println(octeto+classe);
		} 
		else if (octeto >=128 && octeto <=191) {
			classe = "B";
			System.out.println(octeto+classe);
		}
		else if (octeto >= 192 && octeto <=223) {
			classe = "C";
			System.out.println(octeto+classe);
		} else {
			classe = "D";
			System.out.println(octeto+classe);
		}
	}
	
	public void definirMaskPadraoDecimal() {
		
	}
	
	public void definirMaskPadraoBinario() {
		
	}
	
	public void definirIpsDisponiveis() {
		
	}
}
