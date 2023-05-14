package ar.edu.unlam.pb2.parcial1.reproductor.tdd;

public class Volumen {
	private final Integer VOLUMEN_MAXIMO=10;
	private final Integer VOLUMEN_MINIMO=0;
	private Integer volumenActual;
	
	
	
	public Integer getVolumenActual() {
		return volumenActual;
	}



	public void setVolumenActual(Integer volumenActual) {
		this.volumenActual = volumenActual;
	}



	public Boolean subirVolumen() {
		if(this.volumenActual>=VOLUMEN_MINIMO && this.volumenActual<VOLUMEN_MAXIMO) {
			this.volumenActual = this.volumenActual +1;
			return true;
		}
		return false;
	}
	

	public Boolean bajarVolumen() {
		if(this.volumenActual>VOLUMEN_MINIMO && this.volumenActual<=VOLUMEN_MAXIMO) {
			this.volumenActual = this.volumenActual -1;
			return true;
		}
		return false;
	}
			
}
