package es.unileon.prg1.candyClean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Clase encargada de controlar la creación y las modificacione que se producen en el tablero.
 * @author dquina00
 * @author ejuarr00
 * @author jmachr00
 * @author jmartc08
 */
public class Tablero {

	private static final Logger logger = LogManager.getLogger(Interfaz.class);
	private Casilla [][] tablero;
	private int dimesion ;
	private int colores;
	public boolean ganar = false;
	public boolean perder = false;
	private int numeroMaxColor;
	private int puntos;

	/**
	 * Constructor de la clase Tablero
	 * @param dim
	 * @param color
	 */
	public Tablero(int dim, int color) {
		this.dimesion = dim;
		this.colores = color;
		this.tablero = new Casilla[dim][dim];
		this.numeroMaxColor =8;
		this.puntos = 0;

		//llamada para generar el vector 
		int [] vectorColores = generarColoresAleatorios(color);
		try {
			//llamada para generar el tablero
			generarTablero(vectorColores);
		}catch (candyCleanExceptions e){
			//??tratar excepcion???
		}
	}

	/**
	 * Constructor vacio para los test
	 */
	public Tablero() {
		this.tablero = new Casilla[5][5];
		this.dimesion = 5;
		this.colores = 3;
		this.numeroMaxColor =8;
		this.puntos = 0;
		try {
			//llamada para generar el tablero
			this.generarTableroDeterminista();
		}catch (candyCleanExceptions e){
			//??tratar excepcion???
		}
	}

	/**
	 * Metodo que genera un tablero determinista del vector para los test
	 * @throws candyCleanExceptions
	 */
	public void generarTableroDeterminista() throws candyCleanExceptions {
		int[] vectorColoresDeterminista= {1,1,1,1,1,4,4,1,1,1,4,4,4,4,4,2,2,4,4,4,4,4,2,2,2};
		int contador=0;
		for(int i=0; i< tablero.length; i++){
			for(int j=0; j< tablero.length; j++){
				Color c= new Color(vectorColoresDeterminista[contador]);
				tablero[i][j] = new Casilla (c);
				contador++;
			}
			System.out.print("\n");
		}
	}

