package Servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Arriendo;
import Model.Factura;

/**
 * Session Bean implementation class FacturasService
 */
@Stateless
@LocalBean
public class FacturasService implements FacturasServiceLocal {

    /**
     * Default constructor. 
     */
    public FacturasService() {
        // TODO Auto-generated constructor stub
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("clasedatabaseEJB");

	@Override
	public void add(Factura l) {
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
	public List<Factura> getAll() {
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("Factura.getAll", Factura.class).getResultList();
		} catch(Exception e) {
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Factura l) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.remove(em.find(Factura.class, l.getFolio()));
		} catch (Exception e) {
			
		} finally {
			em.close();
		}
	}

	public void update(Factura l) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			Factura origen = em.find(Factura.class, l.getFolio());
			origen.setFecha_compra(l.getFecha_compra());
			origen.setMetodo_pago(l.getMetodo_pago());
			origen.setDistribuidor(l.getDistribuidor());
			origen.setEjemplares(l.getEjemplares());
			
			em.merge(origen);
			em.flush();
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}

}
