package excepciones;

public class ProfesorNoExisteException extends Exception {
	private static final long serialVersionUID = -5109085527623808677L;
	private static final String MESSAGE = "El profesor %d no existe";
	private int legajo;

	public ProfesorNoExisteException(int legajo) {
		this.legajo = legajo;
	}

	public String getMessage() {
		return String.format(MESSAGE, this.legajo);
	}
}
