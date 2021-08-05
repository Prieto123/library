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
@Table(name="correos")

@NamedQueries({
	
	@NamedQuery(name="Correo.getAll", query="select cor from Correo cor")
	
	
})
/**
 * 
 * @author pablo
 *
 */
public class Correo implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String direccion;
	/**
	 * Se obtiene la ID del correo, es autoincrementable
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * Se establece la Id del correo, generalmente no se usa ya que es autoincrementable
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Se obtiene la direccion de correo electronico
	 * @return
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Se establece una direccion de correo electronico
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
