package cl.inacap.clasedatabase.Controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Trabajador;
import Servicios.TrabajadoresServiceLocal;

/**
 * Servlet implementation class agregarTrabajador
 * Clase destinada para Crear un nuevo Trabajador
 */
@WebServlet("/agregarTrabajador.do")
public class agregarTrabajador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public agregarTrabajador() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject
    private TrabajadoresServiceLocal trabajadoresService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	public static Date parseDate(String date) {
    	try {
    		return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    	} catch (Exception e) {
    		return null;
    	}
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rut = 20000000;
		int verificador = 1;
		String nombre = "Pepe";
		String apellidop = "Castillo";
		String apellidom = "Castilla";
		Date contrato = parseDate("20-12-2021");
		
		boolean continuar = false;
		try {
			rut = Integer.parseInt(request.getParameter("rut"));
			verificador = Integer.parseInt(request.getParameter("verificador"));
			nombre = request.getParameter("nombre");
			apellidop = request.getParameter("apellidop");
			apellidom = request.getParameter("apellidom");
			contrato = parseDate(request.getParameter("contrato"));
			continuar = true;
		} catch (Exception e) {
			continuar = false;
		}
		
		Trabajador trabajador = new Trabajador();
		trabajador.setRut(rut);
		trabajador.setNumero_verificador(verificador);
		trabajador.setNombre(nombre);
		trabajador.setApellido_paterno(apellidop);
		trabajador.setApellido_materno(apellidom);
		trabajador.setFecha_contrato(contrato);
		
		trabajadoresService.add(trabajador);
		
		response.sendRedirect("DetalleTrabajadores.do");
		
	}

}
