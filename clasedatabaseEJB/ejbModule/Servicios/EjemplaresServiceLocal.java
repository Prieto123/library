package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Ejemplar;

@Local
public interface EjemplaresServiceLocal {
	/**
	 * Se añade un nuevo libro ejemplar a la base de datos
	 * @param ej
	 */
	public void add(Ejemplar ej);
	/**
	 * Se obtiene una lista de todos los libros ejemplares de la base de datos
	 * @return
	 */
	public List<Ejemplar> getAll();
	/**
	 * Se elimina un libro ejemplar de la base de datos
	 * @param ej
	 */
	public void remove(Ejemplar ej);
	/**
	 * Se actualiza un libro ejemplar de la base de datos
	 * @param ej
	 */
	public void update(Ejemplar ej);
}
