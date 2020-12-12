package ConflitosBelicos;

public class Conflitos {
	private String nome;
	private int mortos;
	
	
	public Conflitos(String nome, int mortos) {
		super();
		this.nome = nome;
		this.mortos = mortos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMortos() {
		return mortos;
	}
	public void setMortos(int mortos) {
		this.mortos = mortos;
	}
	
	
}
