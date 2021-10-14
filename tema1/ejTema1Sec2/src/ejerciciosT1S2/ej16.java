package ejerciciosT1S2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ej16 {

	public static void ejercicio16() throws IOException {
		// Modifica el programa anterior para que el nombre del fichero incluya la fecha
		// y la hora de creaci�n.

		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		String nombreFichero = "input_usuario_" + timeStamp + ".txt";

		File fichero = new File(nombreFichero);
		FileWriter fw = new FileWriter(fichero);
		BufferedWriter bw = new BufferedWriter(fw); // texto linea a linea

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce texto linea a linea (termina con 'exit'): ");
		String linea = teclado.nextLine();
		while (!linea.equals("exit")) {
			bw.write(linea + "\n");
			linea = teclado.nextLine();
		}

		teclado.close();
		bw.close();
		fw.close();

	}

}