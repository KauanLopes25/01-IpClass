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
		String[] ipClasse = ip.split("\\."); // usa dois \\ porque . � um caractere especial em regex
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
		// Criado vetor para mascara decimal de rede 
		int[] mascaraDecimal = new int[4];
		// Criado vetor para armazenar o CIDR do IP
		String[] cidrDoIp = ip.split("/");
		// Convertido o CIDR de string para inteiro
		int cidr = Integer.parseInt(cidrDoIp[1]);
		
		if (cidr <=8) {
			mascaraDecimal[0] = 128;
			for (int i = cidr;i > 0 && i <= 8; i--) {
				int correios = 128 / 2 ;
			}
			
		System.out.println("Mascará em Decimal: "+mascaraDecimal[0]);
		}
		
					
			
			
	}
	
	public void definirMaskPadraoBinario() {
		
	}
	
	public void definirIpsDisponiveis() {
		
	}
	
}
