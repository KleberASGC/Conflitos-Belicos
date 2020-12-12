package ConflitosBelicos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CadChefeMilitar extends JFrame {

	private JPanel contentPane;
	private JTextField txtFaixa;
	private JTextField txtcodigoChef;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadChefeMilitar frame = new CadChefeMilitar();
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
	public CadChefeMilitar() {
		setTitle("Cadastro de Chefe Militar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFaixa = new JTextField();
		txtFaixa.setColumns(10);
		txtFaixa.setBounds(116, 54, 86, 20);
		contentPane.add(txtFaixa);
		
		txtcodigoChef = new JTextField();
		txtcodigoChef.setColumns(10);
		txtcodigoChef.setBounds(116, 21, 86, 20);
		contentPane.add(txtcodigoChef);
		
		JLabel lblCdChefe = new JLabel("C\u00F3d. Chefe");
		lblCdChefe.setBounds(10, 24, 55, 14);
		contentPane.add(lblCdChefe);
		
		JLabel lblFaixa = new JLabel("Faixa");
		lblFaixa.setBounds(10, 57, 46, 14);
		contentPane.add(lblFaixa);
		
		JButton button = new JButton("Inserir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao;
		         Object[] BtSair={"Sim","Não"};
		         opcao = JOptionPane.showOptionDialog(null,"Deseja incluir esse registro?","Confirmação de Inclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, BtSair, BtSair[0]);
		        if(opcao == JOptionPane.YES_OPTION) {
					try {
					/*	Connection con;
						String userName = "root";
						String password = "";
						String url = "jdbc:mysql://127.0.0.1/bd_teste?useTimezone=true&serverTimezone=UTC"; */
						
						Connection con = FabricaConexao.getConexao();
						
						//Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
						//con = DriverManager.getConnection(url, userName, password);
						Statement st = con.createStatement();
						st.execute("INSERT INTO chefe_militar (codigo_Chefe, faixa) VALUES ('"+txtcodigoChef.getText()+"','"+txtFaixa.getText()+"')");
						st.close();
						con.close();
						JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!");
						
						txtcodigoChef.setText("");
						txtFaixa.setText("");
					}
					catch(Exception event){
						JOptionPane.showMessageDialog(null, "Conexão não estabelecida"+event, ""+event, JOptionPane.ERROR_MESSAGE);
					}
		        }
			}
		});
		button.setBounds(10, 135, 89, 23);
		contentPane.add(button);
	}

}
