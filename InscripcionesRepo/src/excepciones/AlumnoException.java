package excepciones;

public class AlumnoException extends Exception {
	private static final long serialVersionUID = 4408372505918592018L;
	private String message;

	public AlumnoException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
