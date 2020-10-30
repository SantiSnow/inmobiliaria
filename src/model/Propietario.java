package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="propietario")
public class Propietario {
	
	//campos de clase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id", unique=true, nullable = false)
	private Integer Id;
	
	@Column(name="Nombre")
	private String Nombre;
	
	@Column(name="Telefono")
	private Integer Telefono;
	
	@Column(name="Correo")
	private String Correo;
	
	@Column(name="Direccion")
	private String Direccion;
	
	@Column(name="Comentarios")
	private String Comentarios;
	
	@OneToMany(mappedBy = "cliente", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE} )
	private List<Inmueble> listaInmuebles;

	
	
	
	
}
