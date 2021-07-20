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
@Table(name="distribuidores")

@NamedQueries({
	
	@NamedQuery(name="Distribuidor.getAll", query="select dis from Distribuidor dis")
	
	
})
public class Distribuidor implements Serializable{
	
	@Id
	private int rut;
	private int numero_verificador;
	private String nombre;
	private int ano_antiguedad;
	
	@ManyToOne
	@JoinColumn(name="telefonos_id")
	private Telefono telefono;
	
	@ManyToOne
	@JoinColumn(name="direcciones_id")
	private Direccion direccion;

}
