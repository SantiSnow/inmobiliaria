package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.*;

import controller.Insertar;
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

	@Ignore
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
	
	@Ignore
	public void recuperarDatosDeInmuebles() {
		//creamos un session factory
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
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
	public void insertarBrokers() {
		 SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.buildSessionFactory();
												
		Session mySession = myFactory.openSession();
		
		Broker myBroker = Insertar.insertarBroker(mySession, "Carlos Fernandez", 15, "FerndzInmobiliaria@gmail.com");
		
		Assert.assertEquals("Carlos Fernandez", myBroker.getNombre());
		
		mySession.close();
		
		myFactory.close();
	}
	
	@Ignore
	public void insertarClientes() {
		 SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.buildSessionFactory();
												
		Session mySession = myFactory.openSession();
		
		Cliente miCliente = Insertar.insertarCliente(mySession, "Santiago Perez", 11223344, "Sperez_1@gmail.com", "Diag. Norte 918", "Potencial cliente");
		
		Assert.assertEquals("Santiago Perez", miCliente.getNombre());
		
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
	
	@Ignore
	public void pruebaDeNoBorradoPorInmuebleNoEncontrado() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.buildSessionFactory();
																
		Session mySession = myFactory.openSession();
		
		Inmueble miInmuebleNulo = Delete.borrarInmueble(mySession, 45);
		
		Assert.assertTrue(miInmuebleNulo == null);
	}
	
	@Ignore
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
	
	@Ignore
	public void pruebaDeNoBorradoPorPropietarioNoEncontrado() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.buildSessionFactory();
																	
		Session mySession = myFactory.openSession();
		
		Propietario miPropietarioNoHallado = Delete.borrarPropietario(mySession, 65);
		
		Assert.assertFalse(miPropietarioNoHallado != null);
	}
	
	@Ignore
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
	
	@Ignore
	public void borradoNoEncontradoDeBrokers() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.buildSessionFactory();
															
		Session mySession = myFactory.openSession();
		
		Broker miBroker = Delete.borrarBroker(mySession, 45);
		
		Assert.assertFalse(miBroker != null);
	}
	
	@Ignore
	public void borradoClientes() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.buildSessionFactory();
														
		Session mySession = myFactory.openSession();
		
		Cliente miCliente = Delete.borrarCliente(mySession, 3);
		
		Assert.assertEquals(3, miCliente.getId(), 0);
		Assert.assertEquals("Santiago Perez", miCliente.getNombre());
		Assert.assertEquals("Sperez_1@gmail.com", miCliente.getCorreo());
	}
	
	@Ignore
	public void borradoNoEncontradoDeClientes() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.buildSessionFactory();
															
		Session mySession = myFactory.openSession();
			
		Cliente miCliente = Delete.borrarCliente(mySession, 45);
		
		Assert.assertTrue(miCliente == null);
	}
	
	@Ignore
	public void testActualizacionCliente() {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
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
		
		//Assert.assertTrue(reparacionBorrada == null);
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



	//mas test con collections
	//arraylist
	@Ignore
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
	@Ignore
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


}
