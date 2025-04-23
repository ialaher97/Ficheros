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

public class PrincipalClienteXML {
	public static void main(String[] args) {

		List<Cliente> clientes = new ArrayList<>();

		Cliente c = new Cliente("Ivan", "Alarcón", 27);
		Cliente c1 = new Cliente("Jose", "Fernandez", 35);
		Cliente c2 = new Cliente("Pedro", "Ruiz", 18);

		clientes.add(c);
		clientes.add(c1);
		clientes.add(c2);

		Tienda t = new Tienda(clientes);
		
		try {
			JAXBContext contexto = JAXBContext.newInstance(Tienda.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(t,new FileWriter("Clientes.xml"));
			
			Unmarshaller um = contexto.createUnmarshaller();
			Tienda t1 =  (Tienda) um.unmarshal(new File("Clientes.xml"));
			System.out.println(t1);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
