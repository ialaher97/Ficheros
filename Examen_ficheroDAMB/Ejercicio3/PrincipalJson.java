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



public class PrincipalJson {
	public static void main(String[] args) {
		Usuario u = new Usuario("Jose","1");
		Usuario u1 = new Usuario("Marta","2");
		Usuario u2 = new Usuario("Pedro","3");
		Usuario u3 = new Usuario("Alberto","4");
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(u);
		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);
		Gym g1 = new Gym("Alfarelo",usuarios);
		
		Gson g = new Gson();
		String fichero = g.toJson(g1);
		
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("gym.json"));
			bw.write(fichero);
			System.out.println("Se ha escrito");
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
			br = new BufferedReader(new FileReader("gym.json"));
			String linea = br.readLine();
			String salida = "";
			while(linea != null) {
				salida +=linea;
				linea = br.readLine();
			}
			Gym gym1 = g.fromJson(salida, Gym.class);
			System.out.println(gym1);
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
