package ConflitosBelicos;

import java.sql.SQLException;

import graficosJChart.JanelaDoGrafico;

public class gerarGraficoConflitos {
	public static void main(String[] args) throws SQLException {
		new JanelaConflitos().setVisible(true);
	}
}
