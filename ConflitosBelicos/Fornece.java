package ConflitosBelicos;

public class Fornece {
	private String traficante;
	private String arma;
	private String grupo_armado;
	
	
	public Fornece(String traficante, String arma, String grupo_armado) {
		super();
		this.traficante = traficante;
		this.arma = arma;
		this.grupo_armado = grupo_armado;
	}
	public String getTraficante() {
		return traficante;
	}
	public void setTraficante(String traficante) {
		this.traficante = traficante;
	}
	public String getArma() {
		return arma;
	}
	public void setArma(String arma) {
		this.arma = arma;
	}
	public String getGrupo_armado() {
		return grupo_armado;
	}
	public void setGrupo_armado(String grupo_armado) {
		this.grupo_armado = grupo_armado;
	}
	
	
}
