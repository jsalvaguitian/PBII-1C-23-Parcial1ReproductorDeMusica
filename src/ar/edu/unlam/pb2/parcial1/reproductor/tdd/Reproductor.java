package ar.edu.unlam.pb2.parcial1.reproductor.tdd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;

public class Reproductor {
	private String nombre;
	private ArrayList<Usuario> usuarios;
	private LinkedHashSet<Cancion> baseDeDatosCanciones;
	private LinkedHashSet<Podcast> baseDeDatosPodcast;

	public Reproductor(String nombre) {
		this.nombre = nombre;
		this.usuarios = new ArrayList<Usuario>();
		this.baseDeDatosCanciones = new LinkedHashSet<Cancion>();
		this.baseDeDatosPodcast = new LinkedHashSet<Podcast>();
	}

	// ---------------------------------------------------------------------------------
	public Boolean registrarUsuario(Usuario user) {
		Boolean exitoso = false;

		if (user.esValidoUsuario()) {
			if (this.usuarios.size() == 0) {
				this.usuarios.add(user);
				exitoso = true;
			} else {
				for (int i = 0; i < this.usuarios.size(); i++) {
					if (!this.encontrarUsuarioPorUserName(user.getUsername())
							&& !this.encontrarUsuarioPorMail(user.getMail())) {
						this.usuarios.add(user);
						exitoso = true;
					}
				}
			}
		}
		return exitoso;

	}

	// ---------------------------------------------------------------------------------
	private boolean encontrarUsuarioPorMail(String mail) {
		for (int i = 0; i < this.usuarios.size(); i++) {
			if (this.usuarios.get(i) != null && usuarios.get(i).getMail().equals(mail))
				return true;
		}
		return false;
	}

	// ---------------------------------------------------------------------------------
	private boolean encontrarUsuarioPorUserName(String username) {
		for (int i = 0; i < this.usuarios.size(); i++) {
			if (this.usuarios.get(i) != null && this.usuarios.get(i).getUsername().equals(username))
				return true;
		}
		return false;
	}

	// ---------------------------------------------------------------------------------
	public Integer obtenerCantidadUsuarios() {
		return this.usuarios.size();
	}

	// ---------------------------------------------------------------------------------
	public Usuario buscarUsuarioRegistrado(String mailOUsername, String password) {
		for (Usuario uno : usuarios) {
			if (uno.getMail().equals(mailOUsername)
					|| uno.getUsername().equals(mailOUsername) && uno.getPassword().equals(password)) {
				return uno;
			}
		}
		return null;
	}

	// ---------------------------------------------------------------------------------
	public Integer iniciarSesion(String mailOUsername, String password) {
		Usuario userIn = this.buscarUsuarioRegistrado(mailOUsername, password);
		Integer idUser = null;
		if (userIn != null) {
			userIn.setInicioSesion(true);
			idUser = userIn.getId();
			return idUser;

		}

		return idUser;
	}

	// ---------------------------------------------------------------------------------
	public boolean agregarCancionALaBD(Cancion cancion) {
		return this.baseDeDatosCanciones.add(cancion);
	}

	// ---------------------------------------------------------------------------------

	public Integer getCantidadCancionesEnLaBD() {
		return this.baseDeDatosCanciones.size();
	}

	// ---------------------------------------------------------------------------------
	public Boolean agregarPodcast(Podcast unPodcast) {
		return this.baseDeDatosPodcast.add(unPodcast);
	}

	// ---------------------------------------------------------------------------------
	public boolean guardarEpisodio(Podcast unPodcast, Episodio episodio) {

		if (this.baseDeDatosPodcast.contains(unPodcast))
			return unPodcast.agregarEpisodio(episodio);

		return false;
	}

	// ---------------------------------------------------------------------------------
	public Integer getCantidadDeEpisodiosDelPodcastPorNombre(String nombreDelPodcast) {
		Podcast encontrado = buscarPodcastPorNombre(nombreDelPodcast);
		if (encontrado != null) {
			return encontrado.obtenerCantidadEpisodios();
		}
		return null;
	}

	// ---------------------------------------------------------------------------------
	public Podcast buscarPodcastPorNombre(String nombreDelPodcast) {
		for (Podcast uno : this.baseDeDatosPodcast) {
			if (uno.getNombre().equals(nombreDelPodcast)) {
				return uno;
			}
		}
		return null;
	}

	// ---------------------------------------------------------------------------------	
	public LinkedHashSet<Podcast> buscarListaDePodcastPorCategoria(Categoria categoria) {
		LinkedHashSet<Podcast> listaPodcastDeUnaCategoria = new LinkedHashSet<Podcast>();
		for (Podcast actual : this.baseDeDatosPodcast) {
			if (actual.getCategoria().equals(categoria)) {
				listaPodcastDeUnaCategoria.add(actual);
			}
			return listaPodcastDeUnaCategoria;
		}
		return null;
	}

