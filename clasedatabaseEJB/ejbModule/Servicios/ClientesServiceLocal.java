package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Cliente;
import Model.Editorial;

@Local
public interface ClientesServiceLocal {
	/**
	 * Se añade un nuevo cliente a la base de datos
	 * @param c
	 */
	public void add(Cliente c);
	/**
	 * Se obtiene una lista con todos los clientes en la base de datos
	 * @return
	 */
	public List<Cliente> getAll();
	/**
	 * Se elimina un cliente de la base de datos
	 * @param c
	 */
	public void remove(Cliente c);
	/**
	 * Se actualiza un cliente de la base de datos
	 * @param c
	 */
	public void update(Cliente c);
}
