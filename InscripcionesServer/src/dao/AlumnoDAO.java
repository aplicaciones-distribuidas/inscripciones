package dao;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

import entities.AlumnoEntity;
import excepciones.AlumnoNoExisteException;
import excepciones.BaseDeDatosException;
import negocio.Alumno;
import persistencia.Persistencia;

public class AlumnoDAO {
	private static AlumnoDAO instancia;

	private AlumnoDAO() {
	}

	public static AlumnoDAO getInstancia() {
		if (instancia == null)
			instancia = new AlumnoDAO();
		return instancia;
	}

	private Alumno toBusiness(AlumnoEntity entity) {
		return new Alumno(entity.getLegajo(), entity.getNombre());
	}

	private AlumnoEntity toEntity(Alumno business) {
		return new AlumnoEntity(business.getLegajo(), business.getNombre());
	}

	public Alumno getByLegajo(int legajo) throws BaseDeDatosException, AlumnoNoExisteException {
		AlumnoEntity entity = new AlumnoEntity();
		try {
			Session session = Persistencia.getInstancia().getSession();
			session.load(entity, legajo);
			session.close();
		} catch (ObjectNotFoundException e) {
			throw new AlumnoNoExisteException(legajo);
		} catch (HibernateException e) {
			throw new BaseDeDatosException(e);
		}
		return this.toBusiness(entity);
	}

	public void save(Alumno alumno) throws BaseDeDatosException {
		AlumnoEntity entity = this.toEntity(alumno);
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
