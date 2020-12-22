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
import javax.swing.JLabel;

public class ListarPaises extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarPaises frame = new ListarPaises();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ListarPaises() {
		setTitle("Listar Pa\u00EDses");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnListarPaises = new JButton("Listar");
		btnListarPaises.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Connection con = FabricaConexao.getConexao();
			
					Statement st = con.createStatement();
				
					ResultSet rs = st.executeQuery("SELECT pais, COUNT(pais) as Numero_Conflitos  FROM conflitoPais cp "
							+ "INNER JOIN confRelig cr "
							+ "WHERE cp.codConflito = cr.codConflito "
							+ "GROUP BY pais "
							+ "ORDER BY COUNT(pais) DESC");
					 List<Pais> paises = new ArrayList<>();
					while(rs.next()) {
						String pais = rs.getString(1);
						int nConfRelig = rs.getInt(2);
						paises.add(new Pais(pais,nConfRelig));
					}
					String print = "";
					for(Pais p : paises) {
						if(p.getnConfRelig() == paises.get(0).getnConfRelig()) 
						print += p.getPais() + " ==> " + p.getnConfRelig() + "\n";
						else break;
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
		btnListarPaises.setBounds(143, 194, 141, 56);
		contentPane.add(btnListarPaises);
		
		JLabel lblViListarO = new JLabel("Listar o pa\u00EDs e n\u00FAmero de conflitos ");
		lblViListarO.setBounds(10, 77, 641, 14);
		contentPane.add(lblViListarO);
		
		JLabel lblComMaiorNmero = new JLabel("com maior n\u00FAmero de conflitos religiosos");
		lblComMaiorNmero.setBounds(10, 102, 641, 14);
		contentPane.add(lblComMaiorNmero);
	}

}
