package cl.inacap.clasedatabase.Controllers;

import java.io.IOException;
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
import Model.Idioma;
import Model.Libro;
import Servicios.AutoresServiceLocal;
import Servicios.CategoriasServiceLocal;
import Servicios.EditorialesServiceLocal;
import Servicios.IdiomasServiceLocal;
import Servicios.LibrosServiceLocal;
/**
 * @author pablo prieto, lucas goni
 */



/**
 * Servlet implementation class DetalleLibro
 * Se obtiene una lista de verlibro.jsp para ver los detalles de un libro, se pasan los atributos
 * isbn, titulo, paginas, autores, categorias, año, editorial, idiomas
 */
@WebServlet("/DetalleLibro.do")
public class DetalleLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalleLibro() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Inject
    private LibrosServiceLocal libroService;
    @Inject
    private EditorialesServiceLocal editorialService;
    @Inject
    private AutoresServiceLocal autorService;
    @Inject
    private CategoriasServiceLocal categoriaService;
    @Inject
    private IdiomasServiceLocal idiomaService;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Editorial> editoriales = new ArrayList<Editorial>();
		editoriales = editorialService.getAll();
		List<Autor> listaAutores = new ArrayList<Autor>();
		listaAutores = autorService.getAll();
		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		listaCategorias = categoriaService.getAll();
		List<Idioma> listaIdiomas = new ArrayList<Idioma>();
		listaIdiomas = idiomaService.getAll();
		request.setAttribute("editoriales", editoriales);
		
		
		long isbn = Long.parseLong(request.getParameter("isbn"));
		List<Libro> libro = new ArrayList<Libro>();
		libro = libroService.getAll();
		long realIsbn = Long.parseLong("1213564764574");
		String titulo = "titulo";
		int paginas = 999;
		int ano_publicado = 2021;
		List<Autor> autores = new ArrayList<Autor>();
		Editorial ed = new Editorial();
		List<Categoria> categorias = new ArrayList<Categoria>();
		List<Idioma> idiomas = new ArrayList<Idioma>();
		for(int i = 0; i < libro.size(); i++) {
			if(libro.get(i).getIsbn() == isbn) {
				realIsbn = libro.get(i).getIsbn();
				titulo = libro.get(i).getTitulo();
				paginas = libro.get(i).getPaginas();
				ano_publicado = libro.get(i).getAno_publicado();
				ed = libro.get(i).getEd();
				autores = libro.get(i).getAutorList();
				categorias = libro.get(i).getCategorias();
				idiomas = libro.get(i).getIdiomas();
			}
		}
		
		request.setAttribute("isbn", realIsbn);
		request.setAttribute("titulo", titulo);
		request.setAttribute("paginas", paginas);
		request.setAttribute("ano_publicado", ano_publicado);
		request.setAttribute("ed", ed);
		request.setAttribute("autores", autores);
		request.setAttribute("categorias", categorias);
		request.setAttribute("idiomas", idiomas);
		request.setAttribute("listaAutores", listaAutores);
		request.setAttribute("listaCategorias", listaCategorias);
		request.setAttribute("listaIdiomas", listaIdiomas);
		
		request.getRequestDispatcher("site/verlibro.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Libro l = new Libro();
		Editorial e=new Editorial();
		List<Libro> libros = new ArrayList<Libro>();
		libros = libroService.getAll();
		List<Autor> autores = new ArrayList<Autor>();
		List<Categoria> categorias = new ArrayList<Categoria>();
		List<Idioma> idiomas = new ArrayList<Idioma>();
		
		List<Editorial> editoriales = new ArrayList<Editorial>();
		editoriales = editorialService.getAll();
		for(Editorial editorial : editoriales) {
			if(editorial.getId() == Integer.parseInt(request.getParameter("editorial"))) {
				e = editorial;
			}
		}
		
		String titulo = request.getParameter("titulo");
		int paginasLibro = 0;
		int anoLibro =  2000;
		boolean seguir = true;
		try {
			paginasLibro = Integer.parseInt(request.getParameter("paginas"));
			anoLibro = Integer.parseInt(request.getParameter("ano"));
		} catch (Exception e2) {
			seguir = false;
		}
		if(seguir) {
			if(!titulo.equals("")) {
				l.setIsbn(			Long.parseLong(request.getParameter("isbn")));
				
				for(int i = 0; i < libros.size(); i++) {
					if(libros.get(i).getIsbn() == l.getIsbn()) {
						autores = libros.get(i).getAutorList();
						l.setAutorList(autores);
						categorias = libros.get(i).getCategorias();
						l.setCategoria(categorias);
						idiomas = libros.get(i).getIdiomas();
						l.setIdiomas(idiomas);
					}
				}
				
				l.setTitulo(		titulo);
				l.setPaginas(		paginasLibro);
				l.setAno_publicado(	anoLibro);
				l.setEd(e);
				
				
				libroService.update(l);
			}
		}
		
		
		
		
		String ruta = "DetalleLibro.do?isbn=" + request.getParameter("isbn"); 
		
		response.sendRedirect(ruta);
	}

}
