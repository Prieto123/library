package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Ejemplar;
import Model.Estado;

@Local
public interface EstadosServiceLocal {
	public void add(Estado es);
	public List<Estado> getAll();
	public void remove(Estado es);
	public void update(Estado es);
}
