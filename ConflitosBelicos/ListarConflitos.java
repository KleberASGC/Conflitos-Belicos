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

public class ListarConflitos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarConflitos frame = new ListarConflitos();
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
	public ListarConflitos() {
		setTitle("Listar Conflitos");
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
					
						ResultSet rs = st.executeQuery("SELECT nome as Conflito, numMortos as Mortos "
								+ "FROM conflito "
								+ "ORDER BY numMortos desc");
						 List<Conflitos> conflitos = new ArrayList<>();
						while(rs.next()) {
							String nome = rs.getString(1);
							int mortos = rs.getInt(2);
							conflitos.add(new Conflitos(nome,mortos));
						}
						String print = "";
						int i=0;
						for(Conflitos c : conflitos) {
							i++;
							print += c.getNome() + " ==> " + c.getMortos() + "\n";
							if(i==4) break;
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
		
		JLabel lblArma = new JLabel("Listar os 5 maiores conflitos em n\u00FAmero de mortos:");
		lblArma.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblArma.setBounds(10, 58, 641, 14);
		contentPane.add(lblArma);
	}
}

