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
import Model.Cliente;
import Model.Direccion;
import Model.Ejemplar;
import Model.Estado;
import Servicios.ArriendosServiceLocal;
import Servicios.EjemplaresServiceLocal;
import Servicios.EstadosServiceLocal;

/**
 * Servlet implementation class AnadirEjemplarBoleta
 * Clase destinada a agregar los Detalles del Arriendo
 */
@WebServlet("/AnadirEjemplarBoleta.do")
public class AnadirEjemplarBoleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnadirEjemplarBoleta() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject
    private ArriendosServiceLocal arriendosService;
    @Inject
    private EjemplaresServiceLocal ejemplaresService;
    @Inject
    private EstadosServiceLocal estadosService;

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
		// TODO Auto-generated method stub
		List<Arriendo> arriendos = new ArrayList<Arriendo>();
		arriendos = arriendosService.getAll();
		List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
		ejemplares = ejemplaresService.getAll();
		List<Ejemplar> ejemplaresArriendo = new ArrayList<Ejemplar>();
		List<Estado> estados = new ArrayList<Estado>();
		estados = estadosService.getAll();
		boolean doIt = false;
		int id = Integer.parseInt(request.getParameter("id"));
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
					if (estado.getEstado().equals("Arrendado")) {
						Estado est = new Estado();
						est = estado;
						addEjemplar.setEstados_id(estado);
						break;
					}
				}
				break;
			}
		}
		Arriendo arriendoFinal = new Arriendo();
		if(doIt) {
			for(Arriendo arriendo : arriendos) {
				boolean existeEnArriendo = false;
				if (arriendo.getId() == id) {
					arriendoFinal = arriendo;
					ejemplaresArriendo = arriendo.getEjemplar();
					for(int i = 0; i < ejemplaresArriendo.size(); i++) {
						if(ejemplaresArriendo.get(i).getLibros_isbn().equals(addEjemplar.getLibros_isbn())){
							existeEnArriendo = true;
							break;
						}
					}
					if(!existeEnArriendo) {
						
						ejemplaresArriendo.add(addEjemplar);
						arriendoFinal.setEjemplar(ejemplaresArriendo);
						arriendosService.update(arriendoFinal);
					}
				}
			}
		}
		
		response.sendRedirect("DetalleArriendo.do");
	}

}
