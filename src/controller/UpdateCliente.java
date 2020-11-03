package controller;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import model.Cliente;

public class UpdateCliente {
	
	public static Cliente actualizarCliente(Session mySession, Integer id) {
		
		mySession.beginTransaction();
		Cliente miCliente = mySession.get(Cliente.class, id);
		
		if(miCliente != null) {
			JOptionPane.showMessageDialog(null, "Datos del Cliente: \nNombre:" + miCliente.getNombre()
												+ "\nDireccion: " + miCliente.getDireccion()
												+ "\nCorreo: " + miCliente.getCorreo()
												+ "\nTelefono: " + miCliente.getTelefono()
												+ "\nComentarios: " + miCliente.getComentarios());
			
			int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese 1 para actualizar nombre "
																			+ "\n2 para cambiar el direccion "
																			+ "\n3 para cambiar el correo "
																			+ "\n4 para actualizar el telefono "
																			+ "\nO 5 para cambiar los comentarios:"));
			
			switch (opcion) {
			case 1:
				String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre: ");
				miCliente.setNombre(nombre);
				break;
			case 2:
				String direccion = JOptionPane.showInputDialog("Ingrese la nueva dirección: ");
				miCliente.setDireccion(direccion);
				break;
			case 3:
				String correo = JOptionPane.showInputDialog("Ingrese el nuevo correo: ");
				miCliente.setCorreo(correo);
				break;
			case 4:
				Integer telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo teléfono: "));
				miCliente.setTelefono(telefono);
				break;
			case 5:
				String comentarios = JOptionPane.showInputDialog("Ingrese comentarios nuevos: ");
				miCliente.setComentarios(comentarios);
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opcion no válida.");
				break;
			}
			mySession.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Registro actualizado con éxito.");
		}
		else {
			JOptionPane.showMessageDialog(null, "No se encontro un cliente con ese ID");
		}
		return miCliente;
	}
}