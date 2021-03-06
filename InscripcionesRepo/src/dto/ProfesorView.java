package dto;

import java.io.Serializable;

public class ProfesorView implements Serializable {
	private static final long serialVersionUID = -4901780827687145706L;
	private int legajo;
	private String nombre;

	public ProfesorView(int legajo, String nombre) {
		this.legajo = legajo;
		this.nombre = nombre;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String toString() {
		return this.legajo + " - " + this.nombre;
	}
}
