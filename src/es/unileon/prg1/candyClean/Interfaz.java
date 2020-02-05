package es.unileon.prg1.candyClean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Clase que controla la consola
 * @author dquina00
 * @author ejuarr00
 * @author jmachr00
 * @author jmartc08
 */
public class Interfaz {

	private static final Logger logger = LogManager.getLogger(Interfaz.class);


	private CandyClean candyclean;

	public Interfaz(CandyClean juego) {
		this.candyclean = juego;
	}

	/**
	 * Metodo que lee por teclado con su llamada a la clase teclado, tambien imprime por terminal 
	 * @throws candyCleanExceptions
	 */
	public void iniciarJuego() throws candyCleanExceptions {
		int row , column;
		boolean perder = false;
		logger.info("Iniciando juego");
		do {
			try {
				System.out.println(this.candyclean.toString());
				System.out.println("Row:");
				row = Teclado.leerInteger();
				System.out.println("Column:");
				column = Teclado.leerInteger();
				logger.info("La fila introducida por el usuario es: "+row+" y la columna: "+column );
				
				if(row != Integer.MIN_VALUE && column != Integer.MIN_VALUE) {
					candyclean.combinacion(row, column);
				}
			}catch (candyCleanExceptions e) {
				logger.info("EL JUGADOR HA PERDIDO!\n");
				logger.info("EL JUEGO HA TERMINADO. \n" );
				System.out.println("YOU LOSE!");
				perder = true;
			}

		}while(candyclean.hasGanado()!=true &&  perder != true);

		if(perder == false) {
			System.out.println("YOU WON!");
			logger.info("EL JUGADOR HA GANADO! \n" );
			logger.info("EL JUEGO HA TERMINADO. \n" );
		}
	}
}
