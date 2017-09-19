package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import excepciones.BaseDeDatosException;

public class Persistencia {
	private static Persistencia instancia;
	private SessionFactory sessionFactory;

	private Persistencia() throws BaseDeDatosException {
		this.sessionFactory = buildSessionFactory();
	}

	public static Persistencia getInstancia() throws BaseDeDatosException {
		if (instancia == null)
			instancia = new Persistencia();
		return instancia;
	}

	private SessionFactory buildSessionFactory() throws BaseDeDatosException {
		try {
			return new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
		} catch (Exception ex) {
			throw new BaseDeDatosException(ex);
		}
	}

	public Session getSession() {
		return this.sessionFactory.openSession();
	}
}
