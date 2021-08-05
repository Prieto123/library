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

import Model.Boleta;
import Model.Cliente;
import Servicios.BoletasServiceLocal;

/**
 * Servlet implementation class BorrarBoleta
 * Clase destinada para Borrar una boleta
 */
@WebServlet("/BorrarBoleta.do")
public class BorrarBoleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarBoleta() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject
    private BoletasServiceLocal boletaService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int folio = Integer.parseInt(request.getParameter("folio"));
		
		List<Boleta> boletas = new ArrayList<Boleta>();
		boletas = boletaService.getAll();
		
		for(Boleta boleta : boletas) {
			if(boleta.getFolio() == folio) {
				boletaService.remove(boleta);
			}
			
		}
		
		response.sendRedirect("DetalleBoletas.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
