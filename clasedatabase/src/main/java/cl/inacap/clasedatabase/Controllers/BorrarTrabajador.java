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
import Model.Boleta;
import Model.Ejemplar;
import Model.Estado;
import Model.Trabajador;
import Servicios.ArriendosServiceLocal;
import Servicios.BoletasServiceLocal;
import Servicios.EjemplaresService;
import Servicios.EjemplaresServiceLocal;
import Servicios.EstadosServiceLocal;
import Servicios.TrabajadoresServiceLocal;

/**
 * Servlet implementation class BorrarTrabajador
 */
@WebServlet("/BorrarTrabajador.do")
public class BorrarTrabajador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarTrabajador() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject private TrabajadoresServiceLocal trabajadoresService;
    @Inject private ArriendosServiceLocal arriendosService;
    @Inject private BoletasServiceLocal boletasService;
    @Inject private EstadosServiceLocal estadosService;
    @Inject private EjemplaresServiceLocal ejemplaresService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();
		trabajadores = trabajadoresService.getAll();
		List<Arriendo> arriendos = new ArrayList<Arriendo>();
		arriendos = arriendosService.getAll();
		List<Boleta> boletas = new ArrayList<Boleta>();
		boletas = boletasService.getAll();
		List<Estado> estados = new ArrayList<Estado>();
		estados = estadosService.getAll();
		
		int rut = 0;
		boolean doIt = false;
		
		try {
			rut = Integer.parseInt(request.getParameter("rut"));
			doIt = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(doIt) {
			for(Boleta boleta : boletas) {
				if(boleta.getTrabajadores_rut().getRut() == rut) {
					boletasService.remove(boleta);
				}
			}
			for(Arriendo arriendo : arriendos) {
				if(arriendo.getTrabajadores_rut().getRut() == rut) {
					for(Ejemplar ejemplar : arriendo.getEjemplar()) {
						for(Estado estado : estados) {
							if(estado.getEstado().equals("Disponible")) {
								ejemplar.setEstados_id(estado);
								ejemplaresService.update(ejemplar);
							}
						}
						
					}
					arriendosService.remove(arriendo);
				}
			}
			for(Trabajador trabajador : trabajadores) {
				if(trabajador.getRut() == rut) {
					trabajadoresService.remove(trabajador);
				}
			}
		}
		response.sendRedirect("DetalleTrabajadores.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
