package ar.edu.unlam.pb2.parcial1.reproductor.tdd;

import java.util.ArrayList;
import java.util.HashSet;

public class Reproductor {
	private String nombre;
	private ArrayList<Usuario> usuarios;
	private HashSet<Cancion> baseDeDatosCanciones;
	private HashSet<Podcast> baseDeDatosPodcast;
	private HashSet<ListaDeReproduccion> dailyMixes;

	/*
	 * Se quizo usar hashset pero hashset "creo" que solo me permite comparar las
	 * siguientes opciones 1) this.username == other.usename; entonces el hashcode
	 * hace result = prime * result + ((username == null) ? 0 :
	 * username.hashCode());
	 * 
	 * 2) this.mail == other.mail; entonces el hashcode hace result = prime * result
	 * + ((mail == null) ? 0 : mail.hashCode())
	 * 
	 * 3) (this.username == other.username && this.mail == other.mail entonces el
	 * hashcode hace lo siguiente: result = prime * result + ((username == null) ? 0
	 * : username.hashCode()); result = prime * result + ((mail == null) ? 0 :
	 * mail.hashCode())
	 * 
	 * Pero no se pudo en nuestro caso de regla de negocio si (this.username ==
	 * other.usename) || (this.mail == other.mail); tendria que cambiar el hashcode
	 * pero no sé como
	 */
	public Reproductor(String nombre) {
		this.nombre = nombre;
		this.usuarios = new ArrayList<Usuario>();
		this.baseDeDatosCanciones = new HashSet<Cancion>();
		this.baseDeDatosPodcast = new HashSet<Podcast>();
		this.dailyMixes = new HashSet<ListaDeReproduccion>();
	}

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

	private boolean encontrarUsuarioPorMail(String mail) {
		for (int i = 0; i < this.usuarios.size(); i++) {
			if (this.usuarios.get(i) != null && usuarios.get(i).getMail().equals(mail))
				return true;
		}
		return false;
	}

	private boolean encontrarUsuarioPorUserName(String username) {
		for (int i = 0; i < this.usuarios.size(); i++) {
			if (this.usuarios.get(i) != null && this.usuarios.get(i).getUsername().equals(username))
				return true;
		}
		return false;
	}

	public Integer obtenerCantidadUsuarios() {
		return this.usuarios.size();
	}

	public Usuario buscarUsuarioRegistrado(String mailOUsername, String password) {
		for (Usuario uno : usuarios) {
			if (uno.getMail().equals(mailOUsername)|| uno.getUsername().equals(mailOUsername) && uno.getPassword().equals(password)) {
				return uno;
			}
		}
		return null;
	}

	public boolean iniciarSesion(String mailOUsername, String password) {
		Usuario userIn = this.buscarUsuarioRegistrado(mailOUsername, password);

		if (userIn != null)
			userIn.setInicioSesion(true);

		return false;
	}

}
