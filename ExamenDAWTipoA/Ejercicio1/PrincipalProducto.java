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

public class PrincipalProducto {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Elige una opción 1-4");
		System.out.println();
		System.out.println("1.Alta Producto");
		System.out.println("2.Baja Producto");
		System.out.println("3.Listar Producto");
		System.out.println("4.salir");
		System.out.println();
		String opcion = sc.next();

		BufferedReader br = null;
		List<Producto> productos = new ArrayList<>();

		try {
			br = new BufferedReader(new FileReader("Productos.txt"));
			String linea = br.readLine();
			while (linea != null) {
				String[] array = linea.split(", ");
				Producto p = new Producto(array[0], array[1], Double.parseDouble(array[2]));
				productos.add(p);
				linea = br.readLine();
			}
			System.out.println("Lista de productos creada");
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
		while (!opcion.equals("4")) {
			if (opcion.equals("1")) {
				System.out.println("Escribe código de barras del producto");
				String codigoBarra = sc.next();
				sc.nextLine();
				System.out.println("Escribe nombre del producto");
				String producto = sc.nextLine();
				System.out.println("Escribe precio del producto");
				Double precio = sc.nextDouble();

				Producto p = new Producto(codigoBarra, producto, precio);

				if (productos.isEmpty()) {
					productos.add(p);
					System.out.println("Producto añadido");
					Collections.sort(productos);
				} else {
					Iterator it = productos.iterator();
					boolean encontrado = false;

					while (it.hasNext() && !encontrado) {
						Producto p1 = (Producto) it.next();

						if (p1.getCodigoBarra().equals(codigoBarra)) {
							encontrado = true;
							System.out.println("El producto se encuentra ya en la lista");
						}
					}
					if (!encontrado) {
						productos.add(p);
						System.out.println("Producto añadido");
						Collections.sort(productos);
					}
				}
			}

			if (opcion.equals("2")) {
				System.out.println("Dime el codigo del producto");
				String codigo = sc.next();

				Iterator it = productos.iterator();
				boolean encontrado = false;

				while (it.hasNext() && !encontrado) {
					Producto p1 = (Producto) it.next();

					if (p1.getCodigoBarra().equals(codigo)) {
						encontrado = true;
						productos.remove(p1);
						System.out.println("El producto se ha eliminado de la lista");
					}
				}
				if (!encontrado) {
					System.out.println("El producto no se encuentra en la lista");
				}

			}

			if (opcion.equals("3")) {
				System.out.println(productos);
			}
			System.out.println("Elige una opción 1-4");
			System.out.println();
			System.out.println("1.Alta Producto");
			System.out.println("2.Baja Producto");
			System.out.println("3.Listar Producto");
			System.out.println("4.salir");
			System.out.println();
			opcion = sc.next();
		}
		
		if(opcion.equals("4")){
			BufferedWriter bw = null;
			
			try {
				bw= new BufferedWriter(new FileWriter("Productos.txt"));
				for(int i=0;i<productos.size();i++) {
					bw.write(productos.get(i).getCodigoBarra()+", "+productos.get(i).getNombre()+", "+productos.get(i).getPrecio());
					bw.newLine();
				}
				System.out.println("Lista escrita en Productos.txt");
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

}
