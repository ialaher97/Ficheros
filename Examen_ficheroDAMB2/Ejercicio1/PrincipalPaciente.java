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

public class PrincipalPaciente {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Paciente> pacientes = new ArrayList<>();

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("Pacientes.txt"));
			String linea = br.readLine();
			if(linea != null) {
			String[] array = linea.split(", ");
			while (linea != null) {
				Paciente p = new Paciente(array[0], array[1], Integer.parseInt(array[2]),(array[3]),
						array[4]);
				pacientes.add(p);
				linea = br.readLine();
			}
			Collections.sort(pacientes);
			}
			System.out.println(pacientes);
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

		System.out.println("1.Alta paciente");
		System.out.println("2.Baja paciente");
		System.out.println("3.Listar paciente");
		System.out.println("4.Salir");

		System.out.println("Elige una opcion 1-4");
		String opcion = sc.next();

		while (!opcion.equals("4")) {

			if (opcion.equals("1")) {
				System.out.println("Dime Dni paciente");
				String dni = sc.next();
				System.out.println("Dime nombre completo del paciente");
				String nombre = sc.next();
				System.out.println("Dime teléfono");
				int telefono = sc.nextInt();
				System.out.println("Dime Fecha de cita");
				String fecha = sc.next();
				System.out.println("Dime que tratamiento va a recibir");
				String tratamiento = sc.next();

				Iterator it = pacientes.iterator();
				BufferedWriter bw = null;
				boolean encontrado = false;
				if(pacientes.isEmpty()) {
					Paciente nuevo = new Paciente(dni, nombre, telefono, fecha, tratamiento);
					pacientes.add(nuevo);

					
				}else {
				while (it.hasNext()) {
					Paciente p = (Paciente) it.next();

					if (p.getDni().equals(dni)) {
						System.out.println("El paciente ya se encuentra en la lista");
						encontrado = true;

					} else if(!encontrado) {
						Paciente nuevo = new Paciente(dni, nombre, telefono, fecha, tratamiento);
						pacientes.add(nuevo);
					}
						

						try {
							bw = new BufferedWriter(new FileWriter("Pacientes.txt", false));
							for (int i = 0; i < pacientes.size(); i++) {
								bw.write(pacientes.get(i).getDni() + ", " + pacientes.get(i).getNombreCompleto() + ", "
										+ pacientes.get(i).getTelefono() + ", " + pacientes.get(i).getFechaDeCita()
										+ ", " + pacientes.get(i).getTratamiento());
								bw.newLine();
							}
							Collections.sort(pacientes);
							System.out.println("Fichero Pacientes.txt Actualizada");

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

					}
				}
			}

			if (opcion.equals("2")) {
				System.out.println("Dime el DNI del paciente a eliminar de la lista");
				String dni = sc.nextLine();
				boolean encontrado = false;
				Iterator it = pacientes.iterator();

				while (it.hasNext() && !encontrado) {
					Paciente p = (Paciente) it.next();
					if (p.getDni().equals(dni)) {
						encontrado = true;
						pacientes.remove(p);
						System.out.println("Paciente eliminado de la lista");
						BufferedWriter bw = null;
						try {
							bw = new BufferedWriter(new FileWriter("Pacientes.txt", false));
							for (int i = 0; i < pacientes.size(); i++) {
								bw.write(pacientes.get(i).getDni() + ", " + pacientes.get(i).getNombreCompleto() + ", "
										+ pacientes.get(i).getTelefono() + ", " + pacientes.get(i).getFechaDeCita()
										+ ", " + pacientes.get(i).getTratamiento());
								bw.newLine();
							}
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

					}
				}

				if (!encontrado) {
					System.out.println("El paciente no se encuentra en la lista");

				}

			}

			if (opcion.equals("3")) {
				System.out.println(pacientes);
			}
			System.out.println("1.Alta paciente");
			System.out.println("2.Baja paciente");
			System.out.println("3.Listar paciente");
			System.out.println("4.Salir");

			System.out.println("Elige una opcion 1-4");
			opcion = sc.next();

		}
		
		if(opcion.equals("4")) {
			System.out.println("Programa finalizado");
		}
	}

}
