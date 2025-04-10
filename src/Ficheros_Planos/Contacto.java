package Ficheros_Planos;

public class Contacto implements Comparable <Contacto>{
	private String nombre;
	private int num;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Contacto(String nombre, int num) {
		super();
		this.nombre = nombre;
		this.num = num;
	}
	public Contacto() {
		super();
	}
	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", num=" + num + "]";
	}
	@Override
	public int compareTo(Contacto o) {
		return this.getNombre().compareTo(o.getNombre());
	}

	
}
