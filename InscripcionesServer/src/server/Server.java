package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import interfaces.AlumnosTDA;
import interfaces.MateriasTDA;
import interfaces.ProfesoresTDA;
import rmi.AlumnosManager;
import rmi.MateriasManager;
import rmi.ProfesoresManager;

public class Server {
	AlumnosTDA alumnosRemoteObject;
	ProfesoresTDA profesoresRemoteObject;
	MateriasTDA materiasRemoteObject;

	public Server() {
		start();
	}

	private void start() {
		try {
			LocateRegistry.createRegistry(1099);
			alumnosRemoteObject = new AlumnosManager();
			profesoresRemoteObject = new ProfesoresManager();
			materiasRemoteObject = new MateriasManager();
			Naming.rebind("//localhost/alumnos", alumnosRemoteObject);
			Naming.rebind("//localhost/profesores", profesoresRemoteObject);
			Naming.rebind("//localhost/materias", materiasRemoteObject);
			System.out.println("Server binded to localhost");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
