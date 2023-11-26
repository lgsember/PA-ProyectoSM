package dll;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import bll.Validador;

public class Decision {
	
	private boolean buena;

	public Decision(boolean buena) {
		super();
		this.buena = buena;
	}

	public boolean isBuena() {
		return buena;
	}

	public void setBuena(boolean buena) {
		this.buena = buena;
	}

	@Override
	public String toString() {
		return "Decision [buena=" + buena + "]";
	}
	
	Validador valid = new Validador();
	ImageIcon ami = new ImageIcon(Decision.class.getResource("Ami.png"));
	ImageIcon rei = new ImageIcon(Decision.class.getResource("Rei.png"));
	ImageIcon mako = new ImageIcon(Decision.class.getResource("Mako.png"));
	ImageIcon mina = new ImageIcon(Decision.class.getResource("Mina.png"));
	
	public boolean Decision1(Jugador jugador, Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus, Enemigo enemigo) {
		String[] respuesta = {"Todo bien, no te preocupes.", "¡Ten más cuidado!"};
		
		 int opcion = JOptionPane.showOptionDialog(
		            null,
		            jupiter.getNombre() + ":\nLo siento. ¿Estás bien?",
		            "Decision",
		            JOptionPane.DEFAULT_OPTION,
		            JOptionPane.PLAIN_MESSAGE,
		            mako,
		            respuesta,
		            respuesta[0]
		        );

		        if (opcion == 0) {
		        	jupiter.modAfinidad(true);
		        	valid.arModStatus(jugador, jupiter, enemigo);
		        	//JOptionPane.showMessageDialog(null, jupiter.getNombre() + ":\nAh, me alegro. Estaba distraída…", "Karma: " + jugador.getKarma() + " | Afinidad: ☿" + mercury.getAfinidad() + " ♂" + mars.getAfinidad() + " ♃" + jupiter.getAfinidad() + " ♀" + venus.getAfinidad(),  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Decision.class.getResource("makogd.png")));
		        	return true;
		        } else {
		        	jupiter.modAfinidad(false);
		        	valid.arModStatus(jugador, jupiter, enemigo);
		        	//JOptionPane.showMessageDialog(null, jupiter.getNombre() + ":\nTampoco es para tanto. Estaba distraída…", "Karma: " + jugador.getKarma() + " | Afinidad: ☿" + mercury.getAfinidad() + " ♂" + mars.getAfinidad() + " ♃" + jupiter.getAfinidad() + " ♀" + venus.getAfinidad(),  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Decision.class.getResource("makobd.png")));
		        	return false;
		        }

	}
	
	public boolean Decision2(Jugador jugador, Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus, Enemigo enemigo) {	
		String[] respuesta = {"¡Me encantaría!", "Sería genial, pero…"};
	
			int opcion = JOptionPane.showOptionDialog(
			    null,
			    venus.getNombre() + ":\n¿No te gustaría venir con nosotros?",
			    "Decision",
			    JOptionPane.DEFAULT_OPTION,
			    JOptionPane.PLAIN_MESSAGE,
			    mina,
			    respuesta,
			    respuesta[0]
			);

		        if (opcion == 0) {
		        	venus.modAfinidad(true);
		        	valid.arModStatus(jugador, venus, enemigo);
		        	//JOptionPane.showMessageDialog(null, venus.getNombre() + ":\n¡Entonces vámonos!\nNuestros amigos ya nos están esperando.", "Karma: " + jugador.getKarma() + " | Afinidad: ☿" + mercury.getAfinidad() + " ♂" + mars.getAfinidad() + " ♃" + jupiter.getAfinidad() + " ♀" + venus.getAfinidad(),  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Decision.class.getResource("minagd.png")));
		            return true;
		        } else {
		        	venus.modAfinidad(false);
		        	valid.arModStatus(jugador, venus, enemigo);
		        	//JOptionPane.showMessageDialog(null, venus.getNombre() + ":\nOh, ya debes tener otros planes.\nTodo bien entonces. ¡Nos vemos por ahí!", "Karma: " + jugador.getKarma() + " | Afinidad: ☿" + mercury.getAfinidad() + " ♂" + mars.getAfinidad() + " ♃" + jupiter.getAfinidad() + " ♀" + venus.getAfinidad(),  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Decision.class.getResource("minabd.png")));
		            return false;
		        }

	}
	
	public boolean Decision3(Jugador jugador) {
		String[] respuesta = {"Busca alguna manera de ayudar.", "Mejor no involucrarse, no hay nada que hacer."};
		
		 int opcion = JOptionPane.showOptionDialog(
		            null,
		           "¿Que haces?",
		            "Decision",
		            JOptionPane.DEFAULT_OPTION,
		            JOptionPane.PLAIN_MESSAGE,
		            null,
		            respuesta,
		            respuesta[0]
		        );

		        if (opcion == 0) {
		        	jugador.calcularKarma(true, 1);
		        	valid.arModKarma(jugador);
		        	//JOptionPane.showMessageDialog(null, "Recoges una piedra para arrojarla al enemigo, pero antes de que puedas hacerlo,\nuna rosa roja cruza el cielo y golpea a Nyx, provocando que libere a Sailor Moon.\nTe das cuenta de que acaba de aparecer un joven con esmoquin y máscara.", "Karma: " + jugador.getKarma() + " | Afinidad: ☿" + mercury.getAfinidad() + " ♂" + mars.getAfinidad() + " ♃" + jupiter.getAfinidad() + " ♀" + venus.getAfinidad(),  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Decision.class.getResource("tmaskfight.png")));
		        	return true;
		        } else {
		        	jugador.calcularKarma(false, 1);
		        	valid.arModKarma(jugador);
		        	//JOptionPane.showMessageDialog(null, "Afortunadamente, una rosa roja cruza el cielo y golpea a Nyx,\nprovocando que ésta libere a Sailor Moon.\nTe das cuenta de que acaba de aparecer un joven con esmoquin y máscara.", "Karma: " + jugador.getKarma() + " | Afinidad: ☿" + mercury.getAfinidad() + " ♂" + mars.getAfinidad() + " ♃" + jupiter.getAfinidad() + " ♀" + venus.getAfinidad(),  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Decision.class.getResource("tmaskfight.png")));
		        	return false;
		        }

	}

}