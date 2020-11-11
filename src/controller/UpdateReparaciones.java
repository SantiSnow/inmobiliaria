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
				JOptionPane.showMessageDialog(null, "Reparación encontrada: ID-" + i.getId() + ", fecha: " + i.getFecha() + ", descripción: " + i.getDescripcion() + "\n");
			}
			Integer idRep = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID de la reparacion a modificar."));		
			Reparacion miReparacion = mySession.get(Reparacion.class, idRep);
			
			int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese 1 para actualizar descripción "
					+ "\n2 para cambiar el costo "
					+ "\n3 para cambiar el fecha "));
			
			switch (opcion) {
			case 1:
				String descripcion = JOptionPane.showInputDialog(null, "Ingrese la descripción de la reparación");
				miReparacion.setDescripcion(descripcion);
				break;
			case 2:
				Double costo = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el costo de la reparación"));
				miReparacion.setCosto(costo);
				break;
			case 3:
				String fecha = JOptionPane.showInputDialog(null, "Ingrese la fecha de la reparación");
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
