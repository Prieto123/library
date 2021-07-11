package Servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Editorial;
import Model.Libro;

/**
 * Session Bean implementation class EditorialesService
 */
@Stateless
@LocalBean
public class EditorialesService implements EditorialesServiceLocal {

    /**
     * Default constructor. 
     */
    public EditorialesService() {
        // TODO Auto-generated constructor stub
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("clasedatabaseEJB");
    
    @Override
	public void add(Editorial ed) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.persist(ed);
			em.flush(); // este es un commit? 
			
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public List<Editorial> getAll() {
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("Editorial.getAll", Editorial.class).getResultList();
		} catch(Exception e) {
			return null;
		} finally {
			em.close();
		}
	}
	
	public List<Editorial> get() {
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("Editorial.get", Editorial.class).getResultList();
		} catch(Exception e) {
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Editorial ed) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.remove(em.find(Editorial.class, ed.getId()));
		} catch (Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Editorial ed) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			Editorial origen = em.find(Editorial.class, ed.getId());
			origen.setEditorial(ed.getEditorial());
			em.merge(origen);
			em.flush();
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}

}
