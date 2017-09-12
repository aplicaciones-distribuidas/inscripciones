package dto;

import java.io.Serializable;

public class AlumnoView implements Serializable {
	private static final long serialVersionUID = -7716280088967048996L;
	private int legajo;
	private String nombre;

	public AlumnoView() {
		this.legajo = 0;
		this.nombre = "";
	}

	public AlumnoView(String nombre) {
		this.legajo = 0;
		this.nombre = nombre;
	}

	public AlumnoView(int legajo, String nombre) {
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
