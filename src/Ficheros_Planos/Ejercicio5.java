package Ficheros_Planos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	ArrayList<Character> caracteres = new ArrayList<>();
	FileReader fr = null;
	
	try {
		fr = new FileReader("codec.txt");
		int c = fr.read();
		while(c != -1) {
			char caracter = (char) c;
			caracteres.add(caracter);
			c = fr.read();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		if(fr != null) {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	System.out.println("Escribe la frase a codificar");
	String frase = sc.next();
	
	
	
	
	
	}

}
