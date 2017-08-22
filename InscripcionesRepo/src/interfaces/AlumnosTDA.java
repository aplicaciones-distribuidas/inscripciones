package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dto.AlumnoView;

public interface AlumnosTDA extends Remote {
	public void agregarAlumno(AlumnoView alumno) throws RemoteException;
}
