package ficheros;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.*;

public class PrincipalSocio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			JAXBContext contexto = JAXBContext.newInstance (Socio.class) ;
			Unmarshaller um = contexto.createUnmarshaller () ;
			Socio s = (Socio) um.unmarshal (new File("socio.xml"));
			Marshaller m = contexto.createMarshaller ();
			Socio sl = new Socio(1, "Armando Fuentes", "C/Fontanería 1", "01/09/1990");
			m.setProperty(Marshaller. JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(sl, new FileWriter("socioNuevo.xml"));

			System.out.println(s);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
