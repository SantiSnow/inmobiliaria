package controller;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import model.Cliente;

public class UpdateCliente {
	
	public static Cliente actualizarCliente(Session mySession, Integer id) {
		
		mySession.beginTransaction();
		Cliente miCliente = mySession.get(Cliente.class, id);
		
		if(miCliente != null) {
			
		}
		else {
			JOptionPane.showMessageDialog(null, "No se encontro un cliente con ese ID");
		}
		
		
		return miCliente;
	}

}