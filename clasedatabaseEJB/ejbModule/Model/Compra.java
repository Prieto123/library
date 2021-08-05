package Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="compras")

@NamedQueries({
	
	@NamedQuery(name="Compra.getAll", query="select c from Compra c")
	
	
})
public class Compra implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ejemplar_libro_numero_serie")
	private Ejemplar ejemplar;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "facturas_folio")
	private Factura factura;

}
