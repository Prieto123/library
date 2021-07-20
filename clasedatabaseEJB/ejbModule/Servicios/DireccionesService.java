package Servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Autor;
import Model.Direccion;

/**
 * Session Bean implementation class DireccionesService
 */
@Stateless
@LocalBean
public class DireccionesService implements DireccionesServiceLocal {

    /**
     * Default constructor. 
     */
    public DireccionesService() {
        // TODO Auto-generated constructor stub
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("clasedatabaseEJB");
    @Override
	public void add(Direccion d) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.persist(d);
			em.flush(); // este es un commit? 
			
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public List<Direccion> getAll() {
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("Direccion.getAll", Direccion.class).getResultList();
		} catch(Exception e) {
			return null;
		} finally {
			em.close();
		}
	}

}
