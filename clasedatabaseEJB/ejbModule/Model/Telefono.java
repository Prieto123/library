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
@Table(name="telefonos")

@NamedQueries({
	
	@NamedQuery(name="Telefono.getAll", query="select tel from Telefono tel")
	
	
})
/**
 * 
 * @author pablo
 *
 */
public class Telefono implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String numero;
	/**
	 * Se obtiene la ID del telefono
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * Se establece la ID del telefono
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Se obtiene el numero de telefono
	 * @return
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * Se establece el numero de telefono
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
