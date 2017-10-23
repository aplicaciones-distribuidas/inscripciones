package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dto.MateriaView;

public interface MateriasTDA extends Remote {
	public void agregarMateria(MateriaView materia) throws RemoteException;
}
