package grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BFS {
	
	private static ArrayList<Integer> L;
	private static boolean [] marcados;
	
	// Determina si un grafo es conexo
	public static boolean esConexo(DiGrafoConPesos diGrafo)
	{
		if( diGrafo == null )
			throw new IllegalArgumentException("Se consulto si es conecxo un grafo null!");
		
		if( diGrafo.cantidadDeVertices() == 0 )
			return true;
		
		return alcanzables(diGrafo, 0).size() == diGrafo.cantidadDeVertices();
	}
	
	// Encuentra los vrtices alcanzables desde el vrtice dado
	static Set<Integer> alcanzables(DiGrafoConPesos diGrafo, int origen)
	{
		inicializar(diGrafo, origen);
		
		while ( L.size()>0 )
		{	
			
			int i = L.get(0);
			marcados[i] = true;
			
			agregarVecinosPendientes(diGrafo, i);
			L.remove(0);	
		}
		
		return marcados();
	}

	private static void inicializar(DiGrafoConPesos diGrafo, int origen) 
	{
		//Los vrtices pendientes de visitar
		L = new ArrayList<Integer>();
		L.add(origen);
		
		//Los vrtices visitados
		marcados = new boolean[diGrafo.cantidadDeVertices()];
	}

	private static void agregarVecinosPendientes(DiGrafoConPesos diGrafo, int i) 
	{
		for (Integer v: diGrafo.vecinos(i))
			if ( marcados[v] == false && L.contains(v) == false )
				L.add(v);
	}
	
	private static Set<Integer> marcados() 
	{
		Set<Integer> ret = new HashSet<Integer>();
		
		for (int i=0; i<marcados.length; ++i)
			if ( marcados[i] == true )
				ret.add(i);
		
		return ret;
	}
}
