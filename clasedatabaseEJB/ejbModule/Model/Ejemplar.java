package Model;

import java.io.Serializable;

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
@Table(name="ejemplar_libro")

@NamedQueries({
	
	@NamedQuery(name="Ejemplar.getAll", query="select e from Ejemplar e")
	
	
})
public class Ejemplar implements Serializable{
	@Id
	private int numero_serie;
	private int precio;
	@ManyToOne
	@JoinColumn(name="estados_id")
	Estado estados_id;
	@ManyToOne
	@JoinColumn(name="libros_isbn")
	Libro libros_isbn;
	
	
	public int getNumero_serie() {
		return numero_serie;
	}
	public void setNumero_serie(int numero_serie) {
		this.numero_serie = numero_serie;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public Estado getEstados_id() {
		return estados_id;
	}
	public void setEstados_id(Estado estados_id) {
		this.estados_id = estados_id;
	}
	public Libro getLibros_isbn() {
		return libros_isbn;
	}
	public void setLibros_isbn(Libro libros_isbn) {
		this.libros_isbn = libros_isbn;
	}
}
