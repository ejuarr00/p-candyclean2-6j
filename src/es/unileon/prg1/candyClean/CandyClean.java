package es.unileon.prg1.candyClean;

import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.LogManager;

/**
 * Clase encargada de controlar la mecánica del juego.
 * @author dquina00
 * @author ejuarr00
 * @author jmachr00
 * @author jmartc08
 */

public class CandyClean  {

	private static final Logger logger = LogManager.getLogger(CandyClean.class);
	private Tablero tablero;
	
	private final int TAMANYOMIN= 5;
	private final int MINCOLORES= 3;
	private final int MAXCOLORES= 7;

	/**
	 * Metodo que compruba los valores pasados por los usuarios y crea el tablero de dicha dimension y colores
	 * @param dimension
	 * @param colores
	 * @throws candyCleanExceptions
	 */
	public CandyClean(int dimension, int colores) throws candyCleanExceptions {
		//StringBuffer msg = new StringBuffer();

		if(comprobarDim(dimension) == false) {
			logger.info("Error, dimension del tablero incorrecto: " + dimension+ "Debe ser mayor que 5. \n");
			throw new candyCleanExceptions/*msg.append*/("Error, dimension del tablero incorrecto: " + dimension+ "Debe ser mayor que 5. \n");
		}
		if(comprobarColor(colores) == false) {
			logger.info("Error, numero de colores incorrecto: " + dimension+ "Debe ser mayor que 3 y menor que 7. \n");
			throw new candyCleanExceptions/*msg.append*/("Error, numero de colores incorrecto: " + dimension+ "Debe ser mayor que 3 y menor que 7. \n");
		}
		/*if(msg.length()!=0){
			throw new candyCleanExceptions(msg.toString());
		}*/else{
			tablero = new Tablero(dimension, colores);
			logger.info("Tablero de Juego Generado." );
		}
	}
	
	public CandyClean() throws candyCleanExceptions {
		tablero = new Tablero();
		tablero.convertirTableroVacio();
	}

	/**
	 * metodo que compruba la combinacion correcta(solo llamada)
	 * @param fila
	 * @param c
	 * @param puntos 
	 * @throws candyCleanExceptions
	 */
	public void combinacion(int fila, int c) throws candyCleanExceptions {

		tablero.comprobarCombinacion(fila, c);		
	}

	/**
	 * Metodo booleano para ver si he ganado
	 * @return booleana
	 */
	public boolean hasGanado() {
		if(tablero.comprobarTableroVacio()==true) {
			return true;
		}
		return false;
	}

	/**
	 * metodo que comprueba la dimension sea mayor que 5
	 * @param dimension 
	 * @return boolena
	 */
	public boolean comprobarDim(int dimension) {
		if(dimension<TAMANYOMIN) {
			return false;
		}
		return true;
	}

	/**
	 * Metodo que comprueba que se cogen entre 3 y 7 colores
	 * @param colores 
	 * @return booleana
	 */
	public boolean comprobarColor(int colores) throws candyCleanExceptions {
		if(colores<MINCOLORES || colores>MAXCOLORES) {
			return false;
		}
		return true;
	}

	/**
	 *toString 
	 */
	public String toString() {
		return this.tablero.toString();
	}
} 
