package ficheros;

import jakarta.xml.bind.annotation.*;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement (name="socio") //el elemento raíz se llamará 'socio'
@XmlType(propOrder = {"nombreSocio","direccion","fechaAlta"})
@XmlAccessorType (XmlAccessType.FIELD)

public class Socio {
	@XmlAttribute (name = "id", required = true)
	private Integer identificacion;
	@XmlElement (name = "nombre")
	private String nombreSocio;
	private String direccion;
	@XmlElement (name = "alta")
	private String fechaAlta;
	public Socio(Integer identificacion, String nombreSocio, String direccion, String fechaalta) {
		super();
		this.identificacion = identificacion;
		this.nombreSocio = nombreSocio;
		this.direccion = direccion;
		this.fechaAlta = fechaalta;
	}
	public Socio() {
		super();
	}
	public Integer getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(Integer identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombreSocio() {
		return nombreSocio;
	}
	public void setNombreSocio(String nombreSocio) {
		this.nombreSocio = nombreSocio;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getFechaalta() {
		return fechaAlta;
	}
	public void setFechaalta(String fechaalta) {
		this.fechaAlta = fechaalta;
	}
	@Override
	public String toString() {
		return "Socio [identificacion=" + identificacion + ", nombreSocio=" + nombreSocio + ", direccion=" + direccion
				+ ", fechaalta=" + fechaAlta + "]";
	}

	/*el constructor por defecto es obligatorio, aunque nosotros añadirenos otro
	que nos resultará útil: */
	
	/*resto de la implementación, incluyendo los getter, los setter y toString()
	para ver los resultados*/
	}

