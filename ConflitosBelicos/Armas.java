package ConflitosBelicos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Armas {
	private int codigoG;
	private String nomeG;
	public Armas(int codigoG) throws SQLException {
		super();
		this.codigoG = codigoG;
		Connection con = FabricaConexao.getConexao();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT nomeGrupo FROM grupo_armado "
				+ "WHERE codigoG = " + this.codigoG);
		String nome = "";
		while(rs.next()) nome = rs.getString(1);
		this.nomeG = nome;
	}
	public int getCodigoG() {
		return codigoG;
	}
	public String getNomeG() {
		return nomeG;
	}
	
	
	
}
