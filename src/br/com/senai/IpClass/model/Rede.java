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
		
		// Lógica para defição do primeiro octeto da mascará padrão decimál
		for (int i = cidr, j = 1; i > 0 && i < 9; i--,j= j * 2) {
			mascaraDecimal[0] = 128/j + mascaraDecimal[0] ;
		}
		
		// Lógica para defição do segundo octeto da mascará padrão decimál
		for (int i = cidr, j = 1; i > 8 && i < 17; i--,j= j * 2) {
			mascaraDecimal[0] = 255;
			mascaraDecimal[1] = 128/j + mascaraDecimal[1] ;
		}
		
		// Lógica para defição do terceiro octeto da mascará padrão decimál
		for (int i = cidr, j = 1; i > 16 && i < 25; i--,j= j * 2) {
			mascaraDecimal[0] = 255;
			mascaraDecimal[1] = 255;
			mascaraDecimal[2] = 128/j + mascaraDecimal[2] ;
		}
		
		// Lógica para defição do terceiro octeto da mascará padrão decimál
		for (int i = cidr, j = 1; i > 24 && i < 33; i--,j= j * 2) {
			mascaraDecimal[0] = 255;
			mascaraDecimal[1] = 255;
			mascaraDecimal[2] = 255;
			mascaraDecimal[3] = 128/j + mascaraDecimal[3] ;
		}
		
		System.out.println("Mascara padrao decimal: "+mascaraDecimal[0]+"."+mascaraDecimal[1]+"."+mascaraDecimal[2]+"."+mascaraDecimal[3]);
		
	}
	
	public void definirMaskPadraoBinario() {
		// Criado vetor para mascara decimal de rede 
		boolean[] mascaraBinario = new boolean[32];
		// Criado vetor para armazenar o CIDR do IP
		String[] cidrDoIp = ip.split("/");
		// Convertido o CIDR de string para inteiro
		int cidr = Integer.parseInt(cidrDoIp[1]);
		
		// Lógica para defição do terceiro octeto da mascará padrão decimál
		for (int i = cidr, j = 0; i > 0 && i < 33; i--,j++) {
			mascaraBinario[j] = true;
		}
		
		System.out.println("Mascara padrao binário: "+mascaraBinario[0]+"."+mascaraBinario[1]+"."+mascaraBinario[2]+"."+mascaraBinario[3]);
		
		
	}
	
	public void definirIpsDisponiveis() {
		
	}
	
}
