package Servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Autor;
import Model.MetodoPago;

/**
 * Session Bean implementation class MetodosPagoService
 */
@Stateless
@LocalBean
public class MetodosPagoService implements MetodosPagoServiceLocal {

    /**
     * Default constructor. 
     */
    public MetodosPagoService() {
        // TODO Auto-generated constructor stub
    }
    
private EntityManagerFactory emf = Persistence.createEntityManagerFactory("clasedatabaseEJB");
    
	@Override
	public void add(MetodoPago mp) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.persist(mp);
			em.flush(); // este es un commit? 
			
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public List<MetodoPago> getAll() {
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("MetodoPago.getAll", MetodoPago.class).getResultList();
		} catch(Exception e) {
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(MetodoPago mp) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.remove(em.find(Autor.class, mp.getId()));
		} catch (Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public void update(MetodoPago mp) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			MetodoPago origen = em.find(MetodoPago.class, mp.getId());
			origen.setMetodo(mp.getMetodo());
			em.merge(origen);
			em.flush();
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}

}
