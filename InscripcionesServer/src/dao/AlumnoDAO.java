package dao;

import org.hibernate.Session;

import entities.AlumnoEntity;
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
		return new Alumno(entity.getNombre());
	}

	private AlumnoEntity toEntity(Alumno business) {
		return new AlumnoEntity(business.getLegajo(), business.getNombre());
	}

	public void save(Alumno alumno) {
		AlumnoEntity entity = this.toEntity(alumno);
		try {
			Session session = Persistencia.getInstancia().getSession();
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			// TODO: throw custom exceptions
			System.err.printf("AlumnoDAO.save failed: %s", e);
		}
	}
}
