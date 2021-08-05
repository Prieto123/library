package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
@Table(name="trabajadores")

@NamedQueries({
	
	@NamedQuery(name="Trabajador.getAll", query="select tr from Trabajador tr")
	
	
})
/**
 * 
 * @author pablo
 *
 */
public class Trabajador implements Serializable {
	@Id
	private int rut;
	private int numero_verificador;
	private String nombre;
	private String apellido_paterno;
	private String apellido_materno;
	private Date fecha_contrato;
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE}) 
	@JoinTable(
			name="trabajadores_has_telefonos",
			joinColumns=@JoinColumn(name="trabajadores_id"),
			inverseJoinColumns =@JoinColumn(name="telefonos_id")
	)
	private List<Telefono> telefonos = new ArrayList<Telefono>();
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE}) 
	@JoinTable(
			name="trabajadores_has_direcciones",
			joinColumns=@JoinColumn(name="trabajadores_rut"),
			inverseJoinColumns =@JoinColumn(name="direcciones_id")
	)
	private List<Direccion> direcciones = new ArrayList<Direccion>();
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
			name = "trabajadores_has_correos",
			joinColumns = @JoinColumn(name = "trabajadores_id"),
			inverseJoinColumns = @JoinColumn(name = "correos_id")
			)
	private List<Correo> correos = new ArrayList<Correo>();
	/**
	 * Se obtiene el rut del trabajador
	 * @return
	 */
	public int getRut() {
		return rut;
	}
	/**
	 * Se establece el rut del trabajador
	 * @param rut
	 */
	public void setRut(int rut) {
		this.rut = rut;
	}
	/**
	 * Se obtiene el numero verificador del trabajador
	 * @return
	 */
	public int getNumero_verificador() {
		return numero_verificador;
	}
	/**
	 * Se establece el numero verificador del trabajador
	 * @param numero_verificador
	 */
	public void setNumero_verificador(int numero_verificador) {
		this.numero_verificador = numero_verificador;
	}
	/**
	 * Se obtiene el nombre del trabajador
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Se establece el nombre del trabajador
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Se obtiene el apellido paterno del trabajador
	 * @return
	 */
	public String getApellido_paterno() {
		return apellido_paterno;
	}
	/**
	 * Se establece el apellido paterno del trabajador
	 * @param apellido_paterno
	 */
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}
	/**
	 * Se obtiene el apellido materno del trabajador
	 * @return
	 */
	public String getApellido_materno() {
		return apellido_materno;
	}
	/**
	 * Se establece el apellido materno del trabajador
	 * @param apellido_materno
	 */
	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
	/**
	 * Se obtiene la fecha de contrato del trabajador
	 * @return
	 */
	public Date getFecha_contrato() {
		return fecha_contrato;
	}
	/**
	 * Se establece la fecha de contrato del trabajador
	 * @param fecha_contrato
	 */
	public void setFecha_contrato(Date fecha_contrato) {
		this.fecha_contrato = fecha_contrato;
	}
	/**
	 * Se obtienen una lista de telefonos perteneciente al trabajador
	 * @return
	 */
	public List<Telefono> getTelefonos() {
		return telefonos;
	}
	/**
	 * Se establece una nueva lista de telefonos perteneciente al trabajador
	 * @param telefonos
	 */
	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	/**
	 * Se obtiene una lista con las direcciones de hogar del trabajador
	 * @return
	 */
	public List<Direccion> getDirecciones() {
		return direcciones;
	}
	/**
	 * Se establece una lista con las direcciones de hogar del trabajador
	 * @param direcciones
	 */
	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
	/**
	 * Se obtiene una lista con las direcciones de correo electronico del trabajador
	 * @return
	 */
	public List<Correo> getCorreos() {
		return correos;
	}
	/**
	 * Se establece una lista con las direcciones de correo electronico del trabajador
	 * @param correos
	 */
	public void setCorreos(List<Correo> correos) {
		this.correos = correos;
	}
	
	public int getCantCorreos() {
		int cantidad = 0;
		List<Correo> correos2 = this.correos;
		for (int i = 0; i < correos2.size(); i++) {
			Correo correo = correos2.get(i);
			cantidad++;
		}
		return cantidad;
	}
	
	public int getCantDirecciones() {
		int cantidad = 0;
		for(Direccion direccion : direcciones) {
			cantidad++;
		}
		return cantidad;
	}
	
	public int getCantTelefonos() {
		int cantidad = 0;
		for(Telefono telefono : telefonos) {
			cantidad++;
		}
		return cantidad;
	}
	
	
}
