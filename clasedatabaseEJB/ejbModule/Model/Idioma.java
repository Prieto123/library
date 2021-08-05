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
@Table(name="idiomas")

@NamedQueries({
	
	@NamedQuery(name="Idioma.getAll", query="select i from Idioma i")
	
	
})

public class Idioma implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	@ManyToMany(mappedBy = "idiomas")
    private List<Libro> libros;
	/**
	 * Se obtiene la id del idioma
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * Se establece la ID del idioma
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Se obtiene el nombre del idioma
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Se establece el nombre del idioma
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
