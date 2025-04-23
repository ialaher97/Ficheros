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

public class PrincipalClienteJSON {

	public static void main(String[] args) {
		List<Cliente> clientes = new ArrayList<>();
		
		Cliente c = new Cliente("Ivan","Alarcón",27);
		Cliente c1 = new Cliente("Jose","Fernandez",35);
		Cliente c2 = new Cliente("Pedro","Ruiz",18);
		
		clientes.add(c);
		clientes.add(c1);
		clientes.add(c2);
		
		Tienda t = new Tienda(clientes);
		
		Gson g = new Gson();
		
		String fichero = g.toJson(t);
		
		BufferedWriter bw = null;
		
		try {
			bw=new BufferedWriter(new FileWriter("Clientes.json"));
			bw.write(fichero);
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
			br = new BufferedReader(new FileReader("Clientes.json"));
			String linea = br.readLine();
			String vacio = "";
			while(linea != null) {
				vacio += linea;
				linea = br.readLine();
			}
			Tienda c3 = g.fromJson(vacio,Tienda.class );
			System.out.println(c3);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
