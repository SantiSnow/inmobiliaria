package controller;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import model.*;

public class Select {

	public static List<Inmueble> selectInmuebles(Session mySession) {
		mySession.beginTransaction();
		List<Inmueble> listaInmuebles = mySession.createQuery("from Inmueble").getResultList();
		mySession.getTransaction().commit();
		return listaInmuebles;
	}
	
	
	public static List<Inmueble> selectInmueblePorDireccion(Session mySession, String direccion) {
		mySession.beginTransaction();
		List<Inmueble> listaInmuebles = mySession.createQuery("from Inmueble where Direccion='" + direccion + "'").getResultList();
		mySession.getTransaction().commit();
		return listaInmuebles;
	}
	
	public static Inmueble selectInmueblePorId(Session mySession, Integer idInmueble) {
		mySession.beginTransaction();
		Inmueble miInmueble = mySession.get(Inmueble.class, idInmueble);
		
		if(miInmueble != null) {
			mySession.getTransaction().commit();
			return miInmueble;
		}
		else {
			JOptionPane.showMessageDialog(null, "No se encontro un inmueble con ese Id");
			return null;
		}		
	}
}
