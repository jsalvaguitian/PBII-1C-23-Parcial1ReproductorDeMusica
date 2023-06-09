package ar.edu.unlam.pb2.parcial1.reproductor.tdd;

import java.util.LinkedHashSet;

public class Podcast extends ListaDeReproduccion{
	//private static Integer id; //veremos si nos servira luego...
	private Categoria categoria;
	private String autor;
	private String descripcion;
	private LinkedHashSet<Episodio>episodios;
	

	public Podcast(String nombre, String autor, String descripcion, Categoria categoria) {
		super(nombre);
		this.autor = autor;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.episodios = new LinkedHashSet<Episodio>();
	}


	public String getAutor() {
		return autor;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public LinkedHashSet<Episodio> getEpisodios() {
		return episodios;
	}


	
	public Categoria getCategoria() {
		return categoria;
	}
	

	public Boolean agregarEpisodio(Episodio episodio) {
		if(!this.episodios.contains(episodio)) {
			return this.episodios.add(episodio);
		}
		return false;
	}


	public Integer obtenerCantidadEpisodios() {
		return this.episodios.size();
	}
	
	public Boolean borrarEpisodio(Episodio episodio) {
		
		if(!this.episodios.isEmpty() && this.episodios.contains(episodio)) {
			return this.episodios.remove(episodio);
		}
		return false;
	}	
	
	

}
