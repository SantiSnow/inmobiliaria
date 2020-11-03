package controller;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import model.Broker;

public class UpdateBroker {

	public static Broker actualizarBroker(Session mySession, Integer id) {
		
		mySession.beginTransaction();
		Broker miBroker = mySession.get(Broker.class, id);
		
		if(miBroker != null) {
			JOptionPane.showMessageDialog(null, "Datos del Broker: \nNombre:" + miBroker.getNombre()
												+ "\nCorreo: " + miBroker.getCorreo()
												+ "\nVentas: " + miBroker.getVentas());
			
			int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese 1 para actualizar nombre "
					+ "\n2 para cambiar el correo"
					+ "\n3 para cambiar el numero de ventas"));
			
			switch (opcion) {
			case 1:
				String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre: ");
				miBroker.setNombre(nombre);
				break;
			case 2:
				String correo = JOptionPane.showInputDialog("Ingrese el nuevo correo: ");
				miBroker.setCorreo(correo);
				break;
			case 3:
				Integer ventas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo nombre: "));
				miBroker.setVentas(ventas);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcion no válida.");
				break;
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "No se encontro un broker con ese ID");
		}
		
		return miBroker;
	}
}
