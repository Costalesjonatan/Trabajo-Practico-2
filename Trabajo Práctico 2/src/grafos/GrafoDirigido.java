package grafos;

import java.util.ArrayList;

public class GrafoDirigido {
	
	private int[][] matrizDePesos;
	
	public GrafoDirigido(int vertices) {
		
		this.matrizDePesos = new int[vertices][vertices];
		
	}
	
	
	public void agregarArista(int verticeA, int verticeB, int peso) {
		
		if(peso <= 0) {
			throw new RuntimeException("Los pesos deben ser >= 1");
		}
		if(verticeA > this.matrizDePesos.length) {
			throw new IndexOutOfBoundsException("El vertice " + verticeA + " no existe");
		}
		if(verticeB > this.matrizDePesos.length) {
			throw new IndexOutOfBoundsException("El vertice " + verticeB + " no existe");
		}
		this.verificarOrdenados(verticeA, verticeB);
		
		this.matrizDePesos[verticeA][verticeB] = peso;
		
	}
	
	public int obtenerArista(int verticeA, int verticeB) {
		return this.matrizDePesos[verticeA][verticeB];
	}
	
	public int cantidadDeVertices() {
		return this.matrizDePesos.length;
	}
	
	public ArrayList<Integer> vecinos(int vertice) {
		
		ArrayList<Integer> vecinos = new ArrayList<Integer>();
		
		for(int i = 0; i < this.matrizDePesos.length; i++) {
			if(this.matrizDePesos[vertice][i] != 0) {
				vecinos.add(i);
			}
		}
		
		return vecinos;
	}
	
	public void verificarOrdenados(int verticeA, int verticeB) {
		
		if(verticeA > verticeB) {
			throw new IllegalArgumentException("los pares de vertices que representan las aristas deben estar ordenados");
		}
		
	}
	
	public void verificarDistintos(int verticeA, int verticeB) {
		if(verticeA == verticeB) {
			throw new IllegalArgumentException("No se permiten aristas entre un mismo vrtice! (" + verticeA + ")");

		}
	}
	
	public String toString() {
		
		StringBuilder cadena = new StringBuilder();
		
		for(int i = 0; i < this.matrizDePesos.length; i++) {
			for(int j = 0; j < this.matrizDePesos.length; j++) {
				cadena.append(this.matrizDePesos[i][j] + "      ");
			}
			cadena.append("\n");
		}
		
		return cadena.toString();
		
	}
}
