package es.unileon.prg1.candyClean;

/**
 * Clase para supervisar las casillas del juego
 * @author ejuarr00
 * @author jmachr00
 */
public class Casilla {

	private Color color;

	

	/**
	 * Constructor de Casilla
	 * @param color
	 * @throws candyCleanExceptions
	 */
	public Casilla(Color color)throws candyCleanExceptions{
		this.color = color;	
	}

	public String getColor() {
		return color.getColor();
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isEmpty() {
		Color negro = new Color(BackgroundColor.BLACK);
		if(this.getColor().equals(negro.getColor())) {
			return true;
		}
		return false;
	}

	public void setEmpty() {
		Color negro = new Color(BackgroundColor.BLACK);
		this.color = negro;
	}

	public String toString() {
		return this.color.toString();
	}

}
