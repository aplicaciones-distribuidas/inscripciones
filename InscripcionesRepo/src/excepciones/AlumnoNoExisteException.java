package excepciones;

public class AlumnoNoExisteException extends Exception {
	private static final long serialVersionUID = 4408372505918592018L;
	private static final String MESSAGE_LEGAJO = "El alumno %d no existe";
	private static final String MESSAGE_NOMBRE = "El alumno %s no existe";
	private int legajo;
	private String nombre;

	public AlumnoNoExisteException(int legajo) {
		this.legajo = legajo;
	}

	public AlumnoNoExisteException(String nombre) {
		this.nombre = nombre;
	}

	public String getMessage() {
		if (nombre.length() > 0) {
			return String.format(MESSAGE_NOMBRE, this.nombre);
		}
		return String.format(MESSAGE_LEGAJO, this.legajo);
	}
}
