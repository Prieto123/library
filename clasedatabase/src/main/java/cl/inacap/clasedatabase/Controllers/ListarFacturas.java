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
import Model.Factura;
import Model.MetodoPago;
import Servicios.DistribuidoresServiceLocal;
import Servicios.FacturasServiceLocal;
import Servicios.MetodosPagoServiceLocal;

/**
 * Servlet implementation class ListarFacturas
 */
@WebServlet("/ListarFacturas.do")
public class ListarFacturas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarFacturas() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject private FacturasServiceLocal facturasService;
    @Inject private MetodosPagoServiceLocal metodosService;
    @Inject private DistribuidoresServiceLocal distribuidoresService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Factura> facturas = new ArrayList<Factura>();
		facturas = facturasService.getAll();
		
		List<MetodoPago> metodos = new ArrayList<MetodoPago>();
		metodos = metodosService.getAll();
		
		List<Distribuidor> distribuidores = new ArrayList<Distribuidor>();
		distribuidores = distribuidoresService.getAll();
		
		request.setAttribute("facturas", facturas);
		request.setAttribute("metodos", metodos);
		request.setAttribute("distribuidores", distribuidores);
		
		request.getRequestDispatcher("site/ListarFacturas.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
