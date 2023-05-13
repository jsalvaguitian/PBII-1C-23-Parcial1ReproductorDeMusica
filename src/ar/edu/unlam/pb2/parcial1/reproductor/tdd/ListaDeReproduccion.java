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
	
	

}
