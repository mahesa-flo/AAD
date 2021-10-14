package ejerciciosT1S2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ej14 {

	public static void ejercicio14(String nombreFichero) throws IOException {
		// Crea otro programa a partir del anterior que en vez de mostrar el contenido
		// por consola lo escriba en otro fichero del mismo directorio.

		//String nombreFichero = args[0];
		System.out.println("Fichero original: " + nombreFichero);

		int posicionPunto = nombreFichero.indexOf(".");
		String nombreFicheroSinExtension = nombreFichero.substring(0, posicionPunto);
		String extension = nombreFichero.substring(posicionPunto);
		String nombreFicheroCopia = nombreFicheroSinExtension + "_copia" + extension;
		System.out.println("Fichero copia: " + nombreFicheroCopia);
		
		//abro los dos ficheros:
		File ficheroOriginal = new File(nombreFichero);
		File ficheroCopia = new File(nombreFicheroCopia);
		//leo el original
		FileReader fr = new FileReader(ficheroOriginal);
		BufferedReader br = new BufferedReader(fr);
		//escribo en la copia
		FileWriter fw=new FileWriter(ficheroCopia);
		BufferedWriter bw= new BufferedWriter(fw);
		
		String linea = br.readLine();
		while (linea != null) {
			bw.write(linea);
			linea = br.readLine();
			
		}
		bw.close();
		fw.close();
		br.close();
		fr.close();
		System.out.println("Copia de " + nombreFichero + " en " + nombreFicheroCopia);
	}

}
