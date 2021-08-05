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
@Table(name="estados")

@NamedQueries({
	
	@NamedQuery(name="Estado.getAll", query="select est from Estado est")
	
	
})
/**
 * 
 * @author pablo
 *
 */
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String estado;
	/**
	 * Se obtiene el ID del estado
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * Se establece el ID del estado
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Se obtiene el nombre del estado
	 * @return
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * Se establece el nombre del estado
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
