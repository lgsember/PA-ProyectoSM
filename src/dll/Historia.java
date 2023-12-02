package dll;

import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import bll.Validador;
import ui.Dialogo;

public class Historia {
	
	private int seccion;

	public Historia(int seccion) {
		super();
		this.seccion = seccion;
	}

	public int getSeccion() {
		return seccion;
	}

	public void setSeccion(int seccion) {
		this.seccion = seccion;
	}

	@Override
	public String toString() {
		return "Historia [titulo=" + seccion + "]";
	}

	public String[][] Prelude(Jugador jugador, Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus) {
		String status = "Jugador: " + jugador.getNombre() + " | Karma: " + jugador.getKarma() + " | Afinidad: ☿" + mercury.getAfinidad() + " ♂" + mars.getAfinidad() + " ♃" + jupiter.getAfinidad() + " ♀" + venus.getAfinidad();
		
		String[][] matriz = {
			    {"", "Ya es casi la hora. Tengo que irme...", "", "", status},
			    {"", "", "", "acto0.jpg", status},
			    {"", "Hoy es un día muy emocionante para todos: el rarísimo eclipse anular está a punto de ocurrir. Al igual que vos, muchos se están reuniendo en el Parque Yoyogi para presenciar el fenómeno. En el camino, alguien acaba chocándote.", "", "yoyogi.jpg", status}
			};
		/*
		for (int i = 0; i < matriz.length; i++) {
		    String linea = matriz[i][1];
		    String img = matriz[i][3];
		JOptionPane.showMessageDialog(null, linea, status,  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Historia.class.getResource(img)));
		}*/	
		
		return matriz;
	}
	
	//Decision1
	
	public String[][] Intro1(Jugador jugador, Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus, Enemigo enemigo) {
		String linea0 = "", imgrespuesta = "";
		Decision ds = new Decision(true);
		
		if (ds.Decision1(jugador, mercury, mars, jupiter, venus, enemigo)) {
			linea0 = "Ah, me alegro. Estaba distraída…";
			imgrespuesta = "makogd.png";
		} else {
			linea0 = "Tampoco es para tanto. Estaba distraída…";
			imgrespuesta = "makobd.png";
		}
		
		String status = "Jugador: " + jugador.getNombre() + " | Karma: " + jugador.getKarma() + " | Afinidad: ☿" + mercury.getAfinidad() + " ♂" + mars.getAfinidad() + " ♃" + jupiter.getAfinidad() + " ♀" + venus.getAfinidad();
		
		String[][] matriz = {
			    {"Makoto: ", linea0, imgrespuesta, "yoyogi.jpg", status},
			    {"Tutorial: ", "Acabas de tomar una decisión. Los íconos en la parte superior de la pantalla te señalan el efecto de tus decisiones y tu nivel de afinidad con cada una de las chicas: Ami, Rei, Mako y Mina. Tus decisiones cambian el curso de la historia.", "", "yoyogi.jpg", status},
			    {"Minako: ", "Eso es lo que pasa cuando miras a los chicos.", "Mina.png", "yoyogi.jpg", status},
			    {"Makoto: ", "Es qué me recuerda mucho el chico que me gustaba...", "Mako.png", "yoyogi.jpg", status},
			    {"Minako: ", "Mako, siempre dices eso... Ah, por cierto, ¿cómo te llamas?", "Mina.png", "yoyogi.jpg", status}
			};
		/*
		for (int i = 0; i < matriz.length; i++) {
			String persona = matriz[i][0];
		    String linea = matriz[i][1];
		    String img = matriz[i][2];
		JOptionPane.showMessageDialog(null, persona + linea, status,  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Historia.class.getResource(img)));
		}*/

		return matriz;
	}
	
	//valid.arNombre
	
