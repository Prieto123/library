package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Autor;
import Model.Libro;

@Local
public interface LibrosServiceLocal {
	/**
	 * Se añade un nuevo libro a la base de datos
	 * @param l
	 */
	public void add(Libro l);
	/**
	 * Se obtiene una lista con todos los libros de la base de datos
	 * @return
	 */
	public List<Libro> getAll();
	/**
	 * Se elimina un libro de la base de datos
	 * @param l
	 */
	public void remove(Libro l);
	/**
	 * Se actualiza un libro de la base de datos
	 * @param l
	 */
	public void update(Libro l);
}
