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
import Servicios.ClientesServiceLocal;

/**
 * Servlet implementation class DetalleClientes
 * Se obtiene la vista detalleClientes.jsp con una lista de todos los clientes para iterarlos
 */
@WebServlet("/DetalleClientes.do")
public class DetalleClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalleClientes() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject
    private ClientesServiceLocal clienteService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes = clienteService.getAll();
		request.setAttribute("clientes", clientes);
		
		request.getRequestDispatcher("site/detalleClientes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
