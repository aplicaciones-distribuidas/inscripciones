package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import excepciones.ConexionException;

public class Persistencia {
	private static Persistencia instancia;
	private SessionFactory sessionFactory;

	private Persistencia() throws ConexionException {
		this.sessionFactory = buildSessionFactory();
	}

	public static Persistencia getInstancia() throws ConexionException {
		if (instancia == null)
			instancia = new Persistencia();
		return instancia;
	}

	private SessionFactory buildSessionFactory() throws ConexionException {
		try {
			return new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("SessionFactory creation failed: " + ex);
			throw new ConexionException();
		}
	}

	public Session getSession() {
		return this.sessionFactory.openSession();
	}
}
