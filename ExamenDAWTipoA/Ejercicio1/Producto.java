package Ejercicio1;

public class Producto implements Comparable <Producto> {
	private String codigoBarra;
	private String nombre;
	private double precio;
	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
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
	public Producto(String codigoBarra, String nombre, double precio) {
		super();
		this.codigoBarra = codigoBarra;
		this.nombre = nombre;
		this.precio = precio;
	}
	public Producto() {
		super();
	}
	@Override
	public String toString() {
		return "Producto [codigoBarra=" + codigoBarra + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	@Override
	public int compareTo(Producto o) {
		return this.codigoBarra.compareTo(o.getCodigoBarra());
	}
	
	
}
