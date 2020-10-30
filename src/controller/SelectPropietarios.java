package controller;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;

import model.*;

public class SelectPropietarios {
	
	public static List<Propietario> selectPropietarios(Session mySession) {
		mySession.beginTransaction();
		List<Propietario> listaPropietarios = mySession.createQuery("from Propietario").getResultList();
		mySession.getTransaction().commit();
		return listaPropietarios;
	}
	
	public static Propietario consultarPorId(Session mySession, Integer id) {
		mySession.beginTransaction();
		Propietario miPropietario = mySession.get(Propietario.class, id);
		
		if(miPropietario != null) {
			mySession.getTransaction().commit();
			return miPropietario;
		}
		else {
			JOptionPane.showMessageDialog(null, "No se encontro un propietario con ese Id");
			mySession.getTransaction().commit();
			return null;
		}
	}
}
