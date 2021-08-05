package Servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Cliente;
import Model.Trabajador;

/**
 * Session Bean implementation class TrabajadoresService
 */
@Stateless
@LocalBean
public class TrabajadoresService implements TrabajadoresServiceLocal {

    /**
     * Default constructor. 
     */
    public TrabajadoresService() {
        // TODO Auto-generated constructor stub
    }
    
private EntityManagerFactory emf = Persistence.createEntityManagerFactory("clasedatabaseEJB");
    
    @Override
	public void add(Trabajador t) {
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
	public List<Trabajador> getAll() {
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("Trabajador.getAll", Trabajador.class).getResultList();
		} catch(Exception e) {
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Trabajador t) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.remove(em.find(Trabajador.class, t.getRut()));
		} catch (Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Trabajador t) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			Trabajador origen = em.find(Trabajador.class, t.getRut());
			origen.setNumero_verificador(t.getNumero_verificador());
			origen.setNombre(t.getNombre());
			origen.setApellido_paterno(t.getApellido_paterno());
			origen.setApellido_materno(t.getApellido_materno());
			origen.setFecha_contrato(t.getFecha_contrato());
			origen.setCorreos(t.getCorreos());
			origen.setDirecciones(t.getDirecciones());
			origen.setTelefonos(t.getTelefonos());
			em.merge(origen);
			em.flush();
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}

}
