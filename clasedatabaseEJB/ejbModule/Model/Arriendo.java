package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="arriendos")

@NamedQueries({
	
	@NamedQuery(name="Arriendo.getAll", query="select ar from Arriendo ar")
	
	
})
public class Arriendo implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date fecha_arriendo;
	private Date fecha_devolucion_deseada;
	private Date fecha_devolucion_real;
	@ManyToOne
	@JoinColumn(name="clientes_rut")
	private Cliente clientes_rut;
	@ManyToOne
	@JoinColumn(name="trabajadores_rut")
	private Trabajador trabajadores_rut;
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
			name = "detalle_arriendo",
			joinColumns = @JoinColumn(name = "arriendos_id"),
			inverseJoinColumns = @JoinColumn(name = "ejemplar_libro_numero_serie")
			)
	private List<Ejemplar> ejemplar = new ArrayList<Ejemplar>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha_arriendo() {
		return fecha_arriendo;
	}
	public void setFecha_arriendo(Date fecha_arriendo) {
		this.fecha_arriendo = fecha_arriendo;
	}
	public Date getFecha_devolucion_deseada() {
		return fecha_devolucion_deseada;
	}
	public void setFecha_devolucion_deseada(Date fecha_devolucion_deseada) {
		this.fecha_devolucion_deseada = fecha_devolucion_deseada;
	}
	public Date getFecha_devolucion_real() {
		return fecha_devolucion_real;
	}
	public void setFecha_devolucion_real(Date fecha_devolucion_real) {
		this.fecha_devolucion_real = fecha_devolucion_real;
	}
	public Cliente getClientes_rut() {
		return clientes_rut;
	}
	public void setClientes_rut(Cliente clientes_rut) {
		this.clientes_rut = clientes_rut;
	}
	public Trabajador getTrabajadores_rut() {
		return trabajadores_rut;
	}
	public void setTrabajadores_rut(Trabajador trabajadores_rut) {
		this.trabajadores_rut = trabajadores_rut;
	}
	public List<Ejemplar> getEjemplar() {
		return ejemplar;
	}
	public void setEjemplar(List<Ejemplar> ejemplar) {
		this.ejemplar = ejemplar;
	}
	public int getTotal() {
		int total = 0;
		for(Ejemplar ejemplar : this.ejemplar) {
			total += ejemplar.getPrecio();
		}
		return total;
	}
	public int getTotalIva() {
		int total = 0;
		for(Ejemplar ejemplar : this.ejemplar) {
			total += ejemplar.getPrecio();
		}
		return total + (total * 19)/100;
	}
	
}
