package ar.edu.unlam.pb2.parcial1.reproductor.tdd;

public class UsuarioPremium extends Usuario {

	private final String NOMBRE_PLAYLIST_DE_FAVORITOS;
	
	public UsuarioPremium(String username, String mail, String password, Integer dia, Integer mes, Integer anio) {
		super(username, mail, password, dia, mes, anio);
		this.NOMBRE_PLAYLIST_DE_FAVORITOS = "Tus me gustas";
		this.biblioteca.add(new ListaDeReproduccion(NOMBRE_PLAYLIST_DE_FAVORITOS));
	}

	@Override
	protected Boolean crearNuevaPlayList(String nombrePlayList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Integer obtenerLaCantidadDePlayList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean seleccionarCancionComoFavorita(Cancion cancionBuscada) {
		if(this.inicioSesion && cancionBuscada!=null) {
			cancionBuscada.setEsFavorito(true);
			return this.agregarCancionALaPLayList(this.NOMBRE_PLAYLIST_DE_FAVORITOS, cancionBuscada);
		}
		
		return false;
	}

	public void deseleccionarCancionComoFavorita(Cancion cancionBuscada) {
		if(this.inicioSesion && cancionBuscada!=null) {
			cancionBuscada.setEsFavorito(false);
			this.eliminarCancionDeLaPLayList(this.NOMBRE_PLAYLIST_DE_FAVORITOS, cancionBuscada);

		}
		
	}

	@Override
	protected boolean agregarPodcast(Podcast unpod) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean agregarDailymix(ListaDeReproduccion dailymix) {
		// TODO Auto-generated method stub
		return false;
	}


}
