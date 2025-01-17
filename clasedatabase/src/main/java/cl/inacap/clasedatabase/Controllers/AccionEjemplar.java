package cl.inacap.clasedatabase.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
import Model.Libro;
import Servicios.ArriendosServiceLocal;
import Servicios.EjemplaresServiceLocal;
import Servicios.EstadosServiceLocal;
import Servicios.LibrosServiceLocal;

/**
 * Servlet implementation class AccionEjemplar
 * Actualiza un estado de un Libro Ejemplar a Arrendado, Vendido o Disponible, adem�s de poder borrar un Ejemplar Libro
 */
@WebServlet("/AccionEjemplar.do")
public class AccionEjemplar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccionEjemplar() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject private LibrosServiceLocal libroService;
    @Inject private EjemplaresServiceLocal ejemplarService;
    @Inject private EstadosServiceLocal estadoService;
    @Inject private ArriendosServiceLocal arriendosService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String accion = request.getParameter("accion");
		int numero_serie = Integer.parseInt(request.getParameter("numero_serie"));
		List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
		ejemplares = ejemplarService.getAll();
		List<Estado> estados = new ArrayList<Estado>();
		estados = estadoService.getAll();
		List<Arriendo> arriendos = new ArrayList<Arriendo>();
		arriendos = arriendosService.getAll();
		int precio = 0;
		Estado estado = new Estado();
		Libro libro = new Libro();
		switch (accion) {
		case "disponible": {
			for(int i = 0; i < ejemplares.size(); i++) {
				if(ejemplares.get(i).getNumero_serie() == numero_serie) {
					precio = ejemplares.get(i).getPrecio();
					estado = ejemplares.get(i).getEstados_id();
					libro = ejemplares.get(i).getLibros_isbn();
				}
			}
			for (int i = 0; i < estados.size(); i++) {
				if (estados.get(i).getEstado().equals("Disponible")) {
					estado = estados.get(i);
				}
			}
			Ejemplar ejemplar = new Ejemplar();
			ejemplar.setNumero_serie(numero_serie);
			ejemplar.setPrecio(precio);
			ejemplar.setLibros_isbn(libro);
			ejemplar.setEstados_id(estado);
			
			ejemplarService.update(ejemplar);
			
			break;
		}
			
			
		case "arrendado":{
			for(int i = 0; i < ejemplares.size(); i++) {
				if(ejemplares.get(i).getNumero_serie() == numero_serie) {
					precio = ejemplares.get(i).getPrecio();
					estado = ejemplares.get(i).getEstados_id();
					libro = ejemplares.get(i).getLibros_isbn();
				}
			}
			for (int i = 0; i < estados.size(); i++) {
				if (estados.get(i).getEstado().equals("Arrendado")) {
					estado = estados.get(i);
				}
			}
			Ejemplar ejemplar = new Ejemplar();
			ejemplar.setNumero_serie(numero_serie);
			ejemplar.setPrecio(precio);
			ejemplar.setLibros_isbn(libro);
			ejemplar.setEstados_id(estado);
			
			ejemplarService.update(ejemplar);
			
			break;
		}
		case "vendido":{
			for(int i = 0; i < ejemplares.size(); i++) {
				if(ejemplares.get(i).getNumero_serie() == numero_serie) {
					precio = ejemplares.get(i).getPrecio();
					estado = ejemplares.get(i).getEstados_id();
					libro = ejemplares.get(i).getLibros_isbn();
				}
			}
			for (int i = 0; i < estados.size(); i++) {
				if (estados.get(i).getEstado().equals("Comprado")) {
					estado = estados.get(i);
				}
			}
			Ejemplar ejemplar = new Ejemplar();
			ejemplar.setNumero_serie(numero_serie);
			ejemplar.setPrecio(precio);
			ejemplar.setLibros_isbn(libro);
			ejemplar.setEstados_id(estado);
			
			ejemplarService.update(ejemplar);
			
			break;
		}
		
		case "eliminar":{
			Ejemplar e = new Ejemplar();
			for(Ejemplar ejemplar : ejemplares) {
				if(ejemplar.getNumero_serie() == numero_serie) {
					e = ejemplar;
				}
			}
			for(Arriendo arriendo : arriendos) {
				for (int i = 0; i < arriendo.getEjemplar().size(); i++) {
					if(arriendo.getEjemplar().get(i).getLibros_isbn().getTitulo().equals(e.getLibros_isbn().getTitulo())) {
						
						out.println(arriendo.getEjemplar().get(i).getLibros_isbn().getTitulo());
						arriendo.getEjemplar().remove(i);
						arriendosService.update(arriendo);
						
					}
				}
			}
			ejemplarService.remove(e);
			break;
		}
		default:
			break;
		}
		response.sendRedirect("ListaEjemplares.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
