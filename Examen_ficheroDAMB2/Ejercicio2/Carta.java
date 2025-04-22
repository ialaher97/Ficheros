package Ejercicio2;

public class Carta {
	private int num;
	private String palo;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPalo() {
		return palo;
	}
	public void setPalo(String palo) {
		this.palo = palo;
	}
	public Carta(int num, String palo) {
		super();
		this.num = num;
		this.palo = palo;
	}
	public Carta() {
		super();
	}
	@Override
	public String toString() {
		return "Carta [num=" + num + ", palo=" + palo + "]";
	}
	
	

}
