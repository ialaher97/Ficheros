package ficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NumerosRealesPrincipal {

	public static void main(String[] args) {
		BufferedReader bf=null;
		try {
			 bf= new BufferedReader(new FileReader("NumerosReales.txt"));
			String texto=bf.readLine();
			String[] numString=texto.split(" ");
			double suma = 0;
			double media=0;
			for(int i=0;i<numString.length;i++) {
				suma=suma+ Double.valueOf(numString[i]);
			}
			media=suma/numString.length;
			System.out.println("Media:"+media);
			System.out.println("Suma:"+suma);
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				bf.close();
			} catch (IOException e) {
				System.out.println("No se ha podido cerrar el fichero");
			}
		}
		

	}

}
