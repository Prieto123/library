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
import Model.Telefono;
import Servicios.ClientesServiceLocal;
import Servicios.TelefonosServiceLocal;

/**
 * Servlet implementation class ClienteTelefono
 * Añade o crea un nuevo telefono al cliente
 */
@WebServlet("/ClienteTelefono.do")
public class ClienteTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteTelefono() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject
    private ClientesServiceLocal clienteService;
    @Inject
    private TelefonosServiceLocal telefonoService;

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
		List<Telefono> telefonos = new ArrayList<Telefono>();
		telefonos = telefonoService.getAll();
		List<Telefono> telefonosCliente = new ArrayList<Telefono>();
		
		int rut = Integer.parseInt(request.getParameter("rut"));
		String telefono = request.getParameter("telefono");
		boolean seguir = false;
		try {
			int valid = Integer.parseInt(telefono);
			seguir = true;
		} catch (Exception e) {
			seguir = false;
		}
		
		if(!telefono.equals("")) {
			Telefono addTelefono = new Telefono();
			
			boolean existeTelefono = false;
			for(Telefono t : telefonos) {
				if(t.getNumero().equals(telefono)) {
					existeTelefono = true;
					addTelefono = t;
					break;
				}
			}
			
			if(!existeTelefono) {
				addTelefono.setNumero(telefono);
				telefonoService.add(addTelefono);
			}
			
			
			Cliente clienteFinal = new Cliente();
			for(Cliente cliente : clientes) {
				if (cliente.getRut() == rut) {
					clienteFinal = cliente;
					telefonosCliente = cliente.getTelefonos();
					telefonosCliente.add(addTelefono);
					clienteFinal.setTelefonos(telefonosCliente);
					clienteService.update(clienteFinal);
					
				}
			}
		}
		
		
		
		response.sendRedirect("DetalleClientes.do");
		
	}

}
