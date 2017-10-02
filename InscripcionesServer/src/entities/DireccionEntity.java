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
}
