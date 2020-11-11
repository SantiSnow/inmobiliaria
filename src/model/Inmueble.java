package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="inmueble")
public class Inmueble implements Comparable<Inmueble>{
	
	//campos de clase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id", unique=true, nullable = false)
	private Integer Id;
	
	@Column(name="Precio")
	private Double Precio;
	
	@Column(name="Direccion")
	private String Direccion;
	
	@Column(name="Partido")
	private String Partido;
	
	@Column(name="Ambientes")
	private Integer Ambientes;
	
	@Column(name="Comentarios")
	private String Comentarios;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH} )
	@JoinColumn(name = "Propietario_Id")
	private Propietario propietario;
	
	@OneToMany(mappedBy = "inmueble", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH} )
	private List<Reparacion> listaReparaciones;
	
	//constructores
	public Inmueble(){
		
	}
	public Inmueble(Double precio, String direccion, String partido, Integer ambientes, String comentarios, Propietario propietario) {
		Precio = precio;
		Direccion = direccion;
		Partido = partido;
		Ambientes = ambientes;
		Comentarios = comentarios;
		this.propietario = propietario;
	}

	//getters, setters y tostring
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Double getPrecio() {
		return Precio;
	}
	public void setPrecio(Double precio) {
		Precio = precio;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getPartido() {
		return Partido;
	}
	public void setPartido(String partido) {
		Partido = partido;
	}
	public Integer getAmbientes() {
		return Ambientes;
	}
	public void setAmbientes(Integer ambientes) {
		Ambientes = ambientes;
	}
	public String getComentarios() {
		return Comentarios;
	}
	public void setComentarios(String comentarios) {
		Comentarios = comentarios;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	public List<Reparacion> getListaReparaciones() {
		return listaReparaciones;
	}
	public void setListaReparaciones(List<Reparacion> listaReparaciones) {
		this.listaReparaciones = listaReparaciones;
	}
	@Override
	public String toString() {
		return "\nInmueble: Id=" + Id + ", Precio=" + Precio + ", Direccion=" + Direccion + ", Partido=" + Partido + ", Ambientes=" + Ambientes + ", Comentarios=" + Comentarios + ", propietario=" + propietario + ".";
	}
	@Override
	public int compareTo(Inmueble o) {
		if(getPartido() == null || o.getPartido() == null) {
			return 0;
		}
		return getPartido().compareTo(o.getPartido());
	}
	
	//metodos
	public Boolean agregarReparacion(Reparacion reparacion) {
		if(listaReparaciones == null) {
			listaReparaciones = new ArrayList<Reparacion>();
			listaReparaciones.add(reparacion);
			reparacion.setInmueble(this);	
		}
		else {
			listaReparaciones.add(reparacion);
			reparacion.setInmueble(this);
		}
		return true;
	}
}
