package Ejercicio1;

public class Paciente implements Comparable <Paciente>{
	private String dni;
	private String nombreCompleto;
	private int telefono;
	private String fechaDeCita;
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
