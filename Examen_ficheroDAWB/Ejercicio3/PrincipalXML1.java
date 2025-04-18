package Ejercicio3;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class PrincipalXML1 {
	public static void main(String[] agrs) {
		List<Palabra> palabras = new ArrayList<>();
		palabras.add(new Palabra("hola","despedida"));
		palabras.add(new Palabra("Roberto","nombre"));
		Diccionario d = new Diccionario(palabras);
		
		try {
			
			JAXBContext contexto = JAXBContext .newInstance (Diccionario.class);
			Marshaller m = contexto. createMarshaller();
			m.setProperty (Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE) ;
			m.marshal (d, new FileWriter("Diccionario.xml"));
			System.out.println("Fichero escrito");
		
			Unmarshaller um = contexto. createUnmarshaller();
			Diccionario d1 = (Diccionario) um.unmarshal(new File("Diccionario.xml"));
			System.out.println(d1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
