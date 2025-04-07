package Ficheros_Planos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
		List<String> firmas = new ArrayList<>();
		
		try {
			br = new BufferedReader(new FileReader("firmas.txt"));
			String firma = br.readLine();
			String[] listaFirmas = firma.split(" ");
			
			while(firma != null) {
				for(int i = 0;i<listaFirmas.length;i++) {
					firmas.add(listaFirmas[i]);
				}
				firma = br.readLine();
			}
			System.out.println(firmas);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("¿Quieres añadir una firma nueva? Y/N ");
		String respuesta = sc.next();
		
		
		boolean encontrado = false;
		while(!respuesta.equalsIgnoreCase("N")) {
		System.out.println("Escribe la firma");
		String nuevaFirma = sc.next();
		
		Iterator<String> it = firmas.iterator();
		
		while(it.hasNext()) {
			String f = it.next();
			
			if(f.equalsIgnoreCase(nuevaFirma)) {
				encontrado = true;
				System.out.println("La firma ya se encuentra dentro de la lista");
			
			}
			
			
		}
		if(!encontrado){
			firmas.add(nuevaFirma);
			System.out.println("Firma añadida");
			System.out.println(firmas);
		}
		System.out.println("¿Quieres añadir una firma nueva? Y/N ");
		respuesta = sc.next();
		}

	}

}
