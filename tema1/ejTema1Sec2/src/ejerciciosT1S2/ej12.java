package ejerciciosT1S2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ej12 {

	public static void ejercicio12(String nombreFichero) throws IOException {
		// Crea un programa que dado un fichero de texto, lea y muestre su contenido l�nea a l�nea.

		//String nombreFichero=args[0];
		System.out.println("Fichero original: " + nombreFichero);
		File ficheroOriginal=new File(nombreFichero);
		FileReader fr= new FileReader (ficheroOriginal);
		BufferedReader br= new BufferedReader(fr);
		String linea=br.readLine();
		while(linea != null) { // mientras sea =!null habr� lineas
			System.out.println(linea);
			linea=br.readLine();
		}
		br.close();
		fr.close();

	}

}
