package negocio;


public class Arco {
	
	private int tipoDeArco;
	private int nodoA;
	private int nodoB;
	private int peso;
	
	public Arco(int tipoDeArco, int nodoA, int nodoB, int peso) {
		
		this.tipoDeArco = tipoDeArco;
		this.nodoA = nodoA;
		this.nodoB = nodoB;
		this.peso = peso;		
		
	}
	
	public String getTipoDeArco() {
		
		if(tipoDeArco == 0) {
			return "Productor --> NodoDePaso";
		}
		else if(tipoDeArco == 1) {
			return "Nodo de Paso --> Nodo de Paso";
		}
		return "Nodo de Paso --> Consumidor";
	}
	
	int getNodoA() {
		return this.nodoA;
	}
	
	int getNodoB() {
		return this.nodoB;
	}
	
	int getPeso() {
		return this.peso;
	}
}
