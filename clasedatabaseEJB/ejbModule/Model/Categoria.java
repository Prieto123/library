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
@Table(name="categorias")

@NamedQueries({
	
	@NamedQuery(name="Categoria.getAll", query="select cat from Categoria cat")
	
	
})

public class Categoria implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	@ManyToMany(mappedBy = "categorias")
    private List<Libro> libros;
	/**
	 * Se obtiene la ID de la Categoria
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * Se establece la ID de la categoria, es Autoincremental asi que generalmente no se usa
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Se obtiene el nombre de la categoria
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Se establece el nombre de la categoria
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