	public String[][] Intro2(Jugador jugador, Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus, Enemigo enemigo) {
		String status = "Jugador: " + jugador.getNombre() + " | Karma: " + jugador.getKarma() + " | Afinidad: ☿" + mercury.getAfinidad() + " ♂" + mars.getAfinidad() + " ♃" + jupiter.getAfinidad() + " ♀" + venus.getAfinidad();
		String linea1 = "";
		
		if (jupiter.getAfinidad()>3) {
			linea1 = "Puedes llamarme Mako.";
		} else {
			linea1 = "Bueno, tenemos que irnos ahora.";
		}
		
		String[][] matriz = {
			    {"Minako: ", "Mucho gusto, " + jugador.getNombre() + ". Yo soy Minako, pero puedes llamarme Mina. Esta es Makoto.", "Mina.png", "yoyogi.jpg", status},
			    {"Makoto: ", linea1, "Mako.png", "yoyogi.jpg", status}
			};
		/*
		for (int i = 0; i < matriz.length; i++) {
			String persona = matriz[i][0];
		    String linea = matriz[i][1];
		    String img = matriz[i][2];
		JOptionPane.showMessageDialog(null, persona + linea, status,  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Historia.class.getResource(img)));
		}*/

		return matriz;
	}
	
	//Decision2
	
	public String[][] Escena1(Jugador jugador, Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus, Enemigo enemigo) {	
		Decision ds = new Decision(true);
		String linea12 = "";
		
		if (jugador.getGenero().equals("Male")) {
			linea12 = "¿Quien es este con ustedes?";
		} else {
			linea12 = "¿Quien es esta con ustedes?";
		}
		
		if (ds.Decision2(jugador, mercury, mars, jupiter, venus, enemigo)) {
			String icoPlayer = "";
			
			if (jugador.getGenero().equals("Male")) {
				icoPlayer = "playerm.png";
			} else {
				icoPlayer = "playerf.png";
			}
			
			String status = "Jugador: " + jugador.getNombre() + " | Karma: " + jugador.getKarma() + " | Afinidad: ☿" + mercury.getAfinidad() + " ♂" + mars.getAfinidad() + " ♃" + jupiter.getAfinidad() + " ♀" + venus.getAfinidad();
			
			String[][] matriz = {
				    {"Mina: ", "¡Entonces vámonos!  Nuestros amigos ya nos están esperando.", "minagd.png", "yoyogi.jpg", status},
				    {"", "Sigues a Mina y Mako por el parque hasta que encuentras un grupo de personas haciendo un picnic en el césped. Ves a dos chicas peleando cuando llegas.", "", "picnic.jpg", status},
				    {"Rei: ", "Usagi! Quedamos en esperar a que lleguen todos para comer.", "Rei.png", "picnic.jpg", status},
				    {"Usagi: ", "¡¡Buuuwaa!! ¡Rei, eres mala! ¿¡No ves que me muero de hambre!?", "Usagi.png", "picnic.jpg", status},
				    {"Mamoru: ", "Usako, ten paciencia.", "mamoru.png", "picnic.jpg", status},
				    {"Usagi: ", "¿Tú también, mamo-chan?💔", "Usagi.png", "picnic.jpg", status},
				    {"Mako: ", "¡Ooooee! ¡Estamos acá!", "Mako.png", "picnic.jpg", status},
				    {"Ami: ", "¡Por fin llegaron!", "Ami.png", "picnic.jpg", status},
				    {"Usagi: ", "Oh, ¿eso significa que ya podemos comer?", "Usagi.png", "picnic.jpg", status},
				    {"", "Rei mira a Usagi con cara de desaprobación.", "reirp1.png", "picnic.jpg", status},
				    {"Usagi: ", "Solo estaba bromeando. ¡Ah, ja, ja! ¡Ah, ja, ja! ¡Ah, ja, ja!", "Usagi.png", "picnic.jpg", status},
				    {"Ami: ", linea12, "Ami.png", "picnic.jpg", status},
				    {"Mina: ", "Ah, es " + jugador.getNombre() + ". Acabamos de nos conocer. " + jugador.getNombre() + ", estas son Rei, Ami y Usagi. Ah, y este es Mamoru, el novio de Usagi.", "Mina.png", "picnic.jpg", status},
				    {"Mako: ", "Usagi es la única de nosotros que tiene novio...", "Mako.png", "picnic.jpg", status},
				    {"Rei: ", "Sólo la cabeza hueca...", "Rei.png", "picnic.jpg", status},
				    {"Usagi: ", "Oye, ¿cómo me llamaste?", "Usagi.png", "picnic.jpg", status},
				    {"", "Te preguntas si siempre son así…", icoPlayer, "picnic.jpg", status},
				    {"Ami: ", "¡Chicas, miren! ¡El evento está por comenzar!", "Ami.png", "picnic.jpg", status},
				    {"Usagi: ", "¡No he comido nada todavía!", "Usagi.png", "picnic.jpg", status}
				};
			/*
			for (int i = 0; i < matriz.length; i++) {
				String persona = matriz[i][0];
			    String linea = matriz[i][1];
			    String img = matriz[i][2];
			JOptionPane.showMessageDialog(null, persona + linea, status,  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Historia.class.getResource(img)));
			}
			 */
			
			return matriz;
		} else {
			
			String status = "Jugador: " + jugador.getNombre() + " | Karma: " + jugador.getKarma() + " | Afinidad: ☿" + mercury.getAfinidad() + " ♂" + mars.getAfinidad() + " ♃" + jupiter.getAfinidad() + " ♀" + venus.getAfinidad();
			
			String[][] matriz = {
					{"Mina: ", "Oh, ya debes tener otros planes. Todo bien entonces. ¡Nos vemos por ahí!", "minabd.png", "yoyogi.jpg", status},
				    {"", "Desde lejos, ves a Mina y Mako unirse a un grupo de personas que hacen un picnic en el césped del parque. Parecen llevarse bien, aunque dos de ellos estuvieron discutiendo antes. Sientes algo fuerte cuando los miras y te preguntas si tal vez no deberías haber ido con ellos. No hay tiempo para arrepentimientos ahora, el espectáculo está por comenzar.", "", "picnic.jpg", status}
				};
			/*
			for (int i = 0; i < matriz.length; i++) {
				String persona = matriz[i][0];
			    String linea = matriz[i][1];
			    String img = matriz[i][2];
			JOptionPane.showMessageDialog(null, persona + linea, status,  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Historia.class.getResource(img)));
			}
			*/
			
			return matriz;
		}
		
	}
	
