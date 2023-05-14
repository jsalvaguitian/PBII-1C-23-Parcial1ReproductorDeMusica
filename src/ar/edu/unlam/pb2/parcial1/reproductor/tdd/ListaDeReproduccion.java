package ar.edu.unlam.pb2.parcial1.reproductor.tdd;

import java.util.ArrayList;

public class ListaDeReproduccion {
	private String nombre;
	private ArrayList<Audio>audios;
	private Boolean estaReproduciendose;

	public ListaDeReproduccion(String nombre) {
		this.nombre = nombre;
		this.audios = new ArrayList<Audio>();
		this.estaReproduciendose = false;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Audio> getAudios() {
		return audios;
	}

	public Boolean getEstaReproduciendose() {
		return estaReproduciendose;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setAudios(ArrayList<Audio> audios) {
		this.audios = audios;
	}

	public void setEstaReproduciendose(Boolean estaReproduciendose) {
		this.estaReproduciendose = estaReproduciendose;
	}

	public Boolean agregarCancion(Cancion cancionSeleccionada, String nombreDeLaClase) {
		Boolean fueExitoso = false;
		if(nombreDeLaClase.equals("UsuarioBasico")) {
			if(this.audios.size()<9)
				fueExitoso = this.audios.add(cancionSeleccionada);
		}
		if(nombreDeLaClase.equals("UsuarioPremium")) {
			fueExitoso = this.audios.add(cancionSeleccionada);

		}
		return fueExitoso;
	}

	public boolean eliminarCancion(Cancion cancion) {
		return this.audios.remove(cancion);
	}

	public Integer obtenerLaCantidadDeAudios() {
		return this.audios.size();
	}

	@Override
	public String toString() {
		return "ListaDeReproduccion [nombre=" + nombre + ", audios=" + audios.toString() + "]";
	}
	
	
	

}
