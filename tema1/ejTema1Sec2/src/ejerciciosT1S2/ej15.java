package ejerciciosT1S2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class ej15 {

	public static void ejercicio15() throws IOException {
		// Realiza un programa que permita recibir por teclado una serie de strings por parte del
		//usuario y los vaya escribiendo en un fichero de texto. Como condici�n de finalizaci�n, el
		//usuario deber� escribir un string que sea �exit�.

		String nombreFichero="input_usuario.txt";
		File fichero=new File(nombreFichero);
		FileWriter fw=new FileWriter(fichero);
		BufferedWriter bw=new BufferedWriter(fw); //texto linea a linea 
		
		Scanner teclado= new Scanner (System.in);
		System.out.println("Introduce texto linea a linea (termina con 'exit'): ");
		String linea=teclado.nextLine();
		while(!linea.equals("exit")) {
			bw.write(linea + "\n");
			linea=teclado.nextLine();
		}
		
		teclado.close();
		bw.close();
		fw.close();
		
		
	}

}
