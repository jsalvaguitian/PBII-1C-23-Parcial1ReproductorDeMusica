package ar.edu.unlam.pb2.parcial1.reproductor.tdd;

import static org.junit.Assert.*;

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
		
		//Usuario BASICO
		final String USERNAME_BASIC = "jesibel11";
		final String MAIL_BASIC= "belen@mail.com";
		final String PASSWORD_BASIC= "je$beL1357";
		final int DIA_BASIC = 29;
		final int MES_BASIC = 11;
		final int ANIO_BASIC= 2000;
		
		Usuario userBasico = new UsuarioBasico(USERNAME_BASIC, MAIL_BASIC, PASSWORD_BASIC, DIA_BASIC, MES_BASIC, ANIO_BASIC);
		
		final Integer CANTIDAD_USUARIO_ESPERADO_DOS = 2;
		
		//Ejecucion
		reproductor.registrarUsuario(user);
		reproductor.registrarUsuario(userBasico);
		
		//Validacion
		assertEquals(CANTIDAD_USUARIO_ESPERADO_DOS, reproductor.obtenerCantidadUsuarios());
	
	}

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

	// __________________________________________________________________________________________
	// Probar el inicio sesion del usuario

	@Test 
	public void queNoPuedaIniciarSesionElUsuarioBasicoSiNoEstaRegistradoEnElReproductor() {
		
		//PREPARACION
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
		
		//Usuario NO registrado
		final String MAIL_NO_REGISTRADO = "elmichi@mail.com";
		final String PASSWORD_NO_REGISTRADA = "soyUnMichiG@lactico1";
		
		assertFalse(reproductor.iniciarSesion(MAIL_NO_REGISTRADO, PASSWORD_NO_REGISTRADA));
		
	}
	
	@Test 
	public void queNoSePuedaIniciarSesionSiElUsuarioPremiumIngresosSuMailOUsernameNoValido() {
		
		//PREPARACION
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
		
		//EJECUCION
		//Usuario intenta iniciar sesion
		final String USERNAME_INGRESADO = "Lean21";
		final String PASSWORD_INGRESADO = "M1ch!1357";
		
		assertFalse(reproductor.iniciarSesion(USERNAME_INGRESADO,PASSWORD_INGRESADO));	
	
	}
	
	// __________________________________________________________________________________________
	// Probar Almacenar canciones, usuarios y episodios en sus respectivas bd
	
	 @Test 
	 public void queSePuedaGuardarCancionEnLaBaseDeDatosDeCancionesDelReproductor() {
	
	 }
	
	 @Test 
	 public void queSePuedaAgregarEpisodioEnUnPodCastDeLaBaseDeDatosDePodcast() {
	 
	 }
	

}
