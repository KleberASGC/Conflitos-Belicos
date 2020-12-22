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

public class CadGrupoArmado extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeGrupo;
	private JTextField txtCodigoG;
	private JLabel lblNmeroDeBaixas;
	private JTextField numBaixas;
	private JTextField textNroDiv;
	private JLabel lblNmeroDaDiviso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadGrupoArmado frame = new CadGrupoArmado();
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
	public CadGrupoArmado() {
		setTitle("Grupo Armado");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdGrupo = new JLabel("C\u00F3digo do Grupo:");
		lblCdGrupo.setBounds(10, 14, 89, 14);
		contentPane.add(lblCdGrupo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 47, 78, 14);
		contentPane.add(lblNome);
		
		txtNomeGrupo = new JTextField();
		txtNomeGrupo.setBounds(338, 44, 86, 20);
		txtNomeGrupo.setColumns(10);
		contentPane.add(txtNomeGrupo);
		
		txtCodigoG = new JTextField();
		txtCodigoG.setBounds(338, 11, 86, 20);
		txtCodigoG.setColumns(10);
		contentPane.add(txtCodigoG);
		
		JButton button = new JButton("Inserir");
		button.setBounds(10, 140, 89, 23);
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
						st.executeUpdate("INSERT INTO grupo_armado (codigoG, nomeGrupo,numBaixasG,nroDivisao) VALUES"
								+ " ("+txtCodigoG.getText()+",'"+txtNomeGrupo.getText()+"'," + numBaixas.getText() + "," + textNroDiv.getText() + ")");
						
						st.close();
						con.close();
						JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!");
						
						txtNomeGrupo.setText("");
						txtCodigoG.setText("");
					}
					catch(Exception event){
						JOptionPane.showMessageDialog(null, "Conexão não estabelecida"+event, ""+event, JOptionPane.ERROR_MESSAGE);
					}
		        }

			}
		});
		contentPane.add(button);
		
		lblNmeroDeBaixas = new JLabel("N\u00FAmero de Baixas: ");
		lblNmeroDeBaixas.setBounds(10, 80, 112, 14);
		contentPane.add(lblNmeroDeBaixas);
		
		numBaixas = new JTextField();
		numBaixas.setColumns(10);
		numBaixas.setBounds(338, 77, 86, 20);
		contentPane.add(numBaixas);
		
		textNroDiv = new JTextField();
		textNroDiv.setColumns(10);
		textNroDiv.setBounds(338, 108, 86, 20);
		contentPane.add(textNroDiv);
		
		lblNmeroDaDiviso = new JLabel("N\u00FAmero da Divis\u00E3o: ");
		lblNmeroDaDiviso.setBounds(10, 105, 112, 14);
		contentPane.add(lblNmeroDaDiviso);
	}
}
