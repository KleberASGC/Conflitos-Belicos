package ConflitosBelicos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;

public class Menu {

	private JFrame frmMenu;
	private JMenuItem itemDivisoes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.setFont(new Font("Arial", Font.PLAIN, 12));
		frmMenu.setBackground(SystemColor.activeCaption);
		frmMenu.getContentPane().setBackground(SystemColor.activeCaption);
		frmMenu.setTitle("Menu");
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.inactiveCaptionBorder);
		frmMenu.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opcoes");
		menuBar.add(mnNewMenu);
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		mnNewMenu.add(mnCadastrar);
		
		
		JMenuItem itemChefeMilitar = new JMenuItem("ChefeMilitar");
		itemChefeMilitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  
				CadChefeMilitar frame = new CadChefeMilitar();
				frame.setVisible(true);
			}
		});
		mnCadastrar.add(itemChefeMilitar);
		
		JMenuItem itemConflito = new JMenuItem("Conflito");
		itemConflito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  
				CadConflito frame = new CadConflito();
				frame.setVisible(true);
			}
		});
		mnCadastrar.add(itemConflito);
		
		itemDivisoes = new JMenuItem("Divis\u00F5es");
		itemDivisoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  
				CadDivisoes window = new CadDivisoes();
				window.frmCadastroDivises.setVisible(true);
			}
		});
		mnCadastrar.add(itemDivisoes);
		
		JMenuItem itemLiderPolitico = new JMenuItem("Lider Politico");
		itemLiderPolitico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  
				CadLiderPolitico frame = new CadLiderPolitico();
				frame.setVisible(true);
			}
		});
		mnCadastrar.add(itemLiderPolitico);
		
		JMenuItem itemGrupoArmado = new JMenuItem("Grupo Armado");
		itemGrupoArmado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  
				CadGrupoArmado frame = new CadGrupoArmado();
				frame.setVisible(true);
			}
		});
		mnCadastrar.add(itemGrupoArmado);
		
		JMenu mnListar = new JMenu("Listar");
		mnNewMenu.add(mnListar);
		
		JMenuItem itemListarConflitos = new JMenuItem("Conflitos");
		itemListarConflitos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  
				ListarConflitos frame = new ListarConflitos();
				frame.setVisible(true);
			}
		});
		mnListar.add(itemListarConflitos);
		
		JMenuItem itemListarOrganizacoes = new JMenuItem("Organiza\u00E7\u00F5es");
		itemListarOrganizacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  
				ListarOrganizacoesM frame = new ListarOrganizacoesM();
				frame.setVisible(true);
			}
		});
		mnListar.add(itemListarOrganizacoes);
		
		JMenuItem itemListarTraficantes = new JMenuItem("Traficantes");
		itemListarTraficantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  
				ListarTraficantes frame = new ListarTraficantes();
				frame.setVisible(true);
			}
		});
		mnListar.add(itemListarTraficantes);
		
		JMenu mcGráficos = new JMenu("Gr\u00E1ficos");
		mnNewMenu.add(mcGráficos);
		
		JMenuItem itemGraficoConflito = new JMenuItem("Conflito");
		itemGraficoConflito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  
				
			}
		});
		itemGraficoConflito.setHorizontalAlignment(SwingConstants.LEFT);
		mcGráficos.add(itemGraficoConflito);
		frmMenu.getContentPane().setLayout(null);
	}

}
