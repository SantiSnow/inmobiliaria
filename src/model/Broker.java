package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="broker")
public class Broker {
	
	//campos de clase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id", unique=true, nullable = false)
	private Integer Id;
	
	@Column(name="Nombre")
	private String Nombre;
	
	@Column(name="Ventas")
	private Integer Ventas;
	
	@Column(name="Correo")
	private String Correo;
	
	//constructores
	public Broker() {
		
	}
	public Broker(String nombre, Integer ventas, String correo) {
		Nombre = nombre;
		Ventas = ventas;
		Correo = correo;
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
	public Integer getVentas() {
		return Ventas;
	}
	public void setVentas(Integer ventas) {
		Ventas = ventas;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	@Override
	public String toString() {
		return "\nBroker: Id=" + Id + ", Nombre=" + Nombre + ", Ventas=" + Ventas + ", Correo=" + Correo + ".";
	}
}
