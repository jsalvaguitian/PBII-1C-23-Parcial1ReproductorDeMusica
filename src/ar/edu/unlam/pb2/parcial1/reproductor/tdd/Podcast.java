package ar.edu.unlam.pb2.parcial1.reproductor.tdd;

import java.util.HashSet;

public class Podcast extends ListaDeReproduccion{
	//private static Integer id; //veremos si nos servira luego...
	private String autor;
	private String descripcion;
	private HashSet<Episodio>episodios;
	

	public Podcast(String nombre, String autor, String descripcion) {
		super(nombre);
		this.autor = autor;
		this.descripcion = descripcion;
		this.episodios = new HashSet<Episodio>();
	}


	public String getAutor() {
		return autor;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public HashSet<Episodio> getEpisodios() {
		return episodios;
	}


	public boolean agregarEpisodio(Episodio episodio) {
		return this.episodios.add(episodio);
	}


	public Integer obtenerCantidadEpisodios() {
		return this.episodios.size();
	}
	
	
	
	
	

}
