package Ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class PricipalJson {
	public static void main(String[] args) {
		List<Palabra> palabras = new ArrayList<>();
		palabras.add(new Palabra("hola","despedida"));
		palabras.add(new Palabra("Roberto","nombre"));
		
		Diccionario d = new Diccionario(palabras);
		
		Gson g = new Gson();
		
		String fichero = g.toJson(d);
		
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("diccionario.json"));
			bw.write(fichero);
			bw.newLine();
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
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("diccionario.json"));
			String linea = br.readLine();
			String vacio = "";
			
			while(linea != null) {
				vacio+= linea;
				linea = br.readLine();
			}
			Diccionario d1 = g.fromJson(vacio,Diccionario.class);
			System.out.println(d1);
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
		
		
		
		
		
	}
	

}
