package Ejercicio3;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name="Palabra")
@XmlType(propOrder= {"significado","sinonimos"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Palabra {
	@XmlElement(name="Significado")
	String significado;
	@XmlElement(name="Sinonimos")
	String sinonimos;
	public String getSignificado() {
		return significado;
	}
	public void setSignificado(String significado) {
		this.significado = significado;
	}
	public String getSinonimos() {
		return sinonimos;
	}
	public void setSinonimos(String sinonimos) {
		this.sinonimos = sinonimos;
	}
	public Palabra(String significado, String sinonimos) {
		super();
		this.significado = significado;
		this.sinonimos = sinonimos;
	}
	public Palabra() {
		super();
	}
	@Override
	public String toString() {
		return "Palabra [significado=" + significado + ", sinonimos=" + sinonimos + "]";
	}

	
}
