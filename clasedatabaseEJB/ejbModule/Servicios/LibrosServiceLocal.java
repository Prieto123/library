package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Libro;

@Local
public interface LibrosServiceLocal {
	public void add(Libro l);
	public List<Libro> getAll();
	public void remove(Libro l);
	public void update(Libro l);
}
