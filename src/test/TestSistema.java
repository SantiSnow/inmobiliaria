package test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Test;

import model.*;


public class TestSistema {
	
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
			.buildSessionFactory();
				
		Session mySession = myFactory.openSession();

		Assert.assertTrue(mySession != null);
		
		mySession.close();
		
		myFactory.close();
	}

}
