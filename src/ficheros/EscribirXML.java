package ficheros;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JAXBContext contexto = null;
		try {
			contexto = JAXBContext.newInstance(Socio.class);
			Marshaller m = contexto.createMarshaller();
			Socio s1 = new Socio(1, "Armando Fuentes", "C/Fontanería 1", "01/09/1990");
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(s1, new FileWriter("sociol.xml"));
			System.out.println("Terminado correctamente");
		} catch (JAXBException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
