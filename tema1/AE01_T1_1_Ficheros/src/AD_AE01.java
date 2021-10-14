import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class AD_AE01 {

	public static void main(String[] args) throws IOException {

		// instancio la clase
		AD_AE01 app = new AD_AE01();
		 app.getInformacion(args[0]);
		 app.creaCarpeta(args[0], "Archivos");
		 app.creaFichero(args[0], "Facturas");
		 app.elimina(args[0], "Facturas");
		 app.renombra(args[0], "Archivos", "Contabilidad");



	}


	/**
	 * Muestra información del directorio/fichero: nombre, tipo (si es fichero o
	 * directorio), la ubicación (ruta completa), la fecha de la última modificación
	 * en formato fecha y si es oculto o no. Si es un fichero muestra su tamaño en
	 * bytes. Si es un directorio muestra el número de elementos que contiene,
	 * espacio libre, espacio disponible y espacio total.
	 * 
	 * @param directorio
	 */
	public void getInformacion(String directorio) {
		System.out.println("Información:");
		System.out.println("Directorio: " + directorio);
		File file = new File(directorio);

		// El permiso de lectura permite ver el contenido del directorio.
		if (!file.canRead()) {
			System.out.println(
					"No tiene permisos de lectura sobre el directorio. No se puede obtener la información solicitada.");
		} else {

			System.out.println("Nombre: " + file.getName());

			System.out.println("Es fichero? " + file.isFile());
			if (file.isFile()) {

				System.out.println("-->Tamaño del fichero: " + file.length() + "bytes.");
			} else {
				System.out.println("Es directorio? " + file.isDirectory());
				System.out.println("-->El directorio contiene " + file.list().length + " elementos");
				System.out.println("-->Espacio libre? " + file.getFreeSpace() / 1024 / 1024 / 1024 + " GB");
				System.out.println("-->Espacio ocupado? "
						+ (file.getTotalSpace() - file.getFreeSpace()) / 1024 / 1024 / 1024 + " GB");
				System.out.println("-->Espacio total? " + file.getTotalSpace() / 1024 / 1024 / 1024 + " GB");
			}
			System.out.println("Ubicación: " + file.getAbsolutePath());
			System.out.println("Última modificación? " + new Date(file.lastModified()));
			System.out.println("Es oculto? " + file.isHidden() + "\n");
		}
	}

	
	
	/**
	 * Crea una nueva carpeta en el directorio especificado, comprobando que no
	 * exista con ese nombre.
	 * 
	 * @param directorio
	 * @param nombreCarpeta
	 * @throws IOException
	 */
	public void creaCarpeta(String directorio, String nombreCarpeta) throws IOException {
		String ruta = directorio + "\\" + nombreCarpeta;
		File file = new File(ruta);


			try {
				if (file.mkdir()) {
					System.out.println(
							"Va a crearse una nueva carpeta: " + nombreCarpeta);
					System.out.println("Carpeta creada correctamente:" + ruta + "\n");
				} else {
					System.out.println("La carpeta no se ha podido crear porque ya existe.");
				}
			} catch (SecurityException e) {
				System.out.println("Error Security Exception: " + e.getMessage());

			} catch (Exception e) {
				System.out.println("Error desconocido: " + e.getMessage());
			}
		}
	

	
	/**
	 * Crea un fichero en el directorio actual comprobando que no exista con ese nombre.
	 * @param directorio
	 * @param nombreFichero
	 * @throws IOException
	 */
	public void creaFichero(String directorio, String nombreFichero) throws IOException {
		
		
		String ruta = directorio + "\\" + nombreFichero;
		File file = new File(ruta);


			try {
				if (file.createNewFile()) {
					System.out.println(
							"Va a crearse un nuevo fichero: " + nombreFichero);
					System.out.println("Fichero creado correctamente: " + ruta);
				} else {
					System.out.println("El fichero no se ha podido crear porque ya existe.");
				}
			} catch (SecurityException e) {
				System.out.println("Error Security Exception: " + e.getMessage());

			} catch (IOException e) {
				System.out.println("Error IO Exception: " + e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Error desconocido: " + e.getMessage());
			}
		}
	

	/**
	 * Elimina un fichero o directorio.
	 * @param directorio
	 * @param nombreAElimar
	 * @throws IOException
	 */
	public void elimina(String directorio, String nombreAElimar) throws IOException {

		try {
			String ruta = directorio + "\\" + nombreAElimar;
			File file = new File(ruta);
			if (!file.exists()) {
				System.out.println("El elemento NO EXISTE, no se ha podido eliminar");
			} else {
				String elemento = "";
				if (file.isDirectory())
					elemento = "DIRECTORIO";
				else
					elemento = "FICHERO";

				Scanner teclado = new Scanner(System.in);
				System.out.println("Se va a eliminar el siguiente " + elemento + ": " + nombreAElimar
						+ "\n¿Está seguro de eliminarlo? (S/N)");
				String confirmacion = teclado.next();
				if (confirmacion.equals("s") || confirmacion.equals("S")) {
					if (file.delete()) {
						System.out.println("Se ha eliminado el " + elemento +" " + nombreAElimar + " correctamente.");
					} else {
						System.out.println("El elemento no se ha podido eliminar");
					}
				} else if (confirmacion.equals("n") || confirmacion.equals("N")) {
					System.out.println("Operación cancelada. El elemento NO se ha eliminado");
				}
			}
		} catch (SecurityException e) {
			System.out.println("Error Security Exception: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error desconocido: " + e.getMessage());
		}
	}

	
	
	/**
	 * Renombra un fichero o directorio.
	 * @param directorio
	 * @param nombreARenombrar
	 * @param nuevoNombre
	 * @throws IOException
	 */
	public void renombra(String directorio, String nombreARenombrar, String nuevoNombre) throws IOException {

		try {
			String ruta = directorio + "\\" + nombreARenombrar;
			File file = new File(ruta);
			if (!file.exists()) {
				System.out.println("El elemento NO EXISTE, no se ha podido renombrar");
			} else {
				String elemento = "";
				if (file.isDirectory())
					elemento = "DIRECTORIO";
				else
					elemento = "FICHERO";

				System.out.println(
						"Va a renombrar el " + elemento + ": " + nombreARenombrar + " por " + nuevoNombre);
				

				String ruta2 = directorio + "\\" + nuevoNombre;
				File file2 = new File(ruta2);

				if (file.renameTo(file2)) {
					ruta = directorio + "\\" + nuevoNombre;
					System.out.println("Se ha renombrado el " + elemento + " correctamente.");
				}else {
					System.out.println("No se puede cambiar el nombre del "+elemento + ": " + nombreARenombrar +" por " + nuevoNombre + " porque ya existe.");
				}
			}
		} catch (SecurityException e) {
			System.out.println("Error Security Exception: " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Error NullPointer Exception (valor null): " + e.getMessage());
		}	catch (Exception e) {
			System.out.println("Error desconocido: " + e.getMessage());
		}
	}
}