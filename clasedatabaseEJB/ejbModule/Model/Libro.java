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

	@ManyToOne(cascade= {CascadeType.MERGE}) 
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
	/**
	 * Se obtiene una lista de los autores del libro
	 * @return
	 */
	public List<Autor> getAutorList() {
		return AutorList;
	}
	/**
	 * Se establece una lista de los autores del libro
	 * @param autorList
	 */
	public void setAutorList(List<Autor> autorList) {
		AutorList = autorList;
	}
	/**
	 * Se obtienen los idiomas del libro
	 * @return
	 */
	public List<Idioma> getIdiomas() {
		return idiomas;
	}
	/**
	 * Se establecen los idiomas del libro
	 * @param idiomas
	 */
	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}
	/**
	 * Se obtienen las categorias del libro
	 * @return
	 */
	public List<Categoria> getCategorias() {
		return categorias;
	}
	/**
	 * Se establecen las categorias del libro
	 * @param categorias
	 */
	public void setCategoria(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	/**
	 * Se obtiene la editorial del libro
	 * @return
	 */
	public Editorial getEd() {
		return ed;
	}
	/**
	 * Se establece la editorial del libro
	 * @param ed
	 */
	public void setEd(Editorial ed) {
		this.ed = ed;
	}
	/**
	 * Se obtiene el ISBN del libro
	 * @return
	 */
	public long getIsbn() {
		return isbn;
	}
	/**
	 * Se establece el ISBN del libro
	 * @param isbn
	 */
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	/**
	 * Se obtiene el titulo del libro
	 * @return
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * Se establece el titulo del libro
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * Se obtienen la cantidad de paginas del libro
	 * @return
	 */
	public int getPaginas() {
		return paginas;
	}
	/**
	 * Se establece la cantidad de paginas del libro
	 * @param paginas
	 */
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	/**
	 * Se obtiene el año de publicacion del libro
	 * @return
	 */
	public int getAno_publicado() {
		return ano_publicado;
	}
	/**
	 * Se establece el año de publicacion del libro
	 * @param ano_publicado
	 */
	public void setAno_publicado(int ano_publicado) {
		this.ano_publicado = ano_publicado;
	}
	

}
