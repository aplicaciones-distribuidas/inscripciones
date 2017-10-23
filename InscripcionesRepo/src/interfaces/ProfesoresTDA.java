package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dto.ProfesorView;

public interface ProfesoresTDA extends Remote {
	public void agregarProfesor(ProfesorView profesor) throws RemoteException;
}
