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

import Model.Arriendo;
import Model.Ejemplar;
import Model.Estado;
import Model.Factura;
import Servicios.ArriendosServiceLocal;
import Servicios.EjemplaresServiceLocal;
import Servicios.EstadosServiceLocal;
import Servicios.FacturasServiceLocal;

/**
 * Servlet implementation class AgregarCompra
 */
@WebServlet("/AgregarCompra.do")
public class AgregarCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarCompra() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject private FacturasServiceLocal facturasService;
    @Inject private EjemplaresServiceLocal ejemplaresService;
    @Inject private EstadosServiceLocal estadosService;

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
		List<Factura> facturas = new ArrayList<Factura>();
		facturas = facturasService.getAll();
		List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
		ejemplares = ejemplaresService.getAll();
		List<Ejemplar> ejemplaresFactura = new ArrayList<Ejemplar>();
		List<Estado> estados = new ArrayList<Estado>();
		estados = estadosService.getAll();
		boolean doIt = false;
		int folio = Integer.parseInt(request.getParameter("folio"));
		int ejemplar = 0;
		
		try {
			ejemplar = Integer.parseInt(request.getParameter("addEjemplar"));
			doIt = true;
		} catch (Exception e) {
			doIt = false;
		}
		
		Ejemplar addEjemplar = new Ejemplar();
		
		boolean existeDireccion = false;
		for(Ejemplar e : ejemplares) {
			if(e.getNumero_serie() == ejemplar) {
				existeDireccion = true;
				addEjemplar = e;
				for(Estado estado : estados) {
					if (estado.getEstado().equals("Comprado")) {
						Estado est = new Estado();
						est = estado;
						addEjemplar.setEstados_id(estado);
						break;
					}
				}
				break;
			}
		}
		Factura facturaFinal = new Factura();
		if(doIt) {
			for(Factura factura : facturas) {
				boolean existeEnArriendo = false;
				if (factura.getFolio() == folio) {
					facturaFinal = factura;
					ejemplaresFactura = factura.getEjemplares();
					for(int i = 0; i < ejemplaresFactura.size(); i++) {
						if(ejemplaresFactura.get(i).getLibros_isbn().equals(addEjemplar.getLibros_isbn())){
							existeEnArriendo = true;
							break;
						}
					}
					if(!existeEnArriendo) {
						
						ejemplaresFactura.add(addEjemplar);
						facturaFinal.setEjemplares(ejemplaresFactura);
						facturasService.update(facturaFinal);
					}
				}
			}
		}
		String ruta = "AgregarFactura.do?folio=" + folio;
		response.sendRedirect(ruta);
	}

}
