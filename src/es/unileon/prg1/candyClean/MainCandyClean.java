package es.unileon.prg1.candyClean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Clase principal del programa.
 * @author ejuarr00
 * @author jmachr00
 */
public class MainCandyClean {
	
	private static final Logger logger = LogManager.getLogger(Interfaz.class);

	/**
	 * Metodo principal en el que se realizan las llamadas
	 * @param args
	 * @throws candyCleanExceptions
	 */
	public static void main(String[] args) throws candyCleanExceptions{
		//esto es por argumentos 
		if (args.length > 2) {
			System.out.println("Error el numero de argumentos no puede ser mayor a 2");
			logger.info("Error el numero de argumentos no puede ser mayor a 2");
			throw new candyCleanExceptions("Error el numero de argumentos no puede ser mayor a 2");

		}else if (args.length < 2) {
			System.out.println("Error el numero de argumentos no puede ser menor a 2");
			logger.info("Error el numero de argumentos no puede ser menor a 2");
			throw new candyCleanExceptions("Error el numero de argumentos no puede ser menor a 2");
		}

		//args[0] = Teclado.leerInteger()+"";
		//args[1] = Teclado.leerInteger()+"";
		try {
			int dimension= Integer.parseInt(args[0]);
			int colores=Integer.parseInt(args[1]);
			CandyClean juego = new CandyClean(dimension,colores);
			Interfaz iu = new Interfaz(juego);
			iu.iniciarJuego();
		} catch (NumberFormatException e) {
			logger.info("ERROR LOS ARGUMENTOS SON INVALIDOS; NO SON NÚMEROS.");
			throw new candyCleanExceptions("ERROR LOS ARGUMENTOS SON INVALIDOS; NO SON NÚMEROS.");
		}
	}

}

