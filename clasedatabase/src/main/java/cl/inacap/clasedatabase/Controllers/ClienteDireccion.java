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
 * Servlet implementation class ClienteDireccion
 */
@WebServlet("/ClienteDireccion.do")
public class ClienteDireccion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteDireccion() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes = clienteService.getAll();
		List<Direccion> direcciones = new ArrayList<Direccion>();
		direcciones = direccionService.getAll();
		List<Direccion> direccionesCliente = new ArrayList<Direccion>();
		
		int rut = Integer.parseInt(request.getParameter("rut"));
		String direccion = request.getParameter("direccion");
		
		Direccion addDireccion = new Direccion();
		
		boolean existeDireccion = false;
		for(Direccion d : direcciones) {
			if(d.getDireccion().equals(direccion)) {
				existeDireccion = true;
				addDireccion = d;
				break;
			}
		}
		
		if(!existeDireccion) {
			addDireccion.setDireccion(direccion);
			direccionService.add(addDireccion);
		}
		
		
		Cliente clienteFinal = new Cliente();
		
		for(Cliente cliente : clientes) {
			boolean existeEnUsuario = false;
			if (cliente.getRut() == rut) {
				clienteFinal = cliente;
				direccionesCliente = cliente.getDirecciones();
				for(int i = 0; i < direccionesCliente.size(); i++) {
					if(direccionesCliente.get(i).getDireccion().equals(addDireccion.getDireccion())) {
						existeEnUsuario = true;
						break;
					}
				}
				if(!existeEnUsuario) {
					
					direccionesCliente.add(addDireccion);
					clienteFinal.setDirecciones(direccionesCliente);
					clienteService.update(clienteFinal);
				}
			}
		}
		
		
		
		
		response.sendRedirect("DetalleClientes.do");
	}

}
