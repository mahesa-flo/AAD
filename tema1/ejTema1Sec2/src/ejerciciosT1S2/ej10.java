package ejerciciosT1S2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ej10 {
	
	public static void ejercicio10(String nombreFichero, int velocidad) throws IOException, InterruptedException {
		// Introduce una modificaci�n en el programa anterior para que admita otro
		// par�metro de entrada adicional
		// que permita especificar la velocidad a la que se muestren los caracteres.

		//String nombreFichero = args[0];
		//int velocidad= Integer.parseInt(args[1]);
		
		System.out.println("Fichero original: " + nombreFichero);
		File ficheroOriginal = new File(nombreFichero);
		FileReader fr = new FileReader(ficheroOriginal);
		BufferedReader br = new BufferedReader(fr);
		int valor = br.read(); // leo el primer caracter
		while (valor != -1) { // si valor!=-1 es porque SI es un caracter v�lido
			System.out.print((char) valor); // para mostrar el caracter y no un entero, hago un cast a char. el valor del caracter a partir del entero en el valor de la tabla ASCII
			valor = br.read();
			Thread.sleep(velocidad);
		}
		br.close();
		fr.close();
	}

}