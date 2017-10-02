package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

import entities.AlumnoEntity;
import entities.CursoEntity;
import excepciones.BaseDeDatosException;
import excepciones.CursoNoExisteException;
import negocio.Alumno;
import negocio.Curso;
import negocio.Materia;
import negocio.Profesor;
import persistencia.Persistencia;

public class CursoDAO {
	private static CursoDAO instancia;

	private CursoDAO() {
	}

	public static CursoDAO getInstancia() {
		if (instancia == null)
			instancia = new CursoDAO();
		return instancia;
	}

	private Curso toBusiness(CursoEntity entity) {
		Profesor profesor = new Profesor(entity.getProfesor().getLegajo(), entity.getProfesor().getNombre(),
				entity.getProfesor().getDireccion().getCalle(), entity.getProfesor().getDireccion().getNumero(),
				entity.getProfesor().getDireccion().getCodigoPostal(),
				entity.getProfesor().getDireccion().getLocalidad());

		Materia materia = new Materia(entity.getMateria().getCodigo(), entity.getMateria().getDescripcion());

		List<Alumno> alumnos = new ArrayList<Alumno>();
		for (AlumnoEntity alumno : entity.getAlumnos()) {
			alumnos.add(new Alumno(alumno.getLegajo(), alumno.getNombre()));
		}

		return new Curso(entity.getNumero(), profesor, materia, entity.getDia(), entity.getTurno(), entity.getMaximo(),
				alumnos);
	}

	private List<Curso> toBusiness(List<CursoEntity> entities) {
		List<Curso> business = new ArrayList<Curso>();
		for (CursoEntity entity : entities) {
			business.add(this.toBusiness(entity));
		}
		return business;
	}

	private CursoEntity toEntity(Curso business) {
		return new CursoEntity(business.getNumero(), business.getDia(), business.getTurno(), business.getMaximo(),
				business.getProfesor(), business.getMateria(), business.obtenerAlumnos());
	}

	@SuppressWarnings("unchecked")
	public List<Curso> getAll() throws BaseDeDatosException {
		List<CursoEntity> all = new ArrayList<CursoEntity>();
		try {
			Session session = Persistencia.getInstancia().getSession();
			all = session.createQuery("from CursoEntity").list();
			session.close();
		} catch (HibernateException e) {
			throw new BaseDeDatosException(e);
		}
		return this.toBusiness(all);
	}

	public Curso getByNumero(int numero) throws BaseDeDatosException, CursoNoExisteException {
		CursoEntity entity = new CursoEntity();
		try {
			Session session = Persistencia.getInstancia().getSession();
			session.load(entity, numero);
			session.close();
		} catch (ObjectNotFoundException e) {
			throw new CursoNoExisteException(numero);
		} catch (HibernateException e) {
			throw new BaseDeDatosException(e);
		}
		return this.toBusiness(entity);
	}

	public void save(Curso curso) throws BaseDeDatosException {
		CursoEntity entity = this.toEntity(curso);
		try {
			Session session = Persistencia.getInstancia().getSession();
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			throw new BaseDeDatosException(e);
		}
	}
}
