package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Categoria;

@Local
public interface CategoriasServiceLocal {
	public void add(Categoria c);
	public List<Categoria> getAll();
	public void remove(Categoria c);
	public void update(Categoria c);
}
