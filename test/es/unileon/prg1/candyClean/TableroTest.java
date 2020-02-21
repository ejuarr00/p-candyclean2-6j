package es.unileon.prg1.candyClean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

/**
 * Clase encargada de Testear la clase Tablero
 * @author ejuarr00
 * @author jmachr00
 */
public class TableroTest {
	
	int [] vectorColores;
	Tablero tableroDeterminista ;
	
	@Before
	public void setUp() throws candyCleanExceptions {
		this.tableroDeterminista = new Tablero();
	}
	
	@Test
	public void generarTableroTest() throws candyCleanExceptions{
		assertNotNull(tableroDeterminista);
	}

	@Test
	public void generarColoresAleatoriosTest() {
		assertNull(vectorColores);
		vectorColores= new int[] {2,3,5};
		assertNotNull(vectorColores);	
	}
	
	@Test (expected = candyCleanExceptions.class)
	public void comprobarCombinacionExcepcion() throws candyCleanExceptions{
		this.tableroDeterminista.comprobarCombinacion(-1, 3);
	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarCombinacionExcepcion1() throws candyCleanExceptions{
		tableroDeterminista.comprobarCombinacion(8, 3);
	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarCombinacionExcepcion2() throws candyCleanExceptions{
		tableroDeterminista.comprobarCombinacion(3, -1);
	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarCombinacionExcepcion3() throws candyCleanExceptions{
		tableroDeterminista.comprobarCombinacion(3, 8);
	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarCombinacionExcepcion4() throws candyCleanExceptions{
		tableroDeterminista.comprobarCombinacion(-1, -1);
	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarCombinacionExcepcion5() throws candyCleanExceptions{
		tableroDeterminista.comprobarCombinacion(8, 8);
	}
	
	@Test 
	public void comprobarCombinacionArribaIzquierda() throws candyCleanExceptions{
		tableroDeterminista.comprobarCombinacion(0, 0);
	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarCombinacionArribaIzquierdaExcepcion() throws candyCleanExceptions{
		tableroDeterminista.convertirTableroAleatorio();
		tableroDeterminista.comprobarCombinacion(0, 0);
	}
	
	@Test 
	public void comprobarCombinacionAbajoDerecha() throws candyCleanExceptions{
		tableroDeterminista.comprobarCombinacion(4, 4);
	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarCombinacionAbajoDerechaExcepcion() throws candyCleanExceptions{
		tableroDeterminista.convertirTableroAleatorio();
		tableroDeterminista.comprobarCombinacion(4, 4);
	}
	
	@Test 
	public void comprobarCombinacionArribaDerecha() throws candyCleanExceptions{
		tableroDeterminista.comprobarCombinacion(0, 4);
	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarCombinacionArribaDerechaExcepcion() throws candyCleanExceptions{
		tableroDeterminista.convertirTableroAleatorio();
		tableroDeterminista.comprobarCombinacion(0, 4);
	}
	@Test 
	public void comprobarCombinacionArribaDerecha1() throws candyCleanExceptions{
		tableroDeterminista.comprobarCombinacion(0, 0);
	}
	@Test 
	public void comprobarCombinacionArribaDerecha2() throws candyCleanExceptions{
		tableroDeterminista.comprobarCombinacion(0, 4);
	}
	
	@Test 
	public void comprobarCombinacionAbajoIzquierda() throws candyCleanExceptions{
		tableroDeterminista.comprobarCombinacion(4, 0);
	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarCombinacionAbajoIzquierdaExcepcion() throws candyCleanExceptions{
		tableroDeterminista.convertirTableroAleatorio();
		//System.out.println(tableroDeterminista.toString());
		tableroDeterminista.comprobarCombinacion(4, 0);
	}
	
	@Test 
	public void comprobarCombinacionFilaMenorTam() throws candyCleanExceptions{
		tableroDeterminista.comprobarCombinacion(2, 0);
	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarCombinacionFilaMenorExcepcion() throws candyCleanExceptions{
		tableroDeterminista.convertirTableroAleatorio();
		tableroDeterminista.comprobarFilaMenorTam(3, 0);
		tableroDeterminista.comprobarFilaMenorTam(2, 0);
		tableroDeterminista.comprobarFilaMenorTam(1, 0);

	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarCombinacionFilaMenorExcepcion1() throws candyCleanExceptions{
		tableroDeterminista.convertirTableroAleatorio();
		tableroDeterminista.comprobarFilaMenorTam(3, 4);
		tableroDeterminista.comprobarFilaMenorTam(2, 4);
		tableroDeterminista.comprobarFilaMenorTam(1, 4);
	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarCombinacionFilaMenorExcepcion2() throws candyCleanExceptions{
		tableroDeterminista.convertirTableroAleatorio();
		tableroDeterminista.comprobarFilaMenorTam(3, 3);
	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarCombinacionFilaMenorExcepcion3() throws candyCleanExceptions{
		tableroDeterminista.convertirTableroAleatorio();
		tableroDeterminista.comprobarFilaMenorTam(3, 2);
	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarCombinacionFilaMenorExcepcion4() throws candyCleanExceptions{
		tableroDeterminista.convertirTableroAleatorio();
		tableroDeterminista.comprobarFilaMenorTam(3, 1);
	}
	
	@Test 
	public void comprobarCombinacionColumnaMenorTam() throws candyCleanExceptions{
		tableroDeterminista.comprobarCombinacion(0, 3);
	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarombinacionColumnaMenorTamExcepcion() throws candyCleanExceptions{
		tableroDeterminista.convertirTableroAleatorio();
		tableroDeterminista.comprobarColumnaMenorTam(0, 3);
		tableroDeterminista.comprobarColumnaMenorTam(0, 2);
		tableroDeterminista.comprobarColumnaMenorTam(0, 1);

	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarombinacionColumnaMenorTamExcepcion1() throws candyCleanExceptions{
		tableroDeterminista.convertirTableroAleatorio();
		tableroDeterminista.comprobarColumnaMenorTam(4, 3);
		tableroDeterminista.comprobarColumnaMenorTam(4, 2);
		tableroDeterminista.comprobarColumnaMenorTam(4, 1);
	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarombinacionColumnaMenorTamExcepcion2() throws candyCleanExceptions{
		tableroDeterminista.convertirTableroAleatorio();
		tableroDeterminista.comprobarColumnaMenorTam(3, 3);
	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarombinacionColumnaMenorTamExcepcion3() throws candyCleanExceptions{
		tableroDeterminista.convertirTableroAleatorio();
		tableroDeterminista.comprobarColumnaMenorTam(3, 2);

	}
	@Test (expected = candyCleanExceptions.class)
	public void comprobarombinacionColumnaMenorTamExcepcion4() throws candyCleanExceptions{
		tableroDeterminista.convertirTableroAleatorio();
		tableroDeterminista.comprobarColumnaMenorTam(3, 1);
	}
		
	@Test
	public void comprobarColorTest() throws candyCleanExceptions{
	tableroDeterminista.comprobarColor(4, 0);
	//System.out.println(tableroDeterminista.toStringDeterminista());
	assertEquals(tableroDeterminista.toString(), 
			" |0|1|2|3|4|\n" + 
			"0[41m  [0m[41m  [0m[41m  [0m[41m  [0m[41m  [0m\n" + 
			"1[44m  [0m[44m  [0m[41m  [0m[41m  [0m[41m  [0m\n" + 
			"2[44m  [0m[44m  [0m[44m  [0m[44m  [0m[44m  [0m\n" + 
			"3[42m  [0m[42m  [0m[44m  [0m[44m  [0m[44m  [0m\n" + 
			"4[40m  [0m[40m  [0m[42m  [0m[42m  [0m[42m  [0m\n" + 
			"Points: 2");
	}

	@Test
	public void convertirNegroTest() throws candyCleanExceptions {
		tableroDeterminista.convertirNegro(4,3);
		assertEquals(tableroDeterminista.toString(), 
				" |0|1|2|3|4|\n" + 
				"0[41m  [0m[41m  [0m[41m  [0m[41m  [0m[41m  [0m\n" + 
				"1[44m  [0m[44m  [0m[41m  [0m[41m  [0m[41m  [0m\n" + 
				"2[44m  [0m[44m  [0m[44m  [0m[44m  [0m[44m  [0m\n" + 
				"3[42m  [0m[42m  [0m[44m  [0m[44m  [0m[44m  [0m\n" + 
				"4[44m  [0m[44m  [0m[42m  [0m[40m  [0m[42m  [0m\n" + 
				"Points: 1");
	}

	@Test
	public void bajarFilaTest() throws candyCleanExceptions {
		tableroDeterminista.convertirNegro(4, 0);
		//System.out.println(tableroDeterminista.toStringDeterminista());
		tableroDeterminista.bajarFila();
		//System.out.println(tableroDeterminista.toStringDeterminista());
		assertEquals(tableroDeterminista.toString(), 
				" |0|1|2|3|4|\n" + 
				"0[40m  [0m[41m  [0m[41m  [0m[41m  [0m[41m  [0m\n" + 
				"1[41m  [0m[44m  [0m[41m  [0m[41m  [0m[41m  [0m\n" + 
				"2[44m  [0m[44m  [0m[44m  [0m[44m  [0m[44m  [0m\n" + 
				"3[44m  [0m[42m  [0m[44m  [0m[44m  [0m[44m  [0m\n" + 
				"4[42m  [0m[44m  [0m[42m  [0m[42m  [0m[42m  [0m\n" + 
				"Points: 1");
	}

	@Test
	public void comprobarTableroVacioTest() {
		assertEquals(tableroDeterminista.comprobarTableroVacio(), false);
	}
	@Test
	public void comprobarTableroVacioTest1() throws candyCleanExceptions {
		tableroDeterminista.convertirTableroVacio();
		assertEquals(tableroDeterminista.comprobarTableroVacio(), true);
	}

	@Test
	public void toStringTest() {
		//System.out.println(tableroDeterminista.toStringDeterminista());
		assertEquals(tableroDeterminista.toString(), 
				" |0|1|2|3|4|\n" + 
				"0[41m  [0m[41m  [0m[41m  [0m[41m  [0m[41m  [0m\n" + 
				"1[44m  [0m[44m  [0m[41m  [0m[41m  [0m[41m  [0m\n" + 
				"2[44m  [0m[44m  [0m[44m  [0m[44m  [0m[44m  [0m\n" + 
				"3[42m  [0m[42m  [0m[44m  [0m[44m  [0m[44m  [0m\n" + 
				"4[44m  [0m[44m  [0m[42m  [0m[42m  [0m[42m  [0m\n" + 
				"Points: 0");
	}
}
