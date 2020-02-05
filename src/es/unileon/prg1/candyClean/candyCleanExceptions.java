package es.unileon.prg1.candyClean;

/**
 * Clase donde se generan los mensajes de las excepciones
 * @author dquina00
 * @author ejuarr00
 * @author jmachr00
 * @author jmartc08
 */
public class candyCleanExceptions extends Exception {

	private static final long serialVersionUID = 6915090179170412071L;

	/**
	 * Metodo para la creacion de los mensajes del logger
	 * @param msg
	 */
	public candyCleanExceptions(String msg){
		super(msg);
	}
}
