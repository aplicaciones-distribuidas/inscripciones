package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "materias")
public class MateriaEntity implements Serializable {
	private static final long serialVersionUID = -4194737709929965068L;

	public MateriaEntity() {
		this.codigo = null;
		this.descripcion = null;
		this.habilitada = null;
	}

	public MateriaEntity(String codigo, String descripcion, Boolean habilitada) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.habilitada = habilitada;
	}

	@Id
	@Column(name = "codigo")
	private String codigo;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "habilitada")
	private Boolean habilitada;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getHabilitada() {
		return habilitada;
	}

	public void setHabilitada(Boolean habilitada) {
		this.habilitada = habilitada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((habilitada == null) ? 0 : habilitada.hashCode());
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
		MateriaEntity other = (MateriaEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (habilitada == null) {
			if (other.habilitada != null)
				return false;
		} else if (!habilitada.equals(other.habilitada))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MateriaEntity [codigo=" + codigo + ", descripcion=" + descripcion + ", habilitada=" + habilitada + "]";
	}
}
