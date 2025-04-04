package Ficheros_Planos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Ejercicio3 {

	public static void main(String[] args){
	int cant = 0;
	FileReader in = null;
		try {
			in = new FileReader("carta.txt");
			   int c = in.read();
			   while(c != -1){
				   cant++;
				   c = in.read();
			   }
			   System.out.println("Hay "+cant +" caracteres");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	
		cant = 0;
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("carta.txt"));
			String linea = br.readLine();
			while(linea != null) {
				cant++;
				linea = br.readLine();
			}
			System.out.println("Hay "+cant+" líneas");
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
		
		cant = 0;
		BufferedReader br1 = null;
		
		try {
			br1 = new BufferedReader(new FileReader("carta.txt"));
			String texto = br1.readLine();
			String[] palabras = texto.split(" ");
			while(texto != null) {
			for(int i = 0;i<palabras.length;i++) {
				cant++;
			}
				texto =br1.readLine();
			}
			System.out.println("hay "+cant+ " palabras");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(br1 != null) {
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
