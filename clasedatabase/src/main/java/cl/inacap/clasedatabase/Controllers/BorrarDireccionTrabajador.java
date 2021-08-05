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

import Model.Cliente;
import Model.Direccion;
import Model.Trabajador;
import Servicios.ClientesServiceLocal;
import Servicios.DireccionesServiceLocal;
import Servicios.TrabajadoresServiceLocal;

/**
 * Servlet implementation class BorrarDireccionTrabajador
 */
@WebServlet("/BorrarDireccionTrabajador.do")
public class BorrarDireccionTrabajador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarDireccionTrabajador() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject
    private TrabajadoresServiceLocal trabajadoresService;
    @Inject
    private DireccionesServiceLocal direccionService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();
		trabajadores = trabajadoresService.getAll();
		List<Direccion> direcciones = new ArrayList<Direccion>();
		direcciones = direccionService.getAll();
		List<Direccion> direccionesVacia = new ArrayList<Direccion>();
		
		int rut = Integer.parseInt(request.getParameter("rut"));
		
		for(Trabajador trabajador : trabajadores) {
			if(trabajador.getRut() == rut) {
				trabajador.setDirecciones(direccionesVacia);
				trabajadoresService.update(trabajador);
			}
			
		}
		
		response.sendRedirect("DetalleTrabajadores.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
