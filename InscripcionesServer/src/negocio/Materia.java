package negocio;

import dao.MateriaDAO;
import dto.MateriaView;
import excepciones.BaseDeDatosException;

public class Materia {

	private String codigo;
	private String descripcion;
	private Boolean habilitada;

	public Materia(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.habilitada = true;
	}

	public Materia(String codigo, String descripcion, Boolean habilitada) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.habilitada = habilitada;
	}

	public void save() throws BaseDeDatosException {
		MateriaDAO.getInstancia().save(this);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isHabilitada() {
		return habilitada;
	}

	public void deshabilitar() {
		this.habilitada = false;
	}

	public MateriaView toView() {
		return new MateriaView(codigo, descripcion, habilitada);
	}

	public boolean soyLaMateria(String codigo) {
		return this.codigo.equals(codigo);
	}
}
