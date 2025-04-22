package Ejercicio3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import Ejercicio1.Paciente;

public class PrincipalJson2 {
	public static void main(String[] args) {
		Paciente p = new Paciente("79032491Y","Ivan Alarcón Herrera",633815885,"05/05/2025","Radio");
		Paciente p1 = new Paciente("81283291Y","Jose Alarcón Herrera",633815885,"05/05/2025","Radio");
		Paciente p2 = new Paciente("9112491Y","Fran Alarcón Herrera",633815885,"05/05/2025","Radio");
		
		List<Paciente> pacientes = new ArrayList<>();
		pacientes.add(p);
		pacientes.add(p1);
		pacientes.add(p2);
		
		Usuarios u = new Usuarios(pacientes);
		
		Gson g = new Gson();
		
		String fichero = g.toJson(u);
		
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("Usuarios.json"));
			bw.write(fichero);
			System.out.println("Lista escrita");
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
