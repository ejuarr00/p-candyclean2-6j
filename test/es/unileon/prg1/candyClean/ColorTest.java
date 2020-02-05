package es.unileon.prg1.candyClean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Clase encargada de Testear la clase Color
 * @author dquina00
 * @author ejuarr00
 * @author jmachr00
 * @author jmartc08
 */
public class ColorTest {

	private Color color;
	private Color blue  = new Color(4);
	private Color red  = new Color(1);
	private Color black  = new Color(0);
	private Color green  = new Color(2);
	private Color yellow  = new Color(3);
	private Color purple  = new Color(5);
	private Color cyan  = new Color(6);
	private Color white  = new Color(7);
	String content = new String ("  ");

	@Before	
	public void setUp() throws Exception{
		Color c = new Color(yellow);
		this.color=new Color(4);
	}

	@Test
	public void testGetColor() {
		assertEquals(color.getColor(), blue.getColor() );
		assertNotSame(color.getColor(), new Color(5).getColor());
	}

	@Test
	public void testAnotherColor() {
		Color another = new Color (3);
		this.color = new Color(another);
		assertEquals(this.color.getColor(), another.getColor());
	}

	@Test
	public void testEquals() {
		Color another = new Color (4);
		assertTrue(color.equals(another));
	}
	
	@Test 
	public void testToStringContent() {
		String content = " ";
		assertEquals(color.toString(content), "[44m"+ content + "[0m");
	}

	@Test
	public void testToString(){
		assertEquals(color.toString(),"[44m  [0m");
	}
}
