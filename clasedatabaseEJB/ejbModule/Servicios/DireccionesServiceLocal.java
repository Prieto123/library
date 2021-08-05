package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Direccion;

@Local
public interface DireccionesServiceLocal {
	/**
	 * Se añade una direccion a la base de datos
	 * @param d
	 */
	public void add(Direccion d);
	/**
	 * Se obtiene una lista con todas las direcciones en la base de datos
	 * @return
	 */
	public List<Direccion> getAll();

}
