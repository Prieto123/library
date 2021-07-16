package cl.inacap.clasedatabase.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import Model.Idioma;
import Model.Libro;
import Servicios.EditorialesServiceLocal;
import Servicios.LibrosServiceLocal;

/**
 * Servlet implementation class CrearLibro
 */
@WebServlet("/CrearLibro.do")
public class CrearLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearLibro() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject
    private EditorialesServiceLocal editorialService;
    @Inject
    private LibrosServiceLocal libroService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Editorial> editoriales = new ArrayList<Editorial>();
		editoriales = editorialService.getAll();
		request.setAttribute("editoriales", editoriales);
		
		request.getRequestDispatcher("site/crearlibro.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Libro l = new Libro();
		Editorial e=new Editorial();
		
		List<Editorial> editoriales = new ArrayList<Editorial>();
		editoriales = editorialService.getAll();
		for(Editorial editorial : editoriales) {
			if(editorial.getId() == Integer.parseInt(request.getParameter("editorial"))) {
				e.setId(editorial.getId());
				e.setEditorial(editorial.getEditorial());
			}
		}
		List<Autor> autores = new ArrayList<Autor>();
		List<Categoria> categorias = new ArrayList<Categoria>();
		List<Idioma> idiomas = new ArrayList<Idioma>();
		
		l.setIsbn(			Long.parseLong(request.getParameter("isbn")));
		l.setTitulo(		request.getParameter("titulo"));
		l.setPaginas(		Integer.parseInt(request.getParameter("paginas")));
		l.setAno_publicado(	Integer.parseInt(request.getParameter("ano")));
		l.setEd(e);
		l.setAutorList(		autores);
		l.setCategoria(		categorias);
		l.setIdiomas(		idiomas);
		
		libroService.add(l); 
		
		response.sendRedirect("Home.do");
		
		
	}

}