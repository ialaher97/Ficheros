package Ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PrincipalTexto {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		List<Partido> listaPartidos = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		try {
			br = new BufferedReader(new FileReader("Partidos.txt"));
			String linea = br.readLine();
			while(linea != null) {
				String[] array = linea.split(" ");
				Partido p = new Partido(array[0],array[1],Integer.parseInt(array[2]),Integer.parseInt(array[3]));
				listaPartidos.add(p);
				linea = br.readLine();
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
		
		
		System.out.println("1.Alta partido");
		System.out.println("2.Baja partido");
		System.out.println("3.Listar partido");
		System.out.println("4.Salir");
		
		System.out.println("Elige una opción");
		String opcion = sc.nextLine();
		
		while(!opcion.equals("4")) {
		if(opcion.equals("1")) {
			System.out.println("Dime el nombre del equipo");
			String nombre = sc.nextLine();
			System.out.println();
			System.out.println("Dime el id del partido");
			String id = sc.nextLine();
			System.out.println();
			System.out.println("Dime goles marcados del partido");
			int golesM = sc.nextInt();
			System.out.println();
			System.out.println("Dimes goles recibidos del partido");
			int golesR = sc.nextInt();
			
			System.out.println("Dime");
			Iterator it = listaPartidos.iterator();
			boolean encontrado = false;
			
			while(it.hasNext() && !encontrado) {
				Partido p = (Partido) it.next();
				
				if(p.getId().equals(id)) {
					encontrado = true;
					System.out.println("El equipo ya se encuentra en la lista");
				}
			}
			if(!encontrado) {
				Partido p = new Partido(nombre,id,golesM,golesR);
				listaPartidos.add(p);
				System.out.println("Partido añadido a la lista");
				
				BufferedWriter bw = null;
				
				try {
					bw = new BufferedWriter(new FileWriter("Partidos.txt",true));
					bw.write(nombre+" "+id+" "+golesM+" "+golesR);
					System.out.println("Partido añadido a la Partidos.txt");
					
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
				
			}
		}
		
		if(opcion.equals("2")) {
			System.out.println("Dime la id del Partido que deseas eliminar");
			String id = sc.nextLine();
			Iterator it = listaPartidos.iterator();
			boolean encontrado = false;
			
			while(it.hasNext() && !encontrado) {
				Partido p = (Partido) it.next();
				
				if(p.getId().equals(id)) {
					encontrado = true;
					listaPartidos.remove(p);
					System.out.println("El Partido ha sido eliminado de la lista");
					
					BufferedWriter bw = null;
					
					try {
						bw = new BufferedWriter(new FileWriter("Partidos.txt",false));
						String vacio = "";
						for(int i = 0;i<listaPartidos.size();i++) {
							vacio = listaPartidos.get(i).getNombreEquipo()+" "+listaPartidos.get(i).getId()+" "+listaPartidos.get(i).getGolesMarcados()+" "+listaPartidos.get(i).getGolesRecibidos();
							bw.write(vacio);
							bw.newLine();
						}
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
					
				}
			}
			if(!encontrado) {
				System.out.println("El partido no se encuentra en la lista");
			}
		}
		
		if(opcion.equals("3")) {
			System.out.println(listaPartidos.toString());
		}
		
		System.out.println("1.Alta partido");
		System.out.println("2.Baja partido");
		System.out.println("3.Listar partido");
		System.out.println("4.Salir");
		
		System.out.println("Elige una opción");
		opcion = sc.nextLine();
		
	}
		if(opcion.equals("4")) {
			System.out.println("Aplicación cerrada");
		}
		

	}

}
