package Servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Boleta;
import Model.Libro;

/**
 * Session Bean implementation class BoletasService
 */
@Stateless
@LocalBean
public class BoletasService implements BoletasServiceLocal {

    /**
     * Default constructor. 
     */
    public BoletasService() {
        // TODO Auto-generated constructor stub
    }

    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("clasedatabaseEJB");

	@Override
	public void add(Boleta l) {
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
	public List<Boleta> getAll() {
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("Boleta.getAll", Boleta.class).getResultList();
		} catch(Exception e) {
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Boleta l) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.remove(em.find(Boleta.class, l.getFolio()));
		} catch (Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Boleta l) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			Boleta origen = em.find(Boleta.class, l.getFolio());
			origen.setFecha_venta(l.getFecha_venta());
			origen.setCliente_rut(l.getCliente_rut());
			origen.setTrabajadores_rut(l.getTrabajadores_rut());
			origen.setCliente_rut(l.getCliente_rut());
			
			em.merge(origen);
			em.flush();
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}
}
