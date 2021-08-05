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
@Table(name="direcciones")

@NamedQueries({
	
	@NamedQuery(name="Direccion.getAll", query="select dir from Direccion dir")
	
	
})
/**
 * 
 * @author pablo
 *
 */
public class Direccion implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String direccion;
	/**
	 * Se obtiene una ID de la direccion de hogar
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * Se establece la ID de la direccion de hogar, generalmente no se usa ya que es Autoincrementable
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Se obtiene la direccion de hogar
	 * @return
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Se establece la dierccion de hogar
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
