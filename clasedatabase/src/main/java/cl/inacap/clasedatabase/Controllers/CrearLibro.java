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

import Model.Editorial;
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
    private LibrosServiceLocal libroService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Libro libro = new Libro();
		/*libro.setIsbn(			Long.parseLong(request.getParameter("isbn")));
		libro.setTitulo(		request.getParameter("titulo"));
		libro.setPaginas(		Integer.parseInt(request.getParameter("paginas")));
		libro.setAno_publicado(	Integer.parseInt(request.getParameter("ano")));
		libro.setEditoriales_id(Integer.parseInt(request.getParameter("editorial")));*/
		
		libro.setIsbn(			Long.parseLong("222222221121")); // tienen q ser 13 numeros 
		libro.setTitulo(		"test");
		libro.setPaginas(		12);
		libro.setAno_publicado(	2020);
		libro.setEditoriales_id(1);
		libroService.add(libro); //la medi vendida.. ya pero ejecutemos 
		/*
		
		
		List<Editorial> editoriales = new ArrayList<Editorial>();
		editoriales = editorialService.getAll();
		request.setAttribute("editoriales", editoriales);
		
		request.getRequestDispatcher("site/crearlibro.jsp").forward(request, response);
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		long longsito = Long.parseLong(request.getParameter("isbn"));
		out.println(longsito);
		out.println(request.getParameter("titulo"));
		out.println(Integer.parseInt(request.getParameter("paginas")));
		out.println(Integer.parseInt(request.getParameter("ano")));
		out.println(Integer.parseInt(request.getParameter("editorial")));
		
		
		
		Libro libro = new Libro();
		/*libro.setIsbn(			Long.parseLong(request.getParameter("isbn")));
		libro.setTitulo(		request.getParameter("titulo"));
		libro.setPaginas(		Integer.parseInt(request.getParameter("paginas")));
		libro.setAno_publicado(	Integer.parseInt(request.getParameter("ano")));
		libro.setEditoriales_id(Integer.parseInt(request.getParameter("editorial")));*/
		
		libro.setIsbn(			Long.parseLong("222222221121")); // tienen q ser 13 numeros 
		libro.setTitulo(		"test");
		libro.setPaginas(		12);
		libro.setAno_publicado(	2020);
		//libro.setEditoriales_id(1);
		
		
		libroService.add(libro);
		//response.sendRedirect("Home.do");
		
		
	}

}
