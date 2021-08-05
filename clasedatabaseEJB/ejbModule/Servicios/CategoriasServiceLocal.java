package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Categoria;

@Local
public interface CategoriasServiceLocal {
	/**
	 * Se añade una nueva categoria a la base de datos
	 * @param c
	 */
	public void add(Categoria c);
	/**
	 * Se obtiene una lista con todas las categorias de la base de datos
	 * @return
	 */
	public List<Categoria> getAll();
	/**
	 * Se elimina una categoria en especifico de la base de datos
	 * @param c
	 */
	public void remove(Categoria c);
	/**
	 * Se actualiza una categoria de la base de datos
	 * @param c
	 */
	public void update(Categoria c);
}
