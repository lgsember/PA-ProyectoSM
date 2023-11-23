package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;

public class Eleccion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eleccion frame = new Eleccion();
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
	public Eleccion() {


		setTitle("Decisión");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelPrincipal = new JPanel();
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperior = new JPanel();
		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setLayout(new BorderLayout(0, 0));
		
		JPanel supCentral = new JPanel();
		panelSuperior.add(supCentral, BorderLayout.CENTER);
		supCentral.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("Jugador: Naru | Karma: 0 | Afinidad:  ☿3 ♂2 ♃3 ♀5");
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		supCentral.add(lblTitle);
		
		JPanel panelInferior = new JPanel();
		panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
		panelInferior.setLayout(new BorderLayout(0, 0));
		
		JPanel infCentral = new JPanel();
		panelInferior.add(infCentral, BorderLayout.CENTER);
		infCentral.setLayout(new BorderLayout(0, 0));
		
		//aca la pregunta
		JLabel lblSpeech = new JLabel(String.format("<html><body style=\"text-align: justify;  text-justify: inter-word; \">%s</body></html>","Quieres venir con nosotros?"));
		infCentral.add(lblSpeech);
		
		JPanel infDerecha = new JPanel();
		FlowLayout flowLayout = (FlowLayout) infDerecha.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		panelInferior.add(infDerecha, BorderLayout.EAST);
		
		JPanel infIzquierda = new JPanel();
		panelInferior.add(infIzquierda, BorderLayout.WEST);
		infIzquierda.setLayout(new BorderLayout(0, 0));
		
		//aca nombre del personaje que pregunta
		JLabel lblSpaceBottomLeft = new JLabel("Ami: ");
		infIzquierda.add(lblSpaceBottomLeft);
		
		JPanel panelIzquierda = new JPanel();
		panelPrincipal.add(panelIzquierda, BorderLayout.WEST);
		panelIzquierda.setLayout(new BorderLayout(0, 0));
		
		JPanel izqCentral = new JPanel();
		panelIzquierda.add(izqCentral, BorderLayout.CENTER);
		izqCentral.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLeftMargin = new JLabel("                   ");
		izqCentral.add(lblLeftMargin, BorderLayout.NORTH);
		
		//aca image del personaje que pregunta
		JLabel lblSpeaker = new JLabel("");
		lblSpeaker.setIcon(new ImageIcon(Eleccion.class.getResource("/dll/amibd.png")));
		izqCentral.add(lblSpeaker, BorderLayout.SOUTH);
		
		JPanel panelDerecha = new JPanel();
		panelPrincipal.add(panelDerecha, BorderLayout.EAST);
		panelDerecha.setLayout(new BorderLayout(0, 0));
		
		JPanel derCentral = new JPanel();
		panelDerecha.add(derCentral, BorderLayout.CENTER);
		derCentral.setLayout(new BorderLayout(0, 0));
		
		//aca image del jugador
		JLabel lblPlayer = new JLabel("");
		lblPlayer.setIcon(new ImageIcon(Eleccion.class.getResource("/dll/playerf.png")));
		derCentral.add(lblPlayer);
		
		JPanel panelCentral = new JPanel();
		panelPrincipal.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		JPanel cenIzquierda = new JPanel();
		panelCentral.add(cenIzquierda, BorderLayout.WEST);
		
		JLabel lblCenMarginLeft = new JLabel("   ");
		cenIzquierda.add(lblCenMarginLeft);
		
		JPanel cenDerecha = new JPanel();
		panelCentral.add(cenDerecha, BorderLayout.EAST);
		
		JLabel lblCenMarginRight = new JLabel("   ");
		cenDerecha.add(lblCenMarginRight);
		
		JPanel cenBotones = new JPanel();
		panelCentral.add(cenBotones, BorderLayout.CENTER);
		cenBotones.setLayout(new GridLayout(7, 8, 0, 0));
		
		JLabel lblCenUpper = new JLabel("");
		cenBotones.add(lblCenUpper);
		
		//aca respuesta 1
		JButton btnDecision1 = new JButton("Si");
		cenBotones.add(btnDecision1);
		
		JLabel lblCenMiddleUp = new JLabel("");
		cenBotones.add(lblCenMiddleUp);
		
		//aca respuesta 2
		JButton btnDecision2 = new JButton("No");
		cenBotones.add(btnDecision2);
		
		JLabel lblCenMiddleDown = new JLabel("");
		cenBotones.add(lblCenMiddleDown);
		
		//aca respuesta 3
		JButton btnDecision3 = new JButton("Talvez");
		cenBotones.add(btnDecision3);
		
		JLabel lblCenLower = new JLabel("");
		cenBotones.add(lblCenLower);
	}

}
