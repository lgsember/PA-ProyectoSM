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

public class Dialogo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dialogo frame = new Dialogo();
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
	public Dialogo() {
		String texto = "Soy Sailor Moon, la bella guerrera en traje de\nmarinero que lucha por el amor y la justicia.\nTe castigaré en nombre de la Luna!";
		
		setTitle("Diálogo");
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
		
		//aca el array de lineas
		JLabel lblSpeech = new JLabel(String.format("<html><body style=\"text-align: justify;  text-justify: inter-word; \">%s</body></html>",texto));
		infCentral.add(lblSpeech);
		
		JPanel infDerecha = new JPanel();
		FlowLayout flowLayout = (FlowLayout) infDerecha.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		panelInferior.add(infDerecha, BorderLayout.EAST);
		
		JButton btnProximo = new JButton("Próximo");
		infDerecha.add(btnProximo);
		
		JPanel infIzquierda = new JPanel();
		panelInferior.add(infIzquierda, BorderLayout.WEST);
		
		//aca el array de nombre
		JLabel lblName = new JLabel("Sailor Moon:");
		infIzquierda.add(lblName);
		
		JPanel panelIzquierda = new JPanel();
		panelPrincipal.add(panelIzquierda, BorderLayout.WEST);
		panelIzquierda.setLayout(new BorderLayout(0, 0));
		
		JPanel izqCentral = new JPanel();
		panelIzquierda.add(izqCentral, BorderLayout.CENTER);
		izqCentral.setLayout(new BorderLayout(0, 0));
		
		//aca el array de image_personaje
		JLabel lblSpeaker = new JLabel("");
		lblSpeaker.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSpeaker.setIcon(new ImageIcon(Dialogo.class.getResource("/dll/moon.png")));
		izqCentral.add(lblSpeaker);
		
		JPanel panelDerecha = new JPanel();
		panelPrincipal.add(panelDerecha, BorderLayout.EAST);
		panelDerecha.setLayout(new BorderLayout(0, 0));
		
		JPanel derCentral = new JPanel();
		panelDerecha.add(derCentral, BorderLayout.CENTER);
		derCentral.setLayout(new GridLayout(2, 1, 0, 120));
		
		JLabel lblNewLabel = new JLabel("                        ");
		derCentral.add(lblNewLabel);
		
		JPanel panelCentral = new JPanel();
		panelPrincipal.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		//aca el array de image_fondo
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Dialogo.class.getResource("/dll/yoyogi.jpg")));
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentral.add(lblFondo);
	}

}
