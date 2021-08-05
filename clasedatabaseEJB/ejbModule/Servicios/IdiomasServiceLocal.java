package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Idioma;

@Local
public interface IdiomasServiceLocal {
	/**
	 * Se añade un nuevo idioma a la base de datos
	 * @param i
	 */
	public void add(Idioma i);
	/**
	 * Se obtiene una lista con todos los idiomas de la base de datos
	 * @return
	 */
	public List<Idioma> getAll();
}
