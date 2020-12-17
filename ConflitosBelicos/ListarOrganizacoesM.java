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

public class ListarOrganizacoesM extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarOrganizacoesM frame = new ListarOrganizacoesM();
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
	public ListarOrganizacoesM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnListar = new JButton("New button");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {		
					Connection con = FabricaConexao.getConexao();
					
					Statement st = con.createStatement();
				
					ResultSet rs = st.executeQuery("SELECT  codigoOrg, count(codigoOrg)"
							+ " FROM entradMed "
							+ "WHERE codConflito "
							+ "NOT IN (SELECT codConflito FROM saidaMed) "
							+ "GROUP BY codigoOrg "
							+ "ORDER BY COUNT(codigoOrg) DESC "
							+ "LIMIT 5");
					 List<Mediando> mediando = new ArrayList<>();
					while(rs.next()) {
						int codigoOrg = rs.getInt(1);
						mediando.add(new Mediando(codigoOrg));
					}

					String print = "";
					for(Mediando m : mediando) {
						print += m.getNomeOrg() + "\n";
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
		btnListar.setBounds(169, 227, 89, 23);
		contentPane.add(btnListar);
	}
}
