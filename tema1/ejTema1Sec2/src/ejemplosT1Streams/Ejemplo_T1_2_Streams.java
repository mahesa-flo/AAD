package ejemplosT1Streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejemplo_T1_2_Streams {

	public static void main(String[] args) {
		// EJEMPLO1: leer txt caracter a caracter y mostrarlo // FileREader

		try {
			FileReader fr = new FileReader("AE02_T1_2_Streams_Groucho.txt"); // dentro del proyecto
			int valor = fr.read(); // lee el primer caracter
			while (valor != -1) { // mientras haya caracteres
				System.out.print((char) valor); // paso el int a char
				valor = fr.read();
				Thread.sleep(10); // para que podamos verlo, pongo pausas de 10 milisegundos por caracter
			}
			fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// EJEMPLO2: leer txt linea a linea y mostrarlo --> FileReader + BufferedReader
//		try {
//			FileReader fr = new FileReader("AE02_T1_2_Streams_Groucho.txt");
//			BufferedReader br = new BufferedReader(fr);
//			String linea = br.readLine(); //leo la primera linea
//			while (linea != null) {
//				System.out.println(linea);
//				linea = br.readLine(); //leo la siguiente linea
//				Thread.sleep(1000);
//			}
//			fr.close();
//			br.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// EJEMPLO3: escribir en fichero -->

//		try {
//			FileWriter fw = new FileWriter("AE02_T1_2_Streams_Groucho_copia.txt"); // creo el nuevo fichero, la copia
//			BufferedWriter bw = new BufferedWriter(fw); // para poder escribir en ese fichero linea a linea
//			FileReader fr = new FileReader("AE02_T1_2_Streams_Groucho.txt"); // original
//			BufferedReader br = new BufferedReader(fr); // para leerlo linea a linea
//			String linea = br.readLine(); // 1� lees la primera linea
//			while (linea != null) {
//				bw.write(linea); // la escribo
//				bw.newLine(); // salto de linea
//				linea = br.readLine(); // pasas a la siguiente linea
//			} // cuando termina el archivo
//			bw.write("(Una Noche en la �pera, 1935)"); // escribo esta l�nea
//			br.close();
//			fr.close();
//			bw.close();
//			fw.close();
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
