package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="clientes")

@NamedQueries({
	
	@NamedQuery(name="Cliente.getAll", query="select cl from Cliente cl")
	
	
})
public class Cliente implements Serializable {
	@Id
	private int rut;
	private int numero_verificador;
	private String nombre;
	private String apellido_paterno;
	private String apellido_materno;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE}) 
	@JoinTable(
			name="clientes_has_telefonos",
			joinColumns=@JoinColumn(name="clientes_rut"),
			inverseJoinColumns =@JoinColumn(name="telefonos_id")
	)
	private List<Telefono> telefonos = new ArrayList<Telefono>();
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE}) 
	@JoinTable(
			name="clientes_has_direcciones",
			joinColumns=@JoinColumn(name="clientes_rut"),
			inverseJoinColumns =@JoinColumn(name="direcciones_id")
	)
	private List<Direccion> direcciones = new ArrayList<Direccion>();
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
			name = "clientes_has_correos",
			joinColumns = @JoinColumn(name = "clientes_id"),
			inverseJoinColumns = @JoinColumn(name = "correos_id")
			)
	private List<Correo> correos = new ArrayList<Correo>();
	
	
	/**
	 * Se obtiene una Lista de los telefonos, ver documentacion de class.Telefono
	 * @return
	 */
	public List<Telefono> getTelefonos() {
		return telefonos;
	}
	/**
	 * Se obtiene  la cantidad de telefonos que tiene el cliente
	 * @return
	 */
	public int getCantTelefonos() {
		int cantidad = 0;
		for(Telefono telefono : telefonos) {
			cantidad++;
		}
		return cantidad;
	}
	/**
	 * Se establece una nueva lista de telefonos al cliente
	 * @param telefonos
	 */
	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	/**
	 * Se obtiene una Lista de direcciones del cliente, ver documentacion de class.Direccion
	 * @return
	 */
	public List<Direccion> getDirecciones() {
		return direcciones;
	}
	/**
	 * Se obtiene la cantidad de direcciones que tiene el cliente
	 * @return
	 */
	public int getCantDirecciones() {
		int cantidad = 0;
		for(Direccion direccion : direcciones) {
			cantidad++;
		}
		return cantidad;
	}
	/**
	 * Se establece una nueva lista de direcciones al cliente
	 * @param direcciones
	 */
	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
	/**
	 * Se obtiene una lista de correos del cliente, ver documentacion de class.Correo
	 * @return
	 */
	public List<Correo> getCorreos() {
		return correos;
	}
	/**
	 * Se obtiene la cantidad de correos que tiene el cliente
	 * @return
	 */
	public int getCantCorreos() {
		int cantidad = 0;
		List<Correo> correos2 = this.correos;
		for (int i = 0; i < correos2.size(); i++) {
			Correo correo = correos2.get(i);
			cantidad++;
		}
		return cantidad;
	}
	/**
	 * Se establece una nueva lista de correos al cliente
	 * @param correos
	 */
	public void setCorreos(List<Correo> correos) {
		this.correos = correos;
	}
	/**
	 * Se obtiene el rut del cliente
	 * @return
	 */
	public int getRut() {
		return rut;
	}
	/**
	 * Se establece el rut del cliente
	 * @param rut
	 */
	public void setRut(int rut) {
		this.rut = rut;
	}
	/**
	 * Se obtiene el numero verificador del rut del cliente
	 * @return
	 */
	public int getNumero_verificador() {
		return numero_verificador;
	}
	/**
	 * Se establece el numero verificador del rut del cliente
	 * @param numero_verificador
	 */
	public void setNumero_verificador(int numero_verificador) {
		this.numero_verificador = numero_verificador;
	}
	/**
	 * Se obtiene el nombre del cliente
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Se establece el nombre del cliente
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Se obtiene el apellido paterno del cliente
	 * @return
	 */
	public String getApellido_paterno() {
		return apellido_paterno;
	}
	/**
	 * Se establece el apellido paterno del cliente
	 * @param apellido_paterno
	 */
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}
	/**
	 * Se obtiene el apellido materno del cliente
	 * @return
	 */
	public String getApellido_materno() {
		return apellido_materno;
	}
	/**
	 * Se establece el apellido materno del cliente
	 * @param apellido_materno
	 */
	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
}
