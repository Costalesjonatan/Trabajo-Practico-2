package grafos;

import java.util.ArrayList;

public class DiGrafoConPesos {
	
	private int[][] matrizDePesos;
	
	public DiGrafoConPesos(int vertices) {
		
		this.matrizDePesos = new int[vertices][vertices];
	}
	
	
	public void agregarArista(int verticeA, int verticeB, int peso) {
		
		if(!this.existeArista(verticeA, verticeB)) {
			this.verificarPeso(peso);
			this.verificarVertices(verticeA, verticeB);
			this.verificarDistintos(verticeA, verticeB);
			this.matrizDePesos[verticeA][verticeB] = peso;
		}
		else {
			throw new IllegalArgumentException("La arista " + verticeA + ", " + verticeB + " ya existe");
		}
	}
	
	public void eliminarArista(int verticeA, int verticeB) {
		
		if(this.existeArista(verticeA, verticeB)) {
			this.matrizDePesos[verticeA][verticeB] = 0;
		}
		else {
			throw new IllegalArgumentException("La arista "+ verticeA + ", " + verticeB + " no existe");
		}
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
	
	private void verificarPeso(int peso) {
		
		if(peso <= 0) {
			throw new IllegalArgumentException("El numero " + peso + " no es válido como argumento");
		}
	}
	
	private void verificarVertices(int verticeA, int verticeB) {
		
		if(verticeA > this.cantidadDeVertices() || verticeB > this.cantidadDeVertices()) {
			throw new IndexOutOfBoundsException("Algunos de los vertices especificados no existe");
		}
	}
	
	private void verificarDistintos(int verticeA, int verticeB) {
		
		if(verticeA == verticeB) {
			throw new IllegalArgumentException("No se permiten aristas entre un mismo vertice! (" + verticeA + ")");
		}
	}
	
	public boolean existeArista(int verticeA, int verticeB) {
		
		return this.matrizDePesos[verticeA][verticeB] != 0;
	}
	
	public boolean equals(Object diGrafo) {
		
		if(diGrafo instanceof DiGrafoConPesos) {
			if(((DiGrafoConPesos) diGrafo).cantidadDeVertices() != this.cantidadDeVertices()) {
				return false;
			}
			else {
				for(int i = 0; i < this.cantidadDeVertices(); i++) {
					for(int j = 0; j < this.cantidadDeVertices(); j++) {
						if(this.obtenerArista(i, j) != ((DiGrafoConPesos) diGrafo).obtenerArista(i, j)) {
							return false;
						}
					}
				}
				return true;
			}
			
		}
		return false;
	}
	
	public String toString() {
		
		StringBuilder cadena = new StringBuilder();
		
		for(int i = 0; i < this.matrizDePesos.length; i++) {
			for(int j = 0; j < this.matrizDePesos.length; j++) {
				cadena.append(this.matrizDePesos[i][j] + " ");
			}
			cadena.append("\n");
		}
		return cadena.toString();
	}
}
