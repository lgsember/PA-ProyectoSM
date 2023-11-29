package dll;

import javax.swing.JOptionPane;

public class Jugador {
	
	private int id;
	private String nombre;
	private String genero;
	private String image;
	private int karma;
	private int progreso;

	public Jugador(int id, String nombre, String genero, String image, int karma, int progreso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.image = image;
		this.karma = karma;
		this.progreso = progreso;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getKarma() {
		return karma;
	}

	public void setKarma(int karma) {
		this.karma = karma;
	}

	public int getProgreso() {
		return progreso;
	}

	public void setProgreso(int progreso) {
		this.progreso = progreso;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombre + ", genero=" + genero + ", karma=" + karma + ", progreso="
				+ progreso + "]";
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
			 this.setImage("playerm.png");
			 return "Male";
		} else if (opGender==1) {
			this.setImage("playerf.png");
			return "Female";
		} else {
			int decidir = (int) (Math.random() * 2);
			if (decidir==0) {
				this.setImage("playerm.png");
				return "Male";
			} else {
				this.setImage("playerf.png");
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
