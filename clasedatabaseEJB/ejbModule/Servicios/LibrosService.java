package Servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Autor;
import Model.Editorial;
import Model.Libro;

/**
 * Session Bean implementation class LibrosService
 */
@Stateless
@LocalBean
public class LibrosService implements LibrosServiceLocal {

    /**
     * Default constructor. 
     */
    public LibrosService() {
        // TODO Auto-generated constructor stub
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("clasedatabaseEJB");

	@Override
	public void add(Libro l) {
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
	public List<Libro> getAll() {
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("Libro.getAll", Libro.class).getResultList();
		} catch(Exception e) {
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Libro l) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.remove(em.find(Libro.class, l.getIsbn()));
		} catch (Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Libro l) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			Libro origen = em.find(Libro.class, l.getIsbn());
			origen.setTitulo(l.getTitulo());
			origen.setPaginas(l.getPaginas());
			origen.setAno_publicado(l.getAno_publicado());
			origen.setEd(l.getEd());
			origen.setAutorList(l.getAutorList());
			origen.setCategoria(l.getCategorias());
			origen.setIdiomas(l.getIdiomas());
			
			em.merge(origen);
			em.flush();
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}
}
