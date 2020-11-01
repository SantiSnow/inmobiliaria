package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
	
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
	
	//constructores
	public Cliente() {
		
	}
	public Cliente(String nombre, Integer telefono, String correo, String direccion, String comentarios) {
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
	@Override
	public String toString() {
		return "\nCliente: Id=" + Id + ", Nombre=" + Nombre + ", Telefono=" + Telefono + ", Correo=" + Correo	+ ", Direccion=" + Direccion + ", Comentarios=" + Comentarios + ".";
	}
	
	
}
