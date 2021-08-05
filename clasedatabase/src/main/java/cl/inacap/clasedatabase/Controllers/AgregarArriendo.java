package cl.inacap.clasedatabase.Controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Arriendo;
import Model.Boleta;
import Model.Cliente;
import Model.Ejemplar;
import Model.Trabajador;
import Servicios.ArriendosServiceLocal;
import Servicios.ClientesServiceLocal;
import Servicios.TrabajadoresServiceLocal;

/**
 * Servlet implementation class AgregarArriendo
 * Clase destinada a crear un arriendo sin detalle de libros
 */
@WebServlet("/AgregarArriendo.do")
public class AgregarArriendo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarArriendo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static Date parseDate(String date) {
    	try {
    		return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    	} catch (Exception e) {
    		return null;
    	}
    }
    
    @Inject private ArriendosServiceLocal arriendosService;
    @Inject private ClientesServiceLocal clientesService;
    @Inject private TrabajadoresServiceLocal trabajadoresService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * mediante el método POST
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean doIt = false;
		Date arriendo = parseDate("27/7/2021");
		Date devolucion = parseDate("27/7/2021");
		Date real = parseDate("27/7/2021");
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes = clientesService.getAll();
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();
		trabajadores = trabajadoresService.getAll();
		
		Cliente cliente = new Cliente();
		cliente.setRut(Integer.parseInt(request.getParameter("cliente")));
		Trabajador trabajador = new Trabajador();
		trabajador.setRut(Integer.parseInt(request.getParameter("trabajador")));
		try {
			arriendo = parseDate(request.getParameter("arriendo"));
			devolucion = parseDate(request.getParameter("devolucion"));
			real = parseDate(request.getParameter("real"));
			doIt = true;
		} catch (Exception e) {
			doIt = false;
		}
		
		if(doIt) {
			for(Cliente c : clientes) {
				if(c.getRut() == cliente.getRut()) {
					cliente = c;
					break;
				}
			}
			for(Trabajador t : trabajadores) {
				if(t.getRut() == trabajador.getRut()) {
					trabajador = t;
					break;
				}
			}
			
		}
		
		if(doIt) {
			List<Ejemplar> ejemplar = new ArrayList<Ejemplar>();
			Boleta boleta = new Boleta();
			Arriendo a = new Arriendo();
			a.setFecha_arriendo(arriendo);
			a.setFecha_devolucion_deseada(devolucion);
			a.setFecha_devolucion_real(real);
			a.setClientes_rut(cliente);
			a.setTrabajadores_rut(trabajador);
			a.setEjemplar(ejemplar);
			arriendosService.add(a);
		}
		response.sendRedirect("DetalleArriendo.do");
	}

}
