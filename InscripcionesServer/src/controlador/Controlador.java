package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import dao.AlumnoDAO;
import dao.CursoDAO;
import dao.MateriaDAO;
import dao.ProfesorDAO;
import dto.AlumnoView;
import dto.CursoView;
import dto.MateriaView;
import dto.ProfesorView;
import excepciones.AlumnoNoExisteException;
import excepciones.BaseDeDatosException;
import excepciones.CursoNoExisteException;
import excepciones.MateriaNoExisteException;
import excepciones.ProfesorNoExisteException;
import negocio.Alumno;
import negocio.Curso;
import negocio.Materia;
import negocio.Profesor;

public class Controlador {
	private static Controlador instancia;

	private Controlador() {
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

	public void crearCurso(String codigo, int legajo, String dia, String turno, int maximo)
			throws BaseDeDatosException, MateriaNoExisteException, ProfesorNoExisteException {
		Materia materia = buscarMateria(codigo);
		Profesor profesor = buscarProfesor(legajo);
		Curso curso = new Curso(profesor, materia, dia, turno, maximo);
		curso.save();
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

	public List<AlumnoView> getAlumnos() throws BaseDeDatosException {
		List<Alumno> alumnos = AlumnoDAO.getInstancia().getAll();
		List<AlumnoView> resultado = new ArrayList<AlumnoView>();
		for (Alumno alumno : alumnos)
			resultado.add(alumno.toView());
		return resultado;
	}

	public void agregarAlumno(String nombre) throws BaseDeDatosException {
		Alumno alumno = new Alumno(nombre);
		alumno.save();
	}

	public List<CursoView> getCursos() throws BaseDeDatosException {
		List<Curso> cursos = CursoDAO.getInstancia().getAll();
		List<CursoView> resultado = new ArrayList<CursoView>();
		for (Curso c : cursos)
			resultado.add(c.toView());
		return resultado;
	}

	public List<MateriaView> getMaterias() throws BaseDeDatosException {
		List<Materia> materias = MateriaDAO.getInstancia().getAll();
		List<MateriaView> resultado = new ArrayList<MateriaView>();
		for (Materia m : materias)
			resultado.add(m.toView());
		return resultado;
	}

	public List<ProfesorView> getProfesores() throws BaseDeDatosException {
		List<Profesor> profesores = ProfesorDAO.getInstancia().getAll();
		List<ProfesorView> resultado = new ArrayList<ProfesorView>();
		for (Profesor p : profesores) {
			resultado.add(p.toView());
		}
		return resultado;
	}

	private Alumno buscarAlumno(int legajo) throws BaseDeDatosException, AlumnoNoExisteException {
		return AlumnoDAO.getInstancia().getByLegajo(legajo);
	}

	private boolean isAlumnoPorNombre(String nombre) throws BaseDeDatosException {
		try {
			AlumnoDAO.getInstancia().getByNombre(nombre);
		} catch (AlumnoNoExisteException e) {
			return false;
		}
		return true;
	}

	private Curso buscarCurso(int numero) throws BaseDeDatosException, CursoNoExisteException {
		return CursoDAO.getInstancia().getByNumero(numero);
	}

	private Materia buscarMateria(String codigo) throws BaseDeDatosException, MateriaNoExisteException {
		return MateriaDAO.getInstancia().getByCodigo(codigo);
	}

	private Profesor buscarProfesor(int legajo) throws BaseDeDatosException, ProfesorNoExisteException {
		return ProfesorDAO.getInstancia().getByLegajo(legajo);
	}

	private void cargoMaterias() throws BaseDeDatosException {
		Materia m = new Materia("M001", "Materia I");
		m.save();
		m = new Materia("M002", "Materia II");
		m.save();
		m = new Materia("M003", "Materia III");
		m.save();
		m = new Materia("M004", "Materia IV");
		m.save();
		m = new Materia("M005", "Materia V");
		m.save();
		m = new Materia("M006", "Materia VI");
		m.save();
		m = new Materia("M007", "Materia VII");
		m.save();
		m = new Materia("M008", "Materia VII");
		m.save();
		m = new Materia("M009", "Materia IX");
		m.save();
		m = new Materia("M010", "Materia X");
		m.save();
	}

	private void cargoAlumnos() throws BaseDeDatosException {
		Alumno a = new Alumno("Alumno I");
		a.save();
		a = new Alumno("Alumno II");
		a.save();
		a = new Alumno("Alumno III");
		a.save();
		a = new Alumno("Alumno IV");
		a.save();
		a = new Alumno("Alumno V");
		a.save();
		a = new Alumno("Alumno VI");
		a.save();
		a = new Alumno("Alumno VII");
		a.save();
		a = new Alumno("Alumno VIII");
		a.save();
		a = new Alumno("Alumno IX");
		a.save();
		a = new Alumno("Alumno X");
		a.save();
		a = new Alumno("Alumno XI");
		a.save();
		a = new Alumno("Alumno XII");
		a.save();
		a = new Alumno("Alumno XIII");
		a.save();
		a = new Alumno("Alumno XIV");
		a.save();
		a = new Alumno("Alumno XV");
		a.save();
	}

	private void cargoProfesores() throws BaseDeDatosException {
		Profesor p = new Profesor(1, "Profesor I", "Calle I", 101, "CP CI", "Localidad I");
		p.save();
		p = new Profesor(2, "Profesor I", "Calle II", 102, "CP CII", "Localidad II");
		p.save();
		p = new Profesor(3, "Profesor I", "Calle III", 103, "CP CIII", "Localidad III");
		p.save();
		p = new Profesor(4, "Profesor I", "Calle IV", 104, "CP CIV", "Localidad IV");
		p.save();
		p = new Profesor(5, "Profesor I", "Calle V", 105, "CP CV", "Localidad V");
		p.save();
		p = new Profesor(6, "Profesor I", "Calle VI", 106, "CP CVI", "Localidad VI");
		p.save();
		p = new Profesor(7, "Profesor I", "Calle VII", 107, "CP CVII", "Localidad VII");
		p.save();
		p = new Profesor(8, "Profesor I", "Calle VIII", 108, "CP CVIII", "Localidad VIII");
		p.save();
		p = new Profesor(9, "Profesor I", "Calle IX", 109, "CP CIX", "Localidad IX");
		p.save();
		p = new Profesor(10, "Profesor X", "Calle X", 110, "CP CX", "Localidad X");
		p.save();
	}

	private void cargoCursos() throws Exception {
		Profesor p = buscarProfesor(2);
		Materia m = buscarMateria("M002");
		Curso c = new Curso(p, m, "Lunes", "Mañana", 10);
		c.anotarAlumno(buscarAlumno(1));
		c.anotarAlumno(buscarAlumno(2));
		c.anotarAlumno(buscarAlumno(3));
		c.save();
		p = buscarProfesor(3);
		m = buscarMateria("M004");
		c = new Curso(p, m, "Martes", "Mañana", 12);
		c.save();
		p = buscarProfesor(1);
		m = buscarMateria("M001");
		c = new Curso(p, m, "Martes", "Tarde", 15);
		c.save();
		p = buscarProfesor(1);
		m = buscarMateria("M001");
		c = new Curso(p, m, "Jueves", "Mañana", 12);
		c.save();
		p = buscarProfesor(3);
		m = buscarMateria("M010");
		c = new Curso(p, m, "Viernes", "Noche", 12);
		c.save();
	}
}
