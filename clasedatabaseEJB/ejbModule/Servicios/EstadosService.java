package Servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Ejemplar;
import Model.Estado;
import Model.Libro;

/**
 * Session Bean implementation class EstadosService
 */
@Stateless
@LocalBean
public class EstadosService implements EstadosServiceLocal {

    /**
     * Default constructor. 
     */
    public EstadosService() {
        // TODO Auto-generated constructor stub
    }
    
private EntityManagerFactory emf = Persistence.createEntityManagerFactory("clasedatabaseEJB");
    
    @Override
	public void add(Estado es) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.persist(es);
			em.flush(); // este es un commit? 
			
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public List<Estado> getAll() {
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("Estado.getAll", Estado.class).getResultList();
		} catch(Exception e) {
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Estado es) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.remove(em.find(Libro.class, es.getId()));
		} catch (Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Estado es) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			Estado origen = em.find(Estado.class, es.getId());
			origen.setEstado(es.getEstado());
			
			em.merge(origen);
			em.flush();
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}

}
