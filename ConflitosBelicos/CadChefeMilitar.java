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
	private JTextField txtNroDiv;
	private JTextField txtCodigoG;
	private JTextField txtNomeL;

	
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

	
	public CadChefeMilitar() {
		setTitle("Cadastro de Chefe Militar");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFaixa = new JTextField();
		txtFaixa.setColumns(10);
		txtFaixa.setBounds(338, 54, 86, 20);
		contentPane.add(txtFaixa);
		
		txtcodigoChef = new JTextField();
		txtcodigoChef.setColumns(10);
		txtcodigoChef.setBounds(338, 21, 86, 20);
		contentPane.add(txtcodigoChef);
		
		JLabel lblCdChefe = new JLabel("C\u00F3d. Chefe");
		lblCdChefe.setBounds(10, 24, 264, 14);
		contentPane.add(lblCdChefe);
		
		JLabel lblFaixa = new JLabel("Faixa");
		lblFaixa.setBounds(10, 57, 279, 14);
		contentPane.add(lblFaixa);
		
		JButton button = new JButton("Inserir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao;
		         Object[] BtSair={"Sim","Não"};
		         opcao = JOptionPane.showOptionDialog(null,"Deseja incluir esse registro?","Confirmação de Inclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, BtSair, BtSair[0]);
		        if(opcao == JOptionPane.YES_OPTION) {
					try {
					
						
						Connection con = FabricaConexao.getConexao();
						Statement st = con.createStatement();
						st.execute("INSERT INTO chefe_militar (codigo_Chefe, faixa,nroDivisao,codigoG,nomeL) "
								+ "VALUES ('"+txtcodigoChef.getText()+"','"+txtFaixa.getText()+"'," 
								+ txtNroDiv.getText()+ ","+txtCodigoG.getText()+", '"+txtNomeL.getText()+"')");
						st.close();
						con.close();
						JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!");
						
						txtcodigoChef.setText("");
						txtFaixa.setText("");
						txtNroDiv.setText("");
						txtCodigoG.setText("");
						txtNomeL.setText("");
					}
					catch(Exception event){
						JOptionPane.showMessageDialog(null, "Conexão não estabelecida"+event, ""+event, JOptionPane.ERROR_MESSAGE);
					}
		        }
			}
		});
		button.setBounds(335, 227, 89, 23);
		contentPane.add(button);
		
		JLabel lblNmeroDaDiviso = new JLabel("N\u00FAmero da Divis\u00E3o:");
		lblNmeroDaDiviso.setBounds(10, 85, 279, 14);
		contentPane.add(lblNmeroDaDiviso);
		
		txtNroDiv = new JTextField();
		txtNroDiv.setColumns(10);
		txtNroDiv.setBounds(338, 82, 86, 20);
		contentPane.add(txtNroDiv);
		
		txtCodigoG = new JTextField();
		txtCodigoG.setColumns(10);
		txtCodigoG.setBounds(338, 113, 86, 20);
		contentPane.add(txtCodigoG);
		
		txtNomeL = new JTextField();
		txtNomeL.setColumns(10);
		txtNomeL.setBounds(338, 144, 86, 20);
		contentPane.add(txtNomeL);
		
		JLabel lblCdigoDoGrupo = new JLabel("C\u00F3digo do Grupo Armado:");
		lblCdigoDoGrupo.setBounds(10, 116, 279, 14);
		contentPane.add(lblCdigoDoGrupo);
		
		JLabel lblLderPolticoQue = new JLabel("L\u00EDder pol\u00EDtico que obedece:");
		lblLderPolticoQue.setBounds(10, 147, 279, 14);
		contentPane.add(lblLderPolticoQue);
	}

}
