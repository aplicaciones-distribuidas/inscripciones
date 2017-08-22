package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import interfaces.AlumnosTDA;
import rmi.AlumnosManager;

public class Server {
	AlumnosTDA alumnosRemoteObject;

	public Server() {
		start();
	}

	private void start() {
		try {
			LocateRegistry.createRegistry(1099);
			alumnosRemoteObject = new AlumnosManager();
			Naming.rebind("//localhost/alumnos", alumnosRemoteObject);
			System.out.println("Binded to //localhost/alumnos");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
