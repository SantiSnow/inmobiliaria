package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Ignore;
import org.junit.Test;

import controller.Select;
import controller.SelectPropietarios;
import model.Broker;
import model.Cliente;
import model.Inmueble;
import model.Propietario;
import model.Reparacion;

public class TestCollecciones {

	//test con collections
	//arraylist
	@Test
	public void testDeCollections() {
		//creamos un session factory
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
														
		Session mySession = myFactory.openSession();
				
		ArrayList<Propietario> listaPropietarios = (ArrayList<Propietario>) SelectPropietarios.selectPropietarios(mySession);
		
		System.out.println("Cantidad de propietarios en el sistema:");
		System.out.println(listaPropietarios.size());
		
		System.out.println(" ");
		System.out.println("Lista de propietarios: ");
		
		for(Propietario i: listaPropietarios) {
			System.out.println("Propietario encontrado");
			System.out.println(i.getNombre());
			System.out.println(i.getDireccion());
			System.out.println(i.getCorreo());
			System.out.println("-----------------------------------");
			System.out.println(" ");
		}
				
		mySession.close();
				
		myFactory.close();
	}
	
	//linkedlist
	@Test
	public void testDeCollectionsLinked() {
		//creamos un session factory
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
														
		Session mySession = myFactory.openSession();
				
		LinkedList<Propietario> listaPropietarios = (LinkedList<Propietario>) SelectPropietarios.selectPropietarios(mySession);
		
		System.out.println("Cantidad de propietarios en el sistema:");
		System.out.println(listaPropietarios.size());
		
		System.out.println(" ");
		System.out.println("Lista de propietarios: ");
		
		for(Propietario i: listaPropietarios) {
			System.out.println("Propietario encontrado");
			System.out.println(i.getNombre());
			System.out.println(i.getDireccion());
			System.out.println(i.getCorreo());
			System.out.println("-----------------------------------");
			System.out.println(" ");
		}
				
		mySession.close();
				
		myFactory.close();
	}
	
	//ordenar un arraylist con comparable
	@Test
	public void testDeOrdenamientoInmueblesArrayList() {
		//creamos un session factory
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
																
		Session mySession = myFactory.openSession();
				
		ArrayList<Inmueble> listaInmuebles = (ArrayList<Inmueble>) Select.selectInmuebles(mySession);
		
		Collections.sort(listaInmuebles);
		
		for(Inmueble i: listaInmuebles) {
			System.out.println("Partido del inmueble:");
			System.out.println(i.getPartido());
			System.out.println("---------------------");
		}
		
	}

}
