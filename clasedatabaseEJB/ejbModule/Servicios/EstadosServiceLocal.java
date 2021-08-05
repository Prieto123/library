package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Ejemplar;
import Model.Estado;

@Local
public interface EstadosServiceLocal {
	/**
	 * Se añade un nuevo estado a la base de datos
	 * @param es
	 */
	public void add(Estado es);
	/**
	 * Se obtiene una lista con todos los estados de la base de datos
	 * @return
	 */
	public List<Estado> getAll();
	/**
	 * Se elimina un estado de la base de datos
	 * @param es
	 */
	public void remove(Estado es);
	/**
	 * Se actualiza un estado de la base de datos
	 * @param es
	 */
	public void update(Estado es);
}
