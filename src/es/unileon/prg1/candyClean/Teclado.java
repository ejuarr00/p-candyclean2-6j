package es.unileon.prg1.candyClean;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Clase para manejar las entradas por teclado
 * @author ejuarr00
 * @author jmachr00
 */
public class Teclado{

	private static String input;

	/**
	 * Lee una linea por consola y la convierte en interger
	 *
	 *
	 * @return  Integer Un numero con el comando.
	 */
	public static int leerInteger() {

		int value= Integer.MIN_VALUE;
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			input = br.readLine();
		}
		catch(Exception e){
			e.printStackTrace();

		} 

		try {
			value = Integer.parseInt(input) ;
		}
		catch (NumberFormatException e) { 
			value=Integer.MIN_VALUE;
		}
		return value;
	}

}
