package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.swing.JButton;

public class Combate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String[] array;
	
	private static Image flipImageHorizontal(Image originalImage) {
	    int width = originalImage.getWidth(null);
	    int height = originalImage.getHeight(null);

	    BufferedImage flippedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g = flippedImage.createGraphics();
	    g.drawImage(originalImage, width, 0, 0, height, 0, 0, width, height, null);
	    g.dispose();

	    return flippedImage;
	}

			public void run() {
				try {
					this.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			public void close() {
				try {
					this.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	public Combate(String[] array) {
		this.array = array;
		
		setTitle("Batalla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 350);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//rondas y salud
		JLabel lblTitulo = new JLabel("Rondas: " + array[0] + " | Salud del Enemigo: " + array[1]);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(200, 10, 199, 13);
		panel.add(lblTitulo);
		
		//nom aliado
		JLabel lblAllyName = new JLabel(array[2]);
		lblAllyName.setHorizontalAlignment(SwingConstants.LEFT);
		lblAllyName.setBounds(10, 10, 180, 13);
		panel.add(lblAllyName);
				
		//nom enemigo
		JLabel lblEnemyName = new JLabel(array[3]);
		lblEnemyName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnemyName.setBounds(408, 10, 180, 13);
		panel.add(lblEnemyName);
		
		//atk aliado
		JLabel lblAllyAtk = new JLabel(array[4]);
		lblAllyAtk.setForeground(Color.WHITE);
		lblAllyAtk.setBackground(Color.BLACK);
		lblAllyAtk.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAllyAtk.setHorizontalAlignment(SwingConstants.LEFT);
		lblAllyAtk.setBounds(28, 35, 244, 13);
		panel.add(lblAllyAtk);
		
		//tipo atk aliado
		JLabel lblAllyType = new JLabel("Poder Tipo " + array[5]);
		lblAllyType.setForeground(Color.WHITE);
		lblAllyType.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAllyType.setHorizontalAlignment(SwingConstants.LEFT);
		lblAllyType.setBounds(28, 57, 226, 13);
		panel.add(lblAllyType);
		
		//animacion aliado
		JLabel lblAllyImg = new JLabel("");
		lblAllyImg.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAllyImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllyImg.setIcon(new ImageIcon(Combate.class.getResource("/dll/" + array[6])));
		lblAllyImg.setBounds(98, 105, 136, 160);
		panel.add(lblAllyImg);
		
		//atk enemigo
		JLabel lblEnemyAtk = new JLabel(array[7]);
		lblEnemyAtk.setForeground(Color.WHITE);
		lblEnemyAtk.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEnemyAtk.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnemyAtk.setBounds(341, 35, 233, 13);
		panel.add(lblEnemyAtk);
		
		//tipo atk enemigo
		JLabel lblEnemyType = new JLabel("Poder Tipo " + array[8]);
		lblEnemyType.setForeground(Color.WHITE);
		lblEnemyType.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEnemyType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnemyType.setBounds(367, 58, 209, 13);
		panel.add(lblEnemyType);
		
		ImageIcon enemyIcon = new ImageIcon(Combate.class.getResource("/dll/" + array[9]));
		Image enemyImage = enemyIcon.getImage();
		ImageIcon invertedEnemyIcon = new ImageIcon(flipImageHorizontal(enemyImage));
		
		//animacion enemigo
		JLabel lblEnemyImg = new JLabel("");
		lblEnemyImg.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEnemyImg.setIcon(invertedEnemyIcon);
		lblEnemyImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnemyImg.setBounds(408, 94, 66, 160);
		panel.add(lblEnemyImg);
		
		//fondo
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Combate.class.getResource("/dll/" + array[10])));
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setBounds(0, 0, 598, 303);
		panel.add(lblFondo);
		
		//resolucion
		JLabel lblDialog = new JLabel(array[11]);
		lblDialog.setHorizontalAlignment(SwingConstants.LEFT);
		lblDialog.setBounds(10, 280, 466, 13);
		panel.add(lblDialog);

	}
}
