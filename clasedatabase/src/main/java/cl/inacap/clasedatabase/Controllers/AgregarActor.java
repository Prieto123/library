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
import Servicios.AutoresServiceLocal;
import Servicios.LibrosServiceLocal;

/**
 * Servlet implementation class AgregarActor
 */
@WebServlet("/AgregarActor.do")
public class AgregarActor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarActor() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject
    private AutoresServiceLocal autorService;
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
		
		PrintWriter out = response.getWriter();
		
		Autor a=new Autor();
		
		
		
		long isbn = Long.parseLong(request.getParameter("isbn3"));
		int actor = Integer.parseInt(request.getParameter("addAutor"));
		List<Autor> listaAutores = new ArrayList<Autor>();
		listaAutores = autorService.getAll();
		for (int i = 0; i < listaAutores.size(); i++) {
			if(listaAutores.get(i).getId() == actor) {
				a = listaAutores.get(i);
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
				autores.add(a);
				categorias = libro.get(i).getCategorias();
				idiomas = libro.get(i).getIdiomas();
			}
			out.println(realIsbn);
			out.println(titulo);
			out.println(paginas);
			out.println(ano_publicado);
			out.println(ed.getEditorial());
			
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
		
		String ruta = "DetalleLibro.do?isbn=" + request.getParameter("isbn3");
		response.sendRedirect(ruta);
		
	}

}
