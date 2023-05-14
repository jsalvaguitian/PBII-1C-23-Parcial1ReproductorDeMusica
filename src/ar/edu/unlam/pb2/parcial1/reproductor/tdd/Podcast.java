package ar.edu.unlam.pb2.parcial1.reproductor.tdd;

import java.util.LinkedHashSet;

public class Podcast extends ListaDeReproduccion{
	//private static Integer id; //veremos si nos servira luego...
	private Categoria categoria;
	private String autor;
	private String descripcion;
	private Formato formato;
	private LinkedHashSet<Episodio>episodios;
	

	public Podcast(String nombre, String autor, String descripcion, Categoria categoria) {
		super(nombre);
		this.autor = autor;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.formato = formato;
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

	public Formato getFormato() {
		return formato;
	}

	public boolean agregarEpisodio(Episodio episodio) {
		return this.episodios.add(episodio);
	}


	public Integer obtenerCantidadEpisodios() {
		return this.episodios.size();
	}
	
	public boolean borrarEpisodio(Episodio episodio) {
		if(!this.episodios.isEmpty()) {
			return this.episodios.remove(episodio);
		}
		return false;
	}	
	
	

}
