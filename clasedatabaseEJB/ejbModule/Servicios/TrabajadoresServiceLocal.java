package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Cliente;
import Model.Trabajador;

@Local
public interface TrabajadoresServiceLocal {
	/**
	 * Se añade un trabajador a la base de datos
	 * @param t
	 */
	public void add(Trabajador t);
	/**
	 * Se obtiene una lista con todos los trabajadores de la base de datos
	 * @return
	 */
	public List<Trabajador> getAll();
	/**
	 * Se elimina un trabajador de la base de datos
	 * @param t
	 */
	public void remove(Trabajador t);
	/**
	 * Se actualiza un trabajador de la base de datos
	 * @param t
	 */
	public void update(Trabajador t);
}
