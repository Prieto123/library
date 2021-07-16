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
import Servicios.CategoriasServiceLocal;
import Servicios.IdiomasServiceLocal;
import Servicios.LibrosServiceLocal;

/**
 * Servlet implementation class AgregarIdioma
 */
@WebServlet("/AgregarIdioma.do")
public class AgregarIdioma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarIdioma() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject
    private LibrosServiceLocal libroService;
    @Inject
    private IdiomasServiceLocal idiomaService;

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
		PrintWriter out = response.getWriter();
		
		Idioma id = new Idioma();
		
		long isbn = Long.parseLong(request.getParameter("isbn"));
		int idioma = Integer.parseInt(request.getParameter("addIdioma"));
		List<Idioma> listaIdiomas = new ArrayList<Idioma>();
		listaIdiomas = idiomaService.getAll();
		for (int i = 0; i < listaIdiomas.size(); i++) {
			if(listaIdiomas.get(i).getId() == idioma) {
				id.setId((listaIdiomas.get(i).getId()));
				id.setNombre((listaIdiomas.get(i).getNombre()));
			}
		}
		
		long realIsbn = Long.parseLong("1213564764574");
		String titulo = "titulo";
		int paginas = 999;
		int ano_publicado = 2021;
		List<Autor> autores = new ArrayList<Autor>();
		Editorial ed = new Editorial();
		List<Categoria> categorias = new ArrayList<Categoria>();
		List<Idioma> idiomas = new ArrayList<Idioma>();
		List<Libro> libro = new ArrayList<Libro>();
		libro = libroService.getAll();
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
				idiomas.add(id);
			}
			
			Libro l = new Libro();
			l.setIsbn(			realIsbn);
			l.setTitulo(		titulo);
			l.setPaginas(		paginas);
			l.setAno_publicado(	ano_publicado);
			l.setEd(			ed);
			l.setAutorList(		autores);
			l.setCategoria(		categorias);
			l.setIdiomas(		idiomas);
			libroService.update(l);
		}
		
		String ruta = "DetalleLibro.do?isbn=" + request.getParameter("isbn");
		response.sendRedirect(ruta);
	}

}
