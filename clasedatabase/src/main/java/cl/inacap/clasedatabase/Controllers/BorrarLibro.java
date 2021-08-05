package cl.inacap.clasedatabase.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Arriendo;
import Model.Boleta;
import Model.Ejemplar;
import Model.Libro;
import Servicios.ArriendosServiceLocal;
import Servicios.EjemplaresServiceLocal;
import Servicios.LibrosServiceLocal;

/**
 * Servlet implementation class BorrarLibro
 */
@WebServlet("/BorrarLibro.do")
public class BorrarLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarLibro() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject private EjemplaresServiceLocal ejemplaresService;
    @Inject private LibrosServiceLocal librosService;
    @Inject private ArriendosServiceLocal arriendosService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long isbn = Long.parseLong(request.getParameter("isbn"));
		
		List<Libro> libros = new ArrayList<Libro>();
		libros = librosService.getAll();
		
		List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
		ejemplares = ejemplaresService.getAll();
		
		List<Arriendo> arriendos = new ArrayList<Arriendo>();
		arriendos = arriendosService.getAll();
		
		/*for(Ejemplar ejemplar : ejemplares) {
			if(ejemplar.getLibros_isbn().getIsbn() == isbn) {
				ejemplaresService.remove(ejemplar);
			}
		}*/
		
		Ejemplar e = new Ejemplar();
		for(Ejemplar ejemplar : ejemplares) {
			if(ejemplar.getLibros_isbn().getIsbn() == isbn) {
				e = ejemplar;
			}
		}
		for(Arriendo arriendo : arriendos) {
			for (int i = 0; i < arriendo.getEjemplar().size(); i++) {
				if(arriendo.getEjemplar().get(i).getLibros_isbn().getIsbn() == e.getLibros_isbn().getIsbn()) {
					arriendo.getEjemplar().remove(i);
					arriendosService.update(arriendo);
					
				}
			}
		}
		ejemplaresService.remove(e);
		
		for(Libro libro : libros) {
			if(libro.getIsbn() == isbn) {
				librosService.remove(libro);
			}
			
		}
		
		
		
		
		
		response.sendRedirect("Home.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
