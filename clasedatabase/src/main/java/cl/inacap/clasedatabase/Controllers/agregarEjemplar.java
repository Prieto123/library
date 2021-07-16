package cl.inacap.clasedatabase.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Autor;
import Model.Categoria;
import Model.Editorial;
import Model.Ejemplar;
import Model.Estado;
import Model.Idioma;
import Model.Libro;
import Servicios.EjemplaresServiceLocal;
import Servicios.EstadosServiceLocal;
import Servicios.LibrosServiceLocal;

/**
 * Servlet implementation class agregarEjemplar
 */
@WebServlet("/agregarEjemplar.do")
public class agregarEjemplar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public agregarEjemplar() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Inject
    private EstadosServiceLocal estadoService;
    @Inject
    private EjemplaresServiceLocal ejemplarService;
    @Inject 
    private LibrosServiceLocal libroService;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int num_serie = Integer.parseInt(request.getParameter("num_serie"));
		int precio = Integer.parseInt(request.getParameter("precio"));
		long elLibro = Long.parseLong(request.getParameter("addLibro"));
		List<Libro> libros = new ArrayList<Libro>();
		libros = libroService.getAll();
		List<Estado> estados = new ArrayList<Estado>();
		estados = estadoService.getAll();
		List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
		ejemplares = ejemplarService.getAll();
		
		Ejemplar ejemplar = new Ejemplar();
		Libro l = new Libro();
		Estado est = new Estado();
		
		boolean doIt = true;
		for(Libro libro : libros) {
			if(libro.getIsbn() == elLibro) {
				l = libro;
			}
		}
		for(Estado estado : estados) {
			if(estado.getId() == Integer.parseInt(request.getParameter("estado"))) {
				est = estado;
			}
		}
		for(Ejemplar ej : ejemplares) {
			if(ej.getNumero_serie() == num_serie) {
				doIt = false;
				break;
			}
		}
		
		if(doIt) {
			ejemplar.setNumero_serie(num_serie);
			ejemplar.setPrecio(precio);
			ejemplar.setEstados_id(est);
			ejemplar.setLibros_isbn(l);
			ejemplarService.add(ejemplar);
		}
		
		PrintWriter out = response.getWriter();
		out.println(est.getEstado());
		out.println(l.getTitulo());
		out.println(precio);
		
		//response.sendRedirect("Home.do");
	}

}
