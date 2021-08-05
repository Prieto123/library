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
import Servicios.ArriendosServiceLocal;
import Servicios.EjemplaresServiceLocal;
import Servicios.EstadosServiceLocal;

/**
 * Servlet implementation class BorrarArriendo
 * Esta clase está destinada para Borrar un Arriendo
 */
@WebServlet("/BorrarArriendo.do")
public class BorrarArriendo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarArriendo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject private ArriendosServiceLocal arriendosService;
    @Inject private EstadosServiceLocal estadosService;
    @Inject private EjemplaresServiceLocal ejemplaresService;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Mediante el método GET
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int folio = Integer.parseInt(request.getParameter("folio"));
		
		List<Arriendo> arriendos = new ArrayList<Arriendo>();
		arriendos = arriendosService.getAll();
		List<Estado> estados = new ArrayList<Estado>();
		estados = estadosService.getAll();
		
		for(Arriendo arriendo : arriendos) {
			if(arriendo.getId() == folio) {
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
		response.sendRedirect("DetalleArriendo.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
