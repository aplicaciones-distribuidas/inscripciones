package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

import entities.MateriaEntity;
import excepciones.BaseDeDatosException;
import excepciones.MateriaNoExisteException;
import negocio.Materia;
import persistencia.Persistencia;

public class MateriaDAO {
	private static MateriaDAO instancia;

	private MateriaDAO() {
	}

	public static MateriaDAO getInstancia() {
		if (instancia == null)
			instancia = new MateriaDAO();
		return instancia;
	}

	private Materia toBusiness(MateriaEntity entity) {
		return new Materia(entity.getCodigo(), entity.getDescripcion(), entity.getHabilitada());
	}

	private List<Materia> toBusiness(List<MateriaEntity> entities) {
		List<Materia> business = new ArrayList<Materia>();
		for (MateriaEntity entity : entities) {
			business.add(this.toBusiness(entity));
		}
		return business;
	}

	private MateriaEntity toEntity(Materia business) {
		return new MateriaEntity(business.getCodigo(), business.getDescripcion(), business.isHabilitada());
	}

	@SuppressWarnings("unchecked")
	public List<Materia> getAll() throws BaseDeDatosException {
		List<MateriaEntity> all = new ArrayList<MateriaEntity>();
		try {
			Session session = Persistencia.getInstancia().getSession();
			all = session.createQuery("from MateriaEntity").list();
			session.close();
		} catch (HibernateException e) {
			throw new BaseDeDatosException(e);
		}
		return this.toBusiness(all);
	}

	public Materia getByCodigo(String codigo) throws BaseDeDatosException, MateriaNoExisteException {
		MateriaEntity entity = new MateriaEntity();
		try {
			Session session = Persistencia.getInstancia().getSession();
			session.load(entity, codigo);
			session.close();
		} catch (ObjectNotFoundException e) {
			throw new MateriaNoExisteException(codigo);
		} catch (HibernateException e) {
			throw new BaseDeDatosException(e);
		}
		return this.toBusiness(entity);
	}

	public void save(Materia materia) throws BaseDeDatosException {
		MateriaEntity entity = this.toEntity(materia);
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
