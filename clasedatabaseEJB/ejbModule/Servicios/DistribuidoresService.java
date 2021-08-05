package Servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Arriendo;
import Model.Distribuidor;

/**
 * Session Bean implementation class DistribuidoresService
 */
@Stateless
@LocalBean
public class DistribuidoresService implements DistribuidoresServiceLocal {

    /**
     * Default constructor. 
     */
    public DistribuidoresService() {
        // TODO Auto-generated constructor stub
    }
    
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("clasedatabaseEJB");

	@Override
	public void add(Distribuidor l) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.persist(l);
			em.flush(); // este es un commit? 
		} catch(Exception e) {
		} finally {
			em.close();
		}
	}

	@Override
	public List<Distribuidor> getAll() {
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("Distribuidor.getAll", Distribuidor.class).getResultList();
		} catch(Exception e) {
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Distribuidor l) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.remove(em.find(Distribuidor.class, l.getRut()));
		} catch (Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Distribuidor l) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			Distribuidor origen = em.find(Distribuidor.class, l.getRut());
			origen.setNumero_verificador(l.getNumero_verificador());
			origen.setNombre(l.getNombre());
			origen.setAno_antiguedad(l.getAno_antiguedad());
			origen.setTelefono(l.getTelefono());
			origen.setDireccion(l.getDireccion());
			
			em.merge(origen);
			em.flush();
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}
}
