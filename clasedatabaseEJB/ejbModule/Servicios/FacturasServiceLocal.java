package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Factura;

@Local
public interface FacturasServiceLocal {

	void update(Factura l);

	void remove(Factura l);

	List<Factura> getAll();

	void add(Factura l);

}
