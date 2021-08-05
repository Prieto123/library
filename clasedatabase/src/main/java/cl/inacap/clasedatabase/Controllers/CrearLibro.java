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
 * Crea un libro nuevo, valida que no exista
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
		boolean ejecutar = false;
		Long isbn = Long.parseLong("8345857234334");
		String titulo = "titulo";
		String pages = request.getParameter("paginas");
		int paginas = 0;
		String ano = request.getParameter("ano");
		int ano2 = Integer.parseInt(ano);
		try {
			  isbn = Long.parseLong(request.getParameter("isbn"));
			  titulo = request.getParameter("titulo");
			  if(titulo.equals("") || pages.equals("") || ano.equals("")) {
				  ejecutar = false;
			  }
			  paginas = Integer.parseInt(pages);
			  ano2 = Integer.parseInt(ano);
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
				
				l.setIsbn(			isbn);
				l.setTitulo(		titulo);
				l.setPaginas(		paginas);
				l.setAno_publicado(	ano2);
				l.setEd(e);
				l.setAutorList(		autores);
				l.setCategoria(		categorias);
				l.setIdiomas(		idiomas);
				ejecutar = true;
				
				
		} catch (Exception e2) {
			ejecutar = false;
		}
		if(ejecutar) {
			libroService.add(l); 
			String ruta = "DetalleLibro.do?isbn=" + isbn.toString();
			response.sendRedirect(ruta);
		} else {
			response.sendRedirect("ListarLibros.do");
		}
		
			
		
		
		
		
	}

}