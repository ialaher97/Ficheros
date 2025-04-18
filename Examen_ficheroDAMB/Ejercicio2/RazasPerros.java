package Ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RazasPerros {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
		BufferedReader br1 = null;
		String[] nombres = new String[0];
		String[] razas = new String[0];
		
		try {
			br = new BufferedReader(new FileReader("NombresPerros.txt"));
			br1 = new BufferedReader(new FileReader("RazasPerros.txt"));
			String nombre = br.readLine();
			String raza = br1.readLine();
			razas = raza.split(",");
			nombres = nombre.split(",");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
		
		System.out.println("Dime cuantas razas de perros");
		int cantidad = sc.nextInt();
		
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("Nombre_Raza.txt",true));
			for(int i = 0;i<cantidad;i++) {
				int numrandom = (int)(Math.random()*nombres.length);
				int numrandom1 = (int)(Math.random()*razas.length);
				bw.write(nombres[numrandom]+" "+razas[numrandom1]);
				bw.newLine();
				}
			System.out.println("Lista creada");
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

}
