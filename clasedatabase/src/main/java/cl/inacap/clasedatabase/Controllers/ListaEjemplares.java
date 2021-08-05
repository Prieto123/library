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

import Model.Ejemplar;
import Model.Estado;
import Model.Libro;
import Servicios.EjemplaresServiceLocal;
import Servicios.EstadosServiceLocal;
import Servicios.LibrosServiceLocal;

/**
 * Servlet implementation class ListaEjemplares
 */
@WebServlet("/ListaEjemplares.do")
public class ListaEjemplares extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaEjemplares() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject
    private EjemplaresServiceLocal ejemplarService;
    @Inject
    private EstadosServiceLocal estadoService;
    @Inject
    private LibrosServiceLocal librosService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
		ejemplares = ejemplarService.getAll();
		request.setAttribute("ejemplares", ejemplares);
		
		List<Libro> libros = new ArrayList<Libro>();
		libros = librosService.getAll();
		request.setAttribute("libros", libros);
		
		List<Estado> estados = new ArrayList<Estado>();
		estados = estadoService.getAll();
		request.setAttribute("estados", estados);
		
		request.getRequestDispatcher("site/listaEjemplares.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
