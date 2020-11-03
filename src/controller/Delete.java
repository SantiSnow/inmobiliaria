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
		Broker miBroker = mySession.get(Broker.class, idBroker);
		
		if(miBroker != null) {
			JOptionPane.showMessageDialog(null, "Datos del broker encontrado: " 
												+ "\nNombre: " + miBroker.getNombre()
												+ "\nVentas: " + miBroker.getVentas()
												+ "\nCorreo: " + miBroker.getCorreo()
												+ "\nID: " + miBroker.getId());
			Integer eleccion = JOptionPane.showConfirmDialog(null, "¿Desea realmente borrar estos registros?", "Borrar broker", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			
			if(eleccion == 0) {
				mySession.delete(miBroker);
				mySession.getTransaction().commit();
				JOptionPane.showMessageDialog(null, "El broker fue eliminado.");
			}
			else {
				JOptionPane.showMessageDialog(null, "No se borro el registro.");
				mySession.getTransaction().commit();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "No se encontró un broker con ese ID.");
			mySession.getTransaction().commit();
		}
		return miBroker;
	}
	
	public static Cliente borrarCliente(Session mySession, Integer idCliente) {
		mySession.beginTransaction();
		Cliente miCliente = mySession.get(Cliente.class, idCliente);
		
		if(miCliente != null) {
			JOptionPane.showMessageDialog(null, "Datos del propietario encontrado: " 
												+ "\nNombre: " + miCliente.getNombre()
												+ "\nDireccion: " + miCliente.getDireccion()
												+ "\nCorreo: " + miCliente.getCorreo()
												+ "\nTelefono: " + miCliente.getTelefono()
												+ "\nComentarios: " + miCliente.getComentarios());
			
			Integer eleccion = JOptionPane.showConfirmDialog(null, "¿Desea realmente borrar estos registros?", "Borrar propietario", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			
			if(eleccion == 0) {
				mySession.delete(miCliente);
				mySession.getTransaction().commit();
				JOptionPane.showMessageDialog(null, "El cliente fue eliminado.");
			}
			else {
				mySession.getTransaction().commit();
				JOptionPane.showMessageDialog(null, "El cliente no fue eliminado.");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "No se encontró un cliente con ese ID.");
			mySession.getTransaction().commit();
		}
		return miCliente;
	}
	
	

}
