package excepciones;

public class AlumnoYaExisteException extends Exception {
	private static final long serialVersionUID = 1901626702360422810L;
	private static final String MESSAGE = "El alumno %s ya existe";
	private String nombre;

	public AlumnoYaExisteException(String nombre) {
		this.nombre = nombre;
	}

	public String getMessage() {
		return String.format(MESSAGE, this.nombre);
	}
}
