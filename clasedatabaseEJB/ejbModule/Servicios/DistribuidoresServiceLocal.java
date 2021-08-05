package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Distribuidor;
import Model.Estado;

@Local
public interface DistribuidoresServiceLocal {
	/**
	 * Se añade un nuevo distribuidor a la base de datos
	 * @param es
	 */
	public void add(Distribuidor l);
	/**
	 * Se obtiene una lista con todos los estados de la base de datos
	 * @return
	 */
	public List<Distribuidor> getAll();
	/**
	 * Se elimina un estado de la base de datos
	 * @param es
	 */
	public void remove(Distribuidor l);
	/**
	 * Se actualiza un estado de la base de datos
	 * @param es
	 */
	public void update(Distribuidor l);
}
