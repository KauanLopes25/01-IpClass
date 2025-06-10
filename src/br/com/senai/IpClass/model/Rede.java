package br.com.senai.IpClass.model;

public class Rede {
	private String ip;
	private String maskPadraoDecimal;
	private String maskPadraoBinario;
	private String classe;
	private int maskCidr;
	private double ipsDisponiveis;

	public void setIp(String ip) {
		this.ip = ip;
		setMaskCidr(maskCidr);
	}

	public void setMaskCidr(int maskCidr) {
		
		// Criado vetor para armazenar o CIDR do IP
		String[] cidrDoIp = ip.split("/");
		// Convertido o CIDR de string para inteiro
		maskCidr = Integer.parseInt(cidrDoIp[1]);
		this.maskCidr = maskCidr;
	}

	public void definirClasse() {
		String[] ipClasse = ip.split("\\."); // usa dois \\ porque . � um caractere especial em regex
		int octeto = Integer.parseInt(ipClasse[0]);
		if (octeto <= 127) {
			classe = "A";
		} else if (octeto >= 128 && octeto <= 191) {
			classe = "B";
		} else if (octeto >= 192 && octeto <= 223) {
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
		for (int i = cidr, j = 1; i > 0 && i < 9; i--, j = j * 2) {
			mascaraDecimal[0] = 128 / j + mascaraDecimal[0];
		}

		// Lógica para defição do segundo octeto da mascará padrão decimál
		for (int i = cidr, j = 1; i > 8 && i < 17; i--, j = j * 2) {
			mascaraDecimal[0] = 255;
			mascaraDecimal[1] = 128 / j + mascaraDecimal[1];
		}

		// Lógica para defição do terceiro octeto da mascará padrão decimál
		for (int i = cidr, j = 1; i > 16 && i < 25; i--, j = j * 2) {
			mascaraDecimal[0] = 255;
			mascaraDecimal[1] = 255;
			mascaraDecimal[2] = 128 / j + mascaraDecimal[2];
		}

		// Lógica para defição do terceiro octeto da mascará padrão decimál
		for (int i = cidr, j = 1; i > 24 && i < 33; i--, j = j * 2) {
			mascaraDecimal[0] = 255;
			mascaraDecimal[1] = 255;
			mascaraDecimal[2] = 255;
			mascaraDecimal[3] = 128 / j + mascaraDecimal[3];
		}

		System.out.println("Mascara padrao decimal: " + mascaraDecimal[0] + "." + mascaraDecimal[1] + "."
				+ mascaraDecimal[2] + "." + mascaraDecimal[3]);

	}

	public void definirMaskPadraoBinario() {
		// Criado vetor para mascara decimal de rede
		String mascaraBinario[] = new String[4];
		mascaraBinario[0] = " ";
		mascaraBinario[1] = " ";
		mascaraBinario[2] = " ";
		mascaraBinario[3] = " ";
		// Criado vetor para armazenar o CIDR do IP
		String[] cidrDoIp = ip.split("/");
		// Convertido o CIDR de string para inteiro
		int cidr = Integer.parseInt(cidrDoIp[1]);

		// Lógica para defição do 1� conjunto de mascará padrão bin�rio

		for (int i = cidr, j = 8; i > 0 && i < 9; i--, j--) {

			mascaraBinario[0] = mascaraBinario[0] + "1";
			mascaraBinario[1] = "00000000";
			mascaraBinario[2] = "00000000";
			mascaraBinario[3] = "00000000";

			while (i == 1 && j > 1) {
				mascaraBinario[0] = mascaraBinario[0] + "0";
				j--;
			}
		}

		// Lógica para defição do 2� conjunto de mascará padrão bin�rio
		for (int i = cidr, j = 8; i > 8 && i < 17; i--, j--) {

			mascaraBinario[0] = "11111111";
			mascaraBinario[1] = mascaraBinario[1] + "1";
			mascaraBinario[2] = "00000000";
			mascaraBinario[3] = "00000000";

			while (i == 9 && j > 1) {
				mascaraBinario[1] = mascaraBinario[1] + "0";
				j--;
			}
		}

		// Lógica para defição do 3� conjunto de mascará padrão bin�rio
		for (int i = cidr, j = 8; i > 16 && i < 25; i--, j--) {

			mascaraBinario[0] = "11111111";
			mascaraBinario[1] = "11111111";
			mascaraBinario[2] = mascaraBinario[2] + "1";
			mascaraBinario[3] = "00000000";

			while (i == 17 && j > 1) {
				mascaraBinario[2] = mascaraBinario[2] + "0";
				j--;
			}
		}
		// Lógica para defição do 3� conjunto de mascará padrão bin�rio
		for (int i = cidr, j = 8; i > 24 && i < 33; i--, j--) {

			mascaraBinario[0] = "11111111";
			mascaraBinario[1] = "11111111";
			mascaraBinario[2] = "11111111";
			mascaraBinario[3] = mascaraBinario[3] + "1";

			while (i == 25 && j > 1) {
				mascaraBinario[3] = mascaraBinario[3] + "0";
				j--;
			}
		}

		System.out.println("Mascara padrao binário: " + mascaraBinario[0] + "   " + mascaraBinario[1] + "   "
				+ mascaraBinario[2] + "   " + mascaraBinario[3]);

	}

	public double definirIpsDisponiveis() {
		ipsDisponiveis = Math.pow(2, (32 - maskCidr))-2;
		System.out.println(ipsDisponiveis);
		return ipsDisponiveis;
		
	}

}
