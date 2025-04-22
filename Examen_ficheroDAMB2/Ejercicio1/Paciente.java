package Ejercicio1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name="Paciente")
@XmlType(propOrder = {"dni","nombreCompleto","telefono","fechaDeCita","tratamiento"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Paciente implements Comparable <Paciente>{
	@XmlAttribute(name="DNI")
	private String dni;
	@XmlAttribute(name="nombreCompleto")
	private String nombreCompleto;
	@XmlAttribute(name="telefono")
	private int telefono;
	@XmlAttribute(name="fechaDeCita")
	private String fechaDeCita;
	@XmlAttribute(name="tratamiento")
	private String tratamiento;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getFechaDeCita() {
		return fechaDeCita;
	}
	public void setFechaDeCita(String fechaDeCita) {
		this.fechaDeCita = fechaDeCita;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public Paciente(String dni, String nombreCompleto, int telefono, String fechaDeCita, String tratamiento) {
		super();
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
		this.fechaDeCita = fechaDeCita;
		this.tratamiento = tratamiento;
	}
	public Paciente() {
		super();
	}
	@Override
	public String toString() {
		return "Paciente [dni=" + dni + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono
				+ ", fechaDeCita=" + fechaDeCita + ", tratamiento=" + tratamiento + "]";
	}
	@Override
	public int compareTo(Paciente o) {
		return this.getDni().compareTo(o.getDni());
	}


	
}
