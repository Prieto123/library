package Model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="boletas")

@NamedQueries({
	
	@NamedQuery(name="Boleta.getAll", query="select bo from Boleta bo")
	
	
})
public class Boleta implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int folio;
	private Date fecha_venta;
	@ManyToOne
	@JoinColumn(name="cliente_rut")
	private Cliente cliente_rut;
	@ManyToOne
	@JoinColumn(name="trabajadores_rut")
	private Trabajador trabajadores_rut;
	@ManyToOne
	@JoinColumn(name="metodos_pago_id")
	private MetodoPago metodos_pago_id;
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	public Date getFecha_venta() {
		return fecha_venta;
	}
	public void setFecha_venta(Date fecha_venta) {
		this.fecha_venta = fecha_venta;
	}
	public Cliente getCliente_rut() {
		return cliente_rut;
	}
	public void setCliente_rut(Cliente cliente_rut) {
		this.cliente_rut = cliente_rut;
	}
	public Trabajador getTrabajadores_rut() {
		return trabajadores_rut;
	}
	public void setTrabajadores_rut(Trabajador trabajadores_rut) {
		this.trabajadores_rut = trabajadores_rut;
	}
	public MetodoPago getMetodos_pago_id() {
		return metodos_pago_id;
	}
	public void setMetodos_pago_id(MetodoPago metodos_pago_id) {
		this.metodos_pago_id = metodos_pago_id;
	}
}
