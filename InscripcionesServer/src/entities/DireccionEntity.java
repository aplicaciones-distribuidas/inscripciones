package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DireccionEntity implements Serializable {
	private static final long serialVersionUID = -8009407122490211072L;

	@Column(name = "calle")
	private String calle;

	@Column(name = "numero")
	private Integer numero;

	@Column(name = "codigo_postal")
	private String codigoPostal;

	@Column(name = "localidad")
	private String localidad;

	public DireccionEntity() {
		this.calle = null;
		this.numero = null;
		this.codigoPostal = null;
		this.localidad = null;
	}

	public DireccionEntity(String calle, Integer numero, String codigoPostal, String localidad) {
		this.calle = calle;
		this.numero = numero;
		this.codigoPostal = codigoPostal;
		this.localidad = localidad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calle == null) ? 0 : calle.hashCode());
		result = prime * result + ((codigoPostal == null) ? 0 : codigoPostal.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		DireccionEntity other = (DireccionEntity) obj;
		if (calle == null) {
			if (other.calle != null)
				return false;
		} else if (!calle.equals(other.calle))
			return false;
		if (codigoPostal == null) {
			if (other.codigoPostal != null)
				return false;
		} else if (!codigoPostal.equals(other.codigoPostal))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DireccionEntity [calle=" + calle + ", numero=" + numero + ", codigoPostal=" + codigoPostal
				+ ", localidad=" + localidad + "]";
	}
}
