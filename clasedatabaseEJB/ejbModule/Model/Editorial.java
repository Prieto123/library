package Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="editoriales")

@NamedQueries({
	
	@NamedQuery(name="Editorial.getAll", query="select ed from Editorial ed")
	
	
})

public class Editorial implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="editorial")
	private String editorial;
	
	/**
	 * Se obtiene la ID de la editorial
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * Se establece la ID de la editorial
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Se obtiene el nombre de la editorial
	 * @return
	 */
	public String getEditorial() {
		return editorial;
	}
	/**
	 * Se establece el nombre de la editorial
	 * @param editorial
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	
}
