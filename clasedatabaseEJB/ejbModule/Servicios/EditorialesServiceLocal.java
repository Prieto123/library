package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Editorial;

@Local
public interface EditorialesServiceLocal {
	/**
	 * Se añade una nueva editorial a la base de datos
	 * @param ed
	 */
	public void add(Editorial ed);
	/**
	 * Se obtiene una lista con todas las editoriales de la base de datos
	 * @return
	 */
	public List<Editorial> getAll();
	/**
	 * Se elimina una editorial de la base de datos
	 * @param ed
	 */
	public void remove(Editorial ed);
	/**
	 * Se actualiza una editorial de la base de datos
	 * @param ed
	 */
	public void update(Editorial ed);
}
