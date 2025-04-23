package Ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrincipalDiccionario {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, String> diccionario = new HashMap<>();
		int cont = 0;

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("Diccionario.txt"));
			String linea = br.readLine();
			while (linea != null) {
				String[] array = linea.split(": ");
				diccionario.put(array[0], array[1]);
				linea = br.readLine();
			}
			System.out.println("Fichero leido");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		System.out.println("¿Cuantas palabras quieres buscar?");
		int cantidad = sc.nextInt();

		if (diccionario.size() < cantidad) {
			System.out.println("Cantidad superior a las palabras que contiene el diccionario");
		} else {

			while (cont < cantidad) {
				System.out.println("Dime una palabra");
				String palabra = sc.next();
				
				if(diccionario.containsKey(palabra)) {
					System.out.println("La traducción de la palabra es:");
					System.out.println();
					System.out.println(diccionario.get(palabra));
				}else {
					System.out.println("La palabra no se encuentra en el diccionario");
					System.out.println("Escriba la definición de la palabra");
					sc.nextLine();
					String definicion = sc.nextLine();
					
					BufferedWriter bw = null;
					
					try {
						bw = new BufferedWriter(new FileWriter("Diccionario.txt",true));
						bw.newLine();
						bw.write(palabra+": "+definicion);
						System.out.println("Nueva palabra escrita");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						if(bw != null) {
							try {
								bw.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				cont++;
			}
		}
	}
}
