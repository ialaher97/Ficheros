package Ficheros_Planos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Ejercicio6 {
	public static void main(String[] args) {
		Contacto c1 = new Contacto("Juan", 633812883);
		Contacto c2 = new Contacto("Pedro", 989675234);
		List<Contacto> contactos = new ArrayList<>();
		contactos.add(c1);
		contactos.add(c2);
		Scanner sc = new Scanner(System.in);
		int cantidadContactos = 0;

		System.out.println("1. Nuevo Contacto");
		System.out.println("2. Buscar por nombre");
		System.out.println("3. Mostrar todos");
		System.out.println("4. Salir");
		System.out.println();

		System.out.println("Elige una opción");
		String opcion = sc.next();

		if (opcion.equals("1")) {
			System.out.println("Escriba el nombre del contacto");
			String nombre = sc.next();
			System.out.println("Escribe el numero de telefono");
			int telefono = sc.nextInt();

			boolean encontrado = false;

			Iterator it = contactos.iterator();

			while (it.hasNext() && !encontrado) {
				Contacto c = (Contacto) it.next();
				if (c.getNombre().equals(nombre)) {
					encontrado = true;
					System.out.println("El usuario ya se encuentra en la agenda");
				} 
				if(!encontrado){
					contactos.add(new Contacto(nombre, telefono));
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

	}
}