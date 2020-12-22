package ConflitosBelicos;

import java.sql.SQLException;

import graficosJChart.JanelaDoGrafico;
import javax.swing.JFrame;

public class gerarGraficoConflitos {
	public static void main(String[] args) throws SQLException {
		JanelaConflitos janelaConflitos = new JanelaConflitos();
		janelaConflitos.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		janelaConflitos.setVisible(true);
	}
}
