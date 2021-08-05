package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="facturas")

@NamedQueries({
	
	@NamedQuery(name="Factura.getAll", query="select f from Factura f")
	
	
})
public class Factura implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int folio;
	private Date fecha_compra;
	private Date hora_compra;
	@ManyToOne(cascade= {CascadeType.MERGE}) 
	@JoinColumn(name="metodos_pago_id")
	private MetodoPago metodo_pago;
	@ManyToOne(cascade= {CascadeType.MERGE}) 
	@JoinColumn(name="distribuidores_rut")
	private Distribuidor distribuidor;
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
			name = "compras",
			joinColumns = @JoinColumn(name = "facturas_folio"),
			inverseJoinColumns = @JoinColumn(name = "ejemplar_libro_numero_serie")
			)
	private List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
	
	public int getCosto() {
		int valor = 0;
		for(Ejemplar e : ejemplares) {
			valor += e.getPrecio();
		}
		return valor;
	}
	public int getCostoIVA() {
		int valor = 0;
		for(Ejemplar e : ejemplares) {
			valor += e.getPrecio();
		}
		return valor + valor*19/100;
	}
	
	public Date getHora_compra() {
		return hora_compra;
	}
	public void setHora_compra(Date hora_compra) {
		this.hora_compra = hora_compra;
	}
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	public Date getFecha_compra() {
		return fecha_compra;
	}
	public void setFecha_compra(Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}
	public MetodoPago getMetodo_pago() {
		return metodo_pago;
	}
	public void setMetodo_pago(MetodoPago metodo_pago) {
		this.metodo_pago = metodo_pago;
	}
	public Distribuidor getDistribuidor() {
		return distribuidor;
	}
	public void setDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
	}
	public List<Ejemplar> getEjemplares() {
		return ejemplares;
	}
	public void setEjemplares(List<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}
}
