package AE_02_T1_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Controlador {

	private Vista vista;
	private Modelo modelo;
	private ActionListener actionListenerBuscar, actionListenerReemplazar;
	private String ficheroLectura, ficheroEscritura;
	private String textoBuscar, textoReemplazar;

	/**
	 * constructor
	 * @param vista
	 * @param modelo
	 */
	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		control(); // llamo a los eventos
	}

	/**
	 * agrupo todos los m?todos q van a suceder en vista.java
	 */
	public void control() {

		// 1. asigno los strings de ficheroEscritura y ficheroLectura que se definen en
		// el Modelo
		ficheroLectura = this.modelo.ficheroLectura();
		ficheroEscritura = this.modelo.ficheroEscritura();

		// 2. mostrar en el textArea_Original el ficheroLectura --> m?todo
		// mostrarFichero()
		mostrarFichero(ficheroLectura, 1);
		System.out.println("Inicio del programa...");
		//JOptionPane.showMessageDialog(null, "Escriba la palabra que quiere 'Buscar'");
		
		// 3. ActionListenerBuscar: al bot?n btnBuscar
		// a. Obtener de la vista el string con el texto a buscar
		// b. Llamar al m?todo buscarTexto del modelo pasandole el String
		// c. Mostrar JOptionPane el num de coincidencias

		this.vista.getBtnBuscar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				String textoBuscado = vista.getTextFieldBuscar().getText();
				System.out.println("Se ha hecho click en el bot?n buscar");
				System.out.println("Texto buscado: " + textoBuscado);
				int numeroCoincidencias = modelo.buscarTexto(textoBuscado);
				JOptionPane.showMessageDialog(null, "Se han encontrado " + numeroCoincidencias + " coincidencias.");
				if (numeroCoincidencias == 0)
					JOptionPane.showMessageDialog(null, "Busca otra palabra...");
				else {
					JOptionPane.showMessageDialog(null, "Escriba la palabra con la que quiere reemplazar y pulse 'Reemplazar'");
					vista.getBtnReemplazar().setEnabled(true);
				}

			}
		});

		// 4. ActionListenerReemplazar: al bot?n btnReemplazar
		// a. obtener de la vista el string con el texto a buscar y el texto a reemplazar
		// b. Llamar al m?todo reemplazarTexto del modelo pasandole ambos strings
		// c. Mostrar en el textArea inferior el ficheroEscritura.
		this.vista.getBtnReemplazar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String textoBuscado = vista.getTextFieldBuscar().getText();
				if (textoBuscado == "") {
					JOptionPane.showMessageDialog(null, "Tiene que escribir primero la palabra que quiere Buscar.");
				}
				String textoReemplazar = vista.getTextFieldReemplazar().getText(); // leo la casilla
				System.out.println("Se ha hecho click en el bot?n reemplazar");
				System.out.println("Reemplazar por: " + textoReemplazar);

				int numeroCoincidencias = modelo.buscarTexto(textoBuscado);
				if (numeroCoincidencias == 0)
					JOptionPane.showMessageDialog(null,
							"Al no encontrarse coincidencias, NO se produce ning?n cambio.");
				else
					modelo.reemplazarTexto(textoBuscado, textoReemplazar);

				mostrarFichero(ficheroEscritura, 2); //-> 2 es el textArea inferior

			}
		});
	}

	/**
	 * m?todo para mostrar contenido de fichero en textArea
	 * 
	 * @param fichero        --> puede q sea el de lectura o el de escritura
	 * @param numeroTextArea --> TextAreaOriginal es el superior==1,
	 *                       TextAreaModificado el inferior
	 */
	public void mostrarFichero(String fichero, int numeroTextArea) {
		
		ArrayList<String> contenidoFichero = this.modelo.contenidoFichero(fichero);

		for (String linea : contenidoFichero) {
			if (numeroTextArea == 1)
				this.vista.getTextAreaOriginal().append(linea + "\n");
			else
				this.vista.getTextAreaModificado().append(linea + "\n");
		}

	}

}
