package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Editorial;

@Local
public interface EditorialesServiceLocal {
	public void add(Editorial ed);
	public List<Editorial> getAll();
	public void remove(Editorial ed);
	public void update(Editorial ed);
}
