package Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="distribuidores")

@NamedQueries({
	
	@NamedQuery(name="Distribuidor.getAll", query="select dis from Distribuidor dis")
	
	
})
public class Distribuidor implements Serializable{
	
	@Id
	private int rut;
	private int numero_verificador;
	private String nombre;
	private int ano_antiguedad;
	
	@ManyToOne
	@JoinColumn(name="telefonos_id")
	private Telefono telefono;
	
	@ManyToOne
	@JoinColumn(name="direcciones_id")
	private Direccion direccion;

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

	public int getAno_antiguedad() {
		return ano_antiguedad;
	}

	public void setAno_antiguedad(int ano_antiguedad) {
		this.ano_antiguedad = ano_antiguedad;
	}

	public Telefono getTelefono() {
		return telefono;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
}
