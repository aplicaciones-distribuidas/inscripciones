package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import negocio.Alumno;
import negocio.Materia;
import negocio.Profesor;

@Entity
@Table(name = "cursos")
public class CursoEntity implements Serializable {
	private static final long serialVersionUID = 3990302587264969529L;

	public CursoEntity() {
		this.numero = null;
		this.dia = null;
		this.turno = null;
		this.maximo = null;
		this.profesor = null;
		this.materia = null;
		this.alumnos = new ArrayList<AlumnoEntity>();
	}

	public CursoEntity(Integer numero, String dia, String turno, Integer maximo, Profesor profesor, Materia materia,
			List<Alumno> alumnos) {
		this.numero = numero;
		this.dia = dia;
		this.turno = turno;
		this.maximo = maximo;
		this.profesor = new ProfesorEntity(profesor.getLegajo(), profesor.getNombre(), profesor.getDireccion());
		this.materia = new MateriaEntity(materia.getCodigo(), materia.getDescripcion(), materia.isHabilitada());
		this.alumnos = new ArrayList<AlumnoEntity>();
		for (Alumno alumno : alumnos) {
			this.alumnos.add(new AlumnoEntity(alumno.getLegajo(), alumno.getNombre()));
		}
	}

	@Id
	@Column(name = "numero")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;

	@Column(name = "dia")
	private String dia;

	@Column(name = "turno")
	private String turno;

	@Column(name = "maximo")
	private Integer maximo;

	@ManyToOne
	@JoinColumn(name = "profesor_legajo")
	private ProfesorEntity profesor;

	@OneToOne
	@JoinColumn(name = "materia_codigo")
	private MateriaEntity materia;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "cursos_alumnos", joinColumns = { @JoinColumn(name = "curso_numero") }, inverseJoinColumns = {
			@JoinColumn(name = "alumno_legajo") })
	private List<AlumnoEntity> alumnos = new ArrayList<AlumnoEntity>();

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Integer getMaximo() {
		return maximo;
	}

	public void setMaximo(Integer maximo) {
		this.maximo = maximo;
	}

	public ProfesorEntity getProfesor() {
		return profesor;
	}

	public void setProfesor(ProfesorEntity profesor) {
		this.profesor = profesor;
	}

	public MateriaEntity getMateria() {
		return materia;
	}

	public void setMateria(MateriaEntity materia) {
		this.materia = materia;
	}

	public List<AlumnoEntity> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<AlumnoEntity> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumnos == null) ? 0 : alumnos.hashCode());
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((materia == null) ? 0 : materia.hashCode());
		result = prime * result + ((maximo == null) ? 0 : maximo.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
		result = prime * result + ((turno == null) ? 0 : turno.hashCode());
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
		CursoEntity other = (CursoEntity) obj;
		if (alumnos == null) {
			if (other.alumnos != null)
				return false;
		} else if (!alumnos.equals(other.alumnos))
			return false;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (materia == null) {
			if (other.materia != null)
				return false;
		} else if (!materia.equals(other.materia))
			return false;
		if (maximo == null) {
			if (other.maximo != null)
				return false;
		} else if (!maximo.equals(other.maximo))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		if (turno == null) {
			if (other.turno != null)
				return false;
		} else if (!turno.equals(other.turno))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CursoEntity [numero=" + numero + ", dia=" + dia + ", turno=" + turno + ", maximo=" + maximo
				+ ", profesor=" + profesor + ", materia=" + materia + ", alumnos=" + alumnos + "]";
	}
}
