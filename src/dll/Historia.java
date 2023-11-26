package dll;

import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import bll.Validador;

public class Historia {
	
	private String titulo;

	public Historia(String titulo) {
		super();
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Historia [titulo=" + titulo + "]";
	}

	public void Prelude(Jugador jugador, Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus) {
		String status = "Jugador: " + jugador.getNombre() + " | Karma: " + jugador.getKarma() + " | Afinidad: ☿" + mercury.getAfinidad() + " ♂" + mars.getAfinidad() + " ♃" + jupiter.getAfinidad() + " ♀" + venus.getAfinidad();
		
		String[][] matriz = {
			    {"Ya es casi la hora. Tengo que irme...", ""},
			    {"", "acto0.jpg"},
			    {"Hoy es un día muy emocionante para todos:\nel rarísimo eclipse anular está a punto de ocurrir.\nAl igual que vos, muchos se están reuniendo\nen el Parque Yoyogi para presenciar el fenómeno.\nEn el camino, alguien acaba chocándote.", "yoyogi.jpg"}
			};

		for (int i = 0; i < matriz.length; i++) {
		    String linea = matriz[i][0];
		    String img = matriz[i][1];
		JOptionPane.showMessageDialog(null, linea, status,  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Historia.class.getResource(img)));
		}
	}
	
	//Decision1
	
	public void Intro1(Jugador jugador, Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus, Enemigo enemigo) {
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
			    {"Makoto: ", linea0, imgrespuesta, "yoyogi.jpg"},
			    {"Tutorial: ", "Acabas de tomar una decisión.\nVea los íconos en la parte superior de la pantalla.\nTe señalan si tus elecciones fueron buenas o no\ny cómo esto afecta tu nivel de afinidad con cada una\nde las chicas: Ami, Rei, Mako y Mina.\nTus decisiones cambian el curso de la historia.", "", "yoyogi.jpg"},
			    {"Minako: ", "Eso es lo que pasa cuando miras a los chicos.", "Mina.png", "yoyogi.jpg"},
			    {"Makoto: ", "Es qué me recuerda mucho el chico que me gustaba...", "Mako.png", "yoyogi.jpg"},
			    {"Minako: ", "Mako, siempre dices eso...\nAh, por cierto, ¿cómo te llamas?", "Mina.png", "yoyogi.jpg"}
			};

		for (int i = 0; i < matriz.length; i++) {
			String persona = matriz[i][0];
		    String linea = matriz[i][1];
		    String img = matriz[i][2];
		JOptionPane.showMessageDialog(null, persona + linea, status,  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Historia.class.getResource(img)));
		}
	}
	
	//valid.arNombre
	
	public void Intro2(Jugador jugador, Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus, Enemigo enemigo) {
		String status = "Jugador: " + jugador.getNombre() + " | Karma: " + jugador.getKarma() + " | Afinidad: ☿" + mercury.getAfinidad() + " ♂" + mars.getAfinidad() + " ♃" + jupiter.getAfinidad() + " ♀" + venus.getAfinidad();
		String linea1 = "";
		
		if (jupiter.getAfinidad()>3) {
			linea1 = "Puedes llamarme Mako.";
		} else {
			linea1 = "Bueno, tenemos que irnos ahora.";
		}
		
		String[][] matriz = {
			    {"Minako: ", "Mucho gusto, " + jugador.getNombre() + ".\nYo soy Minako, pero puedes llamarme Mina.\nEsta es Makoto.", "Mina.png", "yoyogi.jpg", status},
			    {"Makoto: ", linea1, "Mako.png", "yoyogi.jpg", status}
			};
		
		for (int i = 0; i < matriz.length; i++) {
			String persona = matriz[i][0];
		    String linea = matriz[i][1];
		    String img = matriz[i][2];
		JOptionPane.showMessageDialog(null, persona + linea, status,  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Historia.class.getResource(img)));
		}
	}
	
	//Decision2
	
	public void Escena1(Jugador jugador, Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus, Enemigo enemigo, String icoPlayer) {	
		Decision ds = new Decision(true);
		String linea12 = "";
		
		if (jugador.getGenero().equals("Male")) {
			linea12 = "¿Quien es este con ustedes?";
		} else {
			linea12 = "¿Quien es esta con ustedes?";
		}
		
		if (ds.Decision2(jugador, mercury, mars, jupiter, venus, enemigo)) {
			
			String status = "Jugador: " + jugador.getNombre() + " | Karma: " + jugador.getKarma() + " | Afinidad: ☿" + mercury.getAfinidad() + " ♂" + mars.getAfinidad() + " ♃" + jupiter.getAfinidad() + " ♀" + venus.getAfinidad();
			
			String[][] matriz = {
				    {"Mina: ", "¡Entonces vámonos!\nNuestros amigos ya nos están esperando.", "minagd.png", "yoyogi.jpg", status},
				    {"", "Sigues a Mina y Mako por el parque\nhasta que encuentras un grupo de personas\nhaciendo un picnic en el césped.\nVes a dos chicas peleando cuando llegas.", "", "picnic.jpg", status},
				    {"Rei: ", "Usagi!\nQuedamos en esperar a que lleguen todos para comer.", "Rei.png", "picnic.jpg", status},
				    {"Usagi: ", "¡¡Buuuwaa!!\n¡Rei, eres mala!\n¿¡No ves que me muero de hambre!?", "Usagi.png", "picnic.jpg", status},
				    {"Mamoru: ", "Usako, ten paciencia.", "mamoru.png", "picnic.jpg", status},
				    {"Usagi: ", "¿Tú también, mamo-chan?💔", "Usagi.png", "picnic.jpg", status},
				    {"Mako: ", "¡Ooooee!\n¡Estamos acá!", "Mako.png", "picnic.jpg", status},
				    {"Ami: ", "¡Por fin llegaron!", "Ami.png", "picnic.jpg", status},
				    {"Usagi: ", "Oh, ¿eso significa que ya podemos comer?", "Usagi.png", "picnic.jpg", status},
				    {"", "Rei mira a Usagi con cara de desaprobación.", "reirp1.png", "picnic.jpg", status},
				    {"Usagi: ", "Solo estaba bromeando.\n¡Ah, ja, ja! ¡Ah, ja, ja! ¡Ah, ja, ja!", "Usagi.png", "picnic.jpg", status},
				    {"Ami: ", linea12, "Ami.png", "picnic.jpg", status},
				    {"Mina: ", "Ah, es " + jugador.getNombre() + ". Acabamos de nos conocer.\n" + jugador.getNombre() + ", estas son Rei, Ami y Usagi.\nAh, y este es Mamoru, el novio de Usagi.", "Mina.png", "picnic.jpg", status},
				    {"Mako: ", "Usagi es la única de nosotros que tiene novio...", "Mako.png", "picnic.jpg", status},
				    {"Rei: ", "Sólo la cabeza hueca...", "Rei.png", "picnic.jpg", status},
				    {"Usagi: ", "Oye, ¿cómo me llamaste?", "Usagi.png", "picnic.jpg", status},
				    {"", "Te preguntas si siempre son así…", icoPlayer, "picnic.jpg", status},
				    {"Ami: ", "¡Chicas, miren!\n¡El evento está por comenzar!", "Ami.png", "picnic.jpg", status},
				    {"Usagi: ", "¡No he comido nada todavía!", "Usagi.png", "picnic.jpg", status}
				};
			
			for (int i = 0; i < matriz.length; i++) {
				String persona = matriz[i][0];
			    String linea = matriz[i][1];
			    String img = matriz[i][2];
			JOptionPane.showMessageDialog(null, persona + linea, status,  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Historia.class.getResource(img)));
			}

		} else {
			
			String status = "Jugador: " + jugador.getNombre() + " | Karma: " + jugador.getKarma() + " | Afinidad: ☿" + mercury.getAfinidad() + " ♂" + mars.getAfinidad() + " ♃" + jupiter.getAfinidad() + " ♀" + venus.getAfinidad();
			
			String[][] matriz = {
					{"Mina: ", "Oh, ya debes tener otros planes.\nTodo bien entonces. ¡Nos vemos por ahí!", "minabd.png", "yoyogi.jpg", status},
				    {"", "Desde lejos, ves a Mina y Mako unirse a un\ngrupo de personas que hacen un picnic en el\ncésped del parque. Parecen llevarse bien,\naunque dos de ellos estuvieron discutiendo\nantes. Sientes algo fuerte cuando los miras\ny te preguntas si tal vez no deberías haber\nido con ellos. No hay tiempo para arrepen-\ntimientos ahora, el espectáculo está por\ncomenzar.", "", "picnic.jpg", status}
				};
			
			for (int i = 0; i < matriz.length; i++) {
				String persona = matriz[i][0];
			    String linea = matriz[i][1];
			    String img = matriz[i][2];
			JOptionPane.showMessageDialog(null, persona + linea, status,  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Historia.class.getResource(img)));
			}
			
		}
		
	}
	
	public void Escena2(Jugador jugador, Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus, Enemigo enemigo) {	
		String status = "Jugador: " + jugador.getNombre() + " | Karma: " + jugador.getKarma() + " | Afinidad: ☿" + mercury.getAfinidad() + " ♂" + mars.getAfinidad() + " ♃" + jupiter.getAfinidad() + " ♀" + venus.getAfinidad();
		String linea11 = "";
		
		if (jugador.getGenero().equals("Male")) {
			linea11 = "¿No es extraño que el no se desmayara como los demás?";
		} else {
			linea11 = "¿No es extraño que ella no se desmayara como los demás?";
		}
		
		String[][] matriz = {
				{"", "El día comienza a convertirse en noche\nmientras observas la luna ponerse frente a\nsol.\nPoco a poco, el sol se va convirtiendo en\nun anillo de fuego.\nSe escucha a la gente exclamando\nsorprendida, pero pronto las exclamaciones\nse convierten en bostezo.\nNotas que la gente a tu alrededor se\ndesmaya.", "", "eclipse.jpg", status},
			    {"Mamoru: ", "Algo anda mal.", "mamoru.png", "eclipse.jpg", status},
			    {"Rei: ", "¿Qué les está pasando a estas personas?", "Rei.png", "eclipse.jpg", status},
			    {"Mina: ", "Todos se durmieron de repente.", "Mina.png", "eclipse.jpg", status},
			    {"Ami: ", "¡Hay alguien ahí!", "Ami.png", "eclipse.jpg", status},
			    {"", "Miras hacia dónde Ami señaló.\nComo si viniera de la luna, la silueta de alguien aparece flotando allí.", "", "eclipse.jpg", status},
			    {"Rei: ", "¿Será un nuevo enemigo?", "Rei.png", "eclipse.jpg", status},
			    {"Usagi: ", "Chicas, transfórmense.", "Usagi.png", "eclipse.jpg", status},
			    {"Mako: ", "Pero Usagi...", "Mako.png", "eclipse.jpg", status},
			    {"", "Las chicas te miran.\nTodos sucumbieron al sueño, excepto vos y este grupo de personas\nque ahora te miran fijamente sin saber qué hacer.", "", status},
			    {"Ami: ", linea11, "Ami.png", "eclipse.jpg", status},
			    {"???: ", "¡Chicas! ¡No tenemos tiempo que perder!", "", "eclipse.jpg", status},
			    {"Mina: ", "¿¡Artemis!?", "Mina.png", "eclipse.jpg", status},
			    {"", "Notas que un gato blanco acaba de llegar,\njunto con otro gato de pelaje oscuro que\ncomienza a hablar.", "", "eclipse.jpg", status},
			    {"Luna: ", "No se preocupen por eso.\nTengo una suposición...\n\n¡Transformense ahora mismo!", "luna.png", "eclipse.jpg", status},
			    {"", "Las chicas asienten con la cabeza hacia los\ngatos. Sus cuerpos son envueltos por una\nluz que las transforma en guerreras cuando\ngritan por sus planetas protectores. Aunque\nte sorprenda, sientes algo extrañamente\nfamiliar en todo esto.", "", "allmakeup.jpg", status},
			    {"Sailor Moon: ", "¡Detente ahí!\n¿Cómo te atreves a interrumpir un momento\ntan sublime para la gente que vino a este\nparque a relajarse?\n¡Y hasta arruinaste mi comida!", "moonrp2.png", "eclipse.jpg", status},
			    {"Sailor Moon: ", "Soy Sailor Moon, la hermosa guerrera\ndisfrazada de marinera que lucha por el\namor y la justicia.\n¡Te castigaré en nombre de la luna!", "moonrp4.png", "eclipse.jpg", status},
			    {"???: ", "¿Castigarme? Que curioso…\nporque vine aquí precisamente para castigarte…\na ti.", "darkmoon.png", "eclipse.jpg", status},
			    {"Sailor Mercury: ", "¡Ella está emitiendo ondas de sueño!", "mercrp12.png", "eclipse.jpg", status},
			    {"Sailor Jupiter: ", "¿Quién sos para castigarnos?", "juprp5.png", "eclipse.jpg", status},
			    {"???: ", "¿¡No saben quién soy!?", "darkmoon.png", "eclipse.jpg", status},
			    {"", "La figura se acerca, aún flotando en el\naire. Puedes verlo mejor ahora. Su traje es\ngrotesco y se te pone la piel de gallina al\nmirarla.", "dmoonfight.png", "eclipse.jpg", status},
			    {"Nyx: ", "Soy la emperatriz de la luna oscura, Nyx.", "darkmoon.png", "eclipse.jpg", status},
			    {"", "Todos están asustado por la presentación.", "", "eclipse.jpg", status},
			    {"Sailor Venus: ", "¡Eso no es verdad!\nLa luna solo tiene una gobernante.", "venusrp1.png", "eclipse.jpg", status},
			    {"Artemis: ", "Hace mucho tiempo hubo rumores de una\nemperatriz antes de la Queen Serenity.", "artrp1.png", "eclipse.jpg", status},
			    {"Luna: ", "Tanto tiempo que nadie lo recuerda.", "lunarp1.png", "eclipse.jpg", status},
			    {"Sailor Moon: ", "¿Pero por qué lastimas a la gente?", "moonrp11.png", "eclipse.jpg", status},
			    {"Nyx: ", "¡Porque te desprecio!", "darkmoon.png", "eclipse.jpg", status},
			    {"", "En un movimiento rápido, Nyx se acerca y\ncomienza a estrangular a Sailor Moon. Todos\nexclaman asustados. Tienes ganas de ayudar-\nla, pero no sabes cómo.", "", "eclipse.jpg", status},
			    {"Luna: ", "Esta aura…", "luna.png", "eclipse.jpg", status},
			    {"", "Luna no deja de mirarte, incluso cuando\ntodos están preocupados por Sailor Moon.", "luna.png", "eclipse.jpg", status}
			};

		for (int i = 0; i < matriz.length; i++) {
			String persona = matriz[i][0];
		    String linea = matriz[i][1];
		    String img = matriz[i][2];
		JOptionPane.showMessageDialog(null, persona + linea, status,  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Historia.class.getResource(img)));
		}
	
	}
	
	//Decision3
	
	public void Escena3(Jugador jugador, Aliado moon, Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus, Personaje personaje, Enemigo enemigo, String icoPlayer, String icoSenshi) {
		Decision ds = new Decision(true);
		String linea0 = "";
		
		if (ds.Decision3(jugador)) {
			linea0 = "Recoges una piedra para arrojarla al\nenemigo, pero una rosa roja cruza el cielo\ny golpea a Nyx, provocando que libere a\nSailor Moon. Te das cuenta de que acaba de\naparecer un joven con esmoquin y máscara.";
		} else {
			linea0 = "Afortunadamente, una rosa roja cruza el\ncielo y golpea a Nyx, provocando que libere\na Sailor Moon. Te das cuenta de que acaba\nde aparecer un joven con esmoquin y\nmáscara.";
		}
		
		String status = "Jugador: " + jugador.getNombre() + " | Karma: " + jugador.getKarma() + " | Afinidad: ☿" + mercury.getAfinidad() + " ♂" + mars.getAfinidad() + " ♃" + jupiter.getAfinidad() + " ♀" + venus.getAfinidad();
		
		String[][] matriz = {
				{"", linea0, "", "tmaskatk.jpg", status},
				{"Tuxedo Mask: ", "La gente duerme para tener buenos sueños,\n¡pero tú los convertiste en pesadillas!\n¡Sailor Moon, ahora!", "tmask.png", "eclipse.jpg", status},
				{"Sailor Moon: ", "No sé por qué hiciste esto, pero no puedo\npermitir que sigas lastimando a la gente.", "moonrp3.png", "eclipse.jpg", status},
				{"Sailor Moon: ", "Curación Lunar ¡Acción!", "", "mooncure.gif", status},
				{"Nyx: ", "Tonta", "darkmoon.png", "eclipse.jpg", status},
				{"", "Con un simple movimiento, Nyx desvía el\ngolpe y este viene hacia ti.", "", "eclipse.jpg", status},
				{"Todos: ", "¡Eso no!", "", "eclipse.jpg", status},
				{"", "Sientes un aura fuerte que rodea tu cuerpo\ncuando te golpea. Derrepente, todo tu\ncuerpo brilla.", "", "eclipse.jpg", status},
				{"Luna: ", "Es como sospechaba.\n¡Rápido, pídele a la Tierra que te despierte!", "lunarp1.png", "eclipse.jpg", status},
				{jugador.getNombre() + ": ", "Despiértame…?", icoPlayer, "eclipse.jpg", status},
				{"", "Las palabras te confunden. Recordando cómo\nse transformaron las otras, haces lo mismo.", "", "eclipse.jpg", status},
				{jugador.getNombre() + ": ", "¡Por ​​el poder del planeta Tierra,\ndespiértame!", icoPlayer, "eclipse.jpg", status},
				{"", "Y pronto su ropa da paso a un traje de\ncombate.", icoSenshi, "eclipse.jpg", status},
				{"Todos: ", "¡No es posible!", "", "eclipse.jpg", status},
				{"Luna: ", "¡Es como imaginaba!", "luna.png", "eclipse.jpg", status},
				{"Artemis: ", "Entonces no es un mito...", "artemis.png", "eclipse.jpg", status},
				{"Nyx: ", "Así que ahí estás...", "darkmoon.png", "eclipse.jpg", status},
				{"Luna: ", "¡Necesitamos tu ayuda! Pero todavía no\nsabes luchar...", "luna.png", "eclipse.jpg", status},
				{"Luna: ", "Elige una Sailor Guerrera para enfrentar\na Nyx contigo. Cada una tiene sus propios\nataques. Elige la mejor opción para\nenfrentarte a cada enemigo.", "luna.png", "selectsailor.png", status},
				{"Luna: ", "Si su elección es satisfactoria, puedes\natacar al enemigo. Esto lo debilita,\nhaciendo más fácil derrotarlo o salvarlo.", "luna.png", "selectsailor.png", status},
				{"Luna: ", "Analiza al enemigo y el poder de cada\nSailor Guerrera para tomar la mejor\ndecisión.", "luna.png", "selectsailor.png", status}
		};
		
		for (int i = 0; i < matriz.length; i++) {
			String persona = matriz[i][0];
		    String linea = matriz[i][1];
		    String img = matriz[i][2];
		JOptionPane.showMessageDialog(null, persona + linea, status,  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Historia.class.getResource(img)));
		}
		
	}
	
	//batalla
	
	public void Escena4(Jugador jugador, Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus) {
		String status = "Jugador: " + jugador.getNombre() + " | Karma: " + jugador.getKarma() + " | Afinidad: ☿" + mercury.getAfinidad() + " ♂" + mars.getAfinidad() + " ♃" + jupiter.getAfinidad() + " ♀" + venus.getAfinidad();
		
		String[][] matriz = {
				{"Tuxedo Mask: ", "Es el fin.", "tmask.png", "eclipse.jpg", status},
				{"Nyx: ", "Tienes razón. Es el fin, pero no para mí.", "darkmoon.png", "eclipse.jpg", status},
				{"", "En ese momento, Sailor Moon se desmaya\nfrente a todos, causando preocupación.\nTuxedo Mask la toma en sus brazos y se da\ncuenta de que todavía está viva, pero su\ncuerpo está frío como la noche.", "", "smfaint.jpg", status},
			    {"Sailor Mars: ", "¿Por qué haces esto?", "marsrp6.png", "eclipse.jpg", status},
			    {"Nyx: ", "Eso es lo que se merecen por encerrarme\nen la oscuridad durante tanto tiempo.", "darkmoon.png", "eclipse.jpg", status},
			    {"Sailor Jupiter: ", "¡Eso no tiene sentido!\\nNunca nos habíamos conocido antes.", "juprp4.png", "eclipse.jpg", status},
			    {"Nyx: ", "Este mundo todavía está sucio.\nPronto se pudrirá.\nY perecerás junto con él.", "darkmoon.png", "eclipse.jpg", status},
			    {"", "Antes de que alguien pueda decir algo, la\nfigura de Nyx se eleva hacia el cielo,\ndesapareciendo de la misma manera que\napareció. El eclipse se está terminando.", "", "eclipse.jpg", status},
			    {"Luna: ", "Chicos...\nHa llegado el momento de que conozcan la\nhistoria de Dark Moon y Sailor Earth.", "luna.png", "eclipse.jpg", status}
			};
		
		for (int i = 0; i < matriz.length; i++) {
			String persona = matriz[i][0];
		    String linea = matriz[i][1];
		    String img = matriz[i][2];
		JOptionPane.showMessageDialog(null, persona + linea, status,  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Historia.class.getResource(img)));
		}
		
	}
	
	
	public void fin(Aliado moon, Aliado mercury, Aliado mars, Aliado jupiter, Aliado venus) {
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
		
		//controlar os empates
		
		String image = nomMax + ".png";
		
		
		String[][] matriz = {
			    {"", "¡Gracias por jugar la demostración del\njuego! Formaste un vínculo especial con\n" + nomMax + ". Espero que estés listo para\naventurarte con ella en esta nueva aventura\nde Sailor Moon.", image, "smend.jpg"},
			};
		
		for (int i = 0; i < matriz.length; i++) {
			String persona = matriz[i][0];
		    String linea = matriz[i][1];
		    String img = matriz[i][2];
		JOptionPane.showMessageDialog(null, persona + linea, "Fin de la Demo",  JOptionPane.PLAIN_MESSAGE, new ImageIcon(Historia.class.getResource(img)));
		}

		//"Sailor Moon: Battle for Earth\n¡Próximamente!"
	}

	/*
	 * String[][] matriz = {
			    {"Minako: ", "Mucho gusto, " + jugador.getNombre() + ".\nYo soy Minako, pero puedes llamarme Mina.\nEsta es Makoto.", "Mina.png", "yoyogi.jpg", status},
			    {"Makoto: ", linea1, "Mako.png", "yoyogi.jpg", status}
			};
	 */

}