package test;

import controlador.Controlador;
import server.Server;

public class Test {
	public static void main(String[] args) {
		try {
			Controlador.getInstancia().cargarDatos();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Alumnos:\n");
		for (Object o : Controlador.getInstancia().getAlumnos())
			System.out.println(o.toString());

		System.out.println("\nCursos:\n");
		for (Object o : Controlador.getInstancia().getCursos())
			System.out.println(o.toString());

		System.out.println("\nMaterias:\n");
		for (Object o : Controlador.getInstancia().getMaterias())
			System.out.println(o.toString());

		System.out.println("\nProfesores:\n");
		for (Object o : Controlador.getInstancia().getProfesores())
			System.out.println(o.toString());

		new Server();
	}
}
