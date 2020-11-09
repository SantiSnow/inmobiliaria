package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Calendar;

@Entity
@Table(name="Reparacion")
public class Reparacion {

	//campos de clase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id", unique=true, nullable = false)
	private Integer Id;
	
	@Column(name="Descripcion")
	private String Descripcion;
	
	@Column(name="Costo")
	private Double Costo;
	
	@Column(name="Fecha")
	private String Fecha;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE} )
	@JoinColumn(name = "Inmueble_Id")
	private Inmueble inmueble;
	
	//constructores
	public Reparacion(String descipcion, Double costo, Inmueble inmueble) {
		this.Descripcion = descipcion;
		this.Costo = costo;
		
		Calendar ahora = Calendar.getInstance();
		Integer mes = ahora.get(Calendar.MONTH) + 1;
		this.Fecha = ahora.get(Calendar.YEAR) + "/" + mes + "/" + ahora.get(Calendar.DAY_OF_MONTH);
		
		this.inmueble = inmueble;
	}
	public Reparacion() {
		
	}
	
	//getters, setters y tostring
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public Inmueble getInmueble() {
		return inmueble;
	}
	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}
	@Override
	public String toString() {
		return "Reparacion: Id=" + Id + ", Descripcion=" + Descripcion + ", Fecha=" + Fecha + ", inmueble=" + inmueble.getDireccion() + ".";
	}
	
}