	public String[][] Escena2(Jugador jugador, Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus, Enemigo enemigo) {	
		String status = "Jugador: " + jugador.getNombre() + " | Karma: " + jugador.getKarma() + " | Afinidad: ☿" + mercury.getAfinidad() + " ♂" + mars.getAfinidad() + " ♃" + jupiter.getAfinidad() + " ♀" + venus.getAfinidad();
		String linea11 = "";
		
		if (jugador.getGenero().equals("Male")) {
			linea11 = "¿No es extraño que el no se desmayara como los demás?";
		} else {
			linea11 = "¿No es extraño que ella no se desmayara como los demás?";
		}
		
		String[][] matriz = {
				{"", "El día comienza a convertirse en noche mientras observas la luna ponerse frente a sol. Poco a poco, el sol se va convirtiendo en un anillo de fuego. Se escucha a la gente exclamando sorprendida, pero pronto las exclamaciones se convierten en bostezo. Notas que la gente a tu alrededor se desmaya.", "", "eclipse.jpg", status},
			    {"Mamoru: ", "Algo anda mal.", "mamoru.png", "eclipse.jpg", status},
			    {"Rei: ", "¿Qué les está pasando a estas personas?", "Rei.png", "eclipse.jpg", status},
			    {"Mina: ", "Todos se durmieron de repente.", "Mina.png", "eclipse.jpg", status},
			    {"Ami: ", "¡Hay alguien ahí!", "Ami.png", "eclipse.jpg", status},
			    {"", "Miras hacia dónde Ami señaló. Como si viniera de la luna, la silueta de alguien aparece flotando allí.", "", "eclipse.jpg", status},
			    {"Rei: ", "¿Será un nuevo enemigo?", "Rei.png", "eclipse.jpg", status},
			    {"Usagi: ", "Chicas, transfórmense.", "Usagi.png", "eclipse.jpg", status},
			    {"Mako: ", "Pero Usagi...", "Mako.png", "eclipse.jpg", status},
			    {"", "Las chicas te miran. Todos sucumbieron al sueño, excepto vos y este grupo de personas que ahora te miran fijamente sin saber qué hacer.", "", "eclipse.jpg", status},
			    {"Ami: ", linea11, "Ami.png", "eclipse.jpg", status},
			    {"???: ", "¡Chicas! ¡No tenemos tiempo que perder!", "", "eclipse.jpg", status},
			    {"Mina: ", "¿¡Artemis!?", "Mina.png", "eclipse.jpg", status},
			    {"", "Notas que un gato blanco acaba de llegar, junto con otro gato de pelaje oscuro que comienza a hablar.", "", "eclipse.jpg", status},
			    {"Luna: ", "No se preocupen por eso. Tengo una suposición...  ¡Transformense ahora mismo!", "luna.png", "eclipse.jpg", status},
			    {"", "Las chicas asienten con la cabeza hacia los gatos. Sus cuerpos son envueltos por una luz que las transforma en guerreras cuando gritan por sus planetas protectores. Aunque te sorprenda, sientes algo extrañamente familiar en todo esto.", "", "allmakeup.png", status},
			    {"Sailor Moon: ", "¡Detente ahí! ¿Cómo te atreves a interrumpir un momento tan sublime para la gente que vino a este parque a relajarse? ¡Y hasta arruinaste mi comida!", "moonrp2.png", "eclipse.jpg", status},
			    {"Sailor Moon: ", "Soy Sailor Moon, la hermosa guerrera disfrazada de marinera que lucha por el amor y la justicia. ¡Te castigaré en nombre de la luna!", "moonrp4.png", "eclipse.jpg", status},
			    {"???: ", "¿Castigarme? Que curioso… porque vine aquí precisamente para castigarte… a ti.", "darkmoon.png", "eclipse.jpg", status},
			    {"Sailor Mercury: ", "¡Ella está emitiendo ondas de sueño!", "mercrp12.png", "eclipse.jpg", status},
			    {"Sailor Jupiter: ", "¿Quién sos para castigarnos?", "juprp5.png", "eclipse.jpg", status},
			    {"???: ", "¿¡No saben quién soy!?", "darkmoon.png", "eclipse.jpg", status},
			    {"", "La figura se acerca, aún flotando en el aire. Puedes verlo mejor ahora. Su traje es grotesco y se te pone la piel de gallina al mirarla.", "dmoonfight.png", "eclipse.jpg", status},
			    {"Nyx: ", "Soy la emperatriz de la luna oscura, Nyx.", "darkmoon.png", "eclipse.jpg", status},
			    {"", "Todos están asustado por la presentación.", "", "eclipse.jpg", status},
			    {"Sailor Venus: ", "¡Eso no es verdad! La luna solo tiene una gobernante.", "venusrp1.png", "eclipse.jpg", status},
			    {"Artemis: ", "Hace mucho tiempo hubo rumores de una emperatriz antes de la Queen Serenity.", "artrp1.png", "eclipse.jpg", status},
			    {"Luna: ", "Tanto tiempo que nadie lo recuerda.", "lunarp1.png", "eclipse.jpg", status},
			    {"Sailor Moon: ", "¿Pero por qué lastimas a la gente?", "moonrp11.png", "eclipse.jpg", status},
			    {"Nyx: ", "¡Porque te desprecio!", "darkmoon.png", "eclipse.jpg", status},
			    {"", "En un movimiento rápido, Nyx se acerca y comienza a estrangular a Sailor Moon. Todos exclaman asustados. Tienes ganas de ayudarla, pero no sabes cómo.", "", "eclipse.jpg", status},
			    {"Luna: ", "Esta aura…", "luna.png", "eclipse.jpg", status},
			    {"", "Luna no deja de mirarte, incluso cuando todos están preocupados por Sailor Moon.", "luna.png", "eclipse.jpg", status}
			};
		/*
		for (int i = 0; i < matriz.length; i++) {
			String persona = matriz[i][0];
		    String linea = matriz[i][1];
		    String img = matriz[i][2];
		JOptionPane.showMessageDialog(null, persona + linea, status,  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Historia.class.getResource(img)));
		}
		*/
		
		return matriz;
	}
	
