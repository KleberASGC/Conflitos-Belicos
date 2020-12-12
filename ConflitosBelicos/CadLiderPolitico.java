package ConflitosBelicos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CadLiderPolitico extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeL;
	private JTextField txtApoios;
	private JTextField txtCodGrupoArmado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadLiderPolitico frame = new CadLiderPolitico();
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
	public CadLiderPolitico() {
		setTitle("Cadastro de L\u00EDder Pol\u00EDtico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeL = new JLabel("Nome L\u00EDder");
		lblNomeL.setBounds(10, 25, 53, 14);
		contentPane.add(lblNomeL);
		
		JLabel lblApoios = new JLabel("Apoios");
		lblApoios.setBounds(10, 58, 46, 14);
		contentPane.add(lblApoios);
		
		JLabel lblCodGrupoArmado = new JLabel("C\u00F3d. Grupo Armado");
		lblCodGrupoArmado.setBounds(10, 93, 95, 14);
		contentPane.add(lblCodGrupoArmado);
		
		txtNomeL = new JTextField();
		txtNomeL.setBounds(116, 22, 86, 20);
		contentPane.add(txtNomeL);
		txtNomeL.setColumns(10);
		
		txtApoios = new JTextField();
		txtApoios.setBounds(116, 55, 86, 20);
		contentPane.add(txtApoios);
		txtApoios.setColumns(10);
		
		txtCodGrupoArmado = new JTextField();
		txtCodGrupoArmado.setBounds(116, 90, 86, 20);
		contentPane.add(txtCodGrupoArmado);
		txtCodGrupoArmado.setColumns(10);
		
		JButton button = new JButton("Inserir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao;
		         Object[] BtSair={"Sim","Não"};
		         opcao = JOptionPane.showOptionDialog(null,"Deseja incluir esse registro?","Confirmação de Inclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, BtSair, BtSair[0]);
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
						st.executeUpdate("INSERT INTO lider_politico (nomeL, apoios , codigoG) VALUES ('"+txtNomeL.getText()+"','"+txtApoios.getText()+"',"+txtCodGrupoArmado.getText()+")");
						
						st.close();
						con.close();
						JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!");
						
						txtNomeL.setText("");
						txtApoios.setText("");
						txtCodGrupoArmado.setText("");
					}
					catch(Exception event){
						JOptionPane.showMessageDialog(null, "Conexão não estabelecida"+event, ""+event, JOptionPane.ERROR_MESSAGE);
					}
		        }
			}
		});
		button.setBounds(10, 136, 89, 23);
		contentPane.add(button);
	}
}
