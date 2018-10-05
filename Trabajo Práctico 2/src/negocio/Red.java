package negocio;

import java.util.ArrayList;

import grafos.DiGrafoConPesos;


public class Red {
	
	private ArrayList<ArrayList<Integer>> red;
	private ArrayList<Arco> arcos;
	private DiGrafoConPesos grafoDeRed;
	private int contadorNodosProductores;
	private int contadorNodosConsumidores;
	private int contadorNodosDePaso;
	
	public Red() {
		
		this.contadorNodosProductores = 0;
		this.contadorNodosConsumidores = 0;
		this.contadorNodosDePaso = 0;
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
		this.contadorNodosProductores++;
	}
	
	public void agergarNodoDePAso() {
		this.red.get(1).add(this.red.get(1).size());
		this.contadorNodosDePaso++;
	}
	
	public void agregarNodoConsumidor(int demanda) {
		
		if(demanda <= 0) {
			throw new RuntimeException("La demanda de un nodo consumidor debe ser mayor o igual a 0");
		}
		this.red.get(2).add(demanda);
		this.contadorNodosConsumidores++;
	}
	
	
	
	public void agregarArco(int tipoDeArco, int nodoA, int nodoB, int peso) {
		
		if(tipoDeArco < 0 || tipoDeArco > 2) {
			throw new RuntimeException("Se debe indicar: \n 0 para arco del tipo: Productor --> NodoDePaso.\n"
					+ "1 para arco del tipo: Nodo de Paso --> Nodo de Paso.\n 2 para arco del tipo Nodo de Paso --> Consumidor.");
		}
		if(tipoDeArco == 0) {
			if(nodoA > this.red.get(0).size()) {
				throw new RuntimeException("No existe el nodo productor especificado");
			}
			else if(nodoB > this.red.get(1).size()) {
				throw new RuntimeException("No existe el nodo de paso especificado");
			}
		}
		if(tipoDeArco == 1) {
			if(nodoA > this.red.get(1).size() || nodoB > this.red.get(1).size()) {
				throw new RuntimeException("Alguno de los Nodos de paso especificados no existe");
			}
		}
		if(tipoDeArco == 2) {
			if(nodoA > this.red.get(1).size()) {
				throw new RuntimeException("No existe el nodo de paso especificado");
			}
			else if(nodoB > this.red.get(2).size() ) {
				throw new RuntimeException("No existe el nodo consumidor especificado");
			}
		}
		if(nodoA <= 0 || nodoB <= 0) {
			throw new RuntimeException("las cantidades de nodos estan especificadas a partir del 1"); 
		}
		
		if(tipoDeArco == 0) {
			this.arcos.add(new Arco(tipoDeArco, nodoA, this.contadorNodosProductores + nodoB, peso));
		}
		if(tipoDeArco == 1) {
			this.arcos.add(new Arco(tipoDeArco, this.contadorNodosProductores + nodoA, this.contadorNodosProductores + nodoB, peso));
		}
		if(tipoDeArco == 2) {
			this.arcos.add(new Arco(tipoDeArco, this.contadorNodosProductores + nodoA, this.contadorNodosProductores + this.contadorNodosDePaso + nodoB, peso));
		}
		
		
	}
	
	//public void capacidadMaxima()
	
	public DiGrafoConPesos construirGrafo() {
		
		int verticesGrafo = this.contadorNodosProductores + this.contadorNodosConsumidores + this.contadorNodosDePaso;
		this.grafoDeRed = new DiGrafoConPesos(verticesGrafo+2);
		
		for(int i = 0; i < this.arcos.size(); i++) {
			Arco arco = this.arcos.get(i);
			this.grafoDeRed.agregarArista(arco.getNodoA(), arco.getNodoB(), arco.getPeso());
		}
		
		for(int i = 0; i < this.red.get(0).size(); i++) {
			int peso = this.red.get(0).get(i);
			this.grafoDeRed.agregarArista(0, i+1, peso);
		}
		
		for(int i = 0; i < this.red.get(2).size(); i++) {
			int peso = this.red.get(2).get(i);
			this.grafoDeRed.agregarArista(i+1 + this.contadorNodosProductores + this.contadorNodosDePaso, verticesGrafo+1, peso);
		}
		
		
		return this.grafoDeRed;
	}
	
	ArrayList<Integer> getNodosProductores() {
		return this.red.get(0);
	}
	
	ArrayList<Integer> getNodosConsumidores(){
		return this.red.get(2);
	}
	
	ArrayList<Integer> getNodosDePaso(){
		return this.red.get(1);
	}
	
	ArrayList<Arco> getArcos(){
		return this.arcos;
	}
}
