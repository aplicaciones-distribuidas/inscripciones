package excepciones;

public class CursoException extends Exception {

	private static final long serialVersionUID = -5741311071832600989L;
	private String message;

	public CursoException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
