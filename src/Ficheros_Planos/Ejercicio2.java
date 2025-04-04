package Ficheros_Planos;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class Ejercicio2 {
	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedReader br1 = null;
		int min = 0;
		List<Integer> numeros = new ArrayList<>();
		
		try {
			br = new BufferedReader(new FileReader("enteros1.txt"));
			br1 = new BufferedReader(new FileReader("enteros2.txt"));
			String linea = br.readLine();
			while(linea != null) {
			numeros.add(Integer.parseInt(linea));
			linea = br.readLine();
			}
			String otro = br1.readLine();
			while( otro != null) {
				
			numeros.add(Integer.parseInt(otro));
				otro= br1.readLine();
			}
			System.out.println("Fichero escrito");
			Collections.sort(numeros);
			System.out.println(numeros);
			
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(br !=null ) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		BufferedWriter bw = null;
		
		try {
			 bw = new BufferedWriter(new FileWriter("enterosOrdenados.txt"));
			 bw.write(numeros.toString());
			 System.out.println("Texto escrito");
			
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
