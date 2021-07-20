package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Direccion;

@Local
public interface DireccionesServiceLocal {

	public void add(Direccion d);

	public List<Direccion> getAll();

}
