package rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dto.MateriaView;
import interfaces.MateriasTDA;

public class MateriasManager extends UnicastRemoteObject implements MateriasTDA, Serializable {
	private static final long serialVersionUID = 3904689317290212565L;

	public MateriasManager() throws RemoteException {
		super();
	}

	public void agregarMateria(MateriaView materia) throws RemoteException {
		// TODO: implement
	}
}
