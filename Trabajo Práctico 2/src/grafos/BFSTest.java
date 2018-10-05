package grafos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Test;

public class BFSTest {

	private DiGrafoConPesos diGrafo;
	
	@Test (expected = IllegalArgumentException.class)
	public void grafoNullTest() {
		BFS.esConexo(diGrafo);
	}
	
	@Test
	public void alcanzablesTest() {
		
		diGrafo = new DiGrafoConPesos(5);
		diGrafo.agregarArista(0, 1, 5);
		diGrafo.agregarArista(0, 2, 5);
		diGrafo.agregarArista(1, 2, 5);
		diGrafo.agregarArista(1, 3, 5);
		diGrafo.agregarArista(2, 3, 5);
		diGrafo.agregarArista(3, 4, 5);
		
		Set<Integer> alcanzables = BFS.alcanzables(diGrafo, 0);
		ArrayList<Integer> alcanzablesReales = new ArrayList<Integer>();
		
		alcanzablesReales.add(0);
		alcanzablesReales.add(1);
		alcanzablesReales.add(2);
		alcanzablesReales.add(3);
		alcanzablesReales.add(4);
		
		boolean ret = true;
		
		for(int i = 0; i < alcanzables.size(); i++) {
			
			ret = ret && alcanzables.contains(i) && alcanzablesReales.contains(i);

		}
		
		assertTrue(ret);
	}
	
	@Test
	public void esConexoGrafoVacio() {
		this.diGrafo = new DiGrafoConPesos(0);
		
		assertTrue(BFS.esConexo(diGrafo));
	}
	
	@Test
	public void esConexoTest() {
		
		diGrafo = new DiGrafoConPesos(5);
		diGrafo.agregarArista(0, 1, 5);
		diGrafo.agregarArista(0, 2, 5);
		diGrafo.agregarArista(1, 2, 5);
		diGrafo.agregarArista(1, 3, 5);
		diGrafo.agregarArista(2, 3, 5);
		diGrafo.agregarArista(3, 4, 5);
		
		assertTrue(BFS.esConexo(diGrafo));
		
	}
	
	@Test
	public void noEsConexoTest() {
		
		diGrafo = new DiGrafoConPesos(5);
		diGrafo.agregarArista(0, 1, 5);
		diGrafo.agregarArista(1, 2, 6);
		diGrafo.agregarArista(3, 4, 78);
		
		assertFalse(BFS.esConexo(diGrafo));
	}
}
