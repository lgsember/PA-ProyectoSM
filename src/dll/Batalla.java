package dll;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Batalla {
	
	private int id;

	public Batalla(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Batalla [id=" + id + "]";
	}

	ImageIcon select = new ImageIcon(Batalla.class.getResource("selection.png"));
	
	public String eligirAtaque(Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus) {
		String[] respuesta = {"Sailor Mercury", "Sailor Mars", "Sailor Jupiter", "Sailor Venus"};
		String icon = "";
		int poder;
		Aliado aliado = null;

		 int opcion = JOptionPane.showOptionDialog(
		            null,
		           "¿Que Sailor Guerrera eliges para luchar contigo?",
		            "Batalla",
		            JOptionPane.DEFAULT_OPTION,
		            JOptionPane.PLAIN_MESSAGE,
		            select,
		            respuesta,
		            respuesta[0]
		        );

		 if (opcion == 0) {
			aliado = mercury;
			icon = "mercfight.png";
		} else if (opcion == 1) {
			aliado = mars;
			icon = "marsfight.png";
		} else if (opcion == 2) {
			aliado = jupiter;
			icon = "jupfight.png";
		} else {
			aliado = venus;
			icon = "venusfight.png";
		} 
		 
		 String[] poderes = {aliado.getPoder1(), aliado.getPoder2(), "Eligir otra Sailor"};
		 
		 poder = JOptionPane.showOptionDialog(
		            null,
		           "¿Que poder quieres usar?",
		            "Batalla",
		            JOptionPane.DEFAULT_OPTION,
		            JOptionPane.PLAIN_MESSAGE,
		            new ImageIcon(Batalla.class.getResource(icon)),
		            poderes,
		            poderes[0]
		        );
			
			if (poder == 2) {
				return "none";
			} else {
				return aliado.usarPoder(poder);
			}	
	}
	
	public String[] definirGanador(Enemigo enemigo, String atke, String atka) {
		int luz = 1, oscuridad = 2, normal = 3, agua = 4, fuego = 5, tierra = 6, aire = 7, planta = 8, eletricidad = 9, hielo = 10, atkaliado = 0, atkenemigo = 0;
		String aliado = "", imgAliado = "", imgEnemigo = "", tipoAtka = "", tipoAtcke = "", resolucion = "", resultado = "";
		
		if (atka.equals("¡Burbujas Congelantes de Mercurio, Estallen!")) {
			imgAliado = "mercatk1.png";
			tipoAtka = "Hielo";
			aliado = "Sailor Mercury";
		} else if (atka.equals("¡Fulgor del Agua de Mercurio!")) {
			imgAliado = "mercatk2.png";
			tipoAtka = "Agua";
			aliado = "Sailor Mercury";
		} else if (atka.equals("¡Mandala Ardiente!")) {
			imgAliado = "marsatk1.png";
			tipoAtka = "Fuego";
			aliado = "Sailor Mars";
		} else if (atka.equals("¡Que los Demonios se Dispersen!")) {
			imgAliado = "marsatk2.png";
			tipoAtka = "Luz";
			aliado = "Sailor Mars";
		} else if (atka.equals("¡Trueno de Júpiter, Resuena!")) {
			imgAliado = "jupatk1.png";
			tipoAtka = "Eletricidad";
			aliado = "Sailor Jupiter";
		} else if (atka.equals("¡Ataque de hojas de Roble de Júpiter!")) {
			imgAliado = "jupatk2.png";
			tipoAtka = "Planta";
			aliado = "Sailor Jupiter";
		} else if (atka.equals("¡Rayo Creciente de Venus!")) {
			imgAliado = "venusatk1.png";
			tipoAtka = "Luz";
			aliado = "Sailor Venus";
		} else if (atka.equals("¡Cadena del Amor de Venus!")) {
			imgAliado = "venusatk2.png";
			tipoAtka = "Normal";
			aliado = "Sailor Venus";
		}
		
		if (atke.equals("Eclipse anular, ¡manifiéstate!")) {
			tipoAtcke = "Fuego";
		} else if (atke.equals("¡Ondas sonoras de la Luna Oscura!")) {
			tipoAtcke = "Oscuridad";
		} else if (atke.equals("¡Rocas afiladas de Ceres, dispersaos!")) {
			tipoAtcke = "Tierra";
		} else if (atke.equals("¡Ondas gravitacionales de Ceres!")) {
			tipoAtcke = "Tierra";
		} else if (atke.equals("Estacas cristalinas de Eris, ¡congelad!")) {
			tipoAtcke = "Hielo";
		} else if (atke.equals("¡Aurora Resplandeciente de Eris!")) {
			tipoAtcke = "Luz";
		} else if (atke.equals("¡Ciclón perforador de Humea, devastación!")) {
			tipoAtcke = "Aire";
		} else if (atke.equals("¡Proyección astral de Humea!")) {
			tipoAtcke = "Oscuridad";
		}
		
		if (enemigo.getPlaneta().equals("Dark Moon")) {
			imgEnemigo = "dmoonfight.png";
		} else if (enemigo.getPlaneta().equals("Ceres")) {
			imgEnemigo = "ceresfight.png";
		} else if (enemigo.getPlaneta().equals("Eris")) {
			imgEnemigo = "erisfight.png"; 
		} else if (enemigo.getPlaneta().equals("Humea")) {
			imgEnemigo = "humeafight.png"; 
		}
		
		//JOptionPane.showMessageDialog(null, atka, "Tu aliado ataca con:", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Decision.class.getResource(imgAliado)));
		//JOptionPane.showMessageDialog(null, atke, "El enemigo contra ataca con:", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Decision.class.getResource(imgEnemigo)));
		
		atkaliado = this.cargarPoderAliado(atka);
		atkenemigo = this.cargarPoderEnemigo(atke);
		
		if (atkaliado==normal && atkenemigo==luz || atkaliado==luz && atkenemigo==oscuridad || atkaliado==luz && atkenemigo==aire || atkaliado==agua && atkenemigo==tierra || atkaliado==agua && atkenemigo==fuego || atkaliado==hielo && atkenemigo==aire || atkaliado==hielo && atkenemigo==planta || atkaliado==hielo && atkenemigo==agua || atkaliado==fuego && atkenemigo==planta || atkaliado==fuego && atkenemigo==hielo || atkaliado==fuego && atkenemigo==oscuridad || atkaliado==eletricidad && atkenemigo==aire || atkaliado==eletricidad && atkenemigo==agua || atkaliado==eletricidad && atkenemigo==oscuridad || atkaliado==planta && atkenemigo==tierra || atkaliado==planta && atkenemigo==eletricidad || atkaliado==tierra && atkenemigo==fuego || atkaliado==tierra && atkenemigo==eletricidad || atkaliado==tierra && atkenemigo==luz || atkaliado==aire && atkenemigo==fuego || atkaliado==aire && atkenemigo==tierra || atkaliado==oscuridad && atkenemigo==normal || atkaliado==oscuridad && atkenemigo==tierra || atkaliado==oscuridad && atkenemigo==planta) {
			resolucion = "El poder de tu aliado se mostró más fuerte.";
			resultado = "gano";
			//JOptionPane.showMessageDialog(null, "El poder de tu aliado se mostró más fuerte.");
		} else if(atkenemigo==normal && atkaliado==luz || atkenemigo==luz && atkaliado==oscuridad || atkenemigo==luz && atkaliado==aire || atkenemigo==agua && atkaliado==tierra || atkenemigo==agua && atkaliado==fuego || atkenemigo==hielo && atkaliado==aire || atkenemigo==hielo && atkaliado==planta || atkenemigo==hielo && atkaliado==agua || atkenemigo==fuego && atkaliado==planta || atkenemigo==fuego && atkaliado==hielo || atkenemigo==fuego && atkaliado==oscuridad || atkenemigo==eletricidad && atkaliado==aire || atkenemigo==eletricidad && atkaliado==agua || atkenemigo==eletricidad && atkaliado==oscuridad || atkenemigo==planta && atkaliado==tierra || atkenemigo==planta && atkaliado==eletricidad || atkenemigo==tierra && atkaliado==fuego || atkenemigo==tierra && atkaliado==eletricidad || atkenemigo==tierra && atkaliado==luz || atkenemigo==aire && atkaliado==fuego || atkenemigo==aire && atkaliado==tierra || atkenemigo==oscuridad && atkaliado==normal || atkenemigo==oscuridad && atkaliado==tierra || atkenemigo==oscuridad && atkaliado==planta) {
			//JOptionPane.showMessageDialog(null, "El poder del enemigo superó tu aliado.");
			resolucion = "El poder del enemigo superó tu aliado.";
			resultado = "perdio";
		} else {
			//JOptionPane.showMessageDialog(null, "Los poderes se anularon.");
			resultado = "empate";
			resolucion = "Los poderes se anularon.";
		}

		 String[] array = {
				aliado, enemigo.getNombre(), tipoAtka, imgAliado, atke, tipoAtcke, imgEnemigo, resolucion, resultado
		};
		 
		 return array;

	}
	
	private int cargarPoderAliado(String aliado) {
		if (aliado.equals("¡Burbujas Congelantes de Mercurio, Estallen!")) {
			return 10;
		} else if (aliado.equals("¡Fulgor del Agua de Mercurio!")) {
			return 4;
		} else if (aliado.equals("¡Mandala Ardiente!")) {
			return 5;
		} else if (aliado.equals("¡Que los Demonios se Dispersen!")) {
			return 1;
		} else if (aliado.equals("¡Trueno de Júpiter, Resuena!")) {
			return 9;
		} else if (aliado.equals("¡Ataque de hojas de Roble de Júpiter!")) {
			return 8;
		} else if (aliado.equals("¡Rayo Creciente de Venus!")) {
			return 1;
		} else if (aliado.equals("¡Cadena del Amor de Venus!")) {
			return 3;
		} else {
			return 0;
		}
	}
	
	private int cargarPoderEnemigo(String enemigo) {
		if (enemigo.equals("Eclipse anular, ¡manifiéstate!")) {
			return 5;
		} else if (enemigo.equals("¡Ondas sonoras de la Luna Oscura!")) {
			return 2;
		} else if (enemigo.equals("¡Rocas afiladas de Ceres, dispersaos!")) {
			return 6;
		} else if (enemigo.equals("¡Ondas gravitacionales de Ceres!")) {
			return 6;
		} else if (enemigo.equals("Estacas cristalinas de Eris, ¡congelad!")) {
			return 10;
		} else if (enemigo.equals("¡Aurora Resplandeciente de Eris!")) {
			return 1;
		} else if (enemigo.equals("¡Ciclón perforador de Humea, devastación!")) {
			return 7;
		} else if (enemigo.equals("¡Proyección astral de Humea!")) {
			return 2;
		} else {
			return 0;
		}
	}
	
}
