package rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dto.ProfesorView;
import interfaces.ProfesoresTDA;

public class ProfesoresManager extends UnicastRemoteObject implements ProfesoresTDA, Serializable {
	private static final long serialVersionUID = 4302343915032767568L;

	public ProfesoresManager() throws RemoteException {
		super();
	}

	public void agregarProfesor(ProfesorView profesor) throws RemoteException {
		// TODO: implement
	}
}
