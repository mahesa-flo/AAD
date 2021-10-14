package ejTema1Ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class AD_Ejercicios_T1 {

	public static void main(String[] args) throws IOException {
		// le paso al main los parámetros como num de ejericio

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Número de ejercicio: ");
		String numeroString = br.readLine();
		int numero = Integer.parseInt(numeroString);
		switch (numero) {
		case 1:
			ejercicio1(args);
			break;
		case 2:
			ejercicio2(args);
			break;
		case 3:
			ejercicio3(args);
			break;
		case 4:
			ejercicio4(args);
			break;
		case 5:
			ejercicio5(args);
			break;
		case 6:
			ejercicio6(args);
			break;
		case 7:
			ejercicio7(args);
			break;
		case 8:
			ejercicio8(args);
			break;
		}

	}

	
	/**ESTO ES DE LA EVALUABLE PARA RECORRER EL CONTENIDO DEL DIRECTORIO
	 * // app.getInformacion2(args[0]);
	 * recorre el contenido del directorio e indica si es directorio o archivo
	 * 
	 * @param directorio
	 */
	public void getInformacion2(String directorio) {

		File fileDir = new File(directorio);

		for (String elemento : fileDir.list()) {
			File elem = new File(elemento);
			if (elem.isDirectory()) {
				System.out.println("soy un directorio " + elem.getName());
			} else {
				System.out.println("Soy un archivo " + elem.getName());
			}
		}
	}
	
	
	public static void ejercicio1(String[] args) {
		// TODO Run Configuration - Arguments - . (directorio actual)
		System.out.println("Ejercicio 1");
		System.out.println(
				"Realiza un programa que reciba como parámetro de entrada un directorio y lo muestre por pantalla.");
		String directorio = args[0];
		System.out.println("Directorio: " + directorio);
	}

	public static void ejercicio2(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ejercicio 2");
		System.out.println(
				"Ampliar el programa anterior para que muestre todas las características de interés del directorio, tomando como referencia la información que proporciona la clase File.");
		String directorio = args[0];
		System.out.println("Directorio: " + directorio);
		File file = new File(directorio);
		System.out.println("Ejecutable? " + file.canExecute());
		System.out.println("Lectura? " + file.canRead());
		System.out.println("Escritura? " + file.canWrite());
		System.out.println("Ruta absoluta? " + file.getAbsolutePath());
		System.out.println("Espacio libre? " + file.getFreeSpace() / 1024 / 1024 / 1024 + " GB");
		System.out.println("Espacio total? " + file.getTotalSpace() / 1024 / 1024 / 1024 + " GB");
		System.out.println("Padre? " + file.getParent()); // como solo le he puesto en la ruta el ., no puede acceder a
															// ningún direcotorio padre.
		System.out.println("Nombre? " + file.getName());
		System.out.println("Absoluto? " + file.isAbsolute());
		System.out.println("Directorio? " + file.isDirectory());
		System.out.println("Fichero? " + file.isFile());
		System.out.println("Última modificación (milisegundos desde 1/1/1970? " + file.lastModified());
		System.out.println("Última modificación? " + new Date(file.lastModified()));
		System.out.println("Contenido: ");
		String[] lista = file.list();
		for (String elemento : lista) {
			System.out.println(elemento);
		}
	}

	public static void ejercicio3(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ejercicio 3");
		System.out.println(
				"Introducir una comprobación en el programa anterior para determinar si el directorio existe.");
		String directorio = args[0];
		System.out.println("Directorio: " + directorio);
		File file = new File(directorio);
		if (file.exists()) { // compruebo si existe antes de acceder a las propiedades del directorio a
								// través de los métodos de la clase file.
			System.out.println("Ejecutable? " + file.canExecute());
			System.out.println("Lectura? " + file.canRead());
			System.out.println("Escritura? " + file.canWrite());
			System.out.println("Ruta absoluta? " + file.getAbsolutePath());
			System.out.println("Espacio libre? " + file.getFreeSpace() / 1024 / 1024 / 1024 + " GB");
			System.out.println("Espacio total? " + file.getTotalSpace() / 1024 / 1024 / 1024 + " GB");
			System.out.println("Padre? " + file.getParent()); // como solo le he puesto en la ruta el ., no puede
																// acceder a ningún direcotorio padre.
			System.out.println("Nombre? " + file.getName());
			System.out.println("Absoluto? " + file.isAbsolute());
			System.out.println("Directorio? " + file.isDirectory());
			System.out.println("Fichero? " + file.isFile());
			System.out.println("Última modificación (milisegundos desde 1/1/1970? " + file.lastModified());
			System.out.println("Última modificación? " + new Date(file.lastModified()));
			System.out.println("Contenido: ");
			String[] lista = file.list();
			for (String elemento : lista) {
				System.out.println(elemento);
			}
		}

	}

	public static void ejercicio4(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ejercicio 1");
		System.out.println(
				"Realizar un programa que dado un directorio, compruebe si existe y devuelva un mensaje de confirmación si existe o una alerta en caso contrario.");
		String directorio = args[0];
		System.out.println("Directorio: " + directorio);
		File file = new File(directorio);
		if (file.exists()) {
			System.out.println("El directorio existe.");
		} else {
			System.out.println("No se encuentra el directorio.");
		}
	}

	public static void ejercicio5(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ejercicio 5");
		System.out.println(
				"Realiza un programa que reciba como parámetros de entrada un directorio y una extensión de fichero (por ejemplo .txt) y devuelva por pantalla todos los ficheros del directorio que cumplan el criterio.");
		String directorio = args[0];
		System.out.println("Directorio: " + directorio);
		File file = new File(directorio);
		FiltroExtension filtro = new FiltroExtension(args[1]); // .txt
		String[] lista = file.list(filtro);
		for (String elemento : lista) {
			System.out.println(elemento);
		}
	}

	public static void ejercicio6(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ejercicio 6");
		System.out.println(
				"Modifica el programa anterior para que tenga en cuenta que si no se le pasa ninguna extensión como parámetro muestre todo el contenido del directorio.");
		String directorio = args[0];
		System.out.println("Directorio: " + directorio);
		File file = new File(directorio);
		if (args.length > 1) { // controlo los parámetros que le estoy pasando al programa
			FiltroExtension filtro = new FiltroExtension(args[1]); // .txt
			String[] lista = file.list(filtro);
			for (String elemento : lista) {
				System.out.println(elemento);
			}
		} else {
			String[] lista = file.list();
			for (String elemento : lista) {
				System.out.println(elemento);
			}
		}
	}

	public static void ejercicio7(String[] args) {
		// argumentos: . .txt .pdf
		System.out.println("Ejercicio 7");
		System.out.println(
				"Modifica el programa anterior para que admita como parámetros de entrada un número cualquiera de extensiones, devolviendo después por pantalla todos los ficheros del directorio que tengan alguna de las extensiones indicadas.");
		String directorio = args[0];
		System.out.println("Directorio: " + directorio);
		File file = new File(directorio);
		// calculo el num de argumentos, el total -1 (el primero corresponde al
		// directorio)
		int numExtensiones = args.length - 1;
		// recorro desde i=1 [i=0 es el directorio]
		for (int i = 1; i <= numExtensiones; i++) {
			FiltroExtension filtro = new FiltroExtension(args[i]); // recorro cada uno de los argumentos y lo guardo
																	// como filtro
			String[] lista = file.list(filtro); // y para cada filtro creo una lista
			for (String elemento : lista) { // recorro la lista para mostrar los archivos
				System.out.println(elemento);
			}
		}

	}

	public static void ejercicio8(String[] args) throws IOException {
		// args[0]: nombreFichero
		System.out.println("Ejercicio 8");
		System.out.println(
				"Desarrolla un programa que dado un fichero, realice una copia del mismo (en el mismo directorio y cambiándole el nombre) y lo borre después. Muestra una traza por pantalla de las acciones para ver que se realizan.");
		String nombreFichero = args[0];
		System.out.println("Fichero original: " + nombreFichero);

		// 1. determinar el nombreFicheroCopia
		int posicionPunto = nombreFichero.indexOf(".");
		String nombreFicheroSinExtension = nombreFichero.substring(0, posicionPunto);
		String extension = nombreFichero.substring(posicionPunto);
		String nombreFicheroCopia = nombreFicheroSinExtension + "_copia" + extension;
		System.out.println("Fichero copia: " + nombreFicheroCopia);

		// 2. para copiar el fichero primero lo tiene q abrir para leerlo, y en otro fichero lo escribirá 
		File ficheroOriginal = new File(nombreFichero); // para lectura
		File ficheroCopia = new File(nombreFicheroCopia); // para escritura

		FileReader fr = new FileReader(ficheroOriginal);
		BufferedReader br = new BufferedReader(fr); // para poder leer linea a linea

		FileWriter fw = new FileWriter(ficheroCopia);
		BufferedWriter bw = new BufferedWriter(fw); // para escritura linea a linea

		String linea = br.readLine(); // lee la primera linea
		while (linea != null) { //hasta el final del fichero, hasta q no haya líneas
			System.out.println("Copiando \"" + linea + "\" de " + nombreFichero + " a " + nombreFicheroCopia);
			bw.write(linea); // escribe
			linea = br.readLine(); // lee la linea siguiente
		}
		br.close();
		bw.close();
		fr.close();
		fw.close();
		System.out.println("Borrando fichero " + nombreFicheroCopia);
		ficheroCopia.delete();

	}

}
