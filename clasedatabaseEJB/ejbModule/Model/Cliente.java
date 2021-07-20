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
	
	public List<Telefono> getTelefonos() {
		return telefonos;
	}
	public int getCantTelefonos() {
		int cantidad = 0;
		for(Telefono telefono : telefonos) {
			cantidad++;
		}
		return cantidad;
	}
	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	public List<Direccion> getDirecciones() {
		return direcciones;
	}
	public int getCantDirecciones() {
		int cantidad = 0;
		for(Direccion direccion : direcciones) {
			cantidad++;
		}
		return cantidad;
	}
	
	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
	public List<Correo> getCorreos() {
		return correos;
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
	
	public void setCorreos(List<Correo> correos) {
		this.correos = correos;
	}
	public int getRut() {
		return rut;
	}
	public void setRut(int rut) {
		this.rut = rut;
	}
	public int getNumero_verificador() {
		return numero_verificador;
	}
	public void setNumero_verificador(int numero_verificador) {
		this.numero_verificador = numero_verificador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido_paterno() {
		return apellido_paterno;
	}
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}
	public String getApellido_materno() {
		return apellido_materno;
	}
	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
}
