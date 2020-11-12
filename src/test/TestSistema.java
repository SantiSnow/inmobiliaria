package test;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.*;

import model.*;
import controller.*;

public class TestSistema {
	
	/*
	 * Todos los metodos con @Ignore funcionan, fueron omitidos para evitar que los valores duplicados se inserten, borren o actualizen una y otra vez durante la fase de testeo
	 */
	
	@Ignore
	public void testeoDeConexionHibernate() {
		//creamos un session factory
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
				
		Session mySession = myFactory.openSession();

		Assert.assertTrue(mySession != null);
		
		mySession.close();
		
		myFactory.close();
	}
	
	@Ignore
	public void recuperarDatosDeInmuebles() {
		//creamos un session factory
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
										
		Session mySession = myFactory.openSession();
		
		Inmueble miInmueble = Select.selectInmueblePorId(mySession, 1);
		
		Assert.assertEquals("9 de Julio 514", miInmueble.getDireccion());
		Assert.assertEquals("Departamento amplio", miInmueble.getComentarios());
		Assert.assertEquals(1, miInmueble.getId(), 0);
		
		Assert.assertEquals("Santiago Aguirre", miInmueble.getPropietario().getNombre());
		Assert.assertEquals("Aguirresantiago@gmail.com", miInmueble.getPropietario().getCorreo());
		
		mySession.close();
		
		myFactory.close();
	}
	
	@Ignore
	public void recuperarTodosLosInmuebles() {
		//creamos un session factory
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
										
		Session mySession = myFactory.openSession();
		
		List<Inmueble> listaInmuebles = Select.selectInmuebles(mySession);
		
		for(Inmueble i: listaInmuebles) {
			System.out.println(i.getDireccion());
			System.out.println(i.getComentarios());
			System.out.println(i.getId());
		}
		
		mySession.close();
		
		myFactory.close();
	}
	
	@Ignore
	public void consultarLosInmueblesPorDireccion() {
		//creamos un session factory
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
										
		Session mySession = myFactory.openSession();
		
		List<Inmueble> listaInmuebles = Select.selectInmueblePorDireccion(mySession, "Calle del Sol 918");
		
		for(Inmueble i: listaInmuebles) {
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("Lista de inmuebles con la direccion elegida: ");
			System.out.println(i.getDireccion());
			System.out.println(i.getComentarios());
			System.out.println(i.getId());
		}
		
		mySession.close();
		
		myFactory.close();
	}
	
	@Ignore
	public void recuperarDatosDePropietarios() {
		//creamos un session factory
		 SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
												
		Session mySession = myFactory.openSession();
		
		Propietario miPropietario = SelectPropietarios.consultarPorId(mySession, 1);
		
		Assert.assertEquals("Santiago Aguirre", miPropietario.getNombre());
		Assert.assertEquals("Aguirresantiago@gmail.com", miPropietario.getCorreo());
		Assert.assertEquals("Sequeira 3179", miPropietario.getDireccion());
		Assert.assertEquals(11223344, miPropietario.getTelefono(), 0);
				
		mySession.close();
				
		myFactory.close();
	}
	
	@Ignore
	public void buscarPropietarioPorNombre() {
		//creamos un session factory
		 SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
												
		Session mySession = myFactory.openSession();
		
		List<Propietario> listaResultado = SelectPropietarios.consultarPorNombre(mySession, "Santiago");
		
		System.out.println(" ");
		System.out.println("Se han encontrado estos propietarios con el nombre Santiago");
		for(Propietario i: listaResultado) {
			System.out.println(i.getNombre());
			System.out.println(i.getCorreo());
			System.out.println(i.getDireccion());
			System.out.println("------------------------------");
			Assert.assertEquals(i.getNombre(), "Santiago");
		}
	}
	
	@Ignore
	public void recuperarTodosLosPropietarios() {
		//creamos un session factory
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
												
		Session mySession = myFactory.openSession();
		
		List<Propietario> listaPropietarios = SelectPropietarios.selectPropietarios(mySession);
		
		for(Propietario i: listaPropietarios) {
			System.out.println(" ");
			System.out.println("Lista de propietarios: ");
			System.out.println(i.getNombre());
			System.out.println(i.getDireccion());
			System.out.println(i.getCorreo());
		}
		
		mySession.close();
		
		myFactory.close();
	}
	
	@Ignore
	public void recuperarInmueblesDeUnPropietario() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
		
		Session mySession = myFactory.openSession();
		
		Propietario miPropietario = SelectPropietarios.consultarPorId(mySession, 1);
		
