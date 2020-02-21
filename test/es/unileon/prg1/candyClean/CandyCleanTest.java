package es.unileon.prg1.candyClean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Clase encargada de Testear la clase CandyClean
 * @author ejuarr00
 * @author jmachr00
 */
public class CandyCleanTest {
	CandyClean candyclean;
	CandyClean candyCleanVacio;
	int dimensionCorrecta;
	int dimensionIncorrecta;
	int colorCorrecto ;
	int colorIncorrecto;
	Color negro = new Color(BackgroundColor.BLACK);
	Tablero tableroDeterminista ;
	
	Tablero tableroVacio;
	

	@Before
	public void setUp() throws candyCleanExceptions {
		this.dimensionCorrecta = 5;
		this.dimensionIncorrecta = 3;
		this.colorCorrecto = 4;
		this.colorIncorrecto = 2;
		candyclean = new CandyClean(dimensionCorrecta, colorCorrecto);
		
		candyCleanVacio = new CandyClean();
		this.tableroDeterminista = new Tablero();
		this.tableroVacio = new Tablero();
	}

	@Test
	public void CandyCleanTest() throws candyCleanExceptions{
		candyclean = new CandyClean(5, 4);	
	}
	
	@Test (expected = candyCleanExceptions.class)
	public void comprobarCombinacionTest() throws candyCleanExceptions {
		candyclean.combinacion(3, 3);
		tableroVacio.convertirNegro(3, 3);	
	}
	
	@Test
	public void noHasGanadoTest() throws candyCleanExceptions {
		tableroDeterminista.generarTableroDeterminista();
		assertEquals(false, candyclean.hasGanado());
	}
	@Test
	public void hasGanadoTest() throws candyCleanExceptions{
		tableroDeterminista.convertirTableroVacio();
		System.out.println(tableroDeterminista.toString());
		assertEquals(candyCleanVacio.hasGanado(),true);	
	}
	
	@Test
	public void ComprobarDimensionTest()  {
		assertTrue(candyclean.comprobarDim(5));
	}
	@Test
	public void ComprobarDimensionTest1()  {
		assertFalse(candyclean.comprobarDim(3));
	}

	@Test
	public void comprobarColorTest() throws candyCleanExceptions {
		assertTrue(candyclean.comprobarColor(colorCorrecto));
	}
	@Test
	public void comprobarColorTest1() throws candyCleanExceptions {
		assertFalse(candyclean.comprobarColor(2));
	}
	@Test
	public void comprobarColorTest2() throws candyCleanExceptions {
		assertEquals(candyclean.comprobarColor(8),false);
	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarColoresTestException() throws candyCleanExceptions {
		new CandyClean(5, 2);
	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarColoresTestException1() throws candyCleanExceptions {
		new CandyClean(2, 6);
	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarColoresTestException2() throws candyCleanExceptions {
		new CandyClean(2, 9);
	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarColoresTestException3() throws candyCleanExceptions {
		new CandyClean(3, 7);
	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarDimensionTestException() throws candyCleanExceptions {
		new CandyClean(3, 4);
	}
	
	@Test
	public void toStringTest() {
		assertEquals(candyCleanVacio.toString(), 
				" |0|1|2|3|4|\n" + 
				"0[40m  [0m[40m  [0m[40m  [0m[40m  [0m[40m  [0m\n" + 
				"1[40m  [0m[40m  [0m[40m  [0m[40m  [0m[40m  [0m\n" + 
				"2[40m  [0m[40m  [0m[40m  [0m[40m  [0m[40m  [0m\n" + 
				"3[40m  [0m[40m  [0m[40m  [0m[40m  [0m[40m  [0m\n" + 
				"4[40m  [0m[40m  [0m[40m  [0m[40m  [0m[40m  [0m\n" + 
				"Points: 0");
	}	
}
