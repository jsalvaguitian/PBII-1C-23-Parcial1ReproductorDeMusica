package ar.edu.unlam.pb2.parcial1.reproductor.tdd;

public class Cancion extends Audio {
	private Genero genero;
	private String letra;

	public Cancion(String nombre, String artista, String duracion, Genero genero, String letra) {
		super(nombre, artista, duracion);
		this.genero = genero;
		this.letra = letra;
	}

	

}
