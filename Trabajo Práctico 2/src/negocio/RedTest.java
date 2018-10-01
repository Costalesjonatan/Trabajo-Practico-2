package negocio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RedTest {

private Red red;
	
	@Before
	public void setUp() {
		this.red = new Red();
		this.red.agergarNodoProductor(15);
		this.red.agergarNodoProductor(50);
		this.red.agergarNodoProductor(5);
		this.red.agergarNodoDePAso();
		this.red.agergarNodoDePAso();
		this.red.agergarNodoDePAso();
		this.red.agergarNodoDePAso();
		this.red.agergarNodoDePAso();
		this.red.agergarNodoDePAso();
		this.red.agregarNodoConsumidor(9);
		this.red.agregarNodoConsumidor(12);
		this.red.agregarNodoConsumidor(5);
		this.red.agregarNodoConsumidor(20);
		this.red.agregarNodoConsumidor(1);
		this.red.agregarNodoConsumidor(3);
		this.red.agregarArco(0, 1, 4, 25);
		this.red.agregarArco(2, 1, 6, 15);
		this.red.agregarArco(1, 6, 5, 10);
	}
	

	@Test
	public void agregarNodoProductorTest() {
		
		assertTrue(this.red.getNodosProductores().get(2) == 5);
		assertTrue(this.red.getNodosProductores().size() == 3);
		
	}
	
	@Test (expected = RuntimeException.class)
	public void agregarNodoProductorException() {
		
		this.red.agergarNodoProductor(0);
		
	}
	
	@Test
	public void agregarNodoConsumidorTest() {
		
		assertTrue(this.red.getNodosConsumidores().get(4) == 1);
		assertTrue(this.red.getNodosConsumidores().size() == 6);
		
	}
	
	@Test (expected = RuntimeException.class)
	public void agregarNodoConsumidorException() {
		
		this.red.agregarNodoConsumidor(0);
		
	}
	
	@Test
	public void agregarNodoDePasoTest() {
		
		assertTrue(this.red.getNodosDePaso().get(4) == 4);
		assertTrue(this.red.getNodosDePaso().size() == 6);
		
	}
	
	@Test
	public void agregarArcoTest() {
		assertTrue(this.red.getArcos().size() == 3);
	}
	
	@Test (expected = RuntimeException.class)
	public void agregarArcoExcpetionTest() {
		
		red.agregarArco(2, 1000, 2, 15);
		
	}
	
	@Test(expected = RuntimeException.class)
	public void agregarArcoException2() {
		
		red.agregarArco(6, 1, 1, 15);
	}
}