	// Esto es una prueba
	/*
	 * Recordatorio: Los elementos de hashset se ordenan en función de su hashcode,
	 * x_x no en función del orden que inserción como las arrayList, cambiar el
	 * diseño a usar LinkedHashSet
	 */
	// ---------------------------------------------------------------------------------
	public void inicializarBaseDeDatosconCanciones() {

		this.baseDeDatosCanciones.add(new Cancion("The show must go on", "Queen", "3:30", Genero.ROCK,
				"Empty spaces, what are we living for?\n" + "Abandoned places, I guess we know the score, on and on"));

		this.baseDeDatosCanciones.add(new Cancion("Esta vida", "Marshmello y Farruko", "3:03", Genero.DANCE_ELECTRONICA,
				"No se puede complacer\n" + "A to' el mundo\n" + "A to' el mundo\n" + "Decidí vivir\n"
						+ "Sin importar qué digan, soy feliz\n"));

		this.baseDeDatosCanciones.add(new Cancion("Piel morena", "Thalia", "2:29", Genero.LATINO,
				"Eres piel morena\n" + "Canto de pasión y arena\n" + "Eres piel morena"));

		this.baseDeDatosCanciones
				.add(new Cancion("Como te voy a olvidar", "Angeles Azules ft Kinky", "3:21", Genero.CUMBIA,
						"Si besando la cruz estás tú\n" + "Rezando una oración estás tú\n" + "Cómo te voy a olvidar"));

		this.baseDeDatosCanciones.add(new Cancion("Hot in it", "Tiësto & Charli XCX", "2:24", Genero.DANCE_ELECTRONICA,
				"It's Charli, baby\n" + "Tiësto\n" + "You won't see me crying on the bathroom floor\n"
						+ "I ain't never coming back for more"));

		this.baseDeDatosCanciones.add(new Cancion("Thriller", "Michael Jackson", "2:59", Genero.POP,
				"It's close to midnight\n" + "And something evil's lurking in the dark"));

		this.baseDeDatosCanciones
				.add(new Cancion("Hey Jude", "The Beatles", "3:30", Genero.ROCK, "Hey Jude, don't make it bad.\n"
						+ "Take a sad song and make it better.\n" + "Remember to let her into your heart"));

		this.baseDeDatosCanciones.add(new Cancion("Nocturne op 9 no 2", "Frédéric Chopin", "3:29", Genero.CLASICA, ""));

		this.baseDeDatosCanciones.add(new Cancion("Bebiendo sola", "Camilo y Mike Towers", "4:19", Genero.LATINO,
				"De lejos se ve que tiene el corazón roto\n" + "Yo con solo mirarla lo noto"));

		this.baseDeDatosCanciones.add(new Cancion("Prelude in C Major", "J.S. Bach", "2:29", Genero.CLASICA, ""));

	}

	// ---------------------------------------------------------------------------------
	public LinkedHashSet<Cancion> buscarCancionesPorGenero(Genero generoSeleccionado) {
		LinkedHashSet<Cancion> encontradas = new LinkedHashSet<>();

		for (Cancion actual : this.baseDeDatosCanciones) {
			if (actual.getGenero().equals(generoSeleccionado)) {
				encontradas.add(actual);
			}
		}
		return encontradas;
	}

	// ---------------------------------------------------------------------------------
	public String mostrarUnaListaEspecifica(LinkedHashSet<Cancion> encontradas) {
		String informacion = "";
		Integer contador = 1;

		for (Cancion cancion : encontradas) {
			informacion += "\n" + contador + "-" + cancion.toString();
			contador++;
		}
		return informacion;
	}

	// #---------------------------------------------------------------------------------
	public String mostrarTodasLasCanciones() {
		String infoDeLaBDDeCanciones = "";
		Integer contador = 1;

		for (Cancion cancion : this.baseDeDatosCanciones) {
			infoDeLaBDDeCanciones += "\n" + contador + "-" + cancion.toString();
			contador++;
		}
		return infoDeLaBDDeCanciones;
	}
	
	// ---------------------------------------------------------------------------------
	public Cancion buscarCancionesPorNombre(String nombreDeLaCancion) {
		for (Cancion una : this.baseDeDatosCanciones) {
			if (una.getNombre().equalsIgnoreCase(nombreDeLaCancion)) {
				return una;
			}
		}
		return null;
	}
	
	// ---------------------------------------------------------------------------------
	public Cancion seleccionarCancionEnUnaListaDeterminada(String nombreDeLaCancion,
			LinkedHashSet<Cancion> encontradas) {

		for (Cancion uno : encontradas) {
			if (uno.getNombre().equalsIgnoreCase(nombreDeLaCancion)) {
				return uno;
			}
		}

		return null;
	}
	
	// ---------------------------------------------------------------------------------
	// Se Pueda Reproducir La Cancion Mostrando Nombre Artista La Letra Y Su
	// Duracion
	public String play(Cancion actualSonando, Integer idUsuarioLogueado) {
		Usuario oyente = this.obtenerElUsuarioLogueado(idUsuarioLogueado);

		if (this.baseDeDatosCanciones.contains(actualSonando) && oyente != null) {
			actualSonando.setEstaSonando(true);
			oyente.agregaCancionAlHistorial(actualSonando);
			return actualSonando.toString();
		}
		return "";
	}
	
