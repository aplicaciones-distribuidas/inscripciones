package rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import controlador.Controlador;
import dto.AlumnoView;
import excepciones.AlumnoYaExisteException;
import interfaces.AlumnosTDA;

public class AlumnosManager extends UnicastRemoteObject implements AlumnosTDA, Serializable {
	public AlumnosManager() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 3548218673814294625L;

	public void agregarAlumno(AlumnoView alumno) throws AlumnoYaExisteException {
		Controlador.getInstancia().agregarAlumno(alumno.getNombre());
		System.out.println("Alumno agregado: " + alumno.getNombre()); // TODO: remove
	}
}