		List<Inmueble> listaInmuebles = miPropietario.getListaInmuebles();
		System.out.println(" ");
		System.out.println("Lista de inmuebles del propietario: " + miPropietario.getNombre() + ": ");
		
		for(Inmueble i: listaInmuebles) {
			System.out.println(" ");
			System.out.println("Inmueble " + i.getId() + ": ");
			System.out.println(i.getDireccion());
			System.out.println(i.getPartido());
			System.out.println("-----------------------------------------");
			
		}
	}
	
	@Ignore
	public void testDeActualizaciondeInmuebles() {
		//creamos un session factory
		 SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.buildSessionFactory();
												
		Session mySession = myFactory.openSession();
		
		Inmueble inmuebleActualizado = Update.actualizar(mySession, 1);
		
		Assert.assertEquals("9 de Julio 514", inmuebleActualizado.getDireccion());
		
		mySession.close();
		
		myFactory.close();
	}
	
	@Ignore
	public void testDeActualizaciondePropietarios() {
		//creamos un session factory
		 SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.buildSessionFactory();
												
		Session mySession = myFactory.openSession();
		
		Propietario propietarioActualizado = Update.actualizarPropietario(mySession, 1);
		
		Assert.assertEquals("Santiago Aguirre", propietarioActualizado.getNombre());
		
		mySession.close();
		
		myFactory.close();
	}
	
	@Ignore
	public void testSelectDeBrokers() {
		//creamos un session factory
		 SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
												
		Session mySession = myFactory.openSession();
		
		List<Broker> listaBrokers = SelectGeneral.verTodosLosCorredores(mySession);
		
		System.out.println("Lista de brokers: ");
		
		for(Broker i: listaBrokers) {
			System.out.println("\nNombre del Broker: " + i.getNombre());
			System.out.println("Cantidad de ventas: " + i.getVentas());
		}
		
		mySession.close();
		
		myFactory.close();
	}
	
	@Ignore
	public void testSelectDeClientes() {
		//creamos un session factory
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
												
		Session mySession = myFactory.openSession();
		
		List<Cliente> listaObtenida = SelectGeneral.verTodosLosClientes(mySession);
		
		System.out.println("Lista de clientes: ");
		for(Cliente i: listaObtenida) {
			System.out.println("\nNombre del cliente: " + i.getNombre());
			System.out.println("\nCorreo del cliente" + i.getCorreo());
		}
		
		mySession.close();
		
		myFactory.close();
	}
	
	@Ignore
	public void testActualizacionCliente() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
																
		Session mySession = myFactory.openSession();
		
		Cliente miCliente = UpdateCliente.actualizarCliente(mySession, 6);
		
		Assert.assertEquals("Brandsen 3551", miCliente.getDireccion());
	}
	
	@Ignore
	public void testActualizacionBroker() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
																	
		Session mySession = myFactory.openSession();
			
		Broker miBroker = UpdateBroker.actualizarBroker(mySession, 8);
			
		Assert.assertEquals("Juan Miguel", miBroker.getNombre());
		
	}
	
	@Ignore
	public void testListaOrdenadaDeInmuebles() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
																		
		Session mySession = myFactory.openSession();
		
		List<Inmueble> listaInmuebles = Select.listaInmieblesOrdPorPartido(mySession);
		
		Collections.sort(listaInmuebles);
		
		for(Inmueble i: listaInmuebles) {
			System.out.println(" ");
			System.out.println("Inmueble encontrado: ");
			System.out.println(i.getPartido());
		}
		
	}
	
	@Ignore
	public void verReparacionesDeUnaPropiedad() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
			
		Session mySession = myFactory.openSession();
		
		List<Reparacion> listaReparaciones = SelectGeneral.verReparacionesDeLaPropiedad(mySession, 1);
		
		System.out.println(" ");
		
		for(Reparacion i: listaReparaciones) {
			System.out.println("Reparacion de la propiedad: ");
			System.out.println(i.getDescripcion());
			System.out.println(i.getFecha());
			System.out.println("----------------------------");
		}
	}
		
	@Ignore
	public void testActualizarReparacion() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
					
		Session mySession = myFactory.openSession();
		
		Reparacion miReparacion = UpdateReparaciones.actualizarReparacion(mySession, 6);
		
		Assert.assertEquals(5500.0, miReparacion.getCosto(), 0);
	}
	
	@Ignore
	public void testNoActualizarReparacionNoEncuentraInmueble() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Reparacion.class)
			.buildSessionFactory();
					
		Session mySession = myFactory.openSession();
		
		Reparacion miReparacion = UpdateReparaciones.actualizarReparacion(mySession, 45);
		
		Assert.assertTrue(miReparacion == null);
	}

}
