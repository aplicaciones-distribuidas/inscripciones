package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.CursoDAO;
import dto.CursoView;
import excepciones.BaseDeDatosException;
import excepciones.CursoException;

public class Curso {

	private int numero;
	private Profesor profesor;
	private Materia materia;
	private String dia;
	private String turno;
	private List<Alumno> alumnos;
	private int maximo;

	public Curso(Profesor profesor, Materia materia, String dia, String turno, int maximo) {
		this.numero = 0;
		this.profesor = profesor;
		this.materia = materia;
		this.dia = dia;
		this.turno = turno;
		this.maximo = maximo;
		this.alumnos = new ArrayList<Alumno>();
	}

	public Curso(int numero, Profesor profesor, Materia materia, String dia, String turno, int maximo,
			List<Alumno> alumnos) {
		this.numero = numero;
		this.profesor = profesor;
		this.materia = materia;
		this.dia = dia;
		this.turno = turno;
		this.maximo = maximo;
		this.alumnos = alumnos;
	}

	public void save() throws BaseDeDatosException {
		CursoDAO.getInstancia().save(this);
	}

	public void anotarAlumno(Alumno alumno) throws Exception {
		if (!this.hayVacantes()) {
			throw new CursoException("No hay vacantes disponibles");
		}

		if (!alumnos.contains(alumno))
			alumnos.add(alumno);
	}

	public void eliminarAlumno(Alumno alumno) {
		if (alumnos.contains(alumno))
			alumnos.remove(alumno);
	}

	public void reasignarProfesor(Profesor profesor) {
		if (!this.profesor.soyElProfesor(profesor.getLegajo())) {
			this.profesor.removerCurso(this);
			this.profesor = profesor;
		}
	}

	public boolean hayVacantes() {
		return maximo > alumnos.size();
	}

	public boolean soyElCurso(int numero) {
		return this.numero == numero;
	}

	public List<Alumno> obtenerAlumnos() {
		return alumnos;
	}

	public int getNumero() {
		return numero;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public Materia getMateria() {
		return materia;
	}

	public String getDia() {
		return dia;
	}

	public String getTurno() {
		return turno;
	}

	public int getMaximo() {
		return maximo;
	}

	public CursoView toView() {
		return new CursoView(numero, materia.getDescripcion(), profesor.getNombre(), dia, turno,
				maximo - alumnos.size());
	}
}
