package FicherosXML_GSON;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class PrincipalAcademico {

	public static void main(String[] args) {
		try {
			JAXBContext contexto = JAXBContext.newInstance (Academico.class) ;
			Academico a= new Academico("Juan", 1990);
			//Escribe fichero XML
			Marshaller m = contexto.createMarshaller ();
			m.setProperty (Marshaller. JAXB_FORMATTED_OUTPUT, Boolean. TRUE);
			m.marshal (a, new FileWriter("Academico.xml"));
			System.out.println("Fichero escrito");
			//Lee fichero XML
			Unmarshaller um = contexto.createUnmarshaller () ;
			Academico s = (Academico) um.unmarshal (new File("Academico.xml"));
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
