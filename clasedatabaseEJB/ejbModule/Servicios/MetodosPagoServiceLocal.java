package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.MetodoPago;

@Local
public interface MetodosPagoServiceLocal {

	public void update(MetodoPago mp);
	public void remove(MetodoPago mp);
	public List<MetodoPago> getAll();
	public void add(MetodoPago mp);

}
