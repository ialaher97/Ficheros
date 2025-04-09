package xmlyjson;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;


public class EjemploXML {
	 public static void main(String[] args) {
		 

			JAXBContext contexto;
			try {
				contexto = JAXBContext.newInstance (Socio.class);
				Unmarshaller um = contexto.createUnmarshaller () ;
				Socio s = (Socio) um.unmarshal (new File("socio.xml"));
				System.out.println(s);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		
		 
	 }
}