	//Decision3
	
	public String[][] Escena3(Jugador jugador, Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus, Enemigo enemigo) {
		Decision ds = new Decision(true);
		String linea0 = "", civil = "", senshi = "";
		
		if (ds.Decision3(jugador)) {
			linea0 = "Recoges una piedra para arrojarla al enemigo, pero una rosa roja cruza el cielo y golpea a Nyx, provocando que libere a Sailor Moon. Te das cuenta de que acaba de aparecer un joven con esmoquin y máscara.";
		} else {
			linea0 = "Afortunadamente, una rosa roja cruza el cielo y golpea a Nyx, provocando que libere a Sailor Moon. Te das cuenta de que acaba de aparecer un joven con esmoquin y máscara.";
		}
		
		if (jugador.getGenero().equals("Male")) {
			civil = "playerm.png";
			senshi = "earthm.png";
		} else {
			civil = "playerf.png";
			senshi = "earthf.png";
		}
		
		String status = "Jugador: " + jugador.getNombre() + " | Karma: " + jugador.getKarma() + " | Afinidad: ☿" + mercury.getAfinidad() + " ♂" + mars.getAfinidad() + " ♃" + jupiter.getAfinidad() + " ♀" + venus.getAfinidad();
		
		String[][] matriz = {
				{"", linea0, "", "tmaskatk.jpg", status},
				{"Tuxedo Mask: ", "La gente duerme para tener buenos sueños, ¡pero tú los convertiste en pesadillas! ¡Sailor Moon, ahora!", "tmask.png", "eclipse.jpg", status},
				{"Sailor Moon: ", "No sé por qué hiciste esto, pero no puedo permitir que sigas lastimando a la gente.", "moonrp3.png", "eclipse.jpg", status},
				{"Sailor Moon: ", "Curación Lunar ¡Acción!", "", "mooncure.gif", status},
				{"Nyx: ", "Tonta", "darkmoon.png", "eclipse.jpg", status},
				{"", "Con un simple movimiento, Nyx desvía el golpe y este viene hacia ti.", "", "eclipse.jpg", status},
				{"Todos: ", "¡Eso no!", "", "eclipse.jpg", status},
				{"", "Sientes un aura fuerte que rodea tu cuerpo cuando te golpea. Derrepente, todo tu cuerpo brilla.", "", "eclipse.jpg", status},
				{"Luna: ", "Es como sospechaba. ¡Rápido, pídele a la Tierra que te despierte!", "lunarp1.png", "eclipse.jpg", status},
				{jugador.getNombre() + ": ", "Despiértame…?", civil, "eclipse.jpg", status},
				{"", "Las palabras te confunden. Recordando cómo se transformaron las otras, haces lo mismo.", "", "eclipse.jpg", status},
				{jugador.getNombre() + ": ", "¡Por ​​el poder del planeta Tierra, despiértame!", civil, "eclipse.jpg", status},
				{"", "Y pronto su ropa da paso a un traje de combate.", senshi, "eclipse.jpg", status},
				{"Todos: ", "¡No es posible!", "", "eclipse.jpg", status},
				{"Luna: ", "¡Es como imaginaba!", "luna.png", "eclipse.jpg", status},
				{"Artemis: ", "Entonces no es un mito...", "artemis.png", "eclipse.jpg", status},
				{"Nyx: ", "Así que ahí estás...", "darkmoon.png", "eclipse.jpg", status},
				{"Luna: ", "¡Necesitamos tu ayuda! Pero todavía no sabes luchar...", "luna.png", "eclipse.jpg", status},
				{"Luna: ", "Elige una Sailor Guerrera para enfrentar a Nyx contigo. Cada una tiene sus propios ataques. Elige la mejor opción para enfrentarte a cada enemigo.", "luna.png", "selectsailor.png", status},
				{"Luna: ", "Si su elección es satisfactoria, puedes atacar al enemigo. Esto lo debilita, haciendo más fácil derrotarlo o salvarlo.", "luna.png", "selectsailor.png", status},
				{"Luna: ", "Analiza al enemigo y el poder de cada Sailor Guerrera para tomar la mejor decisión.", "luna.png", "selectsailor.png", status}
		};
		/*
		for (int i = 0; i < matriz.length; i++) {
			String persona = matriz[i][0];
		    String linea = matriz[i][1];
		    String img = matriz[i][2];
		JOptionPane.showMessageDialog(null, persona + linea, status,  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Historia.class.getResource(img)));
		}
		*/
		
		return matriz;
	}
	
