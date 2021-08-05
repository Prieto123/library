package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Autor;

@Local
public interface AutoresServiceLocal {
	/**
	 * Se añade un nuevo autor a la base de datos
	 * @param a
	 */
	public void add(Autor a);
	/**
	 * Se obtiene una lista con todos los autores de la base de datos
	 * @return
	 */
	public List<Autor> getAll();
	/**
	 * Se elimina un autor de la lista de autores y de la base de datos
	 * @param a
	 */
	public void remove(Autor a);
	/**
	 * Se actualiza una autor de la base de datos
	 * @param a
	 */
	public void update(Autor a);
}
