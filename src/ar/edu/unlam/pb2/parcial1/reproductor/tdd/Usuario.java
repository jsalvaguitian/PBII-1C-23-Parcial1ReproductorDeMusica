package ar.edu.unlam.pb2.parcial1.reproductor.tdd;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

public abstract class Usuario {
	private String username;
	private String mail;
	private String password;
	protected LocalDate fechaDeNacimiento;
	protected Boolean inicioSesion;
	protected HashSet<ListaDeReproduccion> biblioteca;
	
	
	public Usuario(String username, String mail, String password, Integer dia, Integer mes, Integer anio) {
		if(esValidoElMail(mail) && esValidoLaContrasenia(password) && esValidoLaFecha(dia, mes, anio)) {
			this.username = username;
			this.mail = mail;
			this.password = password;
			this.fechaDeNacimiento = LocalDate.of(anio,mes,dia);
			this.inicioSesion = false;
			this.biblioteca = new HashSet<ListaDeReproduccion>();	
		}
		
	}
	
	/* Cosas a tener en cuenta:
	 * El mail debe tener un solo @
	 * El mail debe tener al menos un punto
	 * */
	public static Boolean esValidoElMail(String mail) {
		Boolean exitoso = false;
		int contadorArroba = 0;
		Boolean tienePunto = mail.contains(".");
		
		char[] mailArray = mail.toCharArray();
		
		for(int i=0; i< mailArray.length; i++) {
			if(mailArray[i] == '@')
				contadorArroba++;
		}
				
		if(tienePunto && contadorArroba == 1)
			exitoso = true;
		
		return exitoso; 
	}

	/*A Terminar */
	public static Boolean esValidoLaContrasenia(String password) {
		return true; 
	}

	/*Cualquier año divisible por 4 es un año bisiesto
	 * Año que tiene 366 días en lugar de 365, en el que febrero tiene 29 días en lugar de 28; 
	 * se repite cada cuatro años, excepto cuando el año acaba en dos ceros.
	 * No usar excepciones
	 * Hay cosas que no se pudo considerar si es calendario gregoriano o no pero
	 * sí se pudo considerar el año bisiesto
	 * */
	public static Boolean esValidoLaFecha(Integer dia, Integer mes, Integer anio) {
		String anioCaracter = String.valueOf(anio);
		
		if(anioCaracter.length() == 4) {
			Integer calendar[] = obtenerCalendario(anio);
			
			for(int i=0;i<calendar.length; i++) {
				if(mes == i+1) {
					if(dia>=1 && dia<=calendar[i])
						return true;
				}
			}	
		}
		
		return false;
	}
	
	private static Integer[] obtenerCalendario(Integer anio) {
		Integer calendarGeneral[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		Integer calendarBisiesto[] = {31,29,31,30,31,30,31,31,30,31,30,31};
		String anioCaracter = String.valueOf(anio);
		
		if(anio % 4 == 0 &&  !(anioCaracter.substring(2).equals("00"))) {
			return calendarBisiesto;
			
		}
	
		else
			return calendarGeneral;
	}
	
	public Boolean esValidoUsuario() {
		if(username!=null && mail!=null && password!=null && fechaDeNacimiento!=null && inicioSesion !=null && biblioteca!=null)
			return true;
		return false;
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

	public HashSet<ListaDeReproduccion> getBiblioteca() {
		return biblioteca;
	}

	public void setInicioSesion(Boolean inicioSesion) {
		this.inicioSesion = inicioSesion;
	}
	

}
