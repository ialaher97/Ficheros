package FicherosXML_GSON;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.List;

import com.sun.tools.jconsole.JConsoleContext;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class PrincipalClubAcademico {

	

	public static void main(String[] args) {
		try {
			JAXBContext contexto = JAXBContext.newInstance(ClubAcademicos.class);
			Academico a = new Academico("Juan", 1990);
			Academico a2 = new Academico("María", 2020);
			List<Academico> lista= new ArrayList<Academico>();
			lista.add(a);
			lista.add(a2);
			ClubAcademicos ca=new ClubAcademicos(lista, "club ajedrez", 50);
			// Escribe fichero XML
			Marshaller m = ((JAXBContext) contexto).createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(ca, new FileWriter("ClubAcademicos.xml"));
			System.out.println("Fichero de club escrito");
			// Lee fichero XML
			Unmarshaller um = ((JAXBContext) contexto).createUnmarshaller();
			ClubAcademicos s = (ClubAcademicos) um.unmarshal(new File("ClubAcademicos.xml"));
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
