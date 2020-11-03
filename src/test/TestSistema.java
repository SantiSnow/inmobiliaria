package test;

import java.sql.Connection;
import java.sql.DriverManager;
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
	 * Todos los metodos con @Ignore funcionan, fueron omitidos para evitar que los valores duplicados se inserten una y otra vez durante la fase de testeo
	 */
	
	@Test
	public void testeoDeLaConexionNativa() {
		//datos conexion mysql
		String host = "jdbc:mysql://localhost:3306/hibernate?serverTimezone=UTC&useSSL=false";
		String usr = "root";
		String pass = "";
					
		try {
						
			System.out.println("Intentando conectar");
					
			Connection miConexion = DriverManager.getConnection(host, usr, pass);
					
			Assert.assertTrue(miConexion != null);
					
			System.out.println("Conexion exitosa");
			
			miConexion.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeoDeConexionHibernate() {
		//creamos un session factory
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
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
			.buildSessionFactory();
						
		Session mySession = myFactory.openSession();
		
		Inmueble nuevoInmueble = Insertar.insertarInmueble(mySession, 50000000.00, "Calle del Sol 918", "Tres de Febrero", 4, "Departamento amplio", 1);
		
		Assert.assertEquals("Calle del Sol 918", nuevoInmueble.getDireccion());
		
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
			.buildSessionFactory();
								
		Session mySession = myFactory.openSession();
				
		Propietario nuevoPropietario = Insertar.insertarPropietario(mySession, "Santiago", 11223344, "Aguirresantiago@gmail.com", "Sequeira 3179", "Potencial Cliente");
		
		Assert.assertEquals("Santiago", nuevoPropietario.getNombre());
		
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
	public void recuperarTodosLosPropietarios() {
		//creamos un session factory
		 SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Propietario.class)
			.addAnnotatedClass(Inmueble.class)
			.addAnnotatedClass(Broker.class)
			.addAnnotatedClass(Cliente.class)
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
	
	
	
	@Test
	public void borradoInmuebles() {

	}
	
	@Test
	public void borradoPropietarios() {
		
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
			.buildSessionFactory();
															
		Session mySession = myFactory.openSession();
			
		Cliente miCliente = Delete.borrarCliente(mySession, 45);
		
		Assert.assertTrue(miCliente == null);
	}
	
	
}
