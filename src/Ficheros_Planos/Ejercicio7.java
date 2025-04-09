package Ficheros_Planos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("1.Registrar nueva temperatura");
		System.out.println("2.Mostrar historial registro");
		System.out.println("3.salir");
		System.out.println();
		System.out.println("Elige una opción");
		String opcion = sc.next();

		while (!opcion.equals("3")) {
			if (opcion.equals("1")) {
				System.out.println("Indica fecha del dia de hoy YYYY/MM/DD");
				String fecha = sc.next();
				System.out.println();
				System.out.println("Escribe temperatura mínima");
				String tempMin = sc.next();
				System.out.println();
				System.out.println("Escribe temperatura maxina");
				String tempMax = sc.next();

				BufferedWriter bw = null;

				try {
					bw = new BufferedWriter(new FileWriter("registro_temperaturas.txt", true));
					bw.newLine();
					bw.write(fecha + "          " + tempMin + "                    " + tempMax);
					
				} catch (IOException e) {

					e.printStackTrace();
				}finally {
					try {
						bw.flush();
						bw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
			if (opcion.equals("2")) {
				BufferedReader br = null;

				try {
					br = new BufferedReader(new FileReader("registro_temperaturas.txt"));
					String linea = br.readLine();
					
					while (linea != null) {
						String[] datos = linea.split(" ");
						System.out.println(Arrays.toString(datos));
						linea = br.readLine();
						
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println("1.Registrar nueva temperatura");
			System.out.println("2.Mostrar historial registro");
			System.out.println("3.salir");
			System.out.println();
			System.out.println("Elige una opción");
			opcion = sc.next();
		}
	}
}
