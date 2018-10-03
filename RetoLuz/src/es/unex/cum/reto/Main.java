package es.unex.cum.reto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	//Lista que contendrá las instancias de los contadores.
	private ArrayList <Contador> listaContadores = new ArrayList<Contador>(); 

	/**
	 * Main del programa.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in); //Objeto scanner para introducir datos
		int ncontadores = 0;
		Boolean correcto = false;
		Main M = new Main();
		/*
		 * En primer lugar, se introducen el número de contadores.
		 * Además, se controla que únicamente se pueda introducir un número entero.
		 */
		do {
			try {
				ncontadores = sc.nextInt();
				correcto = true;
			}catch (InputMismatchException ex) {
				System.out.println("Error");
				ncontadores = 0;
				sc = new Scanner(System.in); //Se reinicia el escaner porque peta
			}
		}while (correcto == false);

		M.leerContadores(ncontadores);
		M.recorrerLista();
		sc.close();
	}
	/**
	 * Método que lee los valores extraidos de los contadores y comprueba que sean correctos.
	 * @param ncontadores
	 */
	public void leerContadores(int ncontadores) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < ncontadores; i++) {
			String cadena = sc.nextLine();
			StringTokenizer cadenaTokens = new StringTokenizer(cadena);
			/* Comprobación de que únicamente se introduzcan dos números */
			if (cadenaTokens.countTokens() != 2) {
				System.out.println("Error. Debes introducir dos números");
				i--;
			}
			else {

				String n1 = cadenaTokens.nextToken();
				String n2 = cadenaTokens.nextToken();
				if (!comprobarNumeros(n1, n2)) {
					i--;
				}
				else {
				}
			}

		}
		sc.close();
	}
	/**
	 * Clase que comprueba que los números introducidos son números y que el segundo 
	 * valor sea mayor al primero.
	 * @param n1
	 * @param n2
	 * @return
	 */
	public Boolean comprobarNumeros(String n1, String n2) {
		int num1 = 0;
		int num2 = 0;
		/* Se comprueba que el número introducido sea un entero */
		try {
			num1 = Integer.parseInt(n1);
			num2 = Integer.parseInt(n2);
		}catch(NumberFormatException ex) {
			return false;
		}
		/* Se comprueba que los valores se han introducido en el orden correcto */
		if (num2-num1 < 0) {
			return false;
		}
		
		Contador C = new Contador(num1, num2, 0, 0);
		listaContadores.add(C);
		return true;
	}
	
	public void recorrerLista() {
		Iterator <Contador> it = listaContadores.iterator();
		while (it.hasNext()) {
			Contador C = (Contador) it.next();
			//System.out.println(C.toString());
			
			//Calcular la cantidad de kw consumido
			int consumo = C.getValorFinal() - C.getValorInicial();
			C.setConsumido(consumo);
			
			//Calcular precio a pagar
			int precio = 1; //1 euro de gastos fijos
			
			if (consumo <= 100) precio = precio + (consumo * 2);
			else {
				precio = precio + 200;
				consumo -= 100;
				
				if (consumo <= 150) precio = precio + (consumo * 3);
				else {
					precio = precio + (150 * 3);
					consumo -= 150;
					precio = precio + (consumo * 4);
				}
			}
			C.setPrecio(precio);
			System.out.println(C.getConsumido() + " " + C.getPrecio());
		}
	}
}
