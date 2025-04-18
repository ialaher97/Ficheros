package Ejercicio1;

public class Usuario implements Comparable<Usuario>{
	private String dni;
	private String nombreCompleto;
	private String fechaNacimiento;
	private double Cuota;
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
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public double getCuota() {
		return Cuota;
	}
	public void setCuota(double cuota) {
		Cuota = cuota;
	}
	public Usuario(String dni, String nombreCompleto, String fechaNacimiento, double cuota) {
		super();
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.fechaNacimiento = fechaNacimiento;
		Cuota = cuota;
	}
	public Usuario() {
		super();
	}
	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", nombreCompleto=" + nombreCompleto + ", fechaNacimiento=" + fechaNacimiento
				+ ", Cuota=" + Cuota + "]";
	}
	@Override
	public int compareTo(Usuario o) {
		return this.dni.compareTo(o.getDni());
	}
	
	

}
