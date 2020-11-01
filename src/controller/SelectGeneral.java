package controller;

import java.util.List;
import org.hibernate.Session;
import model.*;

public class SelectGeneral {
	
	public List<Cliente> verTodosLosClientes(Session mySession){
		mySession.beginTransaction();
		List<Cliente> misClientes = mySession.createQuery("from Cliente").getResultList();
		mySession.getTransaction().commit();
		return misClientes;
	}
	
	public List<Broker> verTodosLosCorredores(Session mySession){
		mySession.beginTransaction();
		List<Broker> misBrokers = mySession.createQuery("from Cliente").getResultList();
		mySession.getTransaction().commit();
		return misBrokers;
	}

}
