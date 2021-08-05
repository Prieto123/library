package Servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Arriendo;
import Model.Boleta;

/**
 * Session Bean implementation class ArriendosService
 */
@Stateless
@LocalBean
public class ArriendosService implements ArriendosServiceLocal {

    /**
     * Default constructor. 
     */
    public ArriendosService() {
        // TODO Auto-generated constructor stub
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("clasedatabaseEJB");

	@Override
	public void add(Arriendo l) {
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
	public List<Arriendo> getAll() {
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("Arriendo.getAll", Arriendo.class).getResultList();
		} catch(Exception e) {
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Arriendo l) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.remove(em.find(Arriendo.class, l.getId()));
		} catch (Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Arriendo l) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			Arriendo origen = em.find(Arriendo.class, l.getId());
			origen.setFecha_arriendo(l.getFecha_arriendo());
			origen.setFecha_devolucion_deseada(l.getFecha_devolucion_deseada());
			origen.setFecha_devolucion_real(l.getFecha_devolucion_real());
			origen.setClientes_rut(l.getClientes_rut());
			origen.setTrabajadores_rut(l.getTrabajadores_rut());
			origen.setEjemplar(l.getEjemplar());
			
			
			
			em.merge(origen);
			em.flush();
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}

}
