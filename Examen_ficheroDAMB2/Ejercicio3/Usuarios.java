package Ejercicio3;

import java.util.ArrayList;
import java.util.List;

import Ejercicio1.Paciente;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
@XmlRootElement(name="Usuario")
@XmlType(propOrder = { "pacientes" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuarios {
	@XmlElementWrapper(name = "ListaPacientes")
	@XmlElement(name="Paciente")
	List<Paciente> pacientes = new ArrayList<>();

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Usuarios(List<Paciente> pacientes) {
		super();
		this.pacientes = pacientes;
	}

	public Usuarios() {
		super();
	}

	@Override
	public String toString() {
		return "Usuarios [pacientes=" + pacientes + "]";
	}
	
	
}
