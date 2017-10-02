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
import javax.persistence.OneToMany;
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

	@OneToOne
	private ProfesorEntity profesor;

	@OneToOne
	private MateriaEntity materia;

	@OneToMany(fetch = FetchType.EAGER)
	private List<AlumnoEntity> alumnos;

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
}
