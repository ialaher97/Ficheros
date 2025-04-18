package Ejercicio1;

public class Partido implements Comparable<Partido> {
	private String nombreEquipo;
	private String id;
	private int golesMarcados;
	private int golesRecibidos;
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGolesMarcados() {
		return golesMarcados;
	}
	public void setGolesMarcados(int golesMarcados) {
		this.golesMarcados = golesMarcados;
	}
	public int getGolesRecibidos() {
		return golesRecibidos;
	}
	public void setGolesRecibidos(int golesRecibidos) {
		this.golesRecibidos = golesRecibidos;
	}
	public Partido(String nombreEquipo, String id, int golesMarcados, int golesRecibidos) {
		super();
		this.nombreEquipo = nombreEquipo;
		this.id = id;
		this.golesMarcados = golesMarcados;
		this.golesRecibidos = golesRecibidos;
	}
	public Partido() {
		super();
	}
	@Override
	public String toString() {
		return "Partido [nombreEquipo=" + nombreEquipo + ", id=" + id + ", golesMarcados=" + golesMarcados
				+ ", golesRecibidos=" + golesRecibidos + "]";
	}
	@Override
	public int compareTo(Partido o) {
		return this.id.compareTo(o.id);
	}
	
	

}
