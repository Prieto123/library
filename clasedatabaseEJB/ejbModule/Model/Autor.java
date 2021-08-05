package Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="autores")

@NamedQueries({
	
	@NamedQuery(name="Autor.getAll", query="select aut from Autor aut")
	
	
})
/**
 * 
 * @author pablo
 *
 */
public class Autor implements Serializable {
	@Id
	/**
	 * La ID de Autor es AI, en ese caso en cuando se cree la clase no es necesario poner setId
	 */
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String apellido_paterno;
	private String apellido_materno;
	
	/**
	 * Obtiene la ID de Autor
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Establece la ID a Autor, es Autoincrementable
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Se obtiene el Nombre del Autor
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Se establece en nombre del Autor
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Se obtiene el Apellido Paterno del Autor
	 * @return
	 */
	public String getApellido_paterno() {
		return apellido_paterno;
	}
	/**
	 * Se establece el apellido paterno del Autor
	 * @param apellido_paterno
	 */
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}
	/**
	 * Se obtiene el apellido materno del Autor
	 * @return
	 */
	public String getApellido_materno() {
		return apellido_materno;
	}
	/**
	 * Se establece el apellido materno del Autor
	 * @param apellido_materno
	 */
	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
}