	// ---------------------------------------------------------------------------------
	private Usuario obtenerElUsuarioLogueado(Integer idUsuarioLogueado) {
		for (Usuario anUser : this.usuarios) {
			if (anUser.getId().equals(idUsuarioLogueado) && anUser.getInicioSesion())
				return anUser;
		}
		return null;
	}
	
	// ---------------------------------------------------------------------------------
	public Cancion next(Cancion actualSonando, LinkedHashSet<Cancion> encontradas) {
		Cancion sonandoLaSiguiente = null;
		int posicionInicial = 0;
		ArrayList<Cancion> canciones = new ArrayList<>(encontradas);
		int posicion = canciones.indexOf(actualSonando);

		if (posicion < canciones.size() - 1) {
			sonandoLaSiguiente = canciones.get(++posicion);
			return sonandoLaSiguiente;

		} else if (posicion == canciones.size() - 1) {
			sonandoLaSiguiente = canciones.get(posicionInicial);
			return sonandoLaSiguiente;
		}

		return sonandoLaSiguiente;
	}
	
	// ---------------------------------------------------------------------------------
	public Cancion previous(Cancion actualSonando, LinkedHashSet<Cancion> encontradas) {
		Cancion anterior = null;
		ArrayList<Cancion> canciones = new ArrayList<>(encontradas);
		int posicionFinal = canciones.size() - 1;

		int posicion = canciones.indexOf(actualSonando);

		if (posicion > 0) {
			anterior = canciones.get(--posicion);
			return anterior;

		} else if (posicion == 0) {
			anterior = canciones.get(posicionFinal);
			return anterior;
		}

		return null;
	}
	
	// ---------------------------------------------------------------------------------
	// Un intento trucho de dailymix
	/* Recordatorio porque sino me pierdo
	 * Usuario tiene ArrayList<ListaDeReproduccion> dailyMixes
	 * */
	public void crearDailyMixes(Integer cantidadDeDailiMix, Integer cantMaxCancionesDailyMix, Integer idUser) {
		Usuario user = this.obtenerElUsuarioLogueado(idUser);
		ArrayList<ListaDeReproduccion> dailyMixes = new ArrayList<>();
		
		if (user != null) {
			ArrayList<Cancion> canciones = user.getHistorial();
			Cancion masEscuchada = obtenerLaCancionMasEscuchada(canciones);
			dailyMixes = obtenerUnConjuntoDeDailyMixes(masEscuchada,cantidadDeDailiMix,cantMaxCancionesDailyMix);
			user.setDailyMixes(dailyMixes);
		}
	}
	
	// ---------------------------------------------------------------------------------
	private ArrayList<ListaDeReproduccion> obtenerUnConjuntoDeDailyMixes(Cancion masEscuchada, Integer cantidadDeDailiMix, Integer cantMaxCancionesDailyMix) {
		ArrayList<ListaDeReproduccion>grupoDailyMix = new ArrayList<>(cantidadDeDailiMix); //le pongo un limite
		ArrayList<Audio>cancionesAleatorias = new ArrayList<>(cantMaxCancionesDailyMix);
		
		for(int i=0; i<cantidadDeDailiMix; i++) {
			ListaDeReproduccion dailyMix = new ListaDeReproduccion("dailyMix "+(i+1));
			cancionesAleatorias = obtenerCancionesAleatorias(masEscuchada,cantMaxCancionesDailyMix);
			dailyMix.setAudios(cancionesAleatorias);
			grupoDailyMix.add(dailyMix);
		}
		return grupoDailyMix;
	}

	// ---------------------------------------------------------------------------------
	private ArrayList<Audio> obtenerCancionesAleatorias(Cancion masEscuchada, Integer cantMaxCancionesDailyMix) {
		ArrayList<Audio> audiosPorGenero = new ArrayList<>(this.buscarCancionesPorGenero(masEscuchada.getGenero()));
		ArrayList<Audio>audiosDailyMix = new ArrayList<>(cantMaxCancionesDailyMix);
		
		int indexRandom = 0;
		
		for(int i=0; i<cantMaxCancionesDailyMix; i++) {
			indexRandom = (int)(Math.random()*audiosPorGenero.size()-1);
			audiosDailyMix.add(audiosPorGenero.get(indexRandom));
		}
		return audiosDailyMix;
	}
	
	// ---------------------------------------------------------------------------------
	public Cancion obtenerLaCancionMasEscuchada(ArrayList<Cancion> escuchadas) {
		
		Cancion masEscuchada = escuchadas.get(0);
		
		for(Cancion escuchada: escuchadas) {
			if(escuchada.getContadorDeReproduccion()>masEscuchada.getContadorDeReproduccion())
				masEscuchada = escuchada;
		}
		
		return masEscuchada;
	}

}
