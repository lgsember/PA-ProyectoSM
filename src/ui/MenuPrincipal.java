package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bll.Validador;
import dll.Aliado;
import dll.Batalla;
import dll.Conexion;
import dll.Enemigo;
import dll.Jugador;
import dll.Personaje;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	public MenuPrincipal() {
		setTitle("Pantalla Principal");
		Connection cnx = new Conexion().conectar();
		
		Validador valid = new Validador();
		Main main = new Main();
		
		Jugador jugador = new Jugador(0, "", "", "", 0, 1);
		Personaje earth = new Personaje("", "Earth", "¡Semillas de la Tierra, germinen!", "¡Ventiscas espirales de la Tierra!");
		
		Aliado moon = new Aliado("Usagi", "Moon", "Tiara Lunar ¡Acción!", "¡Curación Lunar, Acción!", 3);
		Aliado mercury = new Aliado("Ami", "Mercury", "¡Burbujas Congelantes de Mercurio, Estallen!", "¡Fulgor del Agua de Mercurio!", 3);
		Aliado mars = new Aliado("Rei", "Mars", "¡Mandala Ardiente!", "¡Que los Demonios se Dispersen!", 3);
		Aliado jupiter = new Aliado("Mako", "Jupiter", "¡Trueno de Júpiter, Resuena!", "¡Ataque de hojas de Roble de Júpiter!", 3);
		Aliado venus = new Aliado("Mina", "Venus", "¡Rayo Creciente de Venus!", "¡Cadena del Amor de Venus!", 3);
		
		Enemigo ceres = new Enemigo("Sailor Ceres", "Ceres", "¡Rocas afiladas de Ceres, dispersaos!", "¡Ondas gravitacionales de Ceres!", 2, "Enemigo", 0);
		Enemigo eris = new Enemigo("Sailor Eris", "Eris", "Estacas cristalinas de Eris, ¡congelad!", "¡Aurora Resplandeciente de Eris!", 2, "Enemigo", 0);
		Enemigo humea = new Enemigo("Sailor Haumea", "Humea", "¡Ciclón perforador de Humea, devastación!", "¡Proyección astral de Humea!", 3, "Enemigo", 0);
		Enemigo dmoon = new Enemigo("Nyx", "Dark Moon", "Eclipse anular, ¡manifiéstate!", "¡Ondas sonoras de la Luna Oscura!", 4, "Enemigo", 0);
		
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 416);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperior = new JPanel();
		panel.add(panelSuperior, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("Sailor Moon:Battle for Earth");
		panelSuperior.add(lblTitulo);
		
		JPanel panelInferior = new JPanel();
		panel.add(panelInferior, BorderLayout.SOUTH);
		
		JLabel lblCreditos = new JLabel("Desarollado por Gonzalez, Castro, Cisneros.");
		panelInferior.add(lblCreditos);
		
		JPanel panelCentral = new JPanel();
		panel.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		panelCentral.add(splitPane, BorderLayout.CENTER);
		
		JPanel panelBotones = new JPanel();
		splitPane.setLeftComponent(panelBotones);
		panelBotones.setLayout(new GridLayout(8, 1, 10, 10));
		
		JButton btnAltaJugador = new JButton("Nueva Partida");
        btnAltaJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	valid.arNuevoJugador(jugador);
				valid.arAltaStatus(jugador);
				main.campana(jugador, valid, earth, moon, mercury, mars, jupiter, venus, ceres, eris, humea, dmoon);
            }
        });
        panelBotones.add(btnAltaJugador);
		
        JButton btnSelectJugador = new JButton("Cargar Partida");
        btnSelectJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {        	
            	main.cargarJugador(jugador, valid, mercury, mars, jupiter, venus, ceres, eris, humea, dmoon);
            	dispose();
            	main.campana(jugador, valid, earth, moon, mercury, mars, jupiter, venus, ceres, eris, humea, dmoon);
            }
        });
        panelBotones.add(btnSelectJugador);
		
        JButton btnBatalla = new JButton("Modo Batalla");
        btnBatalla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Enemigo enemigo = null;
				int random = (int)(Math.random()*4);
				if (random==0) {
					enemigo = ceres;
				} else if (random==1) {
					enemigo = eris;
				} else if (random==2) {
					enemigo = humea;
				} else {
					enemigo = dmoon;
				}
				main.modoBatalla(mercury, mars, jupiter, venus, enemigo);
            }
        });
        panelBotones.add(btnBatalla);
		
		JLabel lblSeparador1 = new JLabel("");
		panelBotones.add(lblSeparador1);
		
		JButton btnModJugador = new JButton("Cambiar Nombre");
        btnModJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	main.cargarJugador(jugador, valid, mercury, mars, jupiter, venus, ceres, eris, humea, dmoon);			
				if (valid.arNombre(jugador)) {
					JOptionPane.showMessageDialog(null, "Nombre actualizado!");
				}
            }
        });
        panelBotones.add(btnModJugador);
		
        JButton btnBajaJugador = new JButton("Borrar Partida");
        btnBajaJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int opcion = 2;
            	String []confirmacion= {"Si", "No"};
            	main.cargarJugador(jugador, valid, mercury, mars, jupiter, venus, ceres, eris, humea, dmoon);	
				opcion = JOptionPane.showOptionDialog(null, "Estás seguro?", "Borrar usuario", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, confirmacion, confirmacion[0]);
				if (opcion==0 && valid.arBajaJugador(jugador)) {
					JOptionPane.showMessageDialog(null, "Usuario borrado!");
				} else {
					JOptionPane.showMessageDialog(null, "El usuario no se borró.");
				}
            }
        });
        panelBotones.add(btnBajaJugador);
		
		JLabel lblSeparador2 = new JLabel("");
		panelBotones.add(lblSeparador2);
		
		JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });
        panelBotones.add(btnSalir);
		
		JPanel panelImagen = new JPanel();
		splitPane.setRightComponent(panelImagen);
		
		JLabel lblImgFondo = new JLabel("");
		lblImgFondo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/ui/SM_Menu.png")));
		panelImagen.add(lblImgFondo);
		
		JPanel panelIzquierda = new JPanel();
		panelCentral.add(panelIzquierda, BorderLayout.WEST);
		
		JPanel panelDerecha = new JPanel();
		panelCentral.add(panelDerecha, BorderLayout.EAST);
	}
	
}