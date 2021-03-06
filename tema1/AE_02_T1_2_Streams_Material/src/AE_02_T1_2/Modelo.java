package AE_02_T1_2;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Modelo {

	private String fichero_lectura;
	private String fichero_escritura;

	/**
	 * constructor
	 */
	public Modelo() {
		fichero_lectura = "AE02_T1_2_Streams_Groucho.txt";
		fichero_escritura = "AE02_T1_2_Fichero_Escritura.txt";
	}

	/**
	 * lectura del fichero linea linea y lo guardo en una lista
	 * @param fichero
	 * @return cada elemento de la lista es una linea
	 */
	public ArrayList<String> contenidoFichero(String fichero) {
		ArrayList<String> contenidoFichero = new ArrayList<String>();
		File f = new File(fichero);
		FileReader fr;
		try {
			fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea != null) {
				contenidoFichero.add(linea);
				linea = br.readLine();
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e.getLocalizedMessage(),"Error en el archivo: ",JOptionPane.ERROR_MESSAGE);
			System.exit( 0 );
		}
		return contenidoFichero;
	}


	public String ficheroLectura() {
		return fichero_lectura;
	}


	public String ficheroEscritura() {
		return fichero_escritura;
	}

	/**
	 * recorre el contenido del texto y encuentra las coincidencias
	 * @param textoBuscar
	 * @return un entero con el n?mero de coincidencias
	 */
	public int buscarTexto(String textoBuscar) {
		int contador = 0;
		ArrayList<String> contenidoFicheroAL = contenidoFichero(fichero_lectura);

		for (String linea : contenidoFicheroAL) {
			int posicion = 0; //desde la primera letra del texto
			do {
				posicion = linea.indexOf(textoBuscar, posicion); // buscar desde la posicion en la q encuentra la coincidencia
				if (posicion > -1) { // en el caso de que haya encontrado la coinciencia
					contador++; // aumento contador
					posicion++; // sumo una posicion
				}
			} while (posicion > -1);
		}

		return contador;
	}

	/**
	 * lee el ficheroLectura, reemplaza las coincidencias que haya de textoBuscar por textoReemplazar
	 * @param textoBuscar
	 * @param textoReemplazar
	 */
	public void reemplazarTexto(String textoBuscar, String textoReemplazar) {
		File f = new File(fichero_escritura);
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			ArrayList<String> contenidoFicheroAL = contenidoFichero(fichero_lectura);
			for (String linea : contenidoFicheroAL) {
				String nuevaLinea= linea.replaceAll(textoBuscar, textoReemplazar);
				bw.write(nuevaLinea);
				bw.newLine();
			}
			bw.close();
			fw.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getLocalizedMessage(),"Error en el archivo: ",JOptionPane.ERROR_MESSAGE);
			
		}

	}

}
