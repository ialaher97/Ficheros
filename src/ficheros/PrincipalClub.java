package ficheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class PrincipalClub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			JAXBContext contexto = JAXBContext .newInstance (Club.class);
			Unmarshaller um = contexto.createUnmarshaller () ;
			Club c = (Club) um.unmarshal (new File("club.xml"));
			System.out .println(c) ;
			//AGrupar
			Club c1 = new Club("Nautico", "1234");
					Socio s1 = new Socio(1, "Juan Vela", "C/Galera 4", "03/02/2001");
					Socio s2 = new Socio(2, "Amanda Lagos", "C/Siroco 21", "14/07/2002");
					c1.nuevoSocio(s1) ;
					c1.nuevoSocio(s2) ;
					Marshaller m = contexto. createMarshaller();

					m.setProperty (Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE) ;
					m.marshal (c1, new FileWriter("club3.xml"));


		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
