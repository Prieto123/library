package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Arriendo;
import Model.Boleta;

@Local
public interface ArriendosServiceLocal {
	/**
	 * Se añade un nuevo arriendo a la base de datos
	 * @param l
	 */
	public void add(Arriendo l);
	/**
	 * Se obtiene una lista con todos los arriendos de la base de datos
	 * @return
	 */
	public List<Arriendo> getAll();
	/**
	 * Se elimina un arriendo de la base de datos
	 * @param l
	 */
	public void remove(Arriendo l);
	/**
	 * Se actualiza un arriendo de la base de datos
	 * @param l
	 */
	public void update(Arriendo l);
}
