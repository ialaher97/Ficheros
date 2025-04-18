package Ejercicio3;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PrincipalXML {
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
		try {
		//Escribir
			
		JAXBContext contexto = JAXBContext .newInstance (Gym.class);
		Marshaller m = contexto. createMarshaller();
		m.setProperty (Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE) ;
		m.marshal (g1, new FileWriter("Gym.xml"));
		System.out.println("Fichero escrito");
		
		//Leer
		Unmarshaller um = contexto.createUnmarshaller();
		Gym g2 = (Gym) um.unmarshal(new File("Gym.xml"));
		System.out.println(g2);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
