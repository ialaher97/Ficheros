package Ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrincipalCoches {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime un numero del 1 al 6");
		int numero = sc.nextInt();
		List<Coche> coches = new ArrayList<>();

		List<String> matriculas = new ArrayList<>();
		int numAleatorio = (int) (Math.random() * numero + 1);
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("matriculas.txt"));
			String matricula = br.readLine();
			while (matricula != null) {
				matriculas.add(matricula);
				matricula = br.readLine();
			}

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

		System.out.println("Dime el modelo del coche");
		String modelo = sc.next();

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter("Final.txt", true));
			bw.write(matriculas.get(numAleatorio) + ":" + modelo);
			bw.newLine();

			System.out.println("Se ha escrito en el ficher Final.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		BufferedReader br1 = null;

		try {
			br1 = new BufferedReader(new FileReader("Final.txt"));
			String linea = br1.readLine();
			while (linea != null) {
				String[] array = linea.split(":");
				Coche a = new Coche(array[0], array[1]);
				coches.add(a);
				linea = br1.readLine();
			}
			Collections.sort(coches);
			System.out.println(coches.toString());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br1 != null) {
				try {
					br1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
