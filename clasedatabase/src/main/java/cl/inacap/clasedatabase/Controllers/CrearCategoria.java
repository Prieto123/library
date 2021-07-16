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
import Servicios.CategoriasServiceLocal;
import Servicios.LibrosServiceLocal;

/**
 * Servlet implementation class CrearCategoria
 */
@WebServlet("/CrearCategoria.do")
public class CrearCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject
    private CategoriasServiceLocal categoriaService;
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
		
		Categoria ca = new Categoria();
		ca.setNombre(request.getParameter("nombreCategoria"));
		
		long isbn = Long.parseLong(request.getParameter("isbn"));
		
		List<Categoria> validCategoria = new ArrayList<Categoria>();
		validCategoria = categoriaService.getAll();
		boolean ejecutar = true;
		for (int i = 0; i < validCategoria.size(); i++) {
			if (validCategoria.get(i).getNombre().equals(ca.getNombre())) {
				ejecutar = false;
			}
		}
		if(ejecutar) {
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
					categorias.add(ca);
					idiomas = libro.get(i).getIdiomas();
				}
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
