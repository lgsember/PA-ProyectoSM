package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dll.Aliado;
import dll.Enemigo;
import dll.Historia;
import dll.Jugador;

import java.awt.BorderLayout;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Dialogo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String[][] matriz;
	int escena = 0;
	String justified = "<html><body style=\"text-align: justify;  text-justify: inter-word; \">%s</body></html>";

			public void run() {
				try {
					//Dialogo frame = new Dialogo(matriz);
					this.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	public Dialogo(String[][] matriz) {	
		this.matriz = matriz;
		
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
		
		//status
		JLabel lblTitle = new JLabel(matriz[escena][4]);
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		supCentral.add(lblTitle);
		
		JPanel panelInferior = new JPanel();
		panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
		panelInferior.setLayout(new BorderLayout(0, 0));
		
		JPanel infCentral = new JPanel();
		panelInferior.add(infCentral, BorderLayout.CENTER);
		infCentral.setLayout(new BorderLayout(0, 0));
		
		//linea
		JLabel lblSpeech = new JLabel(matriz[escena][1]);
		infCentral.add(lblSpeech);
		
		JPanel infDerecha = new JPanel();
		FlowLayout flowLayout = (FlowLayout) infDerecha.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		panelInferior.add(infDerecha, BorderLayout.EAST);
		
		JPanel infIzquierda = new JPanel();
		panelInferior.add(infIzquierda, BorderLayout.WEST);
		
		//nombre
		JLabel lblName = new JLabel(matriz[escena][0]);
		infIzquierda.add(lblName);
		
		JPanel panelIzquierda = new JPanel();
		panelPrincipal.add(panelIzquierda, BorderLayout.WEST);
		panelIzquierda.setLayout(new BorderLayout(0, 0));
		
		JPanel izqCentral = new JPanel();
		panelIzquierda.add(izqCentral, BorderLayout.CENTER);
		izqCentral.setLayout(new BorderLayout(0, 0));
		
		//personaje
		JLabel lblSpeaker = new JLabel("");
		lblSpeaker.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSpeaker.setIcon(new ImageIcon(Dialogo.class.getResource("/dll/" + matriz[escena][2])));
		izqCentral.add(lblSpeaker);
		
		JPanel panelDerecha = new JPanel();
		panelPrincipal.add(panelDerecha, BorderLayout.EAST);
		panelDerecha.setLayout(new BorderLayout(0, 0));
		
		JPanel derCentral = new JPanel();
		panelDerecha.add(derCentral, BorderLayout.CENTER);
		derCentral.setLayout(new GridLayout(2, 1, 0, 120));
		
		JLabel lblNewLabel = new JLabel("");
		derCentral.add(lblNewLabel);
		
		JPanel panelCentral = new JPanel();
		panelPrincipal.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		//fondo
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Dialogo.class.getResource("/dll/" + matriz[escena][3])));
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentral.add(lblFondo);
		
		JButton btnProximo = new JButton("Próximo");
		btnProximo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {			        
		        
				if (escena < matriz.length - 1) {
					escena++;
					lblName.setText(matriz[escena][0]);
			        lblSpeech.setText(String.format(justified, matriz[escena][1]));
			        lblSpeaker.setIcon(new ImageIcon(Dialogo.class.getResource("/dll/" + matriz[escena][2])));
			        lblFondo.setIcon(new ImageIcon(Dialogo.class.getResource("/dll/" + matriz[escena][3])));
				} else {
					dispose();
				}

		        }
		});
		infDerecha.add(btnProximo);

	}

}
