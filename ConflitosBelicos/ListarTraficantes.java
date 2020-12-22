package ConflitosBelicos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import jdbc.Pessoa;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class ListarTraficantes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarTraficantes frame = new ListarTraficantes();
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
	public ListarTraficantes() {
		setTitle("Listar Traficantes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Listar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						
						Connection con = FabricaConexao.getConexao();
				
						Statement st = con.createStatement();
					
						ResultSet rs = st.executeQuery("SELECT nomeTraf as Traficante, nomeArma as Fornece, nomeGrupo as Grupo_Armado "
								+ "FROM fornece f INNER JOIN grupo_armado ga "
								+ "ON f.codigoG = ga.codigoG "
								+ "AND (f.nomeArma = 'M200 Intervention' OR f.nomeArma = 'Barret M82')");
					//	rs.next();
						 List<Fornece> fornece = new ArrayList<>();
						while(rs.next()) {
							String traficante = rs.getString(1);
							String arma =	rs.getString(2);
							String nomeGrupo = rs.getString(3);
							fornece.add(new Fornece(traficante,arma,nomeGrupo));
						}
						String print = "";
						for(Fornece f : fornece) {
							print += f.getTraficante() + " ==> " + f.getArma() + " ==> " + f.getGrupo_armado() + "\n";
						} 
						JOptionPane.showMessageDialog(null, print);
						
					
						
						st.close();
						con.close();
					}
					catch(Exception event){
						JOptionPane.showMessageDialog(null, event, "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
						
					}
				
				
			}
		});
		btnNewButton.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblArma = new JLabel("Listar Traficantes que fornecem as armas \u201CBarret M82\u201D ou \u201CM200 intervention\" ");
		lblArma.setBounds(10, 58, 641, 14);
		contentPane.add(lblArma);
		
		JLabel lblEGruposArmados = new JLabel("e grupos armados que as recebem:");
		lblEGruposArmados.setBounds(10, 72, 641, 14);
		contentPane.add(lblEGruposArmados);
	}
}
