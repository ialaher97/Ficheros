import java.util.Objects;

public class Producto implements Comparable <Producto> {	
	private String codigoBarras;
	private String nombre;
	private double precio;
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Producto(String codigoBarras, String nombre, double precio) {
		super();
		this.codigoBarras = codigoBarras;
		this.nombre = nombre;
		this.precio = precio;
	}
	public Producto() {
		super();
	}
	@Override
	public String toString() {
		return "Producto [codigoBarras=" + codigoBarras + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	@Override
	public int compareTo(Producto o) {
		return this.codigoBarras.compareTo(o.codigoBarras);
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigoBarras);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(codigoBarras, other.codigoBarras);
	}
	
	
	
	
	

}
