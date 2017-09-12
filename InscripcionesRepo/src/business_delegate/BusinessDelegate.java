package business_delegate;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dto.AlumnoView;
import excepciones.AlumnoYaExisteException;
import excepciones.ConexionException;
import interfaces.AlumnosTDA;

public class BusinessDelegate {
	private static BusinessDelegate instancia;

	AlumnosTDA alumnosRemoteObject;

	private BusinessDelegate() throws ConexionException {
		try {
			alumnosRemoteObject = (AlumnosTDA) Naming.lookup("//localhost/alumnos");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
			throw new ConexionException();
		}
	}

	public static BusinessDelegate getInstancia() throws ConexionException {
		if (instancia == null)
			instancia = new BusinessDelegate();
		return instancia;
	}

	public void agregarAlumno(String nombre) throws ConexionException, AlumnoYaExisteException {
		AlumnoView alumno = new AlumnoView(nombre);

		try {
			alumnosRemoteObject.agregarAlumno(alumno);
		} catch (RemoteException e) {
			e.printStackTrace();
			throw new ConexionException();
		}
	}
}
