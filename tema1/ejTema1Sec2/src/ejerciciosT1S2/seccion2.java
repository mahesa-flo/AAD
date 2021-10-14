package ejerciciosT1S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import ejerciciosT1S2.*;

public class seccion2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		// parseo los argumentos
		String nombreFichero = args[0];
		int velocidad= Integer.parseInt(args[1]);
		
		InputStreamReader isr=new InputStreamReader(System.in); 
		BufferedReader br= new BufferedReader (isr);  
		System.out.print("N�mero de ejercicio: ");
		String numString=br.readLine();
		int numero=Integer.parseInt(numString);
		
		switch (numero) {
		case 9:
			ej9.ejercicio9(nombreFichero);
			break;
		case 10:
			ej10.ejercicio10(nombreFichero, velocidad);
			break;
		case 11:
			ej11.ejercicio11(nombreFichero);
			break;	
		case 12:
			ej12.ejercicio12(nombreFichero);
			break;
		case 13:
			ej13.ejercicio13(nombreFichero, velocidad);
			break;
		case 14:
			ej14.ejercicio14(nombreFichero);
			break;
		case 15:
			ej15.ejercicio15();
			break;
		case 16:
			ej16.ejercicio16();
			break;
		default:
			System.out.println("Secci�n2: solo Ejercicios del 9 al 16.");
			
		}
		
	}

}