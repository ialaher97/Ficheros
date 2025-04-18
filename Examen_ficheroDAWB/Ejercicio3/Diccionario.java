package Ejercicio3;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Diccionario")
@XmlType(propOrder = { "palabras" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Diccionario {
	@XmlElementWrapper(name = "ListaPalabras")
	@XmlElement(name = "Palabra")
	List<Palabra> palabras = new ArrayList<>();

	public List<Palabra> getPalabras() {
		return palabras;
	}

	public void setPalabras(List<Palabra> palabras) {
		this.palabras = palabras;
	}

	public Diccionario(List<Palabra> palabras) {
		super();
		this.palabras = palabras;

	}

	public Diccionario() {
		super();
	}

	@Override
	public String toString() {
		return "Diccionario [palabras=" + palabras + "]";
	}

}
