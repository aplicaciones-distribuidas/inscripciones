package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dto.AlumnoView;
import excepciones.BaseDeDatosException;

public interface AlumnosTDA extends Remote {
	public void agregarAlumno(AlumnoView alumno) throws BaseDeDatosException, RemoteException;
}
