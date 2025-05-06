package br.dev.rebeca.ip_calculo.model;

public class CalculoIp {

	private int primeiroOcteto;
	private int segundoOcteto;
	private int terceiroOcteto;
	private int quartoOcteto;
	private int cidr;

	public void setOctetos(int primeiroOcteto, int segundoOcteto, int terceiroOcteto, int quartoOcteto) {
		this.primeiroOcteto = primeiroOcteto;
		this.segundoOcteto = segundoOcteto;
		this.terceiroOcteto = terceiroOcteto;
		this.quartoOcteto = quartoOcteto;

	}

	public void setCidr(int cidr) {
		this.cidr = cidr;
	}

	public String setIp() {
		return String.format("%d.%d.%d.%d", primeiroOcteto, segundoOcteto, terceiroOcteto, quartoOcteto);
	}

	public String getIp() {
		if (primeiroOcteto >= 0 && primeiroOcteto <= 127) {
			return "A";
		} else if (primeiroOcteto >= 128 && primeiroOcteto <= 191) {
			return "B";
		} else if (primeiroOcteto >= 192 && primeiroOcteto <= 223) {
			return "C";
		} else {
			return "O valor inserido não pode ser maior de 223!";
		}
	}

	public String getMascaraDecimal() {
		int mascara = 0xffffffff << (32 - cidr);
		return String.format("%d.%d.%d.%d", (mascara >>> 24) & 0xff, (mascara >>> 16) & 0xff, (mascara >>> 8) & 0xff,
				mascara & 0xff);
	}

	public String getMascaraBinaria() {
		int mascara = 0xffffffff << (32 - cidr);
		return String.format("%32s", Integer.toBinaryString(mascara)).replace(' ', '0');
	}

	public int getNumIpsDisponiveis() {
		if (cidr >= 32) {
			return 1;
		} else {
			return (int) Math.pow(2, 32 - cidr);
		}
	}

}
