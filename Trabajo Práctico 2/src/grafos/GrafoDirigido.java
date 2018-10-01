package grafos;

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
		
		this.matrizDePesos[verticeA][verticeB] = peso;
		
	}
	
	public int obtenerArista(int verticeA, int verticeB) {
		return this.matrizDePesos[verticeA][verticeB];
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
