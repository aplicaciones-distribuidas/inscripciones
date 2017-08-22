package negocio;

import java.util.ArrayList;
import java.util.List;

import dto.AlumnoView;

public class Alumno {

	private static int numerador;
	private int legajo;
	private String nombre;
	private List<Curso> cursos;

	public Alumno(String nombre) {
		numerador++;
		legajo = numerador;
		this.nombre = nombre;
		cursos = new ArrayList<Curso>();
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
