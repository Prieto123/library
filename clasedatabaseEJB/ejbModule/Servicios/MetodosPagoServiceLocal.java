package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.MetodoPago;

@Local
public interface MetodosPagoServiceLocal {
	/**
	 * Se actualiza el metodo de pago en la base de datos
	 * @param mp
	 */
	public void update(MetodoPago mp);
	/**
	 * Se elimina el metodo de pago en la base de datos
	 * @param mp
	 */
	public void remove(MetodoPago mp);
	/**
	 * Se obtiene una lista con todos los metodos de pago de la base de datos
	 * @return
	 */
	public List<MetodoPago> getAll();
	/**
	 * Se añade un nuevo metodo de pago a la base de datos
	 * @param mp
	 */
	public void add(MetodoPago mp);

}
