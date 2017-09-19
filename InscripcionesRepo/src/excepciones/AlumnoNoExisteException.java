package excepciones;

public class AlumnoNoExisteException extends Exception {
	private static final long serialVersionUID = 4408372505918592018L;
	private static final String MESSAGE = "El alumno %d no existe";
	private int legajo;

	public AlumnoNoExisteException(int legajo) {
		this.legajo = legajo;
	}

	public String getMessage() {
		return String.format(MESSAGE, this.legajo);
	}
}
