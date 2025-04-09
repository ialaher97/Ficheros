package ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import com.google.gson.Gson;

public class PrincipalJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Gson g=new Gson();
		 Gson gson = new Gson();

	        // Leo el fichero
	        String fichero = "";

	        try (BufferedReader br = new BufferedReader(new FileReader("datos.json"))) {
	            String linea;
	            while ((linea = br.readLine()) != null) {
	                fichero += linea;
	            }
	            Properties properties = gson.fromJson(fichero, Properties.class);
	            // Muestro las propiedades
	            System.out.println(properties.get("nombre"));
	            System.out.println(properties.get("apellidos"));
	            System.out.println(properties.get("edad"));
	            //Crea un objeto de la clase persona con los datos del fichero
	          
	            Persona persona = gson.fromJson(fichero, Persona.class);

	            System.out.println(persona);
	           // persona.setNombre("Ana");
//
	            //EScribir en un fichero
	            // Creo una persona
	            Persona persona1 = new Persona("F", "U", 20);
//
	            // Obtengo el JSON de la persona
	            String json = gson.toJson(persona1);

	            // Muestro el resultado
	            System.out.println(json);

	            // Escribo el fichero
	            try (BufferedWriter bw = new BufferedWriter(new FileWriter("datos_persona.json"))) {
	                bw.write(json);
	                System.out.println("Fichero creado");
	            } catch (IOException ex) {
	                System.out.println(ex.getMessage());
	            }


	        } catch (FileNotFoundException ex) {
	            System.out.println(ex.getMessage());
	        } catch (IOException ex) {
	            System.out.println(ex.getMessage());
	        }


	}

}
