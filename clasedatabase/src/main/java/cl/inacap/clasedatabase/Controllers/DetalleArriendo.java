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
import Model.Cliente;
import Model.Ejemplar;
import Model.Trabajador;
import Servicios.ArriendosServiceLocal;
import Servicios.ClientesServiceLocal;
import Servicios.EjemplaresServiceLocal;
import Servicios.TrabajadoresServiceLocal;

/**
 * Servlet implementation class DetalleArriendo
 */
@WebServlet("/DetalleArriendo.do")
public class DetalleArriendo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalleArriendo() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Inject
    private ClientesServiceLocal clientesService;
    @Inject
    private TrabajadoresServiceLocal trabajadoresService;
    @Inject
    private ArriendosServiceLocal arriendosService;
    @Inject
    private EjemplaresServiceLocal ejemplaresService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes = clientesService.getAll();
		request.setAttribute("clientes", clientes);
		
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();
		trabajadores = trabajadoresService.getAll();
		request.setAttribute("trabajadores", trabajadores);
		
		List<Arriendo> arriendos = new ArrayList<Arriendo>();
		arriendos = arriendosService.getAll();
		request.setAttribute("arriendos", arriendos);
		List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
		ejemplares = ejemplaresService.getAll();
		List<Ejemplar> ejemplaresDisponibles = new ArrayList<Ejemplar>();
		for(Ejemplar ejemplar : ejemplares) {
			if(ejemplar.getEstados_id().getEstado().equals("Disponible") ? ejemplaresDisponibles.add(ejemplar) : false);
		}
		request.setAttribute("ejemplares", ejemplaresDisponibles);
		
		request.getRequestDispatcher("site/listaArriendos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
