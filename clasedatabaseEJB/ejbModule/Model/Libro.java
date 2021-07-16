package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name="libros")

@NamedQueries({
	@NamedQuery(name="Libro.getAll", query="select l from Libro l")	
})

public class Libro implements Serializable{

	
	@Id
	private long isbn;
	
	private String titulo;
	private int paginas;
	private int ano_publicado;	

	@ManyToOne
	@JoinColumn(name="editoriales_id")
	Editorial ed;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE}) 
	@JoinTable(
			name="libros_has_autores",
			joinColumns=@JoinColumn(name="libros_isbn"),
			inverseJoinColumns =@JoinColumn(name="autores_id")
	)
	private List<Autor> AutorList = new ArrayList<Autor>();
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE}) 
	@JoinTable(
			name="libros_has_categorias",
			joinColumns=@JoinColumn(name="libros_isbn"),
			inverseJoinColumns =@JoinColumn(name="categorias_id")
	)
	private List<Categoria> categorias = new ArrayList<Categoria>();
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
			name = "libros_has_idiomas",
			joinColumns = @JoinColumn(name = "libros_isbn"),
			inverseJoinColumns = @JoinColumn(name = "idiomas_id")
			)
	private List<Idioma> idiomas = new ArrayList<Idioma>();
	
	public List<Autor> getAutorList() {
		return AutorList;
	}
	public void setAutorList(List<Autor> autorList) {
		AutorList = autorList;
	}
	public List<Idioma> getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategoria(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	public Editorial getEd() {
		return ed;
	}
	public void setEd(Editorial ed) {
		this.ed = ed;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public int getAno_publicado() {
		return ano_publicado;
	}
	public void setAno_publicado(int ano_publicado) {
		this.ano_publicado = ano_publicado;
	}
	/*public int getEditoriales_id() {
		return editoriales_id;
	}
	public void setEditoriales_id(int editoriales_id) {
		this.editoriales_id = editoriales_id;
	}*/
	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", paginas=" + paginas + ", ano_publicado="
				+ ano_publicado + ", editoriales_id=" +ed+ "]";
	}
	

}
