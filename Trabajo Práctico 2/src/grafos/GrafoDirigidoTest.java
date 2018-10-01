package grafos;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class GrafoDirigidoTest {

	private GrafoDirigido grafoD;
	private GrafoDirigido grafoD2;
	
	@Before
	public void setUp() {
		this.grafoD = new GrafoDirigido(10);
		this.grafoD2 = new GrafoDirigido(15);
		
		
		this.grafoD.agregarArista(0, 1, 15);
		this.grafoD.agregarArista(0, 2, 64);
		this.grafoD.agregarArista(0, 3, 1);
		this.grafoD.agregarArista(1, 5, 5);
		this.grafoD.agregarArista(1, 4, 5);
		this.grafoD.agregarArista(4, 5, 5);
		this.grafoD.agregarArista(5, 6, 5);
		
		
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void VerticeAIndexOutOfBoundsExceptionTest() {
		
		this.grafoD2.agregarArista(12, 20, 15);
		
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void VerticeBIndexOutOfBoundsExceptionTest() {
		
		this.grafoD2.agregarArista(3, 50, 15);
		
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void verticeAnegativo() {
		this.grafoD2.agregarArista(-6, 12, 15);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void verticeBnegativo() {
		this.grafoD2.agregarArista(-6, 10, 15);
	}
	
	@Test (expected = RuntimeException.class)
	public void pesoLegalTest() {
		this.grafoD2.agregarArista(10, 2, 0);
	}
	
	@Test (expected = RuntimeException.class)
	public void pesoLegal2Test() {
		this.grafoD2.agregarArista(10, 2, -5);
	}
	
	@Test
	public void aristaCorrecta() {
		assertTrue(this.grafoD.obtenerArista(9, 0) == 0);
	}
	
	@Test
	public void noSimetriaTest() {
		assertTrue(this.grafoD.obtenerArista(0, 9) == 0);
	}
	
	@Test
	public void cantidadDeVerticesTest() {
		assertTrue(this.grafoD.cantidadDeVertices() == 10);
	}
	
	@Test
	public void vecinosTest() {
		
		ArrayList<Integer> vecinos = this.grafoD.vecinos(0);
		ArrayList<Integer> vecinosReales = new ArrayList<Integer>();
		
		vecinosReales.add(1);
		vecinosReales.add(2);
		vecinosReales.add(3);
		
		assertTrue(vecinos.equals(vecinosReales));
		
	}
}
