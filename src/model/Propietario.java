package model;

import java.util.ArrayList;
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
	
	@OneToMany(mappedBy = "propietario", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE} )
	private List<Inmueble> listaInmuebles;
	
	//constructores
	public Propietario() {
		
	}
	public Propietario(String nombre, Integer telefono, String correo, String direccion, String comentarios) {
		Nombre = nombre;
		Telefono = telefono;
		Correo = correo;
		Direccion = direccion;
		Comentarios = comentarios;
	}
	
	//getters, setters y tostring
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public Integer getTelefono() {
		return Telefono;
	}
	public void setTelefono(Integer telefono) {
		Telefono = telefono;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getComentarios() {
		return Comentarios;
	}
	public void setComentarios(String comentarios) {
		Comentarios = comentarios;
	}
	public List<Inmueble> getListaInmuebles() {
		return listaInmuebles;
	}
	public void setListaInmuebles(List<Inmueble> listaInmuebles) {
		this.listaInmuebles = listaInmuebles;
	}
	@Override
	public String toString() {
		return "\nPropietario: Id=" + Id + ", Nombre=" + Nombre + ", Telefono=" + Telefono + ", Correo=" + Correo	+ ", Direccion=" + Direccion + ", Comentarios=" + Comentarios + ", listaInmuebles=" + listaInmuebles + ".";
	}
	
	//metodos
	public Boolean agregarInmueble(Inmueble inmueble) {
		if(listaInmuebles == null) {
			listaInmuebles = new ArrayList<Inmueble>();
			listaInmuebles.add(inmueble);
			inmueble.setPropietario(this);
		}
		else {
			listaInmuebles.add(inmueble);
			inmueble.setPropietario(this);
		}
		return true;
	}
	
}
