package Ficheros_Planos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio4 {

	public static void main(String[] args) {
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

	}
	public void aniadirNuevoNombre(String firma) {
		
	}

}
