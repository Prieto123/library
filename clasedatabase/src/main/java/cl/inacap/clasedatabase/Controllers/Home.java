package cl.inacap.clasedatabase.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Libro;
import Servicios.LibrosService;
import Servicios.LibrosServiceLocal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home.do")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    @Inject
    private LibrosServiceLocal libroService;
    
    
    public static Date parseDate(String date) {
    	try {
    		return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    	} catch (Exception e) {
    		return null;
    	}
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		List<Libro> libros = new ArrayList<Libro>();
		libros = libroService.getAll();
		request.setAttribute("libros", libros);
		libroService.getAll().stream().forEach(l->out.println(l.getTitulo()));
		request.getRequestDispatcher("site/home.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Date fecha = parseDate(request.getParameter("fecha"));
		
		/*Persona p = new Persona(); helllow!!!... holaaa    donde 
		p.setApellidosPersona(request.getParameter("apellidosPersona").toString());
		p.setDireccion(request.getParameter("direccion"));
		p.setFechaNacimiento(fecha);
		p.setFotoPersona(request.getParameter("foto"));
		p.setIdCiudad(Integer.parseInt(request.getParameter("ciudad")));
		p.setNombresPersona(request.getParameter("nombrePersona"));
		p.setRut(request.getParameter("rut"));
		
		personaService.add(p);*/
	}
}
