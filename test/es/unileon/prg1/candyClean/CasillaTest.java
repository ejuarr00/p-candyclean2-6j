package es.unileon.prg1.candyClean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Clase encargada de Testear la clase Casilla
 * @author dquina00
 * @author ejuarr00
 * @author jmachr00
 * @author jmartc08
 */
public class CasillaTest {

	private Color color = new Color(BackgroundColor.RED);
	private Casilla casilla;
	Color otro;
	Color negro; 
	
	@Before
	public void setUp() throws Exception{
		this.otro = new Color (3);
		this.negro = new Color (0);
		this.casilla  = new Casilla(color);
	}
	
	@Test
	public void testGetColor() {
		assertEquals(casilla.getColor(), color.getColor() );
		assertNotSame(casilla.getColor(), new Color(4).getColor());
	}
	
	@Test
	public void testSetColor() {
		Color verde = new Color(2);
		casilla.setColor(verde);
		assertEquals(casilla.getColor(), verde.getColor());
		assertNotSame(casilla.getColor(), new Color(5).getColor());
	}
	
	@Test
	public void testIsEmpty() {
		
		casilla.setColor(otro);
		assertFalse(casilla.isEmpty());
		
		casilla.setColor(negro);
		assertTrue(casilla.isEmpty());
	}
	
	@Test
	public void testSetEmpty() {
		casilla.setEmpty();
		assertEquals(this.casilla.getColor(), negro.getColor());
	}
	
	@Test
	public void testToString(){
		casilla.setColor(color);
		assertEquals(this.casilla.toString(), color.toString());
	}
	
}