	//batalla
	
	public String[][] Escena4(Jugador jugador, Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus) {
		String status = "Jugador: " + jugador.getNombre() + " | Karma: " + jugador.getKarma() + " | Afinidad: ☿" + mercury.getAfinidad() + " ♂" + mars.getAfinidad() + " ♃" + jupiter.getAfinidad() + " ♀" + venus.getAfinidad();
		
		String[][] matriz = {
				{"Tuxedo Mask: ", "Es el fin.", "tmask.png", "eclipse.jpg", status},
				{"Nyx: ", "Tienes razón. Es el fin, pero no para mí.", "darkmoon.png", "eclipse.jpg", status},
				{"", "En ese momento, Sailor Moon se desmaya frente a todos, causando preocupación. Tuxedo Mask la toma en sus brazos y se da cuenta de que todavía está viva, pero su cuerpo está frío como la noche.", "", "smfaint.jpg", status},
			    {"Sailor Mars: ", "¿Por qué haces esto?", "marsrp6.png", "eclipse.jpg", status},
			    {"Nyx: ", "Eso es lo que se merecen por encerrarme en la oscuridad durante tanto tiempo.", "darkmoon.png", "eclipse.jpg", status},
			    {"Sailor Jupiter: ", "¡Eso no tiene sentido! Nunca nos habíamos conocido antes.", "juprp4.png", "eclipse.jpg", status},
			    {"Nyx: ", "Este mundo todavía está sucio. Pronto se pudrirá. Y perecerás junto con él.", "darkmoon.png", "eclipse.jpg", status},
			    {"", "Antes de que alguien pueda decir algo, la figura de Nyx se eleva hacia el cielo, desapareciendo de la misma manera que apareció. El eclipse se está terminando.", "", "eclipse.jpg", status},
			    {"Luna: ", "Chicos... Ha llegado el momento de que conozcan la historia de Dark Moon y Sailor Earth.", "luna.png", "eclipse.jpg", status}
			};
		/*
		for (int i = 0; i < matriz.length; i++) {
			String persona = matriz[i][0];
		    String linea = matriz[i][1];
		    String img = matriz[i][2];
		JOptionPane.showMessageDialog(null, persona + linea, status,  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Historia.class.getResource(img)));
		}
		*/
		
		return matriz;
	}
	
	
	public String[][] fin(Aliado moon, Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus) {
		int max = -100;
		String nomMax = "";
		/*
		if (max<=moon.getAfinidad()) {
			max = moon.getAfinidad();
			nomMax = moon.getNombre();
		}*/
		
		if (max<=mercury.getAfinidad()) {
			max = mercury.getAfinidad();
			nomMax = mercury.getNombre();
		}
		
		if (max<=mars.getAfinidad()) {
			max = mars.getAfinidad();
			nomMax = mars.getNombre();
		}
		
		if (max<=jupiter.getAfinidad()) {
			max = jupiter.getAfinidad();
			nomMax = jupiter.getNombre();
		}
		
		if (max<=venus.getAfinidad()) {
			max = venus.getAfinidad();
			nomMax = venus.getNombre();
		}
		
		String image = nomMax + ".png";
		
		
		String[][] matriz = {
			    {"", "¡Gracias por jugar la demostración del juego! Formaste un vínculo especial con " + nomMax + ". Espero que estés listo para aventurarte con ella en esta nueva aventura de Sailor Moon.", image, "smend.jpg", "Fin de la demo"},
			};
		/*
		for (int i = 0; i < matriz.length; i++) {
			String persona = matriz[i][0];
		    String linea = matriz[i][1];
		    String img = matriz[i][2];
		JOptionPane.showMessageDialog(null, persona + linea, "Fin de la Demo",  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Historia.class.getResource(img)));
		}
		 */

		return matriz;
	}

}