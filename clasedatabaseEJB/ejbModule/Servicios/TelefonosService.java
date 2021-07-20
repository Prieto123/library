package Servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Idioma;
import Model.Telefono;

/**
 * Session Bean implementation class TelefonosService
 */
@Stateless
@LocalBean
public class TelefonosService implements TelefonosServiceLocal {

    /**
     * Default constructor. 
     */
    public TelefonosService() {
        // TODO Auto-generated constructor stub
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("clasedatabaseEJB");
    
    @Override
	public void add(Telefono t) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.persist(t);
			em.flush(); // este es un commit? 
			
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public List<Telefono> getAll() {
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("Telefono.getAll", Telefono.class).getResultList();
		} catch(Exception e) {
			return null;
		} finally {
			em.close();
		}
	}
}
