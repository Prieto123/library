package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Boleta;
import Model.Libro;

@Local
public interface BoletasServiceLocal {
	/**
	 * Se añade una nueva boleta a la base de datos
	 * @param l
	 */
	public void add(Boleta l);
	/**
	 * Se obtiene una lista con todas las boletas de la base de datos
	 * @return
	 */
	public List<Boleta> getAll();
	/**
	 * Se elimina una boleta de la base de datos
	 * @param l
	 */
	public void remove(Boleta l);
	/**
	 * Se actualiza una boleta de la base de datos
	 * @param l
	 */
	public void update(Boleta l);
}
