package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Autor;

@Local
public interface AutoresServiceLocal {
	public void add(Autor a);
	public List<Autor> getAll();
	public void remove(Autor a);
	public void update(Autor a);
}
