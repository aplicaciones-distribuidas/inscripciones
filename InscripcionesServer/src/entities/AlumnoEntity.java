package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

	@ManyToMany(mappedBy = "alumnos", fetch = FetchType.EAGER)
	private List<CursoEntity> cursos = new ArrayList<CursoEntity>();

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

	public List<CursoEntity> getCursos() {
		return cursos;
	}

	public void setCursos(List<CursoEntity> cursos) {
		this.cursos = cursos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cursos == null) ? 0 : cursos.hashCode());
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
		AlumnoEntity other = (AlumnoEntity) obj;
		if (cursos == null) {
			if (other.cursos != null)
				return false;
		} else if (!cursos.equals(other.cursos))
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
		return "AlumnoEntity [legajo=" + legajo + ", nombre=" + nombre + "]";
	}
}
