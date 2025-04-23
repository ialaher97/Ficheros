package Ejercicio3;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
@XmlRootElement(name="Tienda")
@XmlType(propOrder = {"clientes"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Tienda {
	@XmlElementWrapper(name="ListaClientes")
	@XmlElement(name="Cliente")
	private List<Cliente> clientes;

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Tienda(List<Cliente> clientes) {
		super();
		this.clientes = clientes;
	}

	public Tienda() {
		super();
	}

	@Override
	public String toString() {
		return "Tienda [clientes=" + clientes + "]";
	}
	
	

}
