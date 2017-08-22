package excepciones;

public class ProfesorException extends Exception {
	private static final long serialVersionUID = -5795822672191374127L;
	private String message;

	public ProfesorException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
