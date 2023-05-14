package ar.edu.unlam.pb2.parcial1.reproductor.tdd;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import org.junit.Test;

public class ReproductorTest {

	/*---------------------------------------------------
	 * Probar el registro de usuarios
	 ---------------------------------------------------*/
	@Test
	public void queSePuedaRegistrarUnUsuarioBasicoEnElReproductorConDatosValidos() {
		// Preparacion de datos
		final String NOMBRE = "Onda Feliz";
		Reproductor reproductor;

		final String USERNAME = "jesibel12";
		final String MAIL = "jesi@mail.com";
		final String PASSWORD = "b@Rto1357";
		final int DIA = 2;
		final int MES = 11;
		final int ANIO = 1996;
		Usuario user;

		final Integer CANTIDAD_USUARIO_ESPERADO_UNO = 1;
		// Ejecucion
		reproductor = new Reproductor(NOMBRE);

		// Instancio la clase Usuario
		user = new UsuarioBasico(USERNAME, MAIL, PASSWORD, DIA, MES, ANIO);

		// Validacion
		assertTrue(reproductor.registrarUsuario(user));
		assertEquals(CANTIDAD_USUARIO_ESPERADO_UNO, reproductor.obtenerCantidadUsuarios());

	}
///////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void queNoSePuedaRegistrarUnUsuarioBasicoQueNoTengaUnMailValido() {
		// Preparacion de datos
		final String NOMBRE = "Onda Feliz";
		Reproductor reproductor = new Reproductor(NOMBRE);

		final String USERNAME = "jesibel12";
		final String MAIL_INVALIDO = "jesimailcom";
		final String PASSWORD = "b@Rto1357";
		final int DIA = 2;
		final int MES = 11;
		final int ANIO = 1996;
		Usuario user;
		final Integer CANTIDAD_USUARIO_ESPERADO_CERO = 0;

		// Ejecucion
		user = new UsuarioBasico(USERNAME, MAIL_INVALIDO, PASSWORD, DIA, MES, ANIO);

