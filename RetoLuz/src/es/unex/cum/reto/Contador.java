package es.unex.cum.reto;
/**
 * Clase que guardará los valores iniciales y finales de los distintos contadores.
 * @author Marco Antonio Bocho Morán
 * @author Eva Chacón Collado
 */
public class Contador {
	private int valorInicial;
	private int valorFinal;
	private int consumido;
	private int precio;
	
	/**
	 * Constructor por defecto de la clase
	 */
	public Contador() {
		valorInicial = 0;
		valorFinal = 0;
		consumido = 0;
		precio = 0;
	}
	/**
	 * Constructor parametrizado de la clase. Recibe ambos atributos.
	 * @param valorInicial
	 * @param valorFinal
	 * @param consumido
	 * @param precio
	 */
	public Contador(int valorInicial, int valorFinal, int consumido, int precio) {
		super();
		this.valorInicial = valorInicial;
		this.valorFinal = valorFinal;
		this.consumido = consumido;
		this.precio = precio;
	}
	/**
	 * Método get que devuelve el valor inicial.
	 * @return
	 */
	public int getValorInicial() {
		return valorInicial;
	}
	/**
	 * Método set para modificar el valor inicial.
	 * @param valorInicial
	 */
	public void setValorInicial(int valorInicial) {
		this.valorInicial = valorInicial;
	}
	/**
	 * Método get que devuelve el valor final
	 * @return 
	 */
	public int getValorFinal() {
		return valorFinal;
	}
	/**
	 * Método set para modificar el valor final
	 * @param valorFinal
	 */
	public void setValorFinal(int valorFinal) {
		this.valorFinal = valorFinal;
	}
	

	public int getConsumido() {
		return consumido;
	}
	public void setConsumido(int consumido) {
		this.consumido = consumido;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	/**
	 * Método toString que devuelve una cadena con información del objeto.
	 * @return
	 */
	public String toString() {
		return "Contador [valorInicial=" + valorInicial + ", valorFinal=" + valorFinal + "]";
	}
	
	
	
}
