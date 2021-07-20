package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Telefono;

@Local
public interface TelefonosServiceLocal {

	public void add(Telefono t);
	public List<Telefono> getAll();

}
