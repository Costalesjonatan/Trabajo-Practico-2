package grafos;

import java.util.ArrayList;

public class FlujoMaximo {

	
	private static ArrayList<ArrayList<Integer>> L;
	private static boolean[] marcados;
	
	public static int flujoMaximo(DiGrafoConPesos red, int origen) {
		
		
		return origen;
		
	}
	
	private static ArrayList<Integer> obtenerCamino(DiGrafoConPesos red, int origen){
		
		inicializar(red, origen);
		
		while(L.size() > 0) {
			
			int i = L.get(0).get(-1);
			marcados[i] = true;
			
			actualizarPendientes(red, i);
			L.remove(0);
		}
	}
	
	private static void actualizarPendientes(DiGrafoConPesos red, int k) {
		for(int i = 0; i < red.vecinos(i).size(); i++) {
			L.add(new ArrayList<Integer>().addAll(c))
		}
	}
	
	private static void inicializar(DiGrafoConPesos red, int origen) {
		
		L = new ArrayList<ArrayList<Integer>>();
		L.add(new ArrayList<Integer>());
		L.get(0).add(0);
		marcados = new boolean[red.cantidadDeVertices()];
		
		
		
	}
	
	
}
