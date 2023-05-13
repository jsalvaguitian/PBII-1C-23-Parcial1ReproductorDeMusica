package ar.edu.unlam.pb2.parcial1.reproductor.tdd;

public class Episodio extends Audio {
	private String descripcion;

	public Episodio(String nombre, String artista, String duracion, String descripcion) {
		super(nombre, artista, duracion);
		this.descripcion = descripcion;
	}

}
