package Ejercicio3;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement (name="usuario")
@XmlType(propOrder = {"nombre","idUsuario"})
@XmlAccessorType (XmlAccessType . FIELD)
public class Usuario {
	@XmlElement (name = "nombre")
	private String nombre;
	@XmlElement (name = "ID")
	private String idUsuario;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Usuario(String nombre, String idUsuario) {
		super();
		this.nombre = nombre;
		this.idUsuario = idUsuario;
	}
	public Usuario() {
		super();
	}
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", idUsuario=" + idUsuario + "]";
	}
	
	
}
