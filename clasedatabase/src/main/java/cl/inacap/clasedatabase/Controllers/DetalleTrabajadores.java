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
import Model.Trabajador;
import Servicios.TrabajadoresServiceLocal;

/**
 * Servlet implementation class DetalleTrabajadores
 */
@WebServlet("/DetalleTrabajadores.do")
public class DetalleTrabajadores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalleTrabajadores() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject
    private TrabajadoresServiceLocal trabajadoresService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();
		trabajadores = trabajadoresService.getAll();
		request.setAttribute("trabajadores", trabajadores);
		
		request.getRequestDispatcher("site/detalleTrabajadores.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
