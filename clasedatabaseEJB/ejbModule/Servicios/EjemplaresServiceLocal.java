package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Ejemplar;

@Local
public interface EjemplaresServiceLocal {
	public void add(Ejemplar ej);
	public List<Ejemplar> getAll();
	public void remove(Ejemplar ej);
	public void update(Ejemplar ej);
}
