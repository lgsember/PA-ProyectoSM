package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Color;

public class Combate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Combate frame = new Combate();
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
	public Combate() {
		setTitle("Batalla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNameChar = new JLabel("Dark Moon");
		lblNameChar.setForeground(Color.WHITE);
		lblNameChar.setBackground(Color.BLACK);
		lblNameChar.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNameChar.setHorizontalAlignment(SwingConstants.LEFT);
		lblNameChar.setBounds(28, 35, 69, 13);
		panel.add(lblNameChar);
		
		JLabel lblImgChar = new JLabel("");
		lblImgChar.setVerticalAlignment(SwingConstants.BOTTOM);
		lblImgChar.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgChar.setIcon(new ImageIcon(Combate.class.getResource("/dll/dmoonfight.png")));
		lblImgChar.setBounds(140, 105, 75, 160);
		panel.add(lblImgChar);
		
		JLabel lblPowerChar = new JLabel("Fuego y Oscuridad");
		lblPowerChar.setForeground(Color.WHITE);
		lblPowerChar.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPowerChar.setHorizontalAlignment(SwingConstants.LEFT);
		lblPowerChar.setBounds(28, 57, 127, 13);
		panel.add(lblPowerChar);
		
		JLabel lblTitulo = new JLabel("Rondas: 2/4 | Salud del Enemigo: 1");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(163, 10, 255, 13);
		panel.add(lblTitulo);
		
		JLabel lblNameEnemy = new JLabel("Sailor Mars");
		lblNameEnemy.setForeground(Color.WHITE);
		lblNameEnemy.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNameEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNameEnemy.setBounds(505, 35, 69, 13);
		panel.add(lblNameEnemy);
		
		JLabel lblImgEnemy = new JLabel("");
		lblImgEnemy.setVerticalAlignment(SwingConstants.BOTTOM);
		lblImgEnemy.setIcon(new ImageIcon(Combate.class.getResource("/dll/marsatk2.png")));
		lblImgEnemy.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgEnemy.setBounds(402, 112, 66, 160);
		panel.add(lblImgEnemy);
		
		JLabel lblFuegoYOscuridad = new JLabel("Fuego y Luz");
		lblFuegoYOscuridad.setForeground(Color.WHITE);
		lblFuegoYOscuridad.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFuegoYOscuridad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFuegoYOscuridad.setBounds(459, 58, 117, 13);
		panel.add(lblFuegoYOscuridad);
		
		JLabel lblDialogo = new JLabel("Tu poder supero el enemigo.");
		lblDialogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDialogo.setBounds(38, 280, 531, 13);
		panel.add(lblDialogo);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Combate.class.getResource("/dll/bg_batalla.gif")));
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setBounds(0, 0, 598, 303);
		panel.add(lblFondo);
		


		
	}
}
