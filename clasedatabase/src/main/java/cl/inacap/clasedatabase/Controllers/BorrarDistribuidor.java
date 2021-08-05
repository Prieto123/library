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

import Model.Distribuidor;
import Servicios.DistribuidoresServiceLocal;

/**
 * Servlet implementation class BorrarDistribuidor
 */
@WebServlet("/BorrarDistribuidor.do")
public class BorrarDistribuidor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarDistribuidor() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject DistribuidoresServiceLocal distribuidoresService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rut = Integer.parseInt(request.getParameter("rut"));
		
		List<Distribuidor> distribuidores = new ArrayList<Distribuidor>();
		distribuidores = distribuidoresService.getAll();
		
		for(Distribuidor d : distribuidores) {
			if(d.getRut() == rut) {
				distribuidoresService.remove(d);
			}
		}
		
		response.sendRedirect("ListarDistribuidores.do");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		 
		 
	}

}
