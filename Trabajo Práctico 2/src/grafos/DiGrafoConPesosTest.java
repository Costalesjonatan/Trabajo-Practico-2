package grafos;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class DiGrafoConPesosTest {

	private DiGrafoConPesos grafoD;
	private DiGrafoConPesos grafoD2;
	private DiGrafoConPesos grafoD3;
	
	@Before
	public void setUp() {
		this.grafoD = new DiGrafoConPesos(10);
		this.grafoD2 = new DiGrafoConPesos(2);
		this.grafoD3 = new DiGrafoConPesos(10);
		
		
		this.grafoD.agregarArista(0, 1, 15);
		this.grafoD.agregarArista(0, 2, 64);
		this.grafoD.agregarArista(0, 3, 1);
		this.grafoD.agregarArista(1, 5, 5);
		this.grafoD.agregarArista(1, 4, 5);
		this.grafoD.agregarArista(4, 5, 5);
		this.grafoD.agregarArista(5, 6, 5);
		
		this.grafoD3.agregarArista(0, 1, 15);
		this.grafoD3.agregarArista(0, 2, 64);
		this.grafoD3.agregarArista(0, 3, 1);
		this.grafoD3.agregarArista(1, 5, 5);
		this.grafoD3.agregarArista(1, 4, 5);
		this.grafoD3.agregarArista(4, 5, 5);
		this.grafoD3.agregarArista(5, 6, 5);
		
		
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void VerticeAIndexOutOfBoundsExceptionTest() {
		
		this.grafoD2.agregarArista(55, 1, 15);
		
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
	
	@Test (expected = IllegalArgumentException.class)
	public void pesoLegalTest() {
		this.grafoD2.agregarArista(0, 1, 0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void pesoLegal2Test() {
		this.grafoD2.agregarArista(1, 1, -5);
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
	
	@Test (expected = IllegalArgumentException.class)
	public void verificarDistintosTest() {
		grafoD.agregarArista(5, 5, 5);
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
	
	@Test (expected = IllegalArgumentException.class)
	public void existeAristaTest() {
		this.grafoD.agregarArista(0, 2, 54);
	}
	
	@Test
	public void noExisteArista() {
		this.grafoD.agregarArista(0, 4, 5);
		assertTrue(this.grafoD.existeArista(0, 4));
		assertTrue(this.grafoD.obtenerArista(0, 4) == 5);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void eliminarAristaException() {
		this.grafoD.eliminarArista(0, 5);
	}
	
	@Test
	public void eliminarArista() {
		this.grafoD.eliminarArista(0, 1);
		assertFalse(this.grafoD.existeArista(0, 1));
	}
	
	@Test
	public void toStringTest() {
		
		String cadenaEsperada = "0 0 \n0 0 \n" ;
		String cadena = grafoD2.toString();
		
		assertTrue(cadena.equals(cadenaEsperada));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void notEqualsTest() {
		
		int[][] matriz = new int[4][4];
		assertFalse(this.grafoD.equals(matriz));
	}
	
	@Test
	public void notEquals2Test() {
		assertFalse(this.grafoD.equals(this.grafoD2));
	}
	
	@Test
	public void equalsTest() {
		assertTrue(this.grafoD.equals(this.grafoD3));
	}
}
