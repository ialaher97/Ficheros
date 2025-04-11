package Examen_ficheroDAmB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1.Alta usuario");
		System.out.println("2.Baja usuario");
		System.out.println("3.Listar usuario");
		System.out.println("4.Salir");
		
		System.out.println("Elige una opción");
		String opcion = sc.nextLine();
		
		BufferedReader br = null;
		
		try {
			br= new BufferedReader(new FileReader("Usuarios.txt"));
			String linea = br.readLine();
			String[] datos = linea.split(",");
			List<Usuario> usuarios = new ArrayList<>();
			while(linea != null) {
			Usuario u = new Usuario (datos[0],datos[1],datos[2],Integer.parseInt(datos[3]));
			usuarios.add(u);
			Collections.sort(usuarios);
			}
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
		
		if(opcion.equals("1")) {
			System.out.println("Dime DNI del usuario");
			String nuevoDni = sc.nextLine();
			System.out.println("Dime nombre completo");
			String nombreCompleto = sc.nextLine();
			String 
			
		}

	}

}
