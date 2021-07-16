package Servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Autor;
import Model.Idioma;

/**
 * Session Bean implementation class IdiomasService
 */
@Stateless
@LocalBean
public class IdiomasService implements IdiomasServiceLocal {

    /**
     * Default constructor. 
     */
    public IdiomasService() {
        // TODO Auto-generated constructor stub
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("clasedatabaseEJB");
    
    @Override
	public void add(Idioma i) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.persist(i);
			em.flush(); // este es un commit? 
			
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public List<Idioma> getAll() {
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("Idioma.getAll", Idioma.class).getResultList();
		} catch(Exception e) {
			return null;
		} finally {
			em.close();
		}
	}

}
