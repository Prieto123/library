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
import Model.Telefono;
import Servicios.ClientesServiceLocal;
import Servicios.DireccionesServiceLocal;

/**
 * Servlet implementation class BorrarDireccion
 */
@WebServlet("/BorrarDireccion.do")
public class BorrarDireccion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarDireccion() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject
    private ClientesServiceLocal clienteService;
    @Inject
    private DireccionesServiceLocal direccionService;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes = clienteService.getAll();
		List<Direccion> direcciones = new ArrayList<Direccion>();
		direcciones = direccionService.getAll();
		List<Direccion> direccionesVacia = new ArrayList<Direccion>();
		
		int rut = Integer.parseInt(request.getParameter("rut"));
		
		for(Cliente cliente : clientes) {
			if(cliente.getRut() == rut) {
				cliente.setDirecciones(direccionesVacia);
				clienteService.update(cliente);
			}
			
		}
		
		response.sendRedirect("DetalleClientes.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
