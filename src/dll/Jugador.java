package dll;

import javax.swing.JOptionPane;

public class Jugador {
	
	private int id;
	private String nombre;
	private String genero;
	private int karma;

	public Jugador(int id, String nombre, String genero) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.karma = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getKarma() {
		return karma;
	}

	public void setKarma(int karma) {
		this.karma = karma;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", genero=" + genero + ", karma=" + karma + "]";
	}

	public String definirGenero() {
		String[] genero = {"Chico", "Chica", "Lo que sea"};
		
		 int opGender = JOptionPane.showOptionDialog(
		            null,
		            "¿Quieres jugar como chico o chica?",
		            "Eligir genero",
		            JOptionPane.DEFAULT_OPTION,
		            JOptionPane.PLAIN_MESSAGE,
		            null,
		            genero,
		            genero[0]
		        );
		
		 if (opGender==0) {
			 return "Male";
		} else if (opGender==1) {
			return "Female";
		} else {
			int decidir = (int) (Math.random() * 2);
			if (decidir==0) {
				return "Male";
			} else {
				return "Female";
			}
		}
		
	}
	
	public void calcularKarma(boolean buenaDecision, int valor) {

		if (buenaDecision==true) {
			this.setKarma(this.getKarma()+valor);
		} else {
			this.setKarma(this.getKarma()-valor);
		}
		
	}

}
