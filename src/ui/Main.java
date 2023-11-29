package ui;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import bll.Validador;
import dll.Aliado;
import dll.Batalla;
import dll.Decision;
import dll.Enemigo;
import dll.Historia;
import dll.Jugador;
import dll.Personaje;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		

		/*
		 * int opcion = 10;
		Connection cnx = new Conexion().conectar();
		Validador valid = new Validador();

		Jugador jugador = new Jugador(0, "", "", 0, 1);

		Personaje earth = new Personaje(null, "Earth", "¡Semillas de la Tierra, germinen!", "¡Ventiscas espirales de la Tierra!");
		Aliado moon = new Aliado("Usagi", "Moon", "Tiara Lunar ¡Acción!", "¡Curación Lunar, Acción!", 3);
		Aliado mercury = new Aliado("Ami", "Mercury", "¡Burbujas Congelantes de Mercurio, Estallen!", "¡Fulgor del Agua de Mercurio!", 3);
		Aliado mars = new Aliado("Rei", "Mars", "¡Mandala Ardiente!", "¡Que los Demonios se Dispersen!", 3);
		Aliado jupiter = new Aliado("Mako", "Jupiter", "¡Trueno de Júpiter, Resuena!", "¡Ataque de hojas de Roble de Júpiter!", 3);
		Aliado venus = new Aliado("Mina", "Venus", "¡Rayo Creciente de Venus!", "¡Cadena del Amor de Venus!", 3);
		
		Enemigo ceres = new Enemigo("Sailor Ceres", "Ceres", "¡Rocas afiladas de Ceres, dispersaos!", "¡Ondas gravitacionales de Ceres!", 2, "Enemigo", 0);
		Enemigo eris = new Enemigo("Sailor Eris", "Eris", "Estacas cristalinas de Eris, ¡congelad!", "¡Aurora Resplandeciente de Eris!", 2, "Enemigo", 0);
		Enemigo humea = new Enemigo("Sailor Haumea", "Humea", "¡Ciclón perforador de Humea, devastación!", "¡Proyección astral de Humea!", 3, "Enemigo", 0);
		Enemigo dmoon = new Enemigo("Nyx", "Dark Moon", "Eclipse anular, ¡manifiéstate!", "¡Ondas sonoras de la Luna Oscura!", 4, "Enemigo", 0);
		*/
		
		//que condicion con trycatch para que no se cerre la pantalla 
		MenuPrincipal menu = new MenuPrincipal();
		menu.run();
		
		
		

	}
	
	public void campana(Jugador jugador, Validador valid, Personaje earth, Aliado moon, Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus, Enemigo ceres, Enemigo eris, Enemigo humea, Enemigo dmoon) {
		Historia sm = new Historia(0);
		Decision ds = new Decision(true);
		Batalla bt = new Batalla(0);
		
		int opcion = 0;
		String []confirmacion= {"Si", "No"};
		
		System.out.println("ID: " + jugador.getId());
		System.out.println("NAME: " + jugador.getNombre());
		System.out.println("GENDER: " + jugador.getGenero());
		System.out.println("KARMA: " + jugador.getKarma());
		System.out.println("CHECKPOINT: " + jugador.getProgreso());
		System.out.println("☿: " + mercury.getAfinidad());
		System.out.println("♂: " + mars.getAfinidad());
		System.out.println("♃: " + jupiter.getAfinidad());
		System.out.println("♀: " + venus.getAfinidad());
		System.out.println("Ceres: S-" + ceres.getSalud() + " A-" + ceres.getConfianza() + " C-" + ceres.getCondicion());
		System.out.println("Eris: S-" + eris.getSalud() + " A-" + eris.getConfianza() + " C-" + eris.getCondicion());
		System.out.println("Humea: S-" + humea.getSalud() + " A-" + humea.getConfianza() + " C-" + humea.getCondicion());
		System.out.println("Dark Moon: S-" + dmoon.getSalud() + " A-" + dmoon.getConfianza() + " C-" + dmoon.getCondicion());
		
		if (jugador.getProgreso()==1) {

				Dialogo preludio = new Dialogo(sm.Prelude(jugador, mercury, mars, jupiter, venus), new Dialogo.DialogoCallback() {
				    @Override
				    public void onDialogoCompleted() {
				    	Dialogo intro1 = new Dialogo(sm.Intro1(jugador, mercury, mars, jupiter, venus, dmoon), new Dialogo.DialogoCallback() {
						    @Override
						    public void onDialogoCompleted() {
						    	valid.arNombre(jugador);
								
								Dialogo intro2 = new Dialogo(sm.Intro2(jugador, mercury, mars, jupiter, venus, dmoon), new Dialogo.DialogoCallback() {
								    @Override
								    public void onDialogoCompleted() {
								    	
								    	Dialogo escena1 = new Dialogo(sm.Escena1(jugador, mercury, mars, jupiter, venus, dmoon), new Dialogo.DialogoCallback() {
										    @Override
										    public void onDialogoCompleted() {
										    	jugador.setProgreso(2);
												valid.arModProgreso(jugador);
												
												//progreso2
													
													Dialogo escena2 = new Dialogo(sm.Escena2(jugador, mercury, mars, jupiter, venus, dmoon), new Dialogo.DialogoCallback() {
													    @Override
													    public void onDialogoCompleted() {
													    	Dialogo escena3 = new Dialogo(sm.Escena3(jugador, mercury, mars, jupiter, venus, dmoon), new Dialogo.DialogoCallback() {
															    @Override
															    public void onDialogoCompleted() {
															    	jugador.setProgreso(3);
																	valid.arModProgreso(jugador);
																	
																	//progreso3
																		batallaTutorial(mercury, mars, jupiter, venus, dmoon);
																		jugador.setProgreso(4);
																		valid.arModProgreso(jugador);
																		
																		//progreso4
																			Dialogo escena4 = new Dialogo(sm.Escena4(jugador, mercury, mars, jupiter, venus), new Dialogo.DialogoCallback() {
																			    @Override
																			    public void onDialogoCompleted() {
																			    	Dialogo findemo = new Dialogo(sm.fin(moon, mercury, mars, jupiter, venus), new Dialogo.DialogoCallback() {
																			    	    @Override
																			    	    public void onDialogoCompleted() {
																			    	    	jugador.setProgreso(1);
																							valid.arModProgreso(jugador);
																			    	    }
																			    	});
																			    	findemo.run();
																			    }
																			});
																			escena4.run();
															    }
															});
															escena3.run();
													    }
													});
													escena2.run();					
										    }
										});
										escena1.run();
								    }
								});
								intro2.run();
						    }
						});
						intro1.run();
				    }
				});
				preludio.run();
		
		} else if (jugador.getProgreso()==2) {
			
			Dialogo escena2 = new Dialogo(sm.Escena2(jugador, mercury, mars, jupiter, venus, dmoon), new Dialogo.DialogoCallback() {
			    @Override
			    public void onDialogoCompleted() {
			    	Dialogo escena3 = new Dialogo(sm.Escena3(jugador, mercury, mars, jupiter, venus, dmoon), new Dialogo.DialogoCallback() {
					    @Override
					    public void onDialogoCompleted() {
					    	jugador.setProgreso(3);
							valid.arModProgreso(jugador);
							
							//progreso3
								batallaTutorial(mercury, mars, jupiter, venus, dmoon);
								jugador.setProgreso(4);
								valid.arModProgreso(jugador);
								
								//progreso4
									Dialogo escena4 = new Dialogo(sm.Escena4(jugador, mercury, mars, jupiter, venus), new Dialogo.DialogoCallback() {
									    @Override
									    public void onDialogoCompleted() {
									    	Dialogo findemo = new Dialogo(sm.fin(moon, mercury, mars, jupiter, venus), new Dialogo.DialogoCallback() {
									    	    @Override
									    	    public void onDialogoCompleted() {
									    	    	jugador.setProgreso(1);
													valid.arModProgreso(jugador);
									    	    }
									    	});
									    	findemo.run();
									    }
									});
									escena4.run();
					    }
					});
					escena3.run();
			    }
			});
			escena2.run();

	} else if (jugador.getProgreso()==3) {
		
		batallaTutorial(mercury, mars, jupiter, venus, dmoon);
		jugador.setProgreso(4);
		valid.arModProgreso(jugador);
		
		//progreso4
			Dialogo escena4 = new Dialogo(sm.Escena4(jugador, mercury, mars, jupiter, venus), new Dialogo.DialogoCallback() {
			    @Override
			    public void onDialogoCompleted() {
			    	Dialogo findemo = new Dialogo(sm.fin(moon, mercury, mars, jupiter, venus), new Dialogo.DialogoCallback() {
			    	    @Override
			    	    public void onDialogoCompleted() {
			    	    	jugador.setProgreso(1);
							valid.arModProgreso(jugador);
			    	    }
			    	});
			    	findemo.run();
			    }
			});
			escena4.run();

	} else if (jugador.getProgreso()==4) {
		Dialogo escena4 = new Dialogo(sm.Escena4(jugador, mercury, mars, jupiter, venus), new Dialogo.DialogoCallback() {
		    @Override
		    public void onDialogoCompleted() {
		    	Dialogo findemo = new Dialogo(sm.fin(moon, mercury, mars, jupiter, venus), new Dialogo.DialogoCallback() {
		    	    @Override
		    	    public void onDialogoCompleted() {
		    	    	jugador.setProgreso(5);
						valid.arModProgreso(jugador);
		    	    }
		    	});
		    	findemo.run();
		    }
		});
		escena4.run();
	} else if (jugador.getProgreso()==5) {
		JOptionPane.showMessageDialog(null, "Gracias por jugar la demo del juego.\nCarga tu juego para jugar desde el inicio otra vez.");
		jugador.setProgreso(1);
		valid.arModProgreso(jugador);
	}
	
	}
	
	public boolean cargarJugador(Jugador jugador, Validador valid, Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus, Enemigo ceres, Enemigo eris, Enemigo humea, Enemigo dmoon) {
		LinkedList<Jugador> usuarios = valid.arCargarProgreso();
		
		if (usuarios.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay datos para cargar.");
			return false;
			} else {
			String []partidas = new String[usuarios.size()];

			for (Jugador jugadores : usuarios) {
			partidas[usuarios.indexOf(jugadores)]=jugadores.getNombre();
			}
		
		String cargarPartida = (String) JOptionPane.showInputDialog(
		        null,
		        "Elegir un jugador para cargar partida:",
		        "Cargar Partida",
		        JOptionPane.QUESTION_MESSAGE,
		        null,
		        partidas,
		        partidas[0]
		);
		
		for (Jugador jugadores : usuarios) {
			if (cargarPartida.equals(jugadores.getNombre())) {
				jugador.setId(jugadores.getId());
				jugador.setNombre(jugadores.getNombre());
				jugador.setGenero(jugadores.getGenero());
				jugador.setKarma(jugadores.getKarma());
				jugador.setProgreso(jugadores.getProgreso());
				}
			}
		cargarAfinidad(jugador, valid, mercury, mars, jupiter, venus);
		cargarEnemigos(jugador, valid, ceres, eris, humea, dmoon);
		return true;
		}
	}
	
	public void cargarAfinidad(Jugador jugador, Validador valid, Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus) {
		LinkedList<Aliado> afinidades = valid.arCargarStatusAliado(jugador);
		
		mercury.setAfinidad(afinidades.get(0).getAfinidad());
		mars.setAfinidad(afinidades.get(1).getAfinidad());
		jupiter.setAfinidad(afinidades.get(2).getAfinidad());
		venus.setAfinidad(afinidades.get(3).getAfinidad());
	}
	
	public void cargarEnemigos(Jugador jugador, Validador valid, Enemigo ceres, Enemigo eris, Enemigo humea, Enemigo dmoon) {
		LinkedList<Enemigo> enemigos = valid.arCargarStatusEnemigo(jugador);
		
		ceres.setConfianza(enemigos.get(0).getConfianza());
		ceres.setSalud(enemigos.get(0).getSalud());
		ceres.setCondicion(enemigos.get(0).getCondicion());
		
		eris.setConfianza(enemigos.get(1).getConfianza());
		eris.setSalud(enemigos.get(1).getSalud());
		eris.setCondicion(enemigos.get(1).getCondicion());
		
		humea.setConfianza(enemigos.get(2).getConfianza());
		humea.setSalud(enemigos.get(2).getSalud());
		humea.setCondicion(enemigos.get(2).getCondicion());
		
		dmoon.setConfianza(enemigos.get(3).getConfianza());
		dmoon.setSalud(enemigos.get(3).getSalud());
		dmoon.setCondicion(enemigos.get(3).getCondicion());	
	}
	
	public void modoBatalla(Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus, Enemigo enemigo) {
		Batalla bt = new Batalla(1);
		int rondas = 4;
		enemigo.setSalud(2);
		String imgEnemigo = "", atk ="";
		boolean ganador = false;
		
		if (enemigo.getPlaneta().equals("Ceres")) {
			imgEnemigo = "ceres.png";
			JOptionPane.showMessageDialog(null, "Batalla contra " + enemigo.getNombre() + ".\n" + enemigo.getPlaneta() + " tiene poderes de tipo Tierra.");
		} else if (enemigo.getPlaneta().equals("Eris")) {
			imgEnemigo = "eris.png";
			JOptionPane.showMessageDialog(null, "Batalla contra " + enemigo.getNombre() + ".\n" + enemigo.getPlaneta() + " tiene poderes de tipo Hielo y Luz.");
		} else if (enemigo.getPlaneta().equals("Humea")) {
			imgEnemigo = "humea.png";
			JOptionPane.showMessageDialog(null, "Batalla contra " + enemigo.getNombre() + ".\n" + enemigo.getPlaneta() + " tiene poderes de tipo Aire y Oscuridad.");
		} else if (enemigo.getPlaneta().equals("Dark Moon")) {
			imgEnemigo = "nyx.png";
			JOptionPane.showMessageDialog(null, "Batalla contra " + enemigo.getPlaneta() + ".\n" + enemigo.getNombre() + " tiene poderes de tipo Fuego y Oscuridad.");
		}
		
		do {
			
			atk = bt.eligirAtaque(mercury, mars, jupiter, venus);

			while (atk.equals("none")) {
			atk = bt.eligirAtaque(mercury, mars, jupiter, venus);
			}

		if (bt.definirGanador(enemigo, enemigo.usarPoder((int) (Math.random() * 2)), atk)) {
			enemigo.setSalud(enemigo.getSalud()-1);
			rondas = rondas + 1;
			
			if (enemigo.getSalud()==1) {
				JOptionPane.showMessageDialog(null, enemigo.getNombre() + ": ¿¡Cómo te atreves!?", "Diálogo", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Main.class.getResource(imgEnemigo)));
			} else if (enemigo.getSalud()==0) {
				ganador = true;
				rondas = 0;
			}
			
		} else {
			if (rondas==4) {
				JOptionPane.showMessageDialog(null, enemigo.getNombre() + ": ¿Eso es todo lo que puedes hacer?", "Diálogo", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Main.class.getResource(imgEnemigo)));
				rondas = rondas - 1;
			} else if (rondas==3) {
				JOptionPane.showMessageDialog(null, enemigo.getNombre() + ": ¡Eres patético!", "Diálogo", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Main.class.getResource(imgEnemigo)));
				rondas = rondas - 1;
			} else if (rondas==2) {
				JOptionPane.showMessageDialog(null, enemigo.getNombre() + ": Me estoy aburriendo...", "Diálogo", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Main.class.getResource(imgEnemigo)));
				rondas = rondas - 1;
			} else if (rondas==1) {
				JOptionPane.showMessageDialog(null, enemigo.getNombre() + ": Basta. Ya me cansé.", "Diálogo", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Main.class.getResource(imgEnemigo)));
				rondas = rondas - 1;
			}
		}
		
		} while (rondas>0);
		
		if (ganador) {
			JOptionPane.showMessageDialog(null, enemigo.getNombre() + ": ¿Cómo perdí contra ti...?", "Ganó la batalla", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Main.class.getResource(imgEnemigo)));
			
			String []decision= {"Curar el enemigo" , "Derrotar el enemigo"};
			String []respuestas= {"Sé que no querías hacer esto." , "Entiendo lo que hiciste y no te juzgaré por ello.", "Ya no hay nada que puedas hacer."};
			
			int opcion = JOptionPane.showOptionDialog(null, "Que quieres hacer?", "Decidir el destino del enemigo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, decision, decision[0]);
			
			if (opcion==1) {
				JOptionPane.showMessageDialog(null, enemigo.getNombre() + ": ¿¡Cómo puedes ser tan cruel!?", "Enemigo derrotado", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Main.class.getResource(imgEnemigo)));
				JOptionPane.showMessageDialog(null, enemigo.getNombre() + " fue derrotada y ya no aparecerá.");
				enemigo.setCondicion("Derrotado");
			} else {
				JOptionPane.showMessageDialog(null, enemigo.getNombre() + ": Oh, ¿quieres curarme? ¿Crees que me convencerás?", "Curar Enemigo", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Main.class.getResource(imgEnemigo)));
				
				opcion = JOptionPane.showOptionDialog(null, "Que vas a decir?", "Convencer el enemigo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, respuestas, respuestas[0]);
				
				if (opcion==0) {
					JOptionPane.showMessageDialog(null, enemigo.getNombre() + ": ¡Sí, pero eso no cambia nada! Todavía no te creo.", "Enemigo curado", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Main.class.getResource(imgEnemigo)));
					JOptionPane.showMessageDialog(null, enemigo.getNombre() + " ya no será tu enemiga, aunque no la hayas convencido.");
					enemigo.setCondicion("Curado");
				} else if (opcion==1) {
					JOptionPane.showMessageDialog(null, enemigo.getNombre() + ": ¿Es verdad? Bueno... creo que puedo confiar en ti.", "Enemigo curado", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Main.class.getResource(imgEnemigo)));
					JOptionPane.showMessageDialog(null, "Conseguiste convertir a " + enemigo.getNombre() + " en una aliada!");
					enemigo.setCondicion("Aliado");
				} else {
					JOptionPane.showMessageDialog(null, enemigo.getNombre() + ": Eso es lo que piensas. ¡Nos veremos muy pronto!", "Enemigo derrotado", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Main.class.getResource(imgEnemigo)));
					JOptionPane.showMessageDialog(null, "No pudiste convencer a " + enemigo.getNombre() + ". Ella seguirá siendo tu enemiga.");
				}
				
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "Perdiste la batalla contra " + enemigo.getNombre() + ". Ya no poderás curarla.");
			
		}

	}

	public void batallaTutorial(Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus, Enemigo enemigo) {
		Batalla bt = new Batalla(1);
		int rondas = 4;
		enemigo.setSalud(2);
		String imgEnemigo = "", atk ="";
		boolean ganador = false;
		
		if (enemigo.getPlaneta().equals("Ceres")) {
			imgEnemigo = "ceres.png";
			JOptionPane.showMessageDialog(null, "Batalla contra " + enemigo.getNombre() + ".\n" + enemigo.getPlaneta() + " tiene poderes de tipo Tierra.");
		} else if (enemigo.getPlaneta().equals("Eris")) {
			imgEnemigo = "eris.png";
			JOptionPane.showMessageDialog(null, "Batalla contra " + enemigo.getNombre() + ".\n" + enemigo.getPlaneta() + " tiene poderes de tipo Hielo y Luz.");
		} else if (enemigo.getPlaneta().equals("Humea")) {
			imgEnemigo = "humea.png";
			JOptionPane.showMessageDialog(null, "Batalla contra " + enemigo.getNombre() + ".\n" + enemigo.getPlaneta() + " tiene poderes de tipo Aire y Oscuridad.");
		} else if (enemigo.getPlaneta().equals("Dark Moon")) {
			imgEnemigo = "nyx.png";
			JOptionPane.showMessageDialog(null, "Batalla contra " + enemigo.getPlaneta() + ".\n" + enemigo.getNombre() + " tiene poderes de tipo Fuego y Oscuridad.");
		}
		
		do {
			
			atk = bt.eligirAtaque(mercury, mars, jupiter, venus);

			while (atk.equals("none")) {
			atk = bt.eligirAtaque(mercury, mars, jupiter, venus);
			}

		if (bt.definirGanador(enemigo, enemigo.usarPoder((int) (Math.random() * 2)), atk)) {
			enemigo.setSalud(enemigo.getSalud()-1);
			rondas = rondas + 1;
			
			if (enemigo.getSalud()==1) {
				JOptionPane.showMessageDialog(null, enemigo.getNombre() + ": ¿¡Cómo te atreves!?", "Diálogo", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Main.class.getResource(imgEnemigo)));
			} else if (enemigo.getSalud()==0) {
				ganador = true;
				rondas = 0;
			}
			
		} else {
			if (rondas==4) {
				JOptionPane.showMessageDialog(null, enemigo.getNombre() + ": ¿Eso es todo lo que puedes hacer?", "Diálogo", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Main.class.getResource(imgEnemigo)));
				rondas = rondas - 1;
			} else if (rondas==3) {
				JOptionPane.showMessageDialog(null, enemigo.getNombre() + ": ¡Eres patético!", "Diálogo", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Main.class.getResource(imgEnemigo)));
				rondas = rondas - 1;
			} else if (rondas==2) {
				JOptionPane.showMessageDialog(null, enemigo.getNombre() + ": No puedes contra mí.", "Diálogo", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Main.class.getResource(imgEnemigo)));
				rondas = rondas - 1;
			} else if (rondas==1) {
				JOptionPane.showMessageDialog(null, enemigo.getNombre() + ": Basta. Ya me cansé.", "Diálogo", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Main.class.getResource(imgEnemigo)));
				rondas = rondas - 1;
			}
		}
		
		} while (rondas>0);
		
		if (ganador) {
			JOptionPane.showMessageDialog(null, enemigo.getNombre() + ": ¿Cómo perdí contra ti...?", "Ganó la batalla", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Main.class.getResource(imgEnemigo)));
			
		} else {
			JOptionPane.showMessageDialog(null, "Perdiste la batalla contra " + enemigo.getNombre() + ".");
			
		}

	}
	
}
