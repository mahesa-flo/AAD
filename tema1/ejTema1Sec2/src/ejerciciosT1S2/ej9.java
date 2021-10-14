package ejerciciosT1S2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ej9 {
	// Escribe un programa que reciba como parámetro de entrada la ruta de un
	// fichero, lea su contenido y lo muestre por pantalla carácter a carácter.
	
	
	//método
	public static void ejercicio9(String nombreFichero) throws IOException {
		
		//String nombreFichero = args[0];
		System.out.println("Fichero original: " + nombreFichero);
		File ficheroOriginal = new File(nombreFichero);
		FileReader fr = new FileReader(ficheroOriginal);
		BufferedReader br = new BufferedReader(fr);
		int valor = br.read(); // leo el primer caracter
		while (valor != -1) { // si valor!=-1 es porque SI es un caracter válido
			System.out.print((char) valor); // para mostrar el caracter y no un entero, hago un cast a char. el valor del caracter a partir del entero en el valor de la tabla ASCII
			valor = br.read();
		}
		br.close();
		fr.close();

	}

}
