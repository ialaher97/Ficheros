package ficheros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement (name = "club")
@XmlType (propOrder = {"nombreClub", "listaSocios"})
@XmlAccessorType (XmlAccessType.FIELD)

public class Club {

@XmlElement (name = "nombre")
private String nombreClub;

@XmlElementWrapper (name = "socios") 
@XmlElement (name = "socio") 
private List<Socio> listaSocios; 
@XmlTransient 
private String nif; 
public Club() {
}
public Club(String nombreClub, String nif) {
this.nombreClub = nombreClub;
this.listaSocios = new ArrayList<Socio>();
this.nif = nif;
}
public void nuevoSocio(Socio nuevo) {
listaSocios.add(nuevo);

}
public String getNombreClub() {
	return nombreClub;
}
public void setNombreClub(String nombreClub) {
	this.nombreClub = nombreClub;
}

public String getNif() {
	return nif;
}
public void setNif(String nif) {
	this.nif = nif;
}
//@Override
//public String toString() {
//	return "Club [nombreClub=" + nombreClub + ", listaSocios=" + Arrays.toString(listaSocios) + ", nif=" + nif + "]";
//}
public List<Socio> getListaSocios() {
	return listaSocios;
}
public void setListaSocios(List<Socio> listaSocios) {
	this.listaSocios = listaSocios;
}
@Override
public String toString() {
	return "Club [nombreClub=" + nombreClub + ", listaSocios=" + listaSocios + ", nif=" + nif + "]";
}

//..resto de la implementación con getters, setters, etc
}
