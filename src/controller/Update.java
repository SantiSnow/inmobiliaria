package controller;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import model.Inmueble;

public class Update {
	
	public static Inmueble actualizar(Session mySession, Integer id) {
		mySession.beginTransaction();
		Inmueble miInmueble = mySession.get(Inmueble.class, id);
		
		if(miInmueble != null) {
			int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese 1 para actualizar dirección "
																			+ "\n2 para cambiar el precio "
																			+ "\n3 para cambiar el partido "
																			+ "\n4 para actualizar la cantidad de ambientes "
																			+ "\nO 5 para cambiar los comentarios:"));
			switch (opcion) {
			case 1:
				//actualizacion del dato deseado con un setter
				String direccion = JOptionPane.showInputDialog(null, "Ingrese nueva dirección del inmueble: ");
				miInmueble.setDireccion(direccion);
				break;

			case 2:
				Double precio = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese nuevo precio del inmueble: "));
				miInmueble.setPrecio(precio);
				break;
			case 3:
				String partido = JOptionPane.showInputDialog(null, "Ingrese nuevo partido del inmueble: ");
				miInmueble.setPartido(partido);
				break;
			case 4:
				Integer ambientes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese nueva direccion del inmueble: "));
				miInmueble.setAmbientes(ambientes);
				break;
			case 5:
				String comentarios = JOptionPane.showInputDialog(null, "Ingrese nuevos comentarios del inmueble: ");
				miInmueble.setDireccion(comentarios);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opción invalida");
				break;
			}
			mySession.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Registro actualizado con éxito.");
		}
		else {
			JOptionPane.showMessageDialog(null, "No se encontró un inmueble con ese ID.");
		}
		return miInmueble;
	}

}
