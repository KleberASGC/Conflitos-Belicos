package ConflitosBelicos;

public class Conflito {
	private String tipoConflito;
	private int numConflitos;
	
	public Conflito(String tipoConflito, int numConflitos) {

		super();
		this.tipoConflito = tipoConflito;
		this.numConflitos = numConflitos;
	}

	public String getTipoConflito() {
		return tipoConflito;
	}

	public void setTipoConflito(String tipoConflito) {
		this.tipoConflito = tipoConflito;
	}

	public int getNumConflitos() {
		return numConflitos;
	}

	public void setNumConflitos(int numConflitos) {
		this.numConflitos = numConflitos;
	}
	
	
}
