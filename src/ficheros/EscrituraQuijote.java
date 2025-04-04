package ficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EscrituraQuijote {

	public static void main(String[] args) {
		String frase1="En un lugar de la mancha,";
		String frase2="de cuyo nombre no quiero acordarme.";
		List<String> frases=new ArrayList<String>();
		frases.add(frase1);
		frases.add(frase2);
		frases.add("fin del capitulo");
		int numeroPagina=1;
		BufferedWriter bw=null;
		try {
			 bw= new BufferedWriter(new FileWriter("FicheroQuijoteListado.txt"));
			Iterator<String> it=frases.iterator();
			while(it.hasNext()) {
				String l=it.next();
				bw.write(l);
				bw.newLine();
			}
			bw.write(String.valueOf(numeroPagina));
					
			 System.out.println("Finalizado escritura");
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

	}

}
