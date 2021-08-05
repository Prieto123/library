package cl.inacap.clasedatabase.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
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

import Model.Direccion;
import Model.Distribuidor;
import Model.Telefono;
import Servicios.DireccionesServiceLocal;
import Servicios.DistribuidoresServiceLocal;
import Servicios.TelefonosServiceLocal;

/**
 * Servlet implementation class ListarDistribuidores
 */
@WebServlet("/ListarDistribuidores.do")
public class ListarDistribuidores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarDistribuidores() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject private DistribuidoresServiceLocal distribuidoresService;
    @Inject private DireccionesServiceLocal direccionesService;
    @Inject private TelefonosServiceLocal telefonosService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Distribuidor> distribuidores = new ArrayList<Distribuidor>();
		distribuidores = distribuidoresService.getAll();
		request.setAttribute("distribuidores", distribuidores);
		
		request.getRequestDispatcher("site/listaDistribuidores.jsp").forward(request, response);
	}
	
	public static Date parseDate(String date) {
    	try {
    		return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    	} catch (Exception e) {
    		return null;
    	}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Telefono telefono = new Telefono();
		Direccion direccion = new Direccion();
		
		String dir = request.getParameter("direccion");
		String tel =  request.getParameter("telefono");
		
		List<Direccion> direcciones = new ArrayList<Direccion>();
		direcciones = direccionesService.getAll();
		
		List<Telefono> telefonos = new ArrayList<Telefono>();
		telefonos = telefonosService.getAll();
		
		boolean existeDireccion = false;
		for(Direccion d : direcciones) {
			if(d.getDireccion().equals(dir)) {
				existeDireccion = true;
				direccion = d;
				break;
			}
		}
		
		boolean existeTelefono = false;
		for(Telefono t : telefonos) {
			if(Integer.parseInt(t.getNumero()) == Integer.parseInt(tel)) {
				existeTelefono = true;
				telefono = t;
				break;
			}
		}
		
		int rut = Integer.parseInt(request.getParameter("rut"));
		int verificador = Integer.parseInt(request.getParameter("verificador"));
		String nombre = request.getParameter("nombre");
		int ano = Integer.parseInt(request.getParameter("fecha"));
		
		if(!existeTelefono) {
			telefono.setNumero(tel);
			telefonosService.add(telefono);
		}
		if(!existeDireccion) { 
			direccion.setDireccion(dir);
			direccionesService.add(direccion);
		}
		
		Distribuidor dis = new Distribuidor();
		dis.setRut(rut);
		dis.setNumero_verificador(verificador);
		dis.setNombre(nombre);
		dis.setAno_antiguedad(ano);
		dis.setTelefono(telefono);
		dis.setDireccion(direccion);
		
		PrintWriter out = response.getWriter();
		out.println(dis.getRut());
		out.println(dis.getNumero_verificador());
		out.println(dis.getNombre());
		out.println(dis.getAno_antiguedad());
		out.println(dis.getDireccion().getDireccion());
		out.println(dis.getTelefono().getNumero());
		
		distribuidoresService.add(dis);
		
		response.sendRedirect("ListarDistribuidores.do");
	}

}
