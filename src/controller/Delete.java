package controller;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import model.*;

public class Delete {
	
	public static Inmueble borrarInmueble(Session mySession, Integer id) {
		mySession.beginTransaction();
		Inmueble miInmueble = mySession.get(Inmueble.class, id);
		
		if(miInmueble != null) {
			JOptionPane.showMessageDialog(null, "Datos del inmueble encontrado: "
												+ "\nDireccion: " + miInmueble.getDireccion() 
												+ "\nPrecio: " + miInmueble.getPrecio()
												+ "\nPartido: " + miInmueble.getPartido()
												+ "\nAmbientes: " + miInmueble.getAmbientes()
												+ "\nComentarios: " + miInmueble.getComentarios());
			
			Integer eleccion = JOptionPane.showConfirmDialog(null, "¿Desea realmente borrar estos registros?", "Borrar cliente", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			
			if(eleccion == 0) {
				mySession.delete(miInmueble);
				JOptionPane.showMessageDialog(null, "Cliente y datos borrados.");
				mySession.getTransaction().commit();
			}
			else {
				JOptionPane.showMessageDialog(null, "Selecciono no, el registro no será borrado.");
				mySession.getTransaction().commit();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "No se encontro un registro con ese ID");
			mySession.getTransaction().commit();
		}
		
		return miInmueble;
	}
	
	public static Propietario borrarPropietario(Session mySession, Integer idPropietario) {
		mySession.beginTransaction();
		Propietario miPropietario = mySession.get(Propietario.class, idPropietario);
		
		if(miPropietario != null) {
			JOptionPane.showMessageDialog(null, "Datos del propietario encontrado: " 
												+ "\nNombre: " + miPropietario.getNombre()
												+ "\nDireccion: " + miPropietario.getDireccion()
												+ "\nCorreo: " + miPropietario.getCorreo()
												+ "\nTelefono: " + miPropietario.getTelefono()
												+ "\nComentarios: " + miPropietario.getComentarios());
			Integer eleccion = JOptionPane.showConfirmDialog(null, "¿Desea realmente borrar estos registros?", "Borrar propietario", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			
			if(eleccion == 0) {
				mySession.delete(miPropietario);
				JOptionPane.showMessageDialog(null, "Propietario borrado.");
				mySession.getTransaction().commit();
			}
			else {
				JOptionPane.showMessageDialog(null, "El propietario no fue borrado.");
				mySession.getTransaction().commit();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "No se encontró un propietario con ese ID.");
			mySession.getTransaction().commit();
		}
		
		return miPropietario;
	}
	
	public static Broker borrarBroker(Session mySession, Integer idBroker) {
		mySession.beginTransaction();
		
		return null;
	}
	
	public static Cliente Cliente(Session mySession, Integer idCliente) {
		mySession.beginTransaction();
		
		return null;
	}
	
	

}
