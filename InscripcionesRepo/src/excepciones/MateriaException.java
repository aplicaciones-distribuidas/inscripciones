package excepciones;

public class MateriaException extends Exception {
	private static final long serialVersionUID = 4647345402427371266L;
	private String message;

	public MateriaException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
