package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alumnos")
public class AlumnoEntity implements Serializable {
	private static final long serialVersionUID = -6392238791933624213L;

	public AlumnoEntity() {
		this.legajo = null;
		this.nombre = "";
	}

	public AlumnoEntity(Integer legajo, String nombre) {
		this.legajo = legajo;
		this.nombre = nombre;
	}

	@Id
	@Column(name = "legajo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer legajo;

	@Column(name = "nombre")
	private String nombre;

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
