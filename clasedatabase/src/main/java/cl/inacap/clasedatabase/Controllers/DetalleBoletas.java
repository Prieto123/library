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
 * Servlet implementation class DetalleBoletas
 */
@WebServlet("/DetalleBoletas.do")
public class DetalleBoletas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalleBoletas() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject
    private BoletasServiceLocal boletasService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int folio = 0;
		
		try {
			folio = Integer.parseInt(request.getParameter("folio"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		List<Boleta> boletas = new ArrayList<Boleta>();
		boletas = boletasService.getAll();
		request.setAttribute("boletas", boletas);
		request.setAttribute("folio", folio);
		
		request.getRequestDispatcher("site/detalleBoletas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
