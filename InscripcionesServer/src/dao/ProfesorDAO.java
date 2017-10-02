package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

import entities.ProfesorEntity;
import excepciones.BaseDeDatosException;
import excepciones.ProfesorNoExisteException;
import negocio.Profesor;
import persistencia.Persistencia;

public class ProfesorDAO {
	private static ProfesorDAO instancia;

	private ProfesorDAO() {
	}

	public static ProfesorDAO getInstancia() {
		if (instancia == null)
			instancia = new ProfesorDAO();
		return instancia;
	}

	private Profesor toBusiness(ProfesorEntity entity) {
		return new Profesor(entity.getLegajo(), entity.getNombre(), entity.getDireccion().getCalle(),
				entity.getDireccion().getNumero(), entity.getDireccion().getCodigoPostal(),
				entity.getDireccion().getLocalidad());
	}

	private List<Profesor> toBusiness(List<ProfesorEntity> entities) {
		List<Profesor> business = new ArrayList<Profesor>();
		for (ProfesorEntity entity : entities) {
			business.add(this.toBusiness(entity));
		}
		return business;
	}

	private ProfesorEntity toEntity(Profesor business) {
		return new ProfesorEntity(business.getLegajo(), business.getNombre(), business.getDireccion());
	}

	@SuppressWarnings("unchecked")
	public List<Profesor> getAll() throws BaseDeDatosException {
		List<ProfesorEntity> all = new ArrayList<ProfesorEntity>();
		try {
			Session session = Persistencia.getInstancia().getSession();
			all = session.createQuery("from ProfesorEntity").list();
			session.close();
		} catch (HibernateException e) {
			throw new BaseDeDatosException(e);
		}
		return this.toBusiness(all);
	}

	public Profesor getByLegajo(int legajo) throws BaseDeDatosException, ProfesorNoExisteException {
		ProfesorEntity entity = new ProfesorEntity();
		try {
			Session session = Persistencia.getInstancia().getSession();
			session.load(entity, legajo);
			session.close();
		} catch (ObjectNotFoundException e) {
			throw new ProfesorNoExisteException(legajo);
		} catch (HibernateException e) {
			throw new BaseDeDatosException(e);
		}
		return this.toBusiness(entity);
	}

	public void save(Profesor profesor) throws BaseDeDatosException {
		ProfesorEntity entity = this.toEntity(profesor);
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
