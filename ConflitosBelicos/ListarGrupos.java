package ConflitosBelicos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ListarGrupos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarGrupos frame = new ListarGrupos();
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
	public ListarGrupos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnListarGrupos = new JButton("New button");
		btnListarGrupos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {		
					Connection con = FabricaConexao.getConexao();
					
					Statement st = con.createStatement();
				
					ResultSet rs = st.executeQuery("SELECT codigoG, SUM(numArmas) "
							+ "FROM fornece"
							+ " GROUP BY codigoG"
							+ " ORDER BY SUM(numArmas) DESC "
							+ " LIMIT 5");
					 List<Armas> armas = new ArrayList<>();
					while(rs.next()) {
						int codigoG = rs.getInt(1);
						armas.add(new Armas(codigoG));
					}

					String print = "";
					for(Armas a : armas) {
						print += a.getNomeG() + "\n";
					} 
					JOptionPane.showMessageDialog(null, print);
					//txtArma.setText(rs.getString("nome_traf"));
				
					
					st.close();
					con.close();
				}
				catch(Exception event){
					JOptionPane.showMessageDialog(null, event, "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		btnListarGrupos.setBounds(168, 227, 89, 23);
		contentPane.add(btnListarGrupos);
	}

}
