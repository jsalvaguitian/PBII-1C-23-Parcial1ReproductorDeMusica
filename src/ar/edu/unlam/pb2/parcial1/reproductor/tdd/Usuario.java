package ar.edu.unlam.pb2.parcial1.reproductor.tdd;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public abstract class Usuario {
	protected Integer id = 0;
	private String username;
	private String mail;
	private String password;
	private final Integer MINIMA_LONGITUD_PASSWORD=6;
	protected LocalDate fechaDeNacimiento;
	protected Boolean inicioSesion;
	protected LinkedHashSet<ListaDeReproduccion> biblioteca;
	protected ArrayList<Cancion> historial;
	protected ArrayList<ListaDeReproduccion> dailyMixes;


	public Usuario(String username, String mail, String password, Integer dia, Integer mes, Integer anio) {
		if (esValidoElMail(mail) && esValidoLaContrasenia(password) && esValidoLaFecha(dia, mes, anio)) {
			id++;
			this.username = username;
			this.mail = mail;
			this.password = password;
			this.fechaDeNacimiento = LocalDate.of(anio, mes, dia);
			this.inicioSesion = false;
			this.biblioteca = new LinkedHashSet<ListaDeReproduccion>();
			this.historial = new ArrayList<Cancion>();
			this.dailyMixes = new ArrayList<>();
		}
		

	}

	/*
	 * Cosas a tener en cuenta: El mail debe tener un solo @ El mail debe tener al
	 * menos un punto
	 */
	public static Boolean esValidoElMail(String mail) {
		Boolean exitoso = false;
		int contadorArroba = 0;
		Boolean tienePunto = mail.contains(".");

		char[] mailArray = mail.toCharArray();

		for (int i = 0; i < mailArray.length; i++) {
			if (mailArray[i] == '@')
				contadorArroba++;
		}

		if (tienePunto && contadorArroba == 1)
			exitoso = true;

		return exitoso;
	}

	/* Se considera valida la contraseña si tiene una longitud minima y al menos un numero, una mayuscula y una minuscula */
	public static Boolean esValidoLaContrasenia(String password) {
		char ch;
		Boolean esValido = false;
		Boolean hayMayuscula = false;
    		Boolean hayMinuscula = false;
    		Boolean hayNumero = false;
		if(password.length>=MINIMA_LONGITUD_PASSWORD){
	    		for(int i=0;i < password.length();i++) {
        			ch = password.charAt(i);
        			if( Character.isDigit(ch)) {
            				hayNumero = true;
        			}
        			else if (Character.isUpperCase(ch)) {
            				hayMayuscula = true;
        			} else if (Character.isLowerCase(ch)) {
            				hayMinuscula = true;
        			}
        			if(hayNumero && hayMayuscula && hayMinuscula)
            				return esValido=true;
    			}
		}	
		return esValido;
	}

	/*
	 * Cualquier año divisible por 4 es un año bisiesto Año que tiene 366 días en
	 * lugar de 365, en el que febrero tiene 29 días en lugar de 28; se repite cada
	 * cuatro años, excepto cuando el año acaba en dos ceros. No usar excepciones
	 * Hay cosas que no se pudo considerar si es calendario gregoriano o no pero sí
	 * se pudo considerar el año bisiesto
	 */
	public static Boolean esValidoLaFecha(Integer dia, Integer mes, Integer anio) {
		String anioCaracter = String.valueOf(anio);

		if (anioCaracter.length() == 4) {
			Integer calendar[] = obtenerCalendario(anio);

			for (int i = 0; i < calendar.length; i++) {
				if (mes == i + 1) {
					if (dia >= 1 && dia <= calendar[i])
						return true;
				}
			}
		}

		return false;
	}

	private static Integer[] obtenerCalendario(Integer anio) {
		Integer calendarGeneral[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		Integer calendarBisiesto[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String anioCaracter = String.valueOf(anio);

		if (anio % 4 == 0 && !(anioCaracter.substring(2).equals("00"))) {
			return calendarBisiesto;

		}

		else
			return calendarGeneral;
	}

	public Boolean esValidoUsuario() {
		if (username != null && mail != null && password != null && fechaDeNacimiento != null && inicioSesion != null)
			return true;
		return false;
	}

	public Integer getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getMail() {
		return mail;
	}

	public String getPassword() {
		return password;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public Boolean getInicioSesion() {
		return inicioSesion;
	}

	public void setInicioSesion(Boolean inicioSesion) {
		this.inicioSesion = inicioSesion;
	}

	public ArrayList<Cancion> getHistorial() {
		return historial;
	}

	
	public ArrayList<ListaDeReproduccion> getDailyMixes() {
		return dailyMixes;
	}

	public void setDailyMixes(ArrayList<ListaDeReproduccion> dailyMixes) {
		this.dailyMixes = dailyMixes;
	}

	protected abstract Boolean crearNuevaPlayList(String nombrePlayList);

	protected abstract Integer obtenerLaCantidadDePlayList();

	public boolean agregarCancionALaPLayList(String nombrePlaylist, Cancion cancionSeleccionada) {
		Boolean fueExitoso = false;
		String nombreDeClase = this.getClass().getSimpleName();
		if (this.inicioSesion) {
			for (ListaDeReproduccion unaLista : this.biblioteca) {
				if (unaLista.getNombre().equals(nombrePlaylist)) {
					fueExitoso = unaLista.agregarCancion(cancionSeleccionada, nombreDeClase);
				}
			}
		}
		return fueExitoso;
	}

	public boolean eliminarCancionDeLaPLayList(String playlist, Cancion cancion) {
		boolean seElimino = false;
		
		if(this.inicioSesion && cancion !=null) {
			for(ListaDeReproduccion lista: this.biblioteca) {
				if(lista.getNombre().equals(playlist))
					seElimino = lista.eliminarCancion(cancion);
			}
		}

		return seElimino;
	}

	protected abstract boolean seleccionarCancionComoFavorita(Cancion cancionBuscada);

	public Integer obtenerLaCantidadDeCancionesDeUnaPlaylist(String playlist) {
		for(ListaDeReproduccion lista: this.biblioteca) {
			if(lista.getNombre().equals(playlist)) {
				return lista.obtenerLaCantidadDeAudios();
			}
		}
		return null;
	}

	protected abstract void deseleccionarCancionComoFavorita(Cancion cancionBuscada);

	public void agregaCancionAlHistorial(Cancion actualSonando) {
		if(!this.historial.contains(actualSonando)) {
			this.historial.add(actualSonando);
		}
		
	}

	protected abstract ListaDeReproduccion seleccionarDailymix(String nombreDailymix);

	protected abstract boolean agregarPodcast(Podcast unpod);

	protected abstract boolean agregarDailymix(ListaDeReproduccion dailymix);
	

}
