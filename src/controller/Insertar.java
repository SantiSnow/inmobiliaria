package controller;

import org.hibernate.Session;

import model.*;

public class Insertar {
	
	public static Propietario insertarPropietario(Session mySession, String nombre, Integer telefono, String correo, String direccion, String comentarios) {
		Propietario miPropietario = new Propietario(nombre, telefono, correo, direccion, comentarios);
		mySession.beginTransaction();
		mySession.save(miPropietario);
		
		mySession.getTransaction().commit();
		
		return miPropietario;
	}

	public static Inmueble insertarInmueble(Session mySession, Double precio, String direccion, String partido, Integer ambientes, String comentarios, Integer IdPropietario) {
		Propietario miPropietario = mySession.get(Propietario.class, IdPropietario);
		Inmueble miInmueble = new Inmueble(precio, direccion, partido, ambientes, comentarios, miPropietario);
		
		mySession.beginTransaction();
		mySession.save(miInmueble);
		
		mySession.getTransaction().commit();
		
		return miInmueble;
	}
}
