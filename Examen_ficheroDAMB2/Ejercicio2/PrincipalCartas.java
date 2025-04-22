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

public class PrincipalCartas {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Carta> cartas = new ArrayList<>();
		int cont = 0;
		String[] palos = null;
		
		System.out.println("¿Cuantos números quieres generar?");
		int num = sc.nextInt();
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("Palos.txt"));
			String linea = br.readLine();
			palos =linea.split(", ");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		while(cont < num) {
			int numAleatorio = (int)(Math.random()*11);
			int paloAleatorio =(int)(Math.random()*3);
			Carta c = new Carta(numAleatorio,palos[paloAleatorio]);
			cartas.add(c);
			cont++;
			
		}
		
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("Cartas.txt",true));
			for(int i=0;i<cartas.size();i++) {
				bw.write(cartas.get(i).getNum()+", "+cartas.get(i).getPalo());
				bw.newLine();
			}
			System.out.println("Fichero escrito");
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
