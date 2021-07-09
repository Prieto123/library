package Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private long isbn;//Esta tontera me esta lec estoy seguro q esto esta ok
	// porque si se dio cuenta los set funcionaron todos, se cayo al poner add aaaa
	@Column(name="titulo")
	private String titulo;
	@Column(name="paginas")
	private int paginas;
	@Column(name="ano_publicado")
	private int ano_publicado;
	
	//@ManyToOne
	//@JoinColumn(name="editoriales_id")
	//Editorial editoriales_id;
	
	private int editoriales_id;
	
	
	
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
	public int getEditoriales_id() {
		return editoriales_id;
	}
	public void setEditoriales_id(int editoriales_id) {
		this.editoriales_id = editoriales_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
