package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import negocio.Direccion;

@Entity
@Table(name = "profesores")
public class ProfesorEntity implements Serializable {
	private static final long serialVersionUID = 6699998442627267962L;

	public ProfesorEntity() {
		this.legajo = null;
		this.nombre = null;
		this.direccion = null;
	}

	public ProfesorEntity(Integer legajo, String nombre, Direccion direccion) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.direccion = new DireccionEntity(direccion.getCalle(), direccion.getNumero(), direccion.getCodigoPostal(),
				direccion.getLocalidad());
	}

	@Id
	@Column(name = "legajo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer legajo;

	@Column(name = "nombre")
	private String nombre;

	@Embedded
	private DireccionEntity direccion;

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

	public DireccionEntity getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionEntity direccion) {
		this.direccion = direccion;
	}
}
