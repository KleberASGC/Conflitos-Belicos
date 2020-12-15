package ConflitosBelicos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import graficosJChart.GraficoDeBarra;
import graficosJChart.Pessoa;

public class JanelaConflitos extends JFrame {

	private JPanel jpnGrafConf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaConflitos frame = new JanelaConflitos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public JanelaConflitos() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		jpnGrafConf = new JPanel();
		jpnGrafConf.setBorder(new EmptyBorder(5, 5, 5, 5));
		jpnGrafConf.setLayout(new BorderLayout(0, 0));
		setContentPane(jpnGrafConf);
		
		ArrayList<Conflito> listaDeConflitos = new ArrayList<>();
		inserirConflitos(listaDeConflitos);
		
		
		GraficoDeBarraConf graficoDeBarraConf = new GraficoDeBarraConf();
		this.jpnGrafConf.setLayout(new BorderLayout());
		this.jpnGrafConf.add(graficoDeBarraConf.criarGrafico(listaDeConflitos)); 
		pack();
		
		listaDeConflitos.clear();
	}
	
	public void inserirConflitos(ArrayList<Conflito> listaDeConflitos) throws SQLException {
		Connection conexao = FabricaConexao.getConexao();
		Statement stmt = conexao.createStatement();
		
		String sqlRacial = "SELECT COUNT(tipoConf) " + 
				"FROM conflito "
				+ "WHERE tipoConf = 'Racial' ";
		
		String sqlReligioso = "SELECT COUNT(tipoConf) " + 
				"FROM conflito "
				+ "WHERE tipoConf = 'Religioso' ";
		
		String sqlTerritorial = "SELECT COUNT(tipoConf) " + 
				"FROM conflito "
				+ "WHERE tipoConf = 'Territorial' ";
		
		String sqlEconomico = "SELECT COUNT(tipoConf) " + 
				"FROM conflito "
				+ "WHERE tipoConf = 'Economico' ";
	
		ResultSet resultadoRacial = stmt.executeQuery(sqlRacial);
		while(resultadoRacial.next()) {
			int nConf = resultadoRacial.getInt(1);
			listaDeConflitos.add(new Conflito("Racial", nConf));
		}
		ResultSet resultadoReligioso = stmt.executeQuery(sqlReligioso);
		while(resultadoReligioso.next()) {
			int nConf = resultadoReligioso.getInt(1);
			listaDeConflitos.add(new Conflito("Religioso", nConf));
		}
		
		ResultSet resultadoTerritorial = stmt.executeQuery(sqlTerritorial);
		while(resultadoTerritorial.next()) {
			int nConf = resultadoTerritorial.getInt(1);
			listaDeConflitos.add(new Conflito("Territorial", nConf));
		}
		
		ResultSet resultadoEconomico = stmt.executeQuery(sqlEconomico);
		while(resultadoEconomico.next()) {
			int nConf = resultadoEconomico.getInt(1);
			listaDeConflitos.add(new Conflito("Economico", nConf));
		}	
	
		resultadoRacial.close();
		resultadoReligioso.close();
		resultadoEconomico.close();
		resultadoTerritorial.close();
		stmt.close();
		conexao.close();
		
		
	}

}