	/**
	 * Metodo que genera un tablero determinista entero vacio (a negros) para los test
	 * @throws candyCleanExceptions
	 */
	public void convertirTableroVacio() throws candyCleanExceptions {
		Color negro = new Color(BackgroundColor.BLACK);
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j] = new Casilla(negro);
			}
		}
	}

	/**
	 * Metodo que genera un tablero Determnista imposible de solucionar para los test
	 * @throws candyCleanExceptions
	 */
	public void convertirTableroAleatorio() throws candyCleanExceptions {
		int contador = 0;
		int[] vectorColoresDeterminista= {1,4,1,2,1,2,1,2,1,4,4,2,1,4,2,1,4,2,1,4,2,1,4,2,1};
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				Color c= new Color(vectorColoresDeterminista[contador]);
				tablero[i][j] = new Casilla(c);
				contador++;
			}
		}
	}

	/**
	 * Metodo que genera los colores a usar, de tamanyo de los colores a usar por el usuario
	 * @param colores
	 * @return vectorColores
	 */
	public int[] generarColoresAleatorios(int color){
		int[] vectorColores = new int[colores];
		for(int i=0; i<colores; i++){
			int valorEntero = (int) Math.floor(Math.random()*(1-numeroMaxColor+1)+numeroMaxColor);
			vectorColores[i]= valorEntero;
		}
		return vectorColores; 
	}
	
	/**
	 * Metodo que genera el tablero con los colores en formato de numero
	 * @param valorColores
	 * @throws candyCleanExceptions 
	 */
	public void generarTablero(int[] vectorColores) throws candyCleanExceptions{

		for(int i=0; i< tablero.length; i++){
			for(int j=0; j< tablero.length; j++){
				int colorAleatorio =(int) Math.floor(Math.random()*(vectorColores.length)); 
				int escogido=vectorColores[colorAleatorio];
				Color c= new Color(escogido);
				tablero[i][j] = new Casilla (c);	
			}
			System.out.print("\n");
		}
	}

	//LO VA A PROGRAMAR SU MADRE
	/*public boolean comprobarMovimeintos() throws candyCleanExceptions{
	for (int i = 0; i < tablero.length; i++) {
		for (int j = 0; j < tablero.length; j++) {
			comprobarCombinacion(i, j) ;
		}
	}
	}*/

	////este es el metodo grande desglosado que tiene gran parte del funcionamiento
	/**
	 * Metodo que comprueba la combinacion introducida por los ususarios,
	 * y comprueba todas las excepciones de las tiradas.
	 * @param row
	 * @param colum
	 * @throws candyCleanExceptions
	 */
	public void comprobarCombinacion( int row, int colum) throws candyCleanExceptions{
		if(row<0 || row>dimesion-1 || colum<0 || colum>dimesion-1) {
			logger.info("Los datos debe estar en los rangos del tablero.");
			throw new candyCleanExceptions("LOS DATOS DEBEN ESTAR ENTRE LOS RANGOS DEL TABLERO");
		}
		logger.info("Fila introducida: "+ row + "\n Columna introducida: " + colum + "\n" );

		if (colum == row && colum == 0) {
			comprobarArribaIzquierda(row, colum);
		}else if (colum == row && colum == tablero.length-1) {
			comprobarAbajoDerecha(row, colum);
		}else if (colum == tablero.length-1 && row == 0){
			comprobarArribaDerecha(row, colum);
		}else if (row == tablero.length-1 && colum == 0){
			comprobarAbajoIzquierda(row, colum);
		}else if (row < tablero.length-1 ){
			comprobarFilaMenorTam(row, colum);
		}else if (colum < tablero.length-1) {
			comprobarColumnaMenorTam(row, colum);
		}
		comprobarColor(row, colum);
		logger.info("Comprobados colores adyacentes \n" );
		bajarFila();
	}

	/**
	 * metodo que comprueba la casilla Arriba a la izquierda ([0][0])
	 * @param row
	 * @param colum
	 * @throws candyCleanExceptions
	 */
	public void comprobarArribaIzquierda(int row , int colum) throws candyCleanExceptions {
		if (!tablero[row][colum].getColor().equals(tablero[row][colum+1].getColor()) && !tablero[row][colum].getColor().equals( tablero[row+1][colum].getColor())) {
			logger.info("Error, movimiento invalido");
			throw new candyCleanExceptions("Error, movimiento invalido");
		}
	}

	/**
	 * metodo que comprueba la casilla Arriba a la Derecha ([0][tablero.length-1])
	 * @param row
	 * @param colum
	 * @throws candyCleanExceptions
	 */
	public void comprobarArribaDerecha(int row, int colum) throws candyCleanExceptions {
		if (!tablero[row][colum].getColor().equals(tablero[row][colum-1].getColor()) && !tablero[row][colum].getColor().equals(tablero[row+1][colum].getColor())) {
			logger.info("Error, movimiento invalido");
			throw new candyCleanExceptions("Error, movimiento invalido");
		}
	}

	/**
	 * metodo que comprueba la casilla Abajo a la Izquierda ([tablero.length-1][0])
	 * @param row
	 * @param colum
	 * @throws candyCleanExceptions
	 */
	public void comprobarAbajoIzquierda(int row, int colum) throws candyCleanExceptions {
		if (!tablero[row][colum].getColor().equals(tablero[row][colum+1].getColor()) && !tablero[row][colum].getColor().equals(tablero[row-1][colum].getColor())) {
			logger.info("Error, movimiento invalido");
			throw new candyCleanExceptions("Error, movimiento invalido");
		}
	}

	/**
	 * metodo que comprueba la casilla Abajo a la Derecha ([tablero.length-1][tablero.length-1])
	 * @param row
	 * @param colum
	 * @throws candyCleanExceptions
	 */
	public void comprobarAbajoDerecha(int row, int colum) throws candyCleanExceptions{
		if (!tablero[row][colum].getColor().equals(tablero[row][colum-1].getColor()) && !tablero[row][colum].getColor().equals(tablero[row-1][colum].getColor())) {
			logger.info("Error, movimiento invalido");
			throw new candyCleanExceptions("Error, movimiento invalido");
		}
	}

	/**
	 * Metodo que comprueba la casilla cuando la fila es menor que tablero.length-1
	 * @param row
	 * @param colum
	 * @throws candyCleanExceptions
	 */
	public void comprobarFilaMenorTam(int row, int colum) throws candyCleanExceptions {
		if(colum == 0) {

			if (!tablero[row][colum].getColor().equals(tablero[row][colum+1].getColor()) && 
					!tablero[row][colum].getColor().equals(tablero[row-1][colum].getColor())&& 
					!tablero[row][colum].getColor().equals(tablero[row+1][colum].getColor())) 
			{
				logger.info("Error, movimiento invalido");
				throw new candyCleanExceptions("Error, movimiento invalido");	

			}

		}else if(colum == tablero.length-1) {
			if (!tablero[row][colum].getColor().equals(tablero[row][colum-1].getColor()) && 
					!tablero[row][colum].getColor().equals(tablero[row-1][colum].getColor())&& 
					!tablero[row][colum].getColor().equals(tablero[row+1][colum].getColor())) 
			{
				logger.info("Error, movimiento invalido");
				throw new candyCleanExceptions("Error, movimiento invalido");

			}
		}else {
			if (!tablero[row][colum].getColor().equals(tablero[row][colum+1].getColor()) && 
					!tablero[row][colum].getColor().equals(tablero[row][colum-1].getColor())&& 
					!tablero[row][colum].getColor().equals(tablero[row+1][colum].getColor()) && 
					!tablero[row][colum].getColor().equals(tablero[row-1][colum].getColor())) 
			{
				logger.info("Error, movimiento invalido");
				throw new candyCleanExceptions("Error, movimiento invalido");
			}
		}
	}


	/**
	 * Metodo que comprueba la casilla cuando la Columna es menor que tablero.length-1
	 * @param row
	 * @param colum
	 * @throws candyCleanExceptions
	 */
	public void comprobarColumnaMenorTam(int row, int colum) throws candyCleanExceptions {
		if(row == 0) {
			if (!tablero[row][colum].getColor().equals(tablero[row][colum+1].getColor()) && 
					!tablero[row][colum].getColor().equals(tablero[row][colum-1].getColor())&& 
					!tablero[row][colum].getColor().equals(tablero[row+1][colum].getColor())) 
			{
				logger.info("Error, movimiento invalido");
				throw new candyCleanExceptions("Error, movimiento invalido");	
			}

		}else if(row == tablero.length-1) {
			if (!tablero[row][colum].getColor().equals(tablero[row][colum+1].getColor()) && 
					!tablero[row][colum].getColor().equals(tablero[row][colum-1].getColor())&& 
					!tablero[row][colum].getColor().equals(tablero[row-1][colum].getColor())) 
			{
				logger.info("Error, movimiento invalido");
				throw new candyCleanExceptions("Error, movimiento invalido");

			}
			//			if (!tablero[row][colum].getColor().equals(tablero[row][colum-1].getColor()) && !tablero[row][colum].getColor().equals(tablero[row-1][colum].getColor())) {
			//				System.out.println("PORQUE ENTRAS AQUI");
			//				logger.info("Error, movimiento invalido");
			//				throw new candyCleanExceptions("Error, movimiento invalido");
			//			}
		}else {
			if (!tablero[row][colum].getColor().equals(tablero[row][colum+1].getColor()) && 
					!tablero[row][colum].getColor().equals(tablero[row][colum-1].getColor())&& 
					!tablero[row][colum].getColor().equals(tablero[row+1][colum].getColor()) && 
					!tablero[row][colum].getColor().equals(tablero[row-1][colum].getColor())) 
			{
				logger.info("Error, movimiento invalido");
				throw new candyCleanExceptions("Error, movimiento invalido");
			}
		}
	}

	/**
	 * Metodo que compruba los colores de la posicion selecionada y las siguients o anteriores y saca un mensaje de error
	 * @param row
	 * @param colum
	 * @throws candyCleanExceptions 
	 */
	public void comprobarColor(int row, int colum) throws candyCleanExceptions {
		Color negro = new Color(BackgroundColor.BLACK);
		//variable en la que guardo el contenido de la posicion actual del tablero
		Casilla colorAux = tablero[row][colum];
		//si la celda de este tablero es != a 0(negro) la pongo a negro
		if(!tablero[row][colum].getColor().equals(negro.getColor()) ) {
			convertirNegro(row, colum);
		}
		//recorro hacia delante para ver si las siguientes casillas son del mismo color
		if(colum < tablero.length-1) {
			if (colum == 0) {
				for (int i = colum; i < tablero.length-1; i++) {
					if (colorAux.getColor().equals(tablero[row][i+1].getColor())) {
						convertirNegro(row, i+1);
					}else {
						break;
					}
				}	
			}else {
				for (int i = colum; i >= 0; i--) {
					if(i==0) {
						if (colorAux.getColor().equals(tablero[row][i].getColor())) {
							convertirNegro(row, i);
						}
					}else {
						if (colorAux.getColor().equals(tablero[row][i-1].getColor())) {
							convertirNegro(row, i-1);

						}else {

							break;
						}
					}
				}

				for (int i = colum; i <tablero.length-1; i++) {
					if (colorAux.getColor().equals(tablero[row][i+1].getColor())) {
						convertirNegro(row, i+1);
					}else {
						break;
					}
					if (!tablero[row][colum].getColor().equals(tablero[row][colum-1].getColor()) && !tablero[row][colum].getColor().equals(tablero[row-1][colum].getColor())) {
						logger.info("Error, movimiento invalido");
						throw new candyCleanExceptions("Error, movimiento invalido");
					}
				}
			}

		}else if(colum == tablero.length-1) {
			//recorro hacia atras para ver si las anteriores casillas son del mismo color 
			for (int i = colum; i >= 0; i--) {
				if(i==0) {
					if (colorAux.getColor().equals(tablero[row][i].getColor())) {
						convertirNegro(row, i);
					}
				}else {
					if (colorAux.getColor().equals(tablero[row][i-1].getColor())) {
						convertirNegro(row, i-1);
					}else {
						break;
					}
				}
			}
		}
		//SEGUNDA CONVOCATORIA
		if(row < tablero.length-1) {
			if(row == 0) {
				for (int i = row; i < tablero.length-1; i++) {
					if (colorAux.getColor().equals(tablero[i+1][colum].getColor())) {
						convertirNegro(i+1, colum);
					}else {
						break;
					}
				}
			}else {
				for (int i = row; i < tablero.length-1; i++) {
					if (colorAux.getColor().equals(tablero[i+1][colum].getColor())) {
						convertirNegro(i+1, colum);
					}else {
						break;
					}
				}
				for (int i = row; i > 0; i++) {
					if (colorAux.getColor().equals(tablero[i-1][colum].getColor())) {
						convertirNegro(i-1, colum);
					}else {
						break;
					}
				}
			}
		}else if (row == tablero.length-1){
			for (int i = row; i >= 0; i--) {
				if (i==0) {
					if(colorAux.getColor().equals(tablero[i][colum].getColor())) {
						convertirNegro(i, colum);
					}
				}else {
					if(colorAux.getColor().equals(tablero[i-1][colum].getColor())) {
						convertirNegro(i-1, colum);
					}else {
						break;
					}
				}
			}
		}
	}

	/**
	 * Metodo que transforma la posicion pasada a negro.
	 * @param fila
	 * @param colum
	 * @throws candyCleanExceptions 
	 */
	public void convertirNegro(int fila, int colum) throws candyCleanExceptions {
		Color negro = new Color(BackgroundColor.BLACK);
		tablero[fila][colum] = new Casilla (negro);
		logger.info("Celda : " + "[" + fila + "] "+ "[" +colum + "]\n" );
		this.puntos ++;
	}

	/**
	 * Metodo que baja la fila para que las negras esten arriba.
	 * @param tableroInt
	 * @throws candyCleanExceptions 
	 */
	public void bajarFila() throws candyCleanExceptions {
		Color negro = new Color(BackgroundColor.BLACK);
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				for (int k = 0; k < tablero.length; k++) {
					if (j > 0 && tablero[j][k].getColor().equals(negro.getColor())) {
						//Posicion superior

						logger.info("Cambio de la posicion : " + j + " por: " + (j-1) + "\n" );
						Casilla aux = tablero[j-1][k];
						tablero[j][k] = aux;
						tablero[j-1][k] = new Casilla (negro); 
					}
				}
			}
		}
	}

	/**
	 * Metodo que comprueba que el tablero esta vacio
	 * @return boolean
	 */
	public boolean comprobarTableroVacio() {
		Color negro = new Color(BackgroundColor.BLACK);
		for (int  i= 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				if(tablero[i][j].getColor() != negro.getColor()) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 *Metodo toString
	 */
	@Override
	public String toString(){
		StringBuilder output = new StringBuilder();

		int tamanyo= tablero.length+1;
		for(int i=0; i< tamanyo; i++){
			for(int j=0; j< tamanyo; j++){
				if(i==0&&j==0) {
					output.append(" |");
				}else if(i==0&&j!=0) {
					output.append(j-1+"|");
				}else if(j==0&&i!=0) {
					output.append(i-1);
				}else {
					output.append(tablero[i-1][j-1]);
				}
			}
			output.append("\n");	
		}
		output.append("Points: " + this.puntos);
		return output.toString();
	}

}
