package negocio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArcoTest {

	private Arco arco;
	
	@Before
	public void setUp() {
		arco = new Arco(2, 5, 4, 18);
	}
	
	@Test
	public void arcoTest() {
		assertTrue(arco.getTipoDeArco().equals("Nodo de Paso --> Nodo de Paso"));
		assertTrue(arco.getNodoA() == 5);
		assertTrue(arco.getNodoB() == 4);
		assertTrue(arco.getPeso() == 18);
	}
}
