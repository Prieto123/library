package cl.inacap.clasedatabase.Controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Distribuidor;
import Model.Ejemplar;
import Model.Factura;
import Model.MetodoPago;
import Servicios.DistribuidoresServiceLocal;
import Servicios.EjemplaresServiceLocal;
import Servicios.FacturasServiceLocal;
import Servicios.MetodosPagoServiceLocal;

/**
 * Servlet implementation class AgregarFactura
 */
@WebServlet("/AgregarFactura.do")
public class AgregarFactura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarFactura() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject private FacturasServiceLocal facturasService;
    @Inject private MetodosPagoServiceLocal metodosService;
    @Inject private DistribuidoresServiceLocal distribuidoresService;
    @Inject private EjemplaresServiceLocal ejemplaresService;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int folio = Integer.parseInt(request.getParameter("folio"));
		
		List<Factura> facturas = new ArrayList<Factura>();
		facturas = facturasService.getAll();
		
		Factura factura = new Factura();
		
		for(Factura f : facturas) {
			if(f.getFolio() == folio) {
				factura = f;
			}
		}
		
		List<MetodoPago> metodos = new ArrayList<MetodoPago>();
		metodos = metodosService.getAll();
		
		List<Distribuidor> distribuidores = new ArrayList<Distribuidor>();
		distribuidores = distribuidoresService.getAll();
		
		List<Ejemplar> fullEjemplar = new ArrayList<Ejemplar>();
		fullEjemplar = ejemplaresService.getAll();
		
		List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
		
		for(Ejemplar e : fullEjemplar) {
			if(e.getEstados_id().getEstado().equals("Disponible")) {
				ejemplares.add(e);
			}
		}
		
		request.setAttribute("factura", factura);
		request.setAttribute("metodos", metodos);
		request.setAttribute("distribuidores", distribuidores);
		request.setAttribute("ejemplares", ejemplares);
		
		request.getRequestDispatcher("site/detalleFactura.jsp").forward(request, response);
	}

	public static Date parseDate(String date) {
    	try {
    		return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    	} catch (Exception e) {
    		return null;
    	}
    }	
	
	public static Date parseHour(String date) {
    	try {
    		return new SimpleDateFormat("HH:mm:ss").parse(date);
    	} catch (Exception e) {
    		return null;
    	}
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Date fecha = parseDate(request.getParameter("fecha"));
		Date hora = parseHour(request.getParameter("hora"));
		
		MetodoPago metodo = new MetodoPago();
		Distribuidor distribuidor = new Distribuidor();
		
		List<MetodoPago> metodos = new ArrayList<MetodoPago>();
		List<Distribuidor> distribuidores = new ArrayList<Distribuidor>();
		
		metodos = metodosService.getAll();
		distribuidores = distribuidoresService.getAll();
		
		for(MetodoPago m : metodos) {
			if(m.getId() == Integer.parseInt(request.getParameter("metodo"))) {
				metodo = m;
			}
		}
		
		for(Distribuidor d : distribuidores) {
			if(d.getRut() == Integer.parseInt(request.getParameter("distribuidor"))) {
				distribuidor = d;
			}
		}
		
		List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
		
		Factura factura = new Factura();
		factura.setFecha_compra(fecha);
		factura.setHora_compra(hora);
		factura.setMetodo_pago(metodo);
		factura.setDistribuidor(distribuidor);
		factura.setEjemplares(ejemplares);
		
		facturasService.add(factura);
		
		
		
	}

}
