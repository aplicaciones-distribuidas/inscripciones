package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import dto.AlumnoView;
import dto.CursoView;
import dto.MateriaView;
import dto.ProfesorView;
import excepciones.AlumnoException;
import excepciones.CursoException;
import excepciones.MateriaException;
import excepciones.ProfesorException;
import negocio.Alumno;
import negocio.Curso;
import negocio.Materia;
import negocio.Profesor;

public class Controlador {

	private static Controlador instancia;
	private List<Alumno> alumnos;
	private List<Curso> cursos;
	private List<Materia> materias;
	private List<Profesor> profesores;

	private Controlador() {
		alumnos = new ArrayList<Alumno>();
		materias = new ArrayList<Materia>();
		profesores = new ArrayList<Profesor>();
		cursos = new ArrayList<Curso>();
	}

	public static Controlador getInstancia() {
		if (instancia == null)
			instancia = new Controlador();
		return instancia;
	}

	public void cargarDatos() throws Exception {
		cargoAlumnos();
		cargoMaterias();
		cargoProfesores();
		cargoCursos();
	}

	public void crearCurso(String codigo, int legajo, String dia, String turno, int maximo) {
		try {
			Materia materia = buscarMateria(codigo);
			Profesor profesor = buscarProfesor(legajo);
			Curso curso = new Curso(profesor, materia, dia, turno, maximo);
			profesor.agregarCurso(curso);
			cursos.add(curso);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void inscribirAlumno(int legajo, int numero) {
		try {
			Curso curso = buscarCurso(numero);
			Alumno alumno = buscarAlumno(legajo);
			curso.anotarAlumno(alumno);
			alumno.inscripto(curso);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void reasignarDocente(int numero, int legajo) {
		try {
			Curso curso = buscarCurso(numero);
			Profesor profesor = buscarProfesor(legajo);
			curso.reasignarProfesor(profesor);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public List<AlumnoView> getAlumnos() {
		List<AlumnoView> resultado = new ArrayList<AlumnoView>();
		for (Alumno a : alumnos)
			resultado.add(a.toView());
		return resultado;
	}

	public void agregarAlumno(String nombre) {
		if (!isAlumnoPorNombre(nombre)) {
			Alumno a = new Alumno(nombre);
			alumnos.add(a);
		}
		// else
		// JOptionPane.showInternalMessageDialog(null, "El alumno " + nombre + " ya
		// existe");
	}

	public List<CursoView> getCursos() {
		List<CursoView> resultado = new ArrayList<CursoView>();
		for (Curso c : cursos)
			resultado.add(c.toView());
		return resultado;
	}

	public List<MateriaView> getMaterias() {
		List<MateriaView> resultado = new ArrayList<MateriaView>();
		for (Materia m : materias)
			resultado.add(m.toView());
		return resultado;
	}

	public List<ProfesorView> getProfesores() {
		List<ProfesorView> resultado = new ArrayList<ProfesorView>();
		for (Profesor p : profesores) {
			resultado.add(p.toView());
		}
		return resultado;
	}

	private Alumno buscarAlumno(int legajo) throws Exception {
		for (Alumno a : alumnos)
			if (a.soyELAlumno(legajo))
				return a;
		throw new AlumnoException("El alumno no existe");
	}

	private boolean isAlumnoPorNombre(String nombre) {
		for (Alumno a : alumnos)
			if (a.soyELAlumno(nombre))
				return true;
		return false;
	}

	private Curso buscarCurso(int numero) throws Exception {
		for (Curso c : cursos)
			if (c.soyElCurso(numero))
				return c;
		throw new CursoException("El curso no existe");
	}

	private Materia buscarMateria(String codigo) throws Exception {
		for (Materia m : materias)
			if (m.soyLaMateria(codigo))
				return m;
		throw new MateriaException("La materia no existe");
	}

	private Profesor buscarProfesor(int legajo) throws Exception {
		for (Profesor p : profesores)
			if (p.soyElProfesor(legajo))
				return p;
		throw new ProfesorException("El profesor no existe");
	}

	private void cargoMaterias() {
		Materia m = new Materia("M001", "Materia I");
		materias.add(m);
		m = new Materia("M002", "Materia II");
		materias.add(m);
		m = new Materia("M003", "Materia III");
		materias.add(m);
		m = new Materia("M004", "Materia IV");
		materias.add(m);
		m = new Materia("M005", "Materia V");
		materias.add(m);
		m = new Materia("M006", "Materia VI");
		materias.add(m);
		m = new Materia("M007", "Materia VII");
		materias.add(m);
		m = new Materia("M008", "Materia VII");
		materias.add(m);
		m = new Materia("M009", "Materia IX");
		materias.add(m);
		m = new Materia("M010", "Materia X");
		materias.add(m);
	}

	private void cargoAlumnos() {
		Alumno a = new Alumno("Alumno I");
		alumnos.add(a);
		a = new Alumno("Alumno II");
		alumnos.add(a);
		a = new Alumno("Alumno III");
		alumnos.add(a);
		a = new Alumno("Alumno IV");
		alumnos.add(a);
		a = new Alumno("Alumno V");
		alumnos.add(a);
		a = new Alumno("Alumno VI");
		alumnos.add(a);
		a = new Alumno("Alumno VII");
		alumnos.add(a);
		a = new Alumno("Alumno VIII");
		alumnos.add(a);
		a = new Alumno("Alumno IX");
		alumnos.add(a);
		a = new Alumno("Alumno X");
		alumnos.add(a);
		a = new Alumno("Alumno XI");
		alumnos.add(a);
		a = new Alumno("Alumno XII");
		alumnos.add(a);
		a = new Alumno("Alumno XIII");
		alumnos.add(a);
		a = new Alumno("Alumno XIV");
		alumnos.add(a);
		a = new Alumno("Alumno XV");
		alumnos.add(a);
	}

	private void cargoProfesores() {
		Profesor p = new Profesor(1, "Profesor I", "Calle I", 101, "CP CI", "Localidad I");
		profesores.add(p);
		p = new Profesor(2, "Profesor I", "Calle II", 102, "CP CII", "Localidad II");
		profesores.add(p);
		p = new Profesor(3, "Profesor I", "Calle III", 103, "CP CIII", "Localidad III");
		profesores.add(p);
		p = new Profesor(4, "Profesor I", "Calle IV", 104, "CP CIV", "Localidad IV");
		profesores.add(p);
		p = new Profesor(5, "Profesor I", "Calle V", 105, "CP CV", "Localidad V");
		profesores.add(p);
		p = new Profesor(6, "Profesor I", "Calle VI", 106, "CP CVI", "Localidad VI");
		profesores.add(p);
		p = new Profesor(7, "Profesor I", "Calle VII", 107, "CP CVII", "Localidad VII");
		profesores.add(p);
		p = new Profesor(8, "Profesor I", "Calle VIII", 108, "CP CVIII", "Localidad VIII");
		profesores.add(p);
		p = new Profesor(9, "Profesor I", "Calle IX", 109, "CP CIX", "Localidad IX");
		profesores.add(p);
		p = new Profesor(10, "Profesor X", "Calle X", 110, "CP CX", "Localidad X");
		profesores.add(p);
	}

	private void cargoCursos() throws Exception {
		Profesor p = buscarProfesor(2);
		Materia m = buscarMateria("M002");
		Curso c = new Curso(p, m, "Lunes", "Ma�ana", 10);
		cursos.add(c);
		p = buscarProfesor(3);
		m = buscarMateria("M004");
		c = new Curso(p, m, "Martes", "Ma�ana", 12);
		cursos.add(c);
		p = buscarProfesor(1);
		m = buscarMateria("M001");
		c = new Curso(p, m, "Martes", "Tarde", 15);
		cursos.add(c);
		p = buscarProfesor(1);
		m = buscarMateria("M001");
		c = new Curso(p, m, "Jueves", "Ma�ana", 12);
		cursos.add(c);
		p = buscarProfesor(3);
		m = buscarMateria("M010");
		c = new Curso(p, m, "Viernes", "Noche", 12);
		cursos.add(c);
	}
}
