package Ejercicio2;

public class Coche implements Comparable <Coche> {
	String modelo;
	String matricula;
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Coche(String modelo, String matricula) {
		super();
		this.modelo = modelo;
		this.matricula = matricula;
	}
	public Coche() {
		super();
	}
	@Override
	public String toString() {
		return "Coche [modelo=" + modelo + ", matricula=" + matricula + "]";
	}
	@Override
	public int compareTo(Coche o) {
		
		return this.matricula.compareTo(o.matricula);
	}
	
	

}
