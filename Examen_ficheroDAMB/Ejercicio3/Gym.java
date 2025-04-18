package Ejercicio3;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement (name ="Gym")
@XmlType(propOrder = {"nombre","usuarios"})
@XmlAccessorType (XmlAccessType . FIELD)
public class Gym {
	@XmlElement (name = "nombre")
	private String nombre;
	@XmlElementWrapper(name = "listaUsuarios")
	@XmlElement (name = "usuario")
	private List<Usuario> usuarios;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public Gym(String nombre, List<Usuario> usuarios) {
		super();
		this.nombre = nombre;
		this.usuarios = usuarios;
	}
	public Gym() {
		super();
	}
	@Override
	public String toString() {
		return "Gym [nombre=" + nombre + ", usuarios=" + usuarios + "]";
	}
	

}
