package excepciones;

public class CursoNoExisteException extends Exception {
	private static final long serialVersionUID = 751616992755205862L;
	private static final String MESSAGE = "El curso %d no existe";
	private int numero;

	public CursoNoExisteException(int numero) {
		this.numero = numero;
	}

	public String getMessage() {
		return String.format(MESSAGE, this.numero);
	}
}
