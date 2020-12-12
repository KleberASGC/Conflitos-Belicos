package ConflitosBelicos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import javax.swing.*;

public class CadConflito extends JFrame {

	private JPanel contentPane;
	private JTextField txtCod;
	private JTextField txtNome;
	private JTextField txtTipoConf;
	private JTextField txtNFeridos;
	private JLabel lblNMortos;
	private JTextField txtNMortos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadConflito frame = new CadConflito();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadConflito() {
		setTitle("Cadastro de Conflito");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCod = new JLabel("C\u00F3digo do Conflito:");
		lblCod.setBounds(10, 21, 187, 14);
		contentPane.add(lblCod);
		
		txtCod = new JTextField();
		txtCod.setBounds(238, 21, 86, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome do Conflito:");
		lblNome.setBounds(10, 55, 201, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(238, 55, 86, 20);
		contentPane.add(txtNome);
		
		JLabel lblCodPais = new JLabel("Tipo do Conflito:");
		lblCodPais.setBounds(10, 88, 201, 14);
		contentPane.add(lblCodPais);
		
		txtTipoConf = new JTextField();
		lblCodPais.setLabelFor(txtTipoConf);
		txtTipoConf.setColumns(10);
		txtTipoConf.setBounds(238, 86, 86, 20);
		contentPane.add(txtTipoConf);
		
		JLabel lblNumFeridos = new JLabel("N\u00FAmero de Feridos:");
		lblNumFeridos.setBounds(10, 120, 218, 14);
		contentPane.add(lblNumFeridos);
		
		txtNFeridos = new JTextField();
		txtNFeridos.setColumns(10);
		txtNFeridos.setBounds(238, 117, 86, 20);
		contentPane.add(txtNFeridos);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e){
				int opcao;
		         Object[] BtSair={"Sim","Não"};
		         opcao = JOptionPane.showOptionDialog(null,"Deseja incluir esse registro?","Confirmação de Inclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, BtSair, BtSair[0]);  // 
		        if(opcao == JOptionPane.YES_OPTION) {
					try {
						/* Connection con;
						String userName = "root";
						String password = "";
						String url = "jdbc:mysql://127.0.0.1/bd_teste?useTimezone=true&serverTimezone=UTC"; */
						Connection con = FabricaConexao.getConexao();
						
						//Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
						//con = DriverManager.getConnection(url, userName, password);
						Statement st = con.createStatement();
						st.executeUpdate("INSERT INTO conflito (codConflito, nome, tipoConf, numFeridos, numMortos)"
								+ " VALUES ('"+txtCod.getText()+"','"+txtNome.getText()+"','"+txtTipoConf.getText()+
								"','"+txtNFeridos.getText()+"','"+txtNMortos.getText()+"')");
						
						st.close();
						con.close();
						JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!");
						
						txtCod.setText("");
						txtNome.setText("");
						txtTipoConf.setText("");
						txtNFeridos.setText("");
						txtNMortos.setText("");
					}
					catch(Exception event){
						JOptionPane.showMessageDialog(null, "Conexão não estabelecida"+event, ""+event, JOptionPane.ERROR_MESSAGE);
					}
		        }
			}
		});
		btnInserir.setBounds(212, 227, 89, 23);
		contentPane.add(btnInserir);
		
		lblNMortos = new JLabel("N\u00FAmero de Mortos:");
		lblNMortos.setBounds(10, 152, 201, 14);
		contentPane.add(lblNMortos);
		
		txtNMortos = new JTextField();
		txtNMortos.setColumns(10);
		txtNMortos.setBounds(238, 152, 86, 20);
		contentPane.add(txtNMortos);
	}
}
