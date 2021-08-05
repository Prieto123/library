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
import javax.servlet.http.HttpSession;

import Model.Trabajador;
import Servicios.TrabajadoresServiceLocal;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Inject TrabajadoresServiceLocal trabajadoresService;
    
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
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();
		trabajadores = trabajadoresService.getAll();
		
		HttpSession session = request.getSession();
		
		boolean hay = false;
		for(Trabajador trabajador : trabajadores) {
			if(trabajador.getApellido_paterno().equals(request.getParameter("username"))) {
				session.setAttribute("username", request.getParameter("username"));
				hay = true;
				break;
			}
		}
		
		if(hay) {
			response.sendRedirect("Home.do");
		} else {
			response.sendRedirect("Home.do");
		}
	}

}
