package Ex04;

class Nodo {
	public int dado;
	public Nodo link; // referência
	
	public String toString() {
		return ""+dado;
	}
}

class ListaLigadaSimples {
	public Nodo inicio, fim;
	public int quantidade;

	public ListaLigadaSimples() {
		inicio = null;
		fim = null;
		quantidade = 0;
	}

	public void adicionarInicio(int x) {
		if (quantidade == 0) {
			Nodo novo = new Nodo();
			novo.dado = x;
			novo.link = null;
			inicio = novo;
			fim = novo;
			quantidade = 1;
		} else // já existem elementos na lista
		{
			Nodo novo = new Nodo();
			novo.dado = x;
			novo.link = inicio;
			inicio = novo;
			quantidade++;
		}
	}

	public void adicionarFim(int x) {
		if (quantidade == 0) {
			Nodo novo = new Nodo();
			novo.dado = x;
			novo.link = null;
			inicio = novo;
			fim = novo;
			quantidade = 1;
		} else // já existem elementos na lista
		{
			Nodo novo = new Nodo();
			novo.dado = x;
			novo.link = null;
			fim.link = novo;
			fim = novo;
			quantidade++;
		}
	}

	public int removerInicio() {
		if (quantidade == 0)
			throw new RuntimeException(); // lance exceção
		else if (quantidade == 1) {
			int aux = inicio.dado;
			inicio = null;
			fim = null;
			quantidade = 0;
			return aux;
		} else {
			int aux = inicio.dado;
			inicio = inicio.link;
			quantidade--;
			return aux;
		}
	}

	public int removerFim() {
		if (quantidade == 0)
			throw new RuntimeException(); // lance exceção
		else if (quantidade == 1) {
			int aux = inicio.dado;
			inicio = null;
			fim = null;
			quantidade = 0;
			return aux;
		} else {
			int aux = fim.dado;
			Nodo penultimo = inicio;
			while (penultimo.link != fim) {
				penultimo = penultimo.link;
			}
			fim = penultimo;
			penultimo.link = null;
			quantidade--;
			return aux;
		}
	}

	public boolean existe(int elemento) {
		Nodo aux = inicio;
		while (aux != null) {
			if (aux.dado == elemento)
				return true;
			else
				aux = aux.link;
		}
		return false;
	}

	public String toString() {
		Nodo nodo = inicio;
		String saida = "INICIO -> ";
		for (int i = 0; i < quantidade; i++) {
			saida = saida + nodo.dado + " -> ";
			nodo = nodo.link;
		}
		saida = saida + "FIM";
		return saida;
	}

	public boolean crescente() {
		Nodo aux = inicio;
		for (int i = 1; i <= quantidade - 1; i++) {
			if (aux.dado > aux.link.dado)
				return false;
			else
				aux = aux.link;
		}
		return true;
	}

	public Nodo minimo() {
		if (quantidade == 0)
			return null;
		Nodo min = inicio;
		Nodo aux = inicio.link;
		while (aux != null) {
			if (aux.dado < min.dado) {
				min = aux;
			}
			aux = aux.link;
		}
		return min;
	}

}

public class Ex04 {
	public static void main(String args[]) {
		ListaLigadaSimples lista = new ListaLigadaSimples();
		lista.adicionarInicio(7);
		lista.adicionarInicio(4);
		lista.adicionarInicio(2);
		lista.adicionarFim(11);
		System.out.println("Lista no princípio: " + lista);
		System.out.println("Lista é crescente? " + lista.crescente());
		System.out.println("Mínimo elemento da lista: " + lista.minimo());
		System.out.println("Removi o primeiro: " + lista.removerInicio());
		System.out.println("Lista após remoção: " + lista);
		System.out.println("Removi o último: " + lista.removerFim());
		System.out.println("Lista após remoção: " + lista);
		System.out.println("O elemento 7 existe na lista? Resposta: " + lista.existe(7));
		System.out.println("O elemento 15 existe na lista? Resposta: " + lista.existe(15));
	}
}
