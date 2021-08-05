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
import javax.servlet.http.HttpSession;

import Model.Arriendo;
import Model.Boleta;
import Model.Cliente;
import Model.Distribuidor;
import Model.Ejemplar;
import Model.Estado;
import Model.Factura;
import Model.Libro;
import Model.Trabajador;
import Servicios.ArriendosServiceLocal;
import Servicios.BoletasServiceLocal;
import Servicios.ClientesServiceLocal;
import Servicios.DistribuidoresServiceLocal;
import Servicios.EjemplaresServiceLocal;
import Servicios.EstadosServiceLocal;
import Servicios.FacturasServiceLocal;
import Servicios.LibrosService;
import Servicios.LibrosServiceLocal;
import Servicios.TrabajadoresServiceLocal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Servlet implementation class Home
 * Se obtiene la vista de home.jsp, pasandole todos los libros, ejemplares, clientes, trabajadores
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

    
    @Inject private LibrosServiceLocal libroService;
    @Inject private EjemplaresServiceLocal ejemplarService;
    @Inject private EstadosServiceLocal estadoService;
    @Inject private ClientesServiceLocal clienteService;
    @Inject private TrabajadoresServiceLocal trabajadorService;
    @Inject private BoletasServiceLocal boletasService;
    @Inject private ArriendosServiceLocal arriendosService;
    @Inject private DistribuidoresServiceLocal distribuidoresService;
    @Inject private FacturasServiceLocal facturasService;
    
    
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
		
		HttpSession session = request.getSession();
		String username = "";
		if(session.getAttribute("username") == null) {
			request.getRequestDispatcher("site/login.jsp").forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			List<Libro> libros = new ArrayList<Libro>();
			libros = libroService.getAll();
			
			int contadorLibros = 0;
			for(Libro libro : libros) {
				contadorLibros++;
			}
			request.setAttribute("libros", contadorLibros);
			
			List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
			int contadorEjemplares = 0;
			ejemplares = ejemplarService.getAll();
			for(Ejemplar ejemplar : ejemplares) {
				contadorEjemplares++;
			}
			request.setAttribute("ejemplares", contadorEjemplares);
			
			int contadorClientes = 0;
			List<Cliente> clientes = new ArrayList<Cliente>();
			clientes = clienteService.getAll();
			for(Cliente cliente : clientes) {
				contadorClientes++;
			}
			request.setAttribute("clientes", contadorClientes);
			
			int contadorTrabajadores = 0;
			List<Trabajador> trabajadores = new ArrayList<Trabajador>();
			trabajadores = trabajadorService.getAll();
			for(Trabajador trabajador : trabajadores) {
				contadorTrabajadores++;
			}
			request.setAttribute("trabajadores", contadorTrabajadores);
			
			int contadorBoletas = 0;
			List<Boleta> boletas = new ArrayList<Boleta>();
			boletas = boletasService.getAll();
			for(Boleta boleta : boletas) {
				contadorBoletas++;
			}
			request.setAttribute("boletas", contadorBoletas);
			
			int contadorArriendos = 0;
			List<Arriendo> arriendos = new ArrayList<Arriendo>();
			arriendos = arriendosService.getAll();
			for(Arriendo arriendo : arriendos) {
				contadorArriendos++;
			}
			request.setAttribute("arriendos", contadorArriendos);
			
			int contadorDistribuidores = 0;
			List<Distribuidor> distribuidores = new ArrayList<Distribuidor>();
			distribuidores = distribuidoresService.getAll();
			for(Distribuidor distribuidor : distribuidores) {
				contadorDistribuidores++;
			}
			request.setAttribute("distribuidores", contadorDistribuidores);
			
			int contadorFacturas = 0;
			List<Factura> facturas = new ArrayList<Factura>();
			facturas = facturasService.getAll();
			for(Factura factura : facturas) {
				contadorFacturas++;
			}
			request.setAttribute("facturas", contadorFacturas);
			request.setAttribute("username", session.getAttribute("username"));
			
			
			request.getRequestDispatcher("site/home.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
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
