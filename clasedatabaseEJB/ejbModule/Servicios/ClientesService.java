package Servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Autor;
import Model.Cliente;

/**
 * Session Bean implementation class ClientesService
 */
@Stateless
@LocalBean
public class ClientesService implements ClientesServiceLocal {

    /**
     * Default constructor. 
     */
    public ClientesService() {
        // TODO Auto-generated constructor stub
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("clasedatabaseEJB");
    
    @Override
	public void add(Cliente c) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.persist(c);
			em.flush(); // este es un commit? 
			
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public List<Cliente> getAll() {
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("Cliente.getAll", Cliente.class).getResultList();
		} catch(Exception e) {
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Cliente c) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.remove(em.find(Cliente.class, c.getNumero_verificador()));
		} catch (Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Cliente c) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			Cliente origen = em.find(Cliente.class, c.getRut());
			origen.setNumero_verificador(c.getNumero_verificador());
			origen.setNombre(c.getNombre());
			origen.setApellido_paterno(c.getApellido_paterno());
			origen.setApellido_materno(c.getApellido_materno());
			origen.setCorreos(c.getCorreos());
			origen.setDirecciones(c.getDirecciones());
			origen.setTelefonos(c.getTelefonos());
			em.merge(origen);
			em.flush();
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}

}
