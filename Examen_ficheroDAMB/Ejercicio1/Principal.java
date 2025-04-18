package Ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
		
		
		while(!opcion.equals("4")) {
		BufferedReader br = null;
		List<Usuario> usuarios = new ArrayList<>();

		try {
			br = new BufferedReader(new FileReader("Usuarios.txt"));
			String linea = br.readLine();

			while (linea != null) {
				String[] datos = linea.split(",");
				Usuario u = new Usuario(datos[0], datos[1], datos[2], Double.parseDouble(datos[3]));
				usuarios.add(u);
				Collections.sort(usuarios);
				linea = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		if (opcion.equals("1")) {
			System.out.println("Dime DNI del usuario");
			String nuevoDni = sc.nextLine();
			System.out.println("Dime nombre completo");
			String nombreCompleto = sc.nextLine();
			System.out.println("Dime fecha de nacimiento DD/MM/YYYY");
			String fecha = sc.nextLine();
			System.out.println("Dime la cuato del usuario");
			double cuota = sc.nextDouble();

			Usuario nuevo = new Usuario(nuevoDni, nombreCompleto, fecha, cuota);

			Iterator it = usuarios.iterator();
			boolean encontrado = false;

			while (it.hasNext()) {
				Usuario u = (Usuario) it.next();

				if (u.getDni().equals(nuevoDni)) {
					encontrado = true;
				}
			}
			if (!encontrado) {
				usuarios.add(nuevo);
				System.out.println("Usuario añadido");
				Collections.sort(usuarios);

				BufferedWriter bw = null;

				try {
					bw = new BufferedWriter(new FileWriter("Usuarios.txt", true));
					bw.write(nuevoDni + "," + nombreCompleto + "," + fecha + "," + cuota);
					System.out.println("usuarios.txt actualizado");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (bw != null) {
						try {
							bw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			} else {
				System.out.println("El usuario ya se encuentra en la lista");
			}

		}

		if (opcion.equals("2")) {
			System.out.println("Escribe el DNI del usuario a eliminar de la lista");
			String dniEliminar = sc.nextLine();
			Iterator it = usuarios.iterator();
			boolean encontrado = false;

			while (it.hasNext() && !encontrado) {
				Usuario u = (Usuario) it.next();

				if (u.getDni().equals(dniEliminar)) {
					encontrado = true;
					usuarios.remove(u);
					System.out.println("Usuario eliminado de la lista");
				}
			}

				BufferedWriter bw1 = null;

				try {
					bw1 = new BufferedWriter(new FileWriter("Usuarios.txt", false));
					Iterator it1 = usuarios.iterator();

					while (it1.hasNext()) {
						Usuario u1 = (Usuario) it1.next();
						bw1.write(u1.getDni() + "," + u1.getNombreCompleto() + "," + u1.getFechaNacimiento() + ","
								+ u1.getCuota());
						bw1.newLine();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					if(bw1 != null) {
						try {
							bw1.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}


			if (!encontrado) {
				System.out.println("El usuario no se encuentra en la lista");
				Collections.sort(usuarios);
			}
		}

		if (opcion.equals("3")) {
			System.out.println(usuarios.toString());
		}
		
		System.out.println("1.Alta usuario");
		System.out.println("2.Baja usuario");
		System.out.println("3.Listar usuario");
		System.out.println("4.Salir");

		System.out.println("Elige una opción");
		opcion = sc.nextLine();
		}
		
		if(opcion.equals("4")) {
			System.out.println("Programa finalizado");
		}

	}
}
