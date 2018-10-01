package grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BFS {
	
	private static ArrayList<Integer> L;
	private static boolean [] marcados;
	
	// Determina si un grafo es conexo
	public static boolean esConexo(GrafoDirigido grafo)
	{
		if( grafo == null )
			throw new IllegalArgumentException("Se consult la conexin de un grafo null!");
		
		if( grafo.cantidadDeVertices() == 0 )
			return true;
		
		return alcanzables(grafo, 0).size() == grafo.cantidadDeVertices();
	}
	
	// Encuentra los vrtices alcanzables desde el vrtice dado
	static Set<Integer> alcanzables(GrafoDirigido grafo, int origen)
	{
		inicializar(grafo, origen);
		
		while ( L.size()>0 )
		{	
			int i = L.get(0);
			marcados[i] = true;
			
			agregarVecinosPendientes(grafo, i);
			L.remove(0);		
		}
		
		return marcados();
	}

	private static void inicializar(GrafoDirigido grafo, int origen) 
	{
		//Los vrtices pendientes de visitar
		L = new ArrayList<Integer>();
		L.add(origen);
		
		//Los vrtices visitados
		marcados = new boolean[grafo.cantidadDeVertices()];	
	}

	private static void agregarVecinosPendientes(GrafoDirigido grafo, int i) 
	{
		for (Integer v: grafo.vecinos(i))
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
