package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Telefono;

@Local
public interface TelefonosServiceLocal {
	/**
	 * Se añade un nuevo telefono a la base de datos
	 * @param t
	 */
	public void add(Telefono t);
	/**
	 * Se obtiene una lista con todos los telefonos de la base de datos
	 * @return
	 */
	public List<Telefono> getAll();

}
