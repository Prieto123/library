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

import Model.Cliente;
import Model.Trabajador;
import Servicios.ClientesServiceLocal;

/**
 * Servlet implementation class agregarCliente
 */
@WebServlet("/agregarCliente.do")
public class agregarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public agregarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject ClientesServiceLocal clientesService;

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
		int rut = 20000000;
		int verificador = 1;
		String nombre = "Pepe";
		String apellidop = "Castillo";
		String apellidom = "Castilla";
		
		boolean continuar = false;
		try {
			rut = Integer.parseInt(request.getParameter("rut"));
			verificador = Integer.parseInt(request.getParameter("verificador"));
			nombre = request.getParameter("nombre");
			apellidop = request.getParameter("apellidop");
			apellidom = request.getParameter("apellidom");
			continuar = true;
		} catch (Exception e) {
			continuar = false;
		}
		
		Cliente cliente = new Cliente();
		cliente.setRut(rut);
		cliente.setNumero_verificador(verificador);
		cliente.setNombre(nombre);
		cliente.setApellido_paterno(apellidop);
		cliente.setApellido_materno(apellidom);
		
		clientesService.add(cliente);
		
		response.sendRedirect("DetalleTrabajadores.do");
		
	}

}
