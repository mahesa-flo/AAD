package ejTema1MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controlador {

	private Modelo modelo;
	private Vista vista;
	private ActionListener actionListenerAnyadir; //escucha de Vista.java
	private String ficheroLectura, ficheroEscritura;
	
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo=modelo;
		this.vista=vista;
		control();
	}
	
	
	public void control() {
		
		// recurro a Modelo.java
		ficheroLectura= modelo.ficheroEscritura();
		ficheroEscritura=modelo.ficheroEscritura();
		
		mostrarFichero(ficheroLectura,1); //textArea superior
		actionListenerAnyadir = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoAnyadir=vista.getTextField().getText();
				modelo.anyadirTexto(textoAnyadir);
				mostrarFichero(ficheroEscritura,2);
			}
		};
		//-> al botón anyadir de vista.java 
		vista.getAnyadir().addActionListener(actionListenerAnyadir);
		
		
	}
	
	
	public void mostrarFichero(String fichero, int numeroTextArea) {
		ArrayList<String> arrayLineas= modelo.contenidoFichero(fichero);
		for (String linea: arrayLineas) {
			if (numeroTextArea ==1)
				vista.getTextArea().append(linea+"\n"); // textArea superior
			else
				vista.getTextArea_1().append(linea+"\n"); 
		}
		
		
		
		
	}
	
	
}
