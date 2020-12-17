package ConflitosBelicos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mediando {
	private int codigoOrg;
	private String nomeOrg;
	public Mediando(int codigoOrg) throws SQLException {
		super();
		this.codigoOrg = codigoOrg;
		Connection con = FabricaConexao.getConexao();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT nomeOrg " + 
				"FROM organizacaoM WHERE codigoOrg = " + this.codigoOrg);
		String nome = "";
		while(rs.next()) nome = rs.getString(1);
		this.nomeOrg = nome;
	}
	public int getCodigoOrg() {
		return codigoOrg;
	}
	public void setCodigoOrg(int codigoOrg) {
		this.codigoOrg = codigoOrg;
	}
	public String getNomeOrg() {
		return nomeOrg;
	}
	public void setNomeOrg(String nomeOrg) {
		this.nomeOrg = nomeOrg;
	}
	
	
	
	}
	

