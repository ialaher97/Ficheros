package Ejercicio3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Ejercicio1.Paciente;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;


public class PrincipalXML2 {

	public static void main(String[] args) {
		Paciente p = new Paciente("79032491Y","Ivan Alarcón Herrera",633815885,"05/05/2025","Radio");
		Paciente p1 = new Paciente("81283291Y","Jose Alarcón Herrera",633815885,"05/05/2025","Radio");
		Paciente p2 = new Paciente("9112491Y","Fran Alarcón Herrera",633815885,"05/05/2025","Radio");
		
		List<Paciente> pacientes = new ArrayList<>();
		pacientes.add(p);
		pacientes.add(p1);
		pacientes.add(p2);
		Usuarios u = new Usuarios(pacientes);
	
		try {
			JAXBContext contexto = JAXBContext.newInstance(Usuarios.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
			m.marshal(u, new FileWriter("Usuarios.xml"));
			
			Unmarshaller um = contexto.createUnmarshaller();
			Usuarios u1 = (Usuarios) um.unmarshal(new File("Usuarios.xml"));
			System.out.println(u1);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
