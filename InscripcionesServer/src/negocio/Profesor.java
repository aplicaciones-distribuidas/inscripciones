package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.ProfesorDAO;
import dto.ProfesorView;
import excepciones.BaseDeDatosException;

public class Profesor {

	private int legajo;
	private String nombre;
	private Direccion direccion;
	private List<Materia> materias;
	private List<Curso> cursos;

	public Profesor(int legajo, String nombre, String calle, int numero, String codigoPostal, String localidad) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.direccion = new Direccion(calle, numero, codigoPostal, localidad);
		this.materias = new ArrayList<Materia>();
		this.cursos = new ArrayList<Curso>();
	}

	public void save() throws BaseDeDatosException {
		ProfesorDAO.getInstancia().save(this);
	}

	public void agregarMateria(Materia materia) {
		if (!materias.contains(materia))
			materias.add(materia);
	}

	public void eliminarMateria(Materia materia) {
		if (materias.contains(materia))
			materias.remove(materia);
	}

	public void agregarCurso(Curso curso) {
		if (!cursos.contains(curso))
			cursos.add(curso);
	}

	public void removerCurso(Curso curso) {
		if (!cursos.contains(curso))
			cursos.add(curso);
	}

	public boolean disponible(String dia, String turno) {
		for (Curso c : cursos) {
			if (c.getDia().equals(dia) && c.getTurno().equals(turno))
				return false;
		}
		return true;
	}

	public boolean soyElProfesor(int legajo) {
		return this.legajo == legajo;
	}

	public int getLegajo() {
		return legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public ProfesorView toView() {
		return new ProfesorView(legajo, nombre);
	}
}
