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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((legajo == null) ? 0 : legajo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfesorEntity other = (ProfesorEntity) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (legajo == null) {
			if (other.legajo != null)
				return false;
		} else if (!legajo.equals(other.legajo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProfesorEntity [legajo=" + legajo + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
}
