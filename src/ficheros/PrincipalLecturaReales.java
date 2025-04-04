package ficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class PrincipalLecturaReales {

	public static void main(String[] args) {
		BufferedReader br = null;
		int suma = 0;
		float media = 0f;
		try {
			br = new BufferedReader(new FileReader("NumerosReales.txt"));
			String linea = br.readLine();
			while (linea != null) {
				String[] numeros = linea.split(" ");
				for (int i = 0; i < numeros.length; i++) {
					suma = suma + Integer.valueOf(numeros[i]);
				}
				media =Float.valueOf(suma) /numeros.length;
				System.out.println("La suma es:" + suma);
				System.out.println("La media es:" + media);
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

	}

}
