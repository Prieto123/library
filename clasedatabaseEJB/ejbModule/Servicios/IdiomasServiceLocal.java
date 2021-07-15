package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Idioma;

@Local
public interface IdiomasServiceLocal {
	public void add(Idioma i);
	public List<Idioma> getAll();
}
