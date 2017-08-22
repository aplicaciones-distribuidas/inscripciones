package client;

import java.rmi.Naming;
import interfaces.AlumnosTDA;

public class Client {
	private static Client instancia;

	AlumnosTDA alumnosRemoteObject;

	private Client() {
		try {
			getStub();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Client getInstancia() {
		if (instancia == null)
			instancia = new Client();
		return instancia;
	}

	private void getStub() throws Exception {
		alumnosRemoteObject = (AlumnosTDA) Naming.lookup("//localhost/alumnos");
	}

	public AlumnosTDA getAlumnosRemoteObject() {
		return alumnosRemoteObject;
	}
}
