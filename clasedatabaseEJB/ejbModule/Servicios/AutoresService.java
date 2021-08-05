package Servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Autor;
import Model.Editorial;

/**
 * Session Bean implementation class AutoresService
 */
@Stateless
@LocalBean
public class AutoresService implements AutoresServiceLocal {

    /**
     * Default constructor. 
     */
    public AutoresService() {
        // TODO Auto-generated constructor stub
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("clasedatabaseEJB");
    
    @Override
	public void add(Autor a) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.persist(a);
			em.flush(); // este es un commit? 
			
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public List<Autor> getAll() {
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("Autor.getAll", Autor.class).getResultList();
		} catch(Exception e) {
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Autor a) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.remove(em.find(Autor.class, a.getId()));
		} catch (Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Autor a) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			Autor origen = em.find(Autor.class, a.getId());
			origen.setNombre(a.getNombre());
			origen.setApellido_paterno(a.getApellido_paterno());
			em.merge(origen);
			em.flush();
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}
}
