package controller;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import model.*;

public class UpdateReparaciones {

	public static void actualizarReparacion(Session mySession, Integer idInmueble) {
		mySession.beginTransaction();
		Inmueble miInmueble = mySession.get(Inmueble.class, idInmueble);
		
		if(miInmueble != null) {
			List<Reparacion>reparacionesHechas = miInmueble.getListaReparaciones();
			for (Reparacion i: reparacionesHechas) {
				JOptionPane.showMessageDialog(null, "Reparaci�n encontrada: ID-" + i.getId() + ", fecha: " + i.getFecha() + ", descripci�n: " + i.getDescripcion() + "\n");
			}
			Integer idRep = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID de la reparacion a modificar."));		
			Reparacion miReparacion = mySession.get(Reparacion.class, idRep);
			
			int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese 1 para actualizar descripci�n "
					+ "\n2 para cambiar el costo "
					+ "\n3 para cambiar el fecha "));
			
			switch (opcion) {
			case 1:
				String descripcion = JOptionPane.showInputDialog(null, "Ingrese la descripci�n de la reparaci�n");
				miReparacion.setDescripcion(descripcion);
				break;
			case 2:
				Double costo = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el costo de la reparaci�n"));
				miReparacion.setCosto(costo);
				break;
			case 3:
				String fecha = JOptionPane.showInputDialog(null, "Ingrese la fecha de la reparaci�n");
				miReparacion.setFecha(fecha);
				break;

			default:
				JOptionPane.showMessageDialog(null, "");
				break;
			}
			
		}
		else {
			JOptionPane.showMessageDialog(null, "No se encontro un inmueble con ese ID");
			mySession.getTransaction().commit();
		}
		
	}
}
