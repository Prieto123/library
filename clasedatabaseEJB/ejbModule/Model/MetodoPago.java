package Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="metodos_pago")

@NamedQueries({
	
	@NamedQuery(name="MetodoPago.getAll", query="select mp from MetodoPago mp")
	
	
})
public class MetodoPago implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String metodo;
	
	/**
	 * Se obtiene la id del metodo de pago
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * Se establece la id del metodo de pago
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Se obtiene el nombre del metodo de pago
	 * @return
	 */
	public String getMetodo() {
		return metodo;
	}
	/**
	 * Se establece el nombre del metodo de pago
	 * @param metodo
	 */
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
}
