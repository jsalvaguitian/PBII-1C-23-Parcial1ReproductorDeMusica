package ar.edu.unlam.pb2.parcial1.reproductor.tdd;

public class Cancion extends Audio {
	private Genero genero;
	private String letra;
	private Boolean estaSonando;
	private Boolean esFavorito;
	private Integer contadorDeReproduccion;

	public Cancion(String nombre, String artista, String duracion, Genero genero, String letra) {
		super(nombre, artista, duracion);
		this.genero = genero;
		this.letra = letra;
		this.estaSonando = false;
		this.esFavorito = false;
		this.contadorDeReproduccion = 0;
	}

	public Genero getGenero() {
		return genero;
	}

	public String getLetra() {
		return letra;
	}

	public Boolean getEsFavorito() {
		return esFavorito;
	}

	public void setEsFavorito(Boolean esFavorito) {
		this.esFavorito = esFavorito;
	}

	public Boolean getEstaSonando() {
		return estaSonando;
	}

	public void setEstaSonando(Boolean estaSonando) {
		this.estaSonando = estaSonando;
		this.contadorDeReproduccion++;
	}

	
	/*public void setContadorDeReproduccion(Integer contadorDeReproduccion) {
		this.contadorDeReproduccion = contadorDeReproduccion;
	}*/

	public Integer getContadorDeReproduccion() {
		return contadorDeReproduccion;
	}

	@Override
	public String toString() {
		return "Cancion: "+ nombre
				+ "\nArtista: "+ artista
				+ "\nDuracion: "+duracion
				+"\nLetra: " + letra
				+"\n------------------------------------------------------";
	}

	
	

	
	

}
