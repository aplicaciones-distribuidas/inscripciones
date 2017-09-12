package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.AlumnoDAO;
import dto.AlumnoView;

public class Alumno {
	private int legajo;
	private String nombre;
	private List<Curso> cursos;

	public Alumno(String nombre) {
		this.legajo = 0;
		this.nombre = nombre;
		cursos = new ArrayList<Curso>();
	}

	public Alumno(int legajo, String nombre) {
		this.legajo = legajo;
		this.nombre = nombre;
		cursos = new ArrayList<Curso>();
	}

	public void save() {
		// TODO: throw exceptions
		AlumnoDAO.getInstancia().save(this);
	}

	public boolean sePuedeInscribir(Materia materia) {
		for (Curso c : cursos) {
			if (c.getMateria().equals(materia))
				return false;
		}
		return true;
	}

	public void inscripto(Curso curso) {
		if (!cursos.contains(curso))
			cursos.add(curso);
	}

	public boolean soyELAlumno(int legajo) {
		return this.legajo == legajo;
	}

	public boolean soyELAlumno(String nombre) {
		return this.nombre.equalsIgnoreCase(nombre);
	}

	public int getLegajo() {
		return legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public AlumnoView toView() {
		return new AlumnoView(legajo, nombre);
	}
}
