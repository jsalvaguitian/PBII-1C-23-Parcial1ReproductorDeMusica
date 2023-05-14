package ar.edu.unlam.pb2.parcial1.reproductor.tdd;

public abstract class Audio {
	protected String nombre;
	protected String artista;
	protected String duracion;
	protected Volumen volumenAudio;
	
	public Audio(String nombre, String artista, String duracion) {
		this.nombre = nombre;
		this.artista = artista;
		this.duracion = duracion;
		this.volumenAudio=2;
	}

# por defecto, al comienzo el volumen está en 2, luego se puede modificar

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Audio other = (Audio) obj;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public String getNombre() {
		return nombre;
	}

	public String getArtista() {
		return artista;
	}

	public String getDuracion() {
		return duracion;
	}
	
# la sobreescritura de hashcode y de equals, nos permitira establecer el criterio por el cual 2 objetos de audio son iguales

}
