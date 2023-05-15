package ar.edu.unlam.pb2.parcial1.reproductor.tdd;


public class UsuarioBasico extends Usuario {

	private final Integer CANTIDAD_MAX_PLAYLIST;
	private final Integer CANTIDAD_MAX_PODCAST;
	private final Integer CANTIDAD_MAX_DAILYMIX;


	public UsuarioBasico(String username, String mail, String password, Integer dia, Integer mes, Integer anio) {
		super(username, mail, password, dia, mes, anio);
		this.CANTIDAD_MAX_PODCAST = 1;
		this.CANTIDAD_MAX_PLAYLIST = 2;
		this.CANTIDAD_MAX_DAILYMIX = 1;
	}

	@Override
	protected Boolean crearNuevaPlayList(String nombrePlayList) {
		Integer contadorPlaylist = 0;
	
		Boolean exitoso = false;

		if (this.inicioSesion) {
			if (biblioteca.size() == 0) {
				exitoso = this.biblioteca.add(new ListaDeReproduccion(nombrePlayList));
				return exitoso;
			} else {
				contadorPlaylist = this.obtenerLaCantidadDePlayList();

				if (contadorPlaylist < this.CANTIDAD_MAX_PLAYLIST) {
					exitoso = this.biblioteca.add(new ListaDeReproduccion(nombrePlayList));
					return exitoso;
				}

				return exitoso;
			}
		}
		return exitoso;

	}


	@Override
	protected boolean seleccionarCancionComoFavorita(Cancion cancionBuscada) {
		//No hara nada porque no tiene lista canciones favoritas
		return false;
	}


	@Override
	protected void deseleccionarCancionComoFavorita(Cancion cancionBuscada) {
		//No hara nada porque no tiene lista canciones favoritas

	}

	@Override
	protected boolean agregarPodcast(Podcast unpod) {
		int contadorPodcast =0;
		
		if(this.inicioSesion) {
			if(this.biblioteca.isEmpty()) {
				return this.biblioteca.add(unpod);
				
			}else {
				for(ListaDeReproduccion lista : this.biblioteca) {
					if(lista.getClass().getSimpleName().equals("Podcast")) {
						contadorPodcast++;
					}		
				}
				if(contadorPodcast<this.CANTIDAD_MAX_PODCAST) {
					return this.biblioteca.add(unpod);
				}
			}
		}		
		return false;
	}
	
	@Override
	protected boolean agregarDailymix(ListaDeReproduccion dailymix) {
		int contador = 0;
		if(inicioSesion) {
			if(this.biblioteca.isEmpty())
				return this.biblioteca.add(dailymix);
			else {
				for(ListaDeReproduccion lista: this.biblioteca) {
					if(lista.getNombre().contains("dailyMix"))
						contador++;
				}
				if(contador<this.CANTIDAD_MAX_DAILYMIX)
					return this.biblioteca.add(dailymix);
			}			
		}
		return false;
	}
	
	@Override
	protected Integer obtenerLaCantidadDePlayList() {
		Integer contador = 0;

		if(this.inicioSesion) {
			for (ListaDeReproduccion uno : biblioteca) {
				if (uno instanceof ListaDeReproduccion)
					contador++;
			}
			return contador;
		}
		return contador;
	}


}
