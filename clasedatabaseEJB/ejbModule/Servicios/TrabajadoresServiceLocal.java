package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Cliente;
import Model.Trabajador;

@Local
public interface TrabajadoresServiceLocal {
	public void add(Trabajador t);
	public List<Trabajador> getAll();
	public void remove(Trabajador t);
	public void update(Trabajador t);
}
