package FicherosXML_GSON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class PrincipalJSonClubAcademicos {

	public static void main(String[] args) {
		Academico a = new Academico("Juan", 1990);
		Academico a2 = new Academico("María", 2020);
		List<Academico> lista= new ArrayList<Academico>();
		lista.add(a);
		lista.add(a2);
		ClubAcademicos ca=new ClubAcademicos(lista, "club ajedrez", 50);
		Gson g=new Gson();
		String fichero=g.toJson(ca);
		BufferedWriter bw=null;
		//Escribir JSON
		try {
			bw=new BufferedWriter(new FileWriter("clubAcademicos.json"));
			bw.write(fichero);
			System.out.println("Fichero escrito");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(bw!=null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//Leer JSON
		BufferedReader br=null;
		
		try {
			br=new BufferedReader(new FileReader("clubAcademicos.json"));
			String linea;
			linea = br.readLine();
			String salida="";
			while (linea!=null) {
				salida+=linea;
				linea=br.readLine();
			}
			ClubAcademicos club = g.fromJson(salida, ClubAcademicos.class);
			System.out.println(club);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(br!=null) {
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
