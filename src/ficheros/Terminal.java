package ficheros;

public class Terminal {

	private String numero;
	private int tiempoConversacion = 0;
	
	public Terminal(String numero) {
		this.numero = numero;
	}
	
	public void llama(Terminal t, int tiempo) {
		this.tiempoConversacion += tiempo;
		t.tiempoConversacion += tiempo;
	}
	
	public String toString() {
		return "Nº " + numero + " - " + tiempoConversacion + "s de conversacion";
	}
	
	
	
}
