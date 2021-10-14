package ejerciciosT1S2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ej13 {

	public static void ejercicio13(String nombreFichero, int velocidad) throws IOException, InterruptedException {
		// Modifica el programa anterior para que acepte como par�metros de entrada un
		// n�mero que indique la velocidad a la que se muestran las l�neas.

		//String nombreFichero = args[0];
		//int velocidad = Integer.parseInt(args[1]);
		System.out.println("Fichero original: " + nombreFichero);
		File ficheroOriginal = new File(nombreFichero);
		FileReader fr = new FileReader(ficheroOriginal);
		BufferedReader br = new BufferedReader(fr);
		String linea = br.readLine();
		while (linea != null) {
			System.out.println(linea);
			linea = br.readLine();
			Thread.sleep(velocidad);
		}
		br.close();
		fr.close();

	}

}
