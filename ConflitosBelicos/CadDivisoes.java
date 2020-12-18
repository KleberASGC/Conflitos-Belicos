package ConflitosBelicos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CadDivisoes {

	JFrame frmCadastroDivises;
	private JTextField numTanques;
	private JTextField numBarcos;
	private JTextField numBaixas;
	private JTextField numDiv;
	private JTextField numHomens;
	private JTextField numAvioes;
	private JLabel lblCdigoDaDiviso;
	private JTextField numCod;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadDivisoes window = new CadDivisoes();
					window.frmCadastroDivises.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadDivisoes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frmCadastroDivises = new JFrame();
		frmCadastroDivises.setTitle("Divis\u00F5es");
		frmCadastroDivises.setBounds(100, 100, 450, 300);
		frmCadastroDivises.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDivises.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero da Divis\u00E3o:");
		lblNewLabel.setBounds(10, 11, 100, 29);
		frmCadastroDivises.getContentPane().add(lblNewLabel);
		
		JLabel lblNmeroDeBaixas = new JLabel("N\u00FAmero de Baixas:");
		lblNmeroDeBaixas.setBounds(10, 51, 100, 29);
		frmCadastroDivises.getContentPane().add(lblNmeroDeBaixas);
		
		JLabel lblBarcos = new JLabel("N\u00FAmero de Barcos:");
		lblBarcos.setBounds(10, 91, 100, 29);
		frmCadastroDivises.getContentPane().add(lblBarcos);
		
		JLabel lblTanques = new JLabel("N\u00FAmero de Tanques:");
		lblTanques.setBounds(10, 131, 100, 29);
		frmCadastroDivises.getContentPane().add(lblTanques);
		
		JLabel lblHomens = new JLabel("N\u00FAmero de Homens:");
		lblHomens.setBounds(10, 171, 100, 29);
		frmCadastroDivises.getContentPane().add(lblHomens);
		
		JLabel lblAvies = new JLabel("N\u00FAmero de Avi\u00F5es:");
		lblAvies.setBounds(10, 211, 100, 29);
		frmCadastroDivises.getContentPane().add(lblAvies);
		
		numTanques = new JTextField();
		numTanques.setBounds(120, 135, 86, 20);
		frmCadastroDivises.getContentPane().add(numTanques);
		numTanques.setColumns(10);
		
		numBarcos = new JTextField();
		numBarcos.setColumns(10);
		numBarcos.setBounds(120, 95, 86, 20);
		frmCadastroDivises.getContentPane().add(numBarcos);
		
		numBaixas = new JTextField();
		numBaixas.setColumns(10);
		numBaixas.setBounds(120, 55, 86, 20);
		frmCadastroDivises.getContentPane().add(numBaixas);
		
		numDiv = new JTextField();
		numDiv.setColumns(10);
		numDiv.setBounds(120, 15, 86, 20);
		frmCadastroDivises.getContentPane().add(numDiv);
		
		numHomens = new JTextField();
		numHomens.setColumns(10);
		numHomens.setBounds(120, 175, 86, 20);
		frmCadastroDivises.getContentPane().add(numHomens);
		
		numAvioes = new JTextField();
		numAvioes.setColumns(10);
		numAvioes.setBounds(120, 215, 86, 20);
		frmCadastroDivises.getContentPane().add(numAvioes);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao;
		         Object[] BtSair={"Sim","Não"};
		         opcao = JOptionPane.showOptionDialog(null,"Deseja incluir esse registro?","Confirmação de Inclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, BtSair, BtSair[0]);
		           if(opcao == JOptionPane.YES_OPTION) { 
					try {
						
						Connection con = FabricaConexao.getConexao();
						Statement st = con.createStatement();
						st.executeUpdate("INSERT INTO divisao "
								+ "(nroDivisao,codigoG,numBaixasD,barcos,tanques,homens,avioes) "
								+ "VALUES ("+numDiv.getText()+","+numCod.getText()+"," 
								+ numBaixas.getText()+"," + numBarcos.getText()+"," 
								+ numTanques.getText() + "," + numHomens.getText() + "," + numAvioes.getText()+")");
						
						
						st.close();
						con.close();
						JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!");
						numCod.setText("");
						numDiv.setText("");
						numBaixas.setText("");
						numBarcos.setText("");
						numTanques.setText("");
						numHomens.setText("");
						numAvioes.setText("");
						
					}
					catch(Exception event){
						JOptionPane.showMessageDialog(null, "Conexão não estabelecida"+event, ""+event, JOptionPane.ERROR_MESSAGE);
					}
					 }
			} 
		});
		btnInserir.setBounds(335, 214, 89, 23);
		frmCadastroDivises.getContentPane().add(btnInserir);
		
		lblCdigoDaDiviso = new JLabel("C\u00F3digo do Grupo Armado:");
		lblCdigoDaDiviso.setBounds(238, 11, 186, 29);
		frmCadastroDivises.getContentPane().add(lblCdigoDaDiviso);
		
		numCod = new JTextField();
		numCod.setColumns(10);
		numCod.setBounds(338, 40, 86, 20);
		frmCadastroDivises.getContentPane().add(numCod);
	}
}
