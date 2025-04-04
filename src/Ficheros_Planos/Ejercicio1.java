package Ficheros_Planos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Escribe tu nombre");
	String nombre = sc.nextLine();
	
	System.out.println("Escribe tu edad");
	int edad = sc.nextInt();
	
	BufferedWriter out = null;
	
	try {
		out = new BufferedWriter(new FileWriter("datos.txt", true));
		out.write(nombre);
		out.newLine();
		out.write(edad);
		System.out.println("Fichero escrito");
		
	} catch (IOException e) {
		e.printStackTrace();
	}finally {
		if(out != null) {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	}

}
