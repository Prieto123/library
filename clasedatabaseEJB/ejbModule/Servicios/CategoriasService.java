package Servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Categoria;
import Model.Libro;

/**
 * Session Bean implementation class CategoriasService
 */
@Stateless
@LocalBean
public class CategoriasService implements CategoriasServiceLocal {

    /**
     * Default constructor. 
     */
    public CategoriasService() {
        // TODO Auto-generated constructor stub
    }

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("clasedatabaseEJB");

	@Override
	public void add(Categoria c) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.persist(c);
			em.flush(); // este es un commit? 
			
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public List<Categoria> getAll() {
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("Categoria.getAll", Categoria.class).getResultList();
		} catch(Exception e) {
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Categoria c) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.remove(em.find(Categoria.class, c.getId()));
		} catch (Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Categoria c) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			Categoria origen = em.find(Categoria.class, c.getId());
			origen.setNombre(c.getNombre());
			
			em.merge(origen);
			em.flush();
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}
}
