package excepciones;

public class MateriaNoExisteException extends Exception {
	private static final long serialVersionUID = 3433956380682677722L;
	private static final String MESSAGE = "La materia %s no existe";
	private String codigo;

	public MateriaNoExisteException(String codigo) {
		this.codigo = codigo;
	}

	public String getMessage() {
		return String.format(MESSAGE, this.codigo);
	}
}
