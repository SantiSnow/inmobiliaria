package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import controller.Insertar;
import model.Broker;
import model.Cliente;
import model.Inmueble;
import model.Propietario;
import model.Reparacion;

public class TesteoInsersiones {
	
	@Test
	public void testeoInsertarInmuebles() {
		//creamos un session factory
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
						
		Session mySession = myFactory.openSession();
		
		Inmueble nuevoInmueble = Insertar.insertarInmueble(mySession, 89300000.00, "Libertador 16741", "Palermo", 5, "Departamento en Palermo viejo", 3);
		
		Assert.assertEquals("Libertador 16741", nuevoInmueble.getDireccion());
		
		mySession.close();
		
		myFactory.close();
	}

	@Test
	public void testeoInsertarPropietarios() {
		//creamos un session factory
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
								
		Session mySession = myFactory.openSession();
				
		Propietario nuevoPropietario = Insertar.insertarPropietario(mySession, "Pedro", 11333344, "P_perez91@gmail.com", "Bransend 4956", "Cliente buscando vender y mudarse");
		
		Assert.assertEquals("Pedro", nuevoPropietario.getNombre());
		
		mySession.close();
		
		myFactory.close();
	}
	
	@Test
	public void insertarBrokers() {
		 SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
												
		Session mySession = myFactory.openSession();
		
		Broker myBroker = Insertar.insertarBroker(mySession, "Carlos Fernandez", 15, "FerndzInmobiliaria@gmail.com");
		
		Assert.assertEquals("Carlos Fernandez", myBroker.getNombre());
		
		mySession.close();
		
		myFactory.close();
	}
	
	@Test
	public void insertarClientes() {
		 SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
												
		Session mySession = myFactory.openSession();
		
		Cliente miCliente = Insertar.insertarCliente(mySession, "Santiago Perez", 11223344, "Sperez_1@gmail.com", "Diag. Norte 918", "Potencial cliente");
		
		Assert.assertEquals("Santiago Perez", miCliente.getNombre());
		
		mySession.close();
		
		myFactory.close();
	}
	
	@Test
	public void agregarReparacion() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
		
		Session mySession = myFactory.openSession();
		
		Reparacion nuevaReparacion = Insertar.insertarReparacion(mySession, 6, "Reparacion del piso flotante.", 5000.00);
		
		Assert.assertEquals("Reparacion del piso flotante.", nuevaReparacion.getDescripcion());
		Assert.assertEquals(5000.00, nuevaReparacion.getCosto(), 0);
	}
}