		// Validacion
		assertFalse(Usuario.esValidoElMail(MAIL_INVALIDO));
		assertFalse(reproductor.registrarUsuario(user));
		assertEquals(CANTIDAD_USUARIO_ESPERADO_CERO, reproductor.obtenerCantidadUsuarios());
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void queNoSePuedaRegistrarUnUsuarioBasicoQueNoTengaUnContraseniaValida() {
		// Preparacion de datos
		final String NOMBRE = "Onda Feliz";
		Reproductor reproductor = new Reproductor(NOMBRE);

		final String USERNAME = "karen123";
		final String MAIL = "karen@mail.com";
		final String PASSWORD = "abcdefgh";
		final int DIA = 21; 
		final int MES = 2;
		final int ANIO = 1996;

		Usuario miUser;
		final Integer CANTIDAD_USUARIO_ESPERADO_CERO = 0;

		// Ejecucion
		miUser = new UsuarioBasico(USERNAME, MAIL, PASSWORD, DIA, MES, ANIO);
		assertFalse(Usuario.esValidoLaContrasenia(PASSWORD));
		assertFalse(reproductor.registrarUsuario(miUser));
		assertEquals(CANTIDAD_USUARIO_ESPERADO_CERO, reproductor.obtenerCantidadUsuarios());
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void queNoSePuedaRegistrarUnUsuarioBasicoSiSuMailEstaDuplicadoEnLaBaseDeDatosDeUsuarios() {
		// Preparacion de datos
		final String NOMBRE = "Onda Feliz";
		Reproductor reproductor = new Reproductor(NOMBRE);

		// Usuario 1
		final String USERNAME = "jesibel12";
		final String MAIL = "jesi@mail.com";
		final String PASSWORD = "b@Rto1357";
		final int DIA = 2;
		final int MES = 11;
		final int ANIO = 1996;
		Usuario user = new UsuarioBasico(USERNAME, MAIL, PASSWORD, DIA, MES, ANIO);

		// Usuario 2
		final String USERNAME_2 = "karen12";
		final String MAIL_2 = "jesi@mail.com";
		final String PASSWORD_2 = "k@reN1567";
		final int DIA_2 = 2;
		final int MES_2 = 10;
		final int ANIO_2 = 1995;
		Usuario user2 = new UsuarioBasico(USERNAME_2, MAIL_2, PASSWORD_2, DIA_2, MES_2, ANIO_2);

		final Integer CANTIDAD_USUARIO_ESPERADO_UNO = 1;

		// Ejecucion
		reproductor.registrarUsuario(user);

		// Validacion
		assertFalse(reproductor.registrarUsuario(user2));
		assertEquals(CANTIDAD_USUARIO_ESPERADO_UNO, reproductor.obtenerCantidadUsuarios());
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void queNoSePuedaRegistrarUnUsuarioBasicoSiElUsernameEstaDuplicadoEnLaBaseDeDatosDeUsuarios(){
		// Preparacion de datos
		final String NOMBRE = "Onda Feliz";
		Reproductor reproductor = new Reproductor(NOMBRE);

		// Usuario 1
		final String USERNAME = "jesibel12";
		final String MAIL = "jesi@mail.com";
		final String PASSWORD = "b@Rto1357";
		final int DIA = 2;
		final int MES = 11;
		final int ANIO = 1996;
		Usuario user1 = new UsuarioBasico(USERNAME, MAIL, PASSWORD, DIA, MES, ANIO);

		// Usuario 2
		final String USERNAME_2 = "jesibel12";
		final String MAIL_2 = "karen@mail.com";
		final String PASSWORD_2 = "k@reN1567";
		final int DIA_2 = 5;
		final int MES_2 = 10;
		final int ANIO_2 = 1995;
		Usuario user2 = new UsuarioBasico(USERNAME_2, MAIL_2, PASSWORD_2, DIA_2, MES_2, ANIO_2);

		final Integer CANTIDAD_USUARIO_ESPERADO_UNO = 1;

		// Ejecucion
		reproductor.registrarUsuario(user1);

		// Validacion
		assertFalse(reproductor.registrarUsuario(user2));
		assertEquals(CANTIDAD_USUARIO_ESPERADO_UNO, reproductor.obtenerCantidadUsuarios());
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void queSePuedaRegistrarUnUsuarioPremiumYBasicoEnLaBaseDeDatosDeUsuarios() {
		// Preparacion de datos
		final String NOMBRE = "Onda Feliz";
		Reproductor reproductor = new Reproductor(NOMBRE);

		// Usuario PREMIUM
		final String USERNAME = "karen12";
		final String MAIL = "karen@mail.com";
		final String PASSWORD = "K@ren1357";
		final int DIA = 2;
		final int MES = 11;
		final int ANIO = 1996;
		Usuario user = new UsuarioPremium(USERNAME, MAIL, PASSWORD, DIA, MES, ANIO);

		// Usuario BASICO
		final String USERNAME_BASIC = "jesibel11";
		final String MAIL_BASIC = "belen@mail.com";
		final String PASSWORD_BASIC = "je$beL1357";
		final int DIA_BASIC = 29;
		final int MES_BASIC = 11;
		final int ANIO_BASIC = 2000;

		Usuario userBasico = new UsuarioBasico(USERNAME_BASIC, MAIL_BASIC, PASSWORD_BASIC, DIA_BASIC, MES_BASIC,
				ANIO_BASIC);

		final Integer CANTIDAD_USUARIO_ESPERADO_DOS = 2;

		// Ejecucion
		reproductor.registrarUsuario(user);
		reproductor.registrarUsuario(userBasico);

		// Validacion
		assertEquals(CANTIDAD_USUARIO_ESPERADO_DOS, reproductor.obtenerCantidadUsuarios());

	}
///////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void queNoSePuedaRegistrarUnUsuarioConFechaDeNacimientoNoValido() {
		// Preparacion de datos
		final String NOMBRE = "Onda Feliz";
		Reproductor reproductor = new Reproductor(NOMBRE);

		final String USERNAME = "jesibel12";
		final String MAIL = "jesi@mail.com";
		final String PASSWORD = "b@Rto1357";
		final int DIA_MAL = 30; // 29 si es un año bisiesto
		final int MES = 2;
		final int ANIO = 1996;

		Usuario user;
		final Integer CANTIDAD_USUARIO_ESPERADO_CERO = 0;

		// Ejecucion
		user = new UsuarioBasico(USERNAME, MAIL, PASSWORD, DIA_MAL, MES, ANIO);
		assertFalse(Usuario.esValidoLaFecha(DIA_MAL, MES, ANIO));
		assertFalse(reproductor.registrarUsuario(user));
		assertEquals(CANTIDAD_USUARIO_ESPERADO_CERO, reproductor.obtenerCantidadUsuarios());

	}
///////////////////////////////////////////////////////////////////////////////////////////////////////

	// Probar el inicio sesion del usuario

	@Test
	public void queNoPuedaIniciarSesionElUsuarioBasicoSiNoEstaRegistradoEnElReproductor() {

		// PREPARACION
		final String NOMBRE = "Onda Feliz";
		Reproductor reproductor = new Reproductor(NOMBRE);

		// Usuario Registrado
		final String USERNAME = "jesibel12";
		final String MAIL = "jesi@mail.com";
		final String PASSWORD = "b@Rto1357";
		final int DIA = 2;
		final int MES = 11;
		final int ANIO = 1996;
		Usuario user = new UsuarioBasico(USERNAME, MAIL, PASSWORD, DIA, MES, ANIO);

		reproductor.registrarUsuario(user);

		// Usuario NO registrado
		final String MAIL_NO_REGISTRADO = "elmichi@mail.com";
		final String PASSWORD_NO_REGISTRADA = "soyUnMichiG@lactico1";

		assertNull(reproductor.iniciarSesion(MAIL_NO_REGISTRADO, PASSWORD_NO_REGISTRADA)); // no tiene id

	}
///////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void queNoSePuedaIniciarSesionSiElUsuarioPremiumIngresosSuMailOUsernameNoValido() {

		// PREPARACION
		final String NOMBRE = "Onda Feliz";
		Reproductor reproductor = new Reproductor(NOMBRE);

		// Usuario Registrado
		final String USERNAME = "Lean12";
		final String MAIL = "losmichis@mail.com";
		final String PASSWORD = "M1ch!1357";
		final int DIA = 27;
		final int MES = 8;
		final int ANIO = 2001;
		Usuario user = new UsuarioPremium(USERNAME, MAIL, PASSWORD, DIA, MES, ANIO);

		reproductor.registrarUsuario(user);

		// EJECUCION
		// Usuario intenta iniciar sesion
		final String USERNAME_INGRESADO = "Lean21";
		final String PASSWORD_INGRESADO = "M1ch!1357";

		assertNull(reproductor.iniciarSesion(USERNAME_INGRESADO, PASSWORD_INGRESADO));

	}
///////////////////////////////////////////////////////////////////////////////////////////////////////

	// Probar Almacenar canciones,episodios en sus respectivas bd

	@Test
	public void queSePuedaGuardarCancionEnLaBaseDeDatosDeCancionesDelReproductor() {
		// PREPARACION
		final String NOMBRE = "Onda Feliz";
		Reproductor reproductor = new Reproductor(NOMBRE);

		// cancion a agregar
		final Integer CANTIDAD_DE_CANCION_ESPERADA = 1;
		final String NOMBRE_CANCION = "Que bonito";
		final String ARTISTA = "Rosario";
		final String DURACION = "3:49";
		final Genero GENERO = Genero.POP;
		final String LETRA = "Qué bonito cuando te veo, ¡ay!\n" + "Qué bonito cuando te siento\n"
				+ "Qué bonito pensar que estás aquí\n" + "Junto a mí";

		Cancion cancion = new Cancion(NOMBRE_CANCION, ARTISTA, DURACION, GENERO, LETRA);

		assertTrue(reproductor.agregarCancionALaBD(cancion));
		assertEquals(CANTIDAD_DE_CANCION_ESPERADA, reproductor.getCantidadCancionesEnLaBD());
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void queSePuedaAgregarEpisodioEnUnPodcastDeLaBaseDeDatosDePodcast() {
		// PREPARACION
		final String NOMBRE = "Onda Feliz";
		Reproductor reproductor = new Reproductor(NOMBRE);

		// creo un podcast para guardar un episodio
		final String NOMBRE_PODCAST = "Relatos en inglés con Duolingo";
		final String AUTOR = "Duolingo";
		final String DESCRIPCION = "Mejora tu inglés mediante relatos de la vida real narradas en inglés";
		final Categoria CATEGORIA = Categoria.EDUCACION;
		Podcast unPodcast = new Podcast(NOMBRE_PODCAST, AUTOR, DESCRIPCION, CATEGORIA);
		reproductor.agregarPodcast(unPodcast);

		// preparo el episodio
		final String NOMBRE_EPISODIO = "Episodio 01: Furry friends";
		final String NOMBRE_DEL_PODCAST_QUE_PERTENECE = "Relatos en inglés con Duolingo"; // nombre del podcast
		final String DURACION = "23:57";
		final String DESCRIPCION_EPISODIO = "Nuestro amigo el perro Firulais";

		final Integer CANTIDAD_DE_EPISODIO_ESPERADO = 1;

		Episodio episodio = new Episodio(NOMBRE_EPISODIO, NOMBRE_DEL_PODCAST_QUE_PERTENECE, DURACION,
				DESCRIPCION_EPISODIO);

		// VALIDACION
		assertTrue(reproductor.guardarEpisodio(unPodcast, episodio));
		assertEquals(CANTIDAD_DE_EPISODIO_ESPERADO,
				reproductor.getCantidadDeEpisodiosDelPodcastPorNombre(NOMBRE_DEL_PODCAST_QUE_PERTENECE));

	}
///////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void queNoSePuedaGuardarCancionConNombreYArtistaDuplicadoEnLaBDDeCancionesDelReproductor() {
		// PREPARACION
		final String NOMBRE = "Onda Feliz";
		Reproductor reproductor = new Reproductor(NOMBRE);

		// cancion a agregar
		final Integer CANTIDAD_DE_CANCION_ESPERADA = 1;
		final String NOMBRE_CANCION = "Sin documentos";
		final String ARTISTA = "Los Rodriguez";
		final String DURACION = "4:49";
		final Genero GENERO = Genero.ROCK;
		final String LETRA = "Déjame atravesar el viento sin documentos\n" + "Que lo haré por el tiempo que tuvimos\n"
				+ "Porque no queda salida, porque pareces dormida\n"
				+ "Porque buscando tu sonrisa estaría toda mi vida";

		// Ejecucion
		Cancion cancion = new Cancion(NOMBRE_CANCION, ARTISTA, DURACION, GENERO, LETRA);
		Cancion cancionDos = new Cancion(NOMBRE_CANCION, ARTISTA, DURACION, GENERO, LETRA);

		reproductor.agregarCancionALaBD(cancion);

		// vALIDACION
		assertFalse(reproductor.agregarCancionALaBD(cancionDos));
		assertEquals(CANTIDAD_DE_CANCION_ESPERADA, reproductor.getCantidadCancionesEnLaBD());

	}
///////////////////////////////////////////////////////////////////////////////////////////////////////
	// Prueba de filtros
	@Test
	public void queSePuedaBuscarCancionesPorGenero() {
		// PREPARACION
		final String NOMBRE = "Onda Feliz";
		final Genero GENERO_SELECCIONADO = Genero.LATINO;

		Reproductor reproductor = new Reproductor(NOMBRE);

		final String INFORMACION_ESPERADA = "\n1-Cancion: " + "Piel morena" + "\nArtista: " + "Thalia" + "\nDuracion: "
				+ "2:29" + "\nLetra: Eres piel morena" + "\nCanto de pasión y arena" + "\nEres piel morena"
				+ "\n------------------------------------------------------" + "\n2-Cancion: " + "Bebiendo sola"
				+ "\nArtista: " + "Camilo y Mike Towers" + "\nDuracion: " + "4:19"
				+ "\nLetra: De lejos se ve que tiene el corazón roto" + "\nYo con solo mirarla lo noto"
				+ "\n------------------------------------------------------";

		reproductor.inicializarBaseDeDatosconCanciones();

		LinkedHashSet<Cancion> encontradas = reproductor.buscarCancionesPorGenero(GENERO_SELECCIONADO);

		assertEquals(INFORMACION_ESPERADA, reproductor.mostrarUnaListaEspecifica(encontradas));

	}
///////////////////////////////////////////////////////////////////////////////////////////////////////
	// *********************************************************
	// Prueba de que el usuario pueda crear y agregar canciones en su playList
	@Test
	public void quePuedaAgregarSoloDosPlaylistEnLaBibliotecaDelUsuarioBasico() {
		// *****PREPARACION*****
		// Registro un usuario basico
		final String NOMBRE = "Onda Feliz";
		Reproductor reproductor = new Reproductor(NOMBRE);

		final String NOMBRE_PLAYLIST_1 = "Un poco de todo";
		final String NOMBRE_PLAYLIST_2 = "Disco";
		final String NOMBRE_PLAYLIST_3 = "Fiesta";
		final Integer CANTIDAD_PLAYLIST_ESPERADA = 2;
		final String USERNAME = "jesibel12";
		final String MAIL = "jesi@mail.com";
		final String PASSWORD = "b@Rto1357";
		final int DIA = 2;
		final int MES = 11;
		final int ANIO = 1996;
		Usuario user = new UsuarioBasico(USERNAME, MAIL, PASSWORD, DIA, MES, ANIO);

		reproductor.registrarUsuario(user);

		// Inicio sesion el usuario basico
		reproductor.iniciarSesion(MAIL, PASSWORD);

		// Que agregue 2 playlist
		user.crearNuevaPlayList(NOMBRE_PLAYLIST_1);
		user.crearNuevaPlayList(NOMBRE_PLAYLIST_2);

		// ****EJECUCION******
		// Que intente agregar la 3ra playlist y no pueda guardarla
		assertFalse(user.crearNuevaPlayList(NOMBRE_PLAYLIST_3));

		// *****VALIDACION*****
		// validar que se tenga solo 2 playlist
		assertEquals(CANTIDAD_PLAYLIST_ESPERADA, user.obtenerLaCantidadDePlayList());

	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void queNoSePuedaAgregarMasDe10CancionesEnUnaPlayListDeUsuarioBasico() {
		// *****PREPARACION*****
		// Registro un usuario basico
		final String NOMBRE = "Onda Feliz";
		Reproductor reproductor = new Reproductor(NOMBRE);
		reproductor.inicializarBaseDeDatosconCanciones();

		final String NOMBRE_PLAYLIST_1 = "Un poco de todo";

		final Integer CANTIDAD_PLAYLIST_ESPERADA = 2;
		final String USERNAME = "jesibel12";
		final String MAIL = "jesi@mail.com";
		final String PASSWORD = "b@Rto1357";
		final int DIA = 2;
		final int MES = 11;
		final int ANIO = 1996;
		Usuario user = new UsuarioBasico(USERNAME, MAIL, PASSWORD, DIA, MES, ANIO);

		reproductor.registrarUsuario(user);

		// Inicio sesion el usuario basico
		reproductor.iniciarSesion(MAIL, PASSWORD);

		// Agrego una playlist
		user.crearNuevaPlayList(NOMBRE_PLAYLIST_1);

		// Agregarle 10 canciones :-s mama mia
		Cancion cancionSeleccionada = reproductor.buscarCancionesPorNombre("Piel morena");
		Cancion cancionSeleccionada2 = reproductor.buscarCancionesPorNombre("The show must go on");
		Cancion cancionSeleccionada3 = reproductor.buscarCancionesPorNombre("Hot in it");
		Cancion cancionSeleccionada4 = reproductor.buscarCancionesPorNombre("Piel morena");
		Cancion cancionSeleccionada5 = reproductor.buscarCancionesPorNombre("Thriller");
		Cancion cancionSeleccionada6 = reproductor.buscarCancionesPorNombre("Piel morena");
		Cancion cancionSeleccionada7 = reproductor.buscarCancionesPorNombre("Prelude in C Major");
		Cancion cancionSeleccionada8 = reproductor.buscarCancionesPorNombre("Piel morena");
		Cancion cancionSeleccionada9 = reproductor.buscarCancionesPorNombre("Piel morena");
		Cancion cancionSeleccionada10 = reproductor.buscarCancionesPorNombre("Hot in it");
		Cancion cancionSeleccionadaQueNoSeGuarda = reproductor.buscarCancionesPorNombre("Hey Jude");

		// ***** EJECUCION *****
		user.agregarCancionALaPLayList(NOMBRE_PLAYLIST_1, cancionSeleccionada);
		user.agregarCancionALaPLayList(NOMBRE_PLAYLIST_1, cancionSeleccionada2);
		user.agregarCancionALaPLayList(NOMBRE_PLAYLIST_1, cancionSeleccionada3);
		user.agregarCancionALaPLayList(NOMBRE_PLAYLIST_1, cancionSeleccionada4);
		user.agregarCancionALaPLayList(NOMBRE_PLAYLIST_1, cancionSeleccionada5);
		user.agregarCancionALaPLayList(NOMBRE_PLAYLIST_1, cancionSeleccionada6);
		user.agregarCancionALaPLayList(NOMBRE_PLAYLIST_1, cancionSeleccionada7);
		user.agregarCancionALaPLayList(NOMBRE_PLAYLIST_1, cancionSeleccionada8);
		user.agregarCancionALaPLayList(NOMBRE_PLAYLIST_1, cancionSeleccionada9);
		user.agregarCancionALaPLayList(NOMBRE_PLAYLIST_1, cancionSeleccionada10);

		// VALIDACION
		assertFalse(user.agregarCancionALaPLayList(NOMBRE_PLAYLIST_1, cancionSeleccionadaQueNoSeGuarda));
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 *Un intento de obtener 1 dailyMix de 5 canciones, el cual se basará según la música que escucha y/o
	 * el género de canciones que le gusta
	 */
	@Test
	public void queElUsuarioBasicoPuedaAgregarSoloUnaDailyMixDe5CancionesDeLas3AElegir() {
		// PREPARACION
		final String NOMBRE = "Onda Feliz";
		Reproductor reproductor = new Reproductor(NOMBRE);
		
		//Ganó thriller es pop: agregar 4 canciones de michael jackson y canciones pop en la db para la prueba
		reproductor.agregarCancionALaBD(new Cancion("Thriller", "Michael Jackson", "2:59", Genero.POP,""));
		
		reproductor.agregarCancionALaBD(new Cancion("Que bonito", "Rosario", "4:59", Genero.POP,""));
		
		reproductor.agregarCancionALaBD(new Cancion("Brother Louie", "Modern Talking", "3:29", Genero.POP,""));
		
		reproductor.agregarCancionALaBD(new Cancion("Calm down", "Selena Gomez", "2:59", Genero.POP,""));
		
		reproductor.agregarCancionALaBD(new Cancion("Remember the time", "Michael Jackson", "2:59", Genero.POP,""));
		
		reproductor.agregarCancionALaBD(new Cancion("Love never felt so good", "Michael Jackson", "2:59", Genero.POP,""));
		
		reproductor.agregarCancionALaBD(new Cancion("Billie Jean", "Michael Jackson", "2:59", Genero.POP,""));

		//---------------------------------------------------
		reproductor.inicializarBaseDeDatosconCanciones();
		final String USERNAME = "juani";
		final String MAIL = "juan@mail.com";
		final String PASSWORD = "b@Rto1357";
		final int DIA = 12;
		final int MES = 12;
		final int ANIO = 1996;
		final Integer CANTIDAD_DE_DAILYMIX = 3;
		final Integer CANTIDAD_MAX_CANCIONES = 5;
		
		Usuario user = new UsuarioBasico(USERNAME, MAIL, PASSWORD, DIA, MES, ANIO);
		reproductor.registrarUsuario(user);
		Integer idUser = reproductor.iniciarSesion(MAIL, PASSWORD);
		
		Cancion cancionSonando = reproductor.buscarCancionesPorNombre("The show must go on");
		reproductor.play(cancionSonando, idUser);
		
		Cancion cancionSonando2 = reproductor.buscarCancionesPorNombre("Thriller");
		reproductor.play(cancionSonando2, idUser);
		
		Cancion cancionSonando3 = reproductor.buscarCancionesPorNombre("The show must go on");
		reproductor.play(cancionSonando3, idUser);
		
		Cancion cancionSonando4 = reproductor.buscarCancionesPorNombre("Thriller");
		reproductor.play(cancionSonando4, idUser);
		
		Cancion cancionSonando5 = reproductor.buscarCancionesPorNombre("Thriller");
		reproductor.play(cancionSonando5, idUser);
		
		reproductor.crearDailyMixes(CANTIDAD_DE_DAILYMIX, CANTIDAD_MAX_CANCIONES, idUser);

		ListaDeReproduccion dailymixSeleccionada = user.seleccionarDailymix("dailyMix 2");
		ListaDeReproduccion dailymixNoPermitida = user.seleccionarDailymix("dailyMix 1");

	
		assertEquals(CANTIDAD_DE_DAILYMIX, (Integer)user.getDailyMixes().size());
		assertTrue(user.agregarDailymix(dailymixSeleccionada));
		assertFalse(user.agregarDailymix(dailymixNoPermitida));
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////
	// Aclaracion: solo los usuarios premium
	@Test
	public void queSePuedaSeleccionarUnaCancionComoFavoritaYAutomaticamenteAgregarseEnUnaPlaylistTusMeGusta() {
		// PREPARACION
		// 1- preparo el reproductor
		final String NOMBRE = "Onda Feliz";
		Reproductor reproductor = new Reproductor(NOMBRE);
		reproductor.inicializarBaseDeDatosconCanciones();

		// 2-registro un usuario premium
		final String USERNAME = "juani";
		final String MAIL = "juan@mail.com";
		final String PASSWORD = "b@Rto1357";
		final int DIA = 12;
		final int MES = 12;
		final int ANIO = 1996;

		Usuario user = new UsuarioPremium(USERNAME, MAIL, PASSWORD, DIA, MES, ANIO);
		reproductor.registrarUsuario(user);

		// 3-inicia sesion
		reproductor.iniciarSesion(MAIL, PASSWORD);

		// 4-el usuario busca una cancion por el nombre
		Cancion cancionBuscada = reproductor.buscarCancionesPorNombre("Nocturne op 9 no 2");

		// VALIDACION
		assertTrue(user.seleccionarCancionComoFavorita(cancionBuscada));
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void queSePuedaDeseleccionarUnaCancionFavoritaYDesaparezcaDeListaTusMeGusta() {
		// PREPARACION
		// 1- preparo el reproductor
		final String NOMBRE = "Onda Feliz";
		Reproductor reproductor = new Reproductor(NOMBRE);
		reproductor.inicializarBaseDeDatosconCanciones();

		// 2-registro un usuario premium
		final String USERNAME = "juani";
		final String MAIL = "juan@mail.com";
		final String PASSWORD = "b@Rto1357";
		final int DIA = 12;
		final int MES = 12;
		final int ANIO = 1996;
		final String CANCION = "Nocturne op 9 no 2";
		final String CANCION_DOS = "Thriller";
		final Integer CANTIDAD_CANCIONES_EN_FAVORITOS_UNO = 1;
		final String NOMBRE_PLAYLIST = "Tus me gustas";
		Usuario user = new UsuarioPremium(USERNAME, MAIL, PASSWORD, DIA, MES, ANIO);
		reproductor.registrarUsuario(user);

		// 3-inicia sesion
		reproductor.iniciarSesion(MAIL, PASSWORD);

		// 4-el usuario busca una cancion por el nombre
		Cancion cancionBuscada = reproductor.buscarCancionesPorNombre(CANCION);
		Cancion buscadaDos = reproductor.buscarCancionesPorNombre(CANCION_DOS);

		user.seleccionarCancionComoFavorita(cancionBuscada);
		user.seleccionarCancionComoFavorita(buscadaDos);

		user.deseleccionarCancionComoFavorita(cancionBuscada);

		// VALIDACION
		assertEquals(CANTIDAD_CANCIONES_EN_FAVORITOS_UNO,user.obtenerLaCantidadDeCancionesDeUnaPlaylist(NOMBRE_PLAYLIST));

	}
///////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void queAlBuscarUnaCancionDeLaBDSePuedaReproducirLaCancionMostrandoNombreArtistaLaLetraYSuDuracion() {
		// PREPARACION
		// Registro un usuario basico
		final String NOMBRE = "Onda Feliz";
		Reproductor reproductor = new Reproductor(NOMBRE);
		reproductor.inicializarBaseDeDatosconCanciones();

		final String INFORMACION_ESPERADA = "Cancion: Hot in it" + "\nArtista: Tiësto & Charli XCX" + "\nDuracion: 2:24"
				+ "\nLetra: It's Charli, baby" + "\nTiësto" + "\nYou won't see me crying on the bathroom floor"
				+ "\nI ain't never coming back for more" + "\n------------------------------------------------------";
		final String USERNAME = "jesibel12";
		final String MAIL = "jesi@mail.com";
		final String PASSWORD = "b@Rto1357";
		final int DIA = 2;
		final int MES = 11;
		final int ANIO = 1996;

		Usuario user = new UsuarioBasico(USERNAME, MAIL, PASSWORD, DIA, MES, ANIO);
		reproductor.registrarUsuario(user);
		Integer idUser = reproductor.iniciarSesion(MAIL, PASSWORD);

		// Seleccionar una cancion para escuchar ingresando el nombre de la cancion
		Cancion cancionSonando = reproductor.buscarCancionesPorNombre("Hot in it");

		// VALIDACION
		assertNotNull(cancionSonando);
		assertEquals(INFORMACION_ESPERADA, reproductor.play(cancionSonando, idUser));
		assertTrue(cancionSonando.getEstaSonando());

	}
///////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void queSePuedaCambiarLaCancionQueSeEstaSonandoAlaSiguiente() {
		// PREPARACION
		// Registro un usuario basico
		final String NOMBRE = "Onda Feliz";
		Reproductor reproductor = new Reproductor(NOMBRE);
		reproductor.inicializarBaseDeDatosconCanciones();

		final String USERNAME = "jesibel12";
		final String MAIL = "jesi@mail.com";
		final String PASSWORD = "b@Rto1357";
		final int DIA = 2;
		final int MES = 11;
		final int ANIO = 1996;
		final Genero GENERO_SELECCIONADO = Genero.DANCE_ELECTRONICA;

		Cancion SIGUIENTE = new Cancion("Out of touch", "Cut", "3:20", Genero.DANCE_ELECTRONICA,
				"I'm out of touch\n" + "I'm out of sync with you\n" + "I'm out of touch");

		reproductor.agregarCancionALaBD(SIGUIENTE);

		Usuario user = new UsuarioBasico(USERNAME, MAIL, PASSWORD, DIA, MES, ANIO);

		reproductor.registrarUsuario(user);

		// Inicio sesion el usuario basico
		Integer idUser = reproductor.iniciarSesion(MAIL, PASSWORD);

		// Buscar una lista por genero
		LinkedHashSet<Cancion> encontradas = reproductor.buscarCancionesPorGenero(GENERO_SELECCIONADO);

		// Seleccionar una cancion para escuchar
		Cancion actualSonando = reproductor.seleccionarCancionEnUnaListaDeterminada("Hot in it", encontradas);

		reproductor.play(actualSonando, idUser);

		assertNotNull(actualSonando);
		assertTrue(actualSonando.getEstaSonando());
		assertEquals(SIGUIENTE, reproductor.next(actualSonando, encontradas));
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void queSePuedaCambiarLaCancionQueSeEstaSonandoAlaAnterior() {
		// PREPARACION
		// Registro un usuario basico
		final String NOMBRE = "Onda Feliz";
		Reproductor reproductor = new Reproductor(NOMBRE);
		reproductor.inicializarBaseDeDatosconCanciones();


		final String USERNAME = "jesibel12";
		final String MAIL = "jesi@mail.com";
		final String PASSWORD = "b@Rto1357";
		final int DIA = 2;
		final int MES = 11;
		final int ANIO = 1996;
		final Genero GENERO_SELECCIONADO = Genero.DANCE_ELECTRONICA;

		Cancion actualEsperada = new Cancion("Out of touch", "Cut", "3:20", Genero.DANCE_ELECTRONICA,
				"I'm out of touch\n" + "I'm out of sync with you\n" + "I'm out of touch");

		Cancion previaEsperada = new Cancion("Hot in it", "Tiësto & Charli XCX", "2:24", Genero.DANCE_ELECTRONICA,
				"It's Charli, baby\n" + "Tiësto\n" + "You won't see me crying on the bathroom floor\n"
						+ "I ain't never coming back for more");

		reproductor.agregarCancionALaBD(actualEsperada);

		Usuario user = new UsuarioBasico(USERNAME, MAIL, PASSWORD, DIA, MES, ANIO);

		reproductor.registrarUsuario(user);

		// Inicio sesion el usuario basico
		Integer idUser = reproductor.iniciarSesion(MAIL, PASSWORD);

		// Buscar una lista por genero
		LinkedHashSet<Cancion> encontradas = reproductor.buscarCancionesPorGenero(GENERO_SELECCIONADO);

		// Seleccionar una cancion para escuchar
		Cancion actualSonando = reproductor.seleccionarCancionEnUnaListaDeterminada("Out of touch", encontradas);

		reproductor.play(actualSonando, idUser);

		assertNotNull(actualSonando);
		assertTrue(actualSonando.getEstaSonando());
		assertEquals(actualEsperada, actualSonando);
		assertEquals(previaEsperada, reproductor.previous(actualSonando, encontradas));

	}

///////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void queNoSePuedaSubirElVolumenDeUnaCancionMasDelMaximo() {
		// Preparacion de datos 
		Boolean resultadoObtenido;
		Boolean resultadoEsperado=false;
		Cancion unaCancion = new Cancion("Billie Jean", "Michael Jackson", "2:59", Genero.POP,"");
		unaCancion.volumenAudio.setVolumenActual(10);
		
		// Ejecucion
		resultadoObtenido=unaCancion.volumenAudio.subirVolumen();
		
		// Validacion
		assertEquals(resultadoEsperado,resultadoObtenido);
		
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void queNoSePuedaBajarElVolumenDeUnaCancionMenosDelMinimo() {
		// Preparacion de datos 
		Boolean resultadoObtenido;
		Boolean resultadoEsperado=false;
		Cancion otraCancion = new Cancion("Que bonito", "Rosario", "4:59", Genero.POP,"");
		otraCancion.volumenAudio.setVolumenActual(0);
		
		// Ejecucion
		resultadoObtenido=otraCancion.volumenAudio.bajarVolumen();
		
		// Validacion
		assertEquals(resultadoEsperado,resultadoObtenido);
		
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////	
	

}
