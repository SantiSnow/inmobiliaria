package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import controller.Delete;
import model.Broker;
import model.Cliente;
import model.Inmueble;
import model.Propietario;
import model.Reparacion;

public class TesteoBorrado {
	
	@Test
	public void borradoInmuebles() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
															
		Session mySession = myFactory.openSession();
		
		Inmueble miInmueble = Delete.borrarInmueble(mySession, 5);
		
		Assert.assertEquals("Libertador 16741", miInmueble.getDireccion());
		//Assert.assertEquals("Casa con frente amplo", miInmueble.getComentarios());
	}
	
	@Test
	public void borradoPropietarios() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
															
		Session mySession = myFactory.openSession();
		
		Propietario miPropietario = Delete.borrarPropietario(mySession, 4);
		
		Assert.assertEquals("Franco Matias", miPropietario.getNombre());
		Assert.assertEquals("F_Mati@gmail.com", miPropietario.getCorreo());
		
		System.out.println(" ");
		System.out.println("Propiedades de la persona borrada: ");
		List<Inmueble> listaInmuebles = miPropietario.getListaInmuebles();
		
		for(Inmueble i: listaInmuebles) {
			System.out.println("Inmueble que se borrara: ");
			System.out.println(i.getDireccion());
			System.out.println(i.getPartido());
		}
	}
	
	@Test
	public void pruebaDeNoBorradoPorInmuebleNoEncontrado() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
																
		Session mySession = myFactory.openSession();
		
		Inmueble miInmuebleNulo = Delete.borrarInmueble(mySession, 45);
		
		Assert.assertTrue(miInmuebleNulo == null);
	}
	
	@Test
	public void pruebaDeNoBorradoPorPropietarioNoEncontrado() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
																	
		Session mySession = myFactory.openSession();
		
		Propietario miPropietarioNoHallado = Delete.borrarPropietario(mySession, 65);
		
		Assert.assertFalse(miPropietarioNoHallado != null);
	}
	
	@Test
	public void borradoBrokers() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.buildSessionFactory();
														
		Session mySession = myFactory.openSession();
		
		Broker miBroker = Delete.borrarBroker(mySession, 6);
		
		Assert.assertEquals(6, miBroker.getId(), 0);
		Assert.assertEquals("Carlos Fernandez", miBroker.getNombre());
		Assert.assertEquals("FerndzInmobiliaria@gmail.com", miBroker.getCorreo());
	}
	
	@Test
	public void borradoNoEncontradoDeBrokers() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
															
		Session mySession = myFactory.openSession();
		
		Broker miBroker = Delete.borrarBroker(mySession, 45);
		
		Assert.assertFalse(miBroker != null);
	}
	
	@Test
	public void borradoClientes() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
														
		Session mySession = myFactory.openSession();
		
		Cliente miCliente = Delete.borrarCliente(mySession, 3);
		
		Assert.assertEquals(3, miCliente.getId(), 0);
		Assert.assertEquals("Santiago Perez", miCliente.getNombre());
		Assert.assertEquals("Sperez_1@gmail.com", miCliente.getCorreo());
	}
	
	@Test
	public void borradoNoEncontradoDeClientes() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
															
		Session mySession = myFactory.openSession();
			
		Cliente miCliente = Delete.borrarCliente(mySession, 45);
		
		Assert.assertTrue(miCliente == null);
	}

	@Test
	public void borradoDeUnaReparacion() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
				
		Session mySession = myFactory.openSession();
		
		Reparacion reparacionBorrada = Delete.borrarReparacion(mySession, 6);
		
		Assert.assertEquals("Reparacion del piso.", reparacionBorrada.getDescripcion());
		Assert.assertEquals(5000.00, reparacionBorrada.getCosto(), 0);
		
	}

}
