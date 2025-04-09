package Ficheros_Planos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Ejercicio6 {
	public static void main(String[] args) {
		List<Contacto> contactos = new ArrayList<>();
		BufferedReader bf = null;
		
		try {
			bf = new BufferedReader(new FileReader("agenda.txt"));
			String linea = bf.readLine();
			while(linea != null) {
        	String[] contacto = linea.split(" ");
        	Contacto c = new Contacto (contacto[0],Integer.valueOf(contacto[1]));
			contactos.add(c);
			linea = bf.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	
		Scanner sc = new Scanner(System.in);
		int cantidadContactos = 0;
		
		System.out.println("1. Nuevo Contacto");
		System.out.println("2. Buscar por nombre");
		System.out.println("3. Mostrar todos");
		System.out.println("4. Salir");
		System.out.println();

		System.out.println("Elige una opción");
		String opcion = sc.next();
		

		while(!opcion.equals("4")) {
		if(opcion.equals("1")) {
			System.out.println("Escriba el nombre del contacto");
			String nombre = sc.next();
			System.out.println("Escribe el numero de telefono");
			int telefono = sc.nextInt();

			boolean encontrado = false;

			Iterator it = contactos.iterator();
			if(contactos.isEmpty()) {
				contactos.add(new Contacto(nombre, telefono));
				System.out.println("Contacto añadido");
			}else {

			while (it.hasNext() && !encontrado) {
				Contacto c = (Contacto) it.next();
				if (c.getNombre().equals(nombre)) {
					encontrado = true;
					System.out.println("El usuario ya se encuentra en la agenda");
				} 
			}
				if(!encontrado){
					contactos.add(new Contacto(nombre, telefono));
					System.out.println("Contacto añadido");
				}
			
			}
		}
		if (opcion.equals("2")) {
			Iterator it = contactos.iterator();
			System.out.println("Buscar usuario");
			String caracteres = sc.next();
			List<Contacto> buscados = new ArrayList<>();

			while (it.hasNext()) {
				Contacto c = (Contacto) it.next();
				if (c.getNombre().contains(caracteres)) {
					buscados.add(c);
				}
			}
			System.out.println(buscados);
		}
		
		if(opcion.equals("3")) {
			System.out.println(contactos);
		}
		
		
		System.out.println("1. Nuevo Contacto");
		System.out.println("2. Buscar por nombre");
		System.out.println("3. Mostrar todos");
		System.out.println("4. Salir");
		System.out.println();

		System.out.println("Elige una opción");
		opcion = sc.next();
	}
		
		if(opcion.equals("4")) {
			BufferedWriter bw= null;
			
			try {
				bw = new BufferedWriter(new FileWriter("agenda.txt"));
				Iterator it = contactos.iterator();
				
				while(it.hasNext()) {
					Contacto c = (Contacto) it.next();
					bw.write(c.getNombre()+" ");
					bw.write(String.valueOf(c.getNum()));
					bw.newLine();
				}
				System.out.println("Agenda escrita");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
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
