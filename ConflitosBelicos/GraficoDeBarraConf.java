package ConflitosBelicos;

import java.awt.Dimension;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import graficosJChart.Pessoa;

public class GraficoDeBarraConf {
	public CategoryDataset createDataSet(ArrayList<Conflito> listaDeConflitos) {
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		
		for(Conflito conflito : listaDeConflitos) 
			dataSet.addValue(conflito.getNumConflitos(), conflito.getTipoConflito(), "");
		
		return dataSet;
	}
	
	public JFreeChart createBarChart(CategoryDataset dataSet) {
		JFreeChart graficoBarrasConf = ChartFactory.createBarChart("Tipos de Conflito e Suas Quantidades",
				"",
				"Número de Conflitos",
				dataSet,
				PlotOrientation.VERTICAL,
				true,
				false,
				false);
		
		return graficoBarrasConf;
	}
	
	public ChartPanel criarGrafico(ArrayList<Conflito> listaDeConflitos) {
		CategoryDataset dataSet = this.createDataSet(listaDeConflitos);
		JFreeChart grafico = this.createBarChart(dataSet);
		ChartPanel painelDoGrafico = new ChartPanel(grafico);
		painelDoGrafico.setPreferredSize(new Dimension(400, 400));
		
		return painelDoGrafico;
	}
}
