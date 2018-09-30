package negocio;

import java.util.ArrayList;


public class Red {
	
	private ArrayList<ArrayList<Integer>> red;
	private ArrayList<Arco> arcos;
	
	public Red() {
		
		this.arcos = new ArrayList<Arco>();
		this.red = new ArrayList<ArrayList<Integer>>(3);
		for(int i = 0; i < 3; i++) {
			this.red.add(new ArrayList<Integer>());
		}	
	}
	
	public void agergarNodoProductor(int oferta) {
		
		if(oferta <= 0) {
			throw new RuntimeException("La oferta de un nodo productor debe ser mayor o igual a 0");
		}
		this.red.get(0).add(oferta);
	}
	
	public void agregarNodoConsumidor(int demanda) {
		
		if(demanda <= 0) {
			throw new RuntimeException("La demanda de un nodo consumidor debe ser mayor o igual a 0");
		}
		this.red.get(1).add(demanda);
	}
	
	public void agergarNodoDePAso() {
		this.red.get(2).add(this.red.get(2).size()+1);
	}
	
	public void agregarArco(int tipoDeArco, int nodoA, int nodoB, int peso) {
		
		if(tipoDeArco < 0 || tipoDeArco > 2) {
			throw new RuntimeException("Se debe indicar: \n 0 para arco del tipo: Productor --> NodoDePaso.\n"
					+ "1 para arco del tipo: Nodo de Paso --> Consumidor.\n 0 para arco del tipo Nodo de Paso --> Nodo de Paso.");
		}
		if(tipoDeArco == 0) {
			if(nodoA > this.red.get(0).size()) {
				throw new RuntimeException("No existe el nodo productor especificado");
			}
			else if(nodoB > this.red.get(2).size()) {
				throw new RuntimeException("No existe el nodo de paso especificado");
			}
		}
		if(tipoDeArco == 1) {
			if(nodoA > this.red.get(2).size()) {
				throw new RuntimeException("No existe el nodo de paso especificado");
			}
			else if(nodoB > this.red.get(1).size() ) {
				throw new RuntimeException("No existe el nodo consumidor especificado");
			}
		}
		if(tipoDeArco == 2) {
			if(nodoA > this.red.get(2).size() || nodoB > this.red.get(2).size()) {
				throw new RuntimeException("Alguno de los Nodos de paso especificados no existe");
			}
		}
		if(nodoA <= 0 || nodoB <= 0) {
			throw new RuntimeException("las cantidades de nodos estan especificadas a partir del 1"); 
		}
		
		this.arcos.add(new Arco(tipoDeArco, nodoA, nodoB, peso));
		
	}
	
	ArrayList<Integer> getNodosProductores() {
		return this.red.get(0);
	}
	
	ArrayList<Integer> getNodosConsumidores(){
		return this.red.get(1);
	}
	
	ArrayList<Integer> getNodosDePaso(){
		return this.red.get(2);
	}
	
	ArrayList<Arco> getArcos(){
		return this.arcos;
	}
}
