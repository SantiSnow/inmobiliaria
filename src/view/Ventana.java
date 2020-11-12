package view;

import javax.swing.*;

public class Ventana extends JFrame{

	//campos de clase
	private JPanel miPanel;
	private JButton agregarInmueble;
	private JButton agregarPropietario;
	private JButton agregarBroker;
	private JButton agregarCliente;
	private JButton agregarReparacion;
	
	//constructor
	public Ventana() {
		//detalles de la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		//panel
		miPanel = new JPanel();
		add(miPanel);
		
		//metodos
		agregarBotones();
	}
	
	public void agregarBotones() {
		//los instanciamos
		agregarInmueble = new JButton();
		agregarPropietario = new JButton();
		agregarBroker = new JButton();
		agregarCliente = new JButton();
		agregarReparacion = new JButton();
		
		//los agregamos
		miPanel.add(agregarInmueble);
		miPanel.add(agregarPropietario);
		miPanel.add(agregarBroker);
		miPanel.add(agregarCliente);
		miPanel.add(agregarReparacion);
	}
}
