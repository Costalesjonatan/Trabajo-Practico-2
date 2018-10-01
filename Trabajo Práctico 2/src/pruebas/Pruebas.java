package pruebas;

import grafos.GrafoDirigido;
import negocio.Red;

public class Pruebas {

	
	public static void main(String args[]) {
		
		Red red = new Red();
		
		red = new Red();
		red.agergarNodoProductor(15);
		red.agergarNodoDePAso();
		red.agergarNodoDePAso();
		red.agregarNodoConsumidor(5);
		
		red.agregarArco(0, 1, 1, 5);
		red.agregarArco(0, 1, 2, 5);
		red.agregarArco(1, 1, 2, 5);
		red.agregarArco(2, 1, 1, 5);
		
		
		GrafoDirigido grafo = red.construirGrafo();
		
		System.out.println(grafo.toString());
	}
	
}
