package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Cliente;
import Model.Editorial;

@Local
public interface ClientesServiceLocal {
	public void add(Cliente c);
	public List<Cliente> getAll();
	public void remove(Cliente c);
	public void update(Cliente c);
}
