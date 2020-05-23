class No {
	int chave;
	No pai, esquerda, direita;
	// agora cada No sabera quem eh seu pai, seu filho da esquerda e da direita

	public No antecessor() {
		No n, ant;
		ant = n = esquerda;

		while (n != null) {
			ant = n;
			n = n.direita;
		}

		return ant;
	}

	public No sucessor() {
		No n, suc;
		suc = n = direita;

		while (n != null) {
			suc = n;
			n = n.esquerda;
		}

		return suc;
	}

	public int numeroFilhos() {
		if (esquerda == null && direita == null)
			return 0;
		else if (esquerda != null && direita != null)
			return 2;
		else
			return 1;
	}

	public String toString() {
		return "<" + chave + ">";
	}
}

class ArvoreBinaria {
	private No raiz;

	public ArvoreBinaria() {
		raiz = null;
	}

	public No getRaiz() {
		return raiz;
	}

	public void insere(int chave) {
		No novo = new No();
		novo.chave = chave;
		novo.esquerda = novo.direita = null;

		if (raiz == null) {
			novo.pai = null;
			raiz = novo;
		} else {
			No aux = raiz, pai = null;

			while (aux != null) {
				if (aux.chave == chave)
					return; // o "chave" ja existe
				else if (aux.chave < chave) {
					pai = aux;
					aux = aux.direita; // passo a procurar aa direita
				} else {
					pai = aux;
					aux = aux.esquerda; // passo a procurar aa esquerda
				}
			}

			if (pai.chave > chave)
				pai.esquerda = novo;
			else
				pai.direita = novo;

			novo.pai = pai;
		}
	}

	public void remove(No n) {
		if (raiz == null)
			throw new RuntimeException("Lista vazia.");
		else {
			int numFilhos = n.numeroFilhos();

			if (numFilhos == 0) // folha
			{
				if (n == raiz)
					raiz = null;
				else {
					if (n.pai.chave > n.chave)
						n.pai.esquerda = null;
					else
						n.pai.direita = null;
				}
			} else if (numFilhos == 1) // tem 1 filho
			{
				No filho;
				if (n.esquerda != null)
					filho = n.esquerda;
				else
					filho = n.direita;

				if (n == raiz)
					raiz = filho;
				else {
					if (n.pai.chave > n.chave)
						n.pai.esquerda = filho;
					else
						n.pai.direita = filho;
				}
			} else // tem 2 filhos
			{
				No substituto = n.antecessor();
				remove(substituto);
				n.chave = substituto.chave;
			}
		}
	}

	public boolean contem(int chave) {
		No aux = raiz;

		while (aux != null) {
			if (aux.chave == chave)
				return true; // se encontrei, retorno true
			else if (aux.chave < chave)
				aux = aux.direita; // passo a procurar aa direita
			else
				aux = aux.esquerda; // passo a procurar aa esquerda
		}
		return false; // se chegou aqui eh porque nao existe
	}

	public No procurar(int chave) {
		No aux = raiz;

		while (aux != null) {
			if (aux.chave == chave)
				return aux; // se encontrei, retorno a referencia
			else if (aux.chave < chave)
				aux = aux.direita; // passo a procurar aa direita
			else
				aux = aux.esquerda; // passo a procurar aa esquerda
		}
		return null; // se chegou aqui eh porque nao existe
	}

	private String espacos(int n) {
		String s = "";
		for (int i = 0; i < n; i++)
			s = s + "      ";
		return s;
	}

	public String toString() {
		return mostra(raiz, 1);
	}

	private String mostra(No n, int nivel) {
		if (n == null)
			return "";
		else
			return mostra(n.direita, nivel + 1) + "\n" + espacos(nivel) + n.chave + "\n"
					+ mostra(n.esquerda, nivel + 1);
	}

	public String emOrdem(No raiz) {
		if (raiz == null)
			return "";
		else
			return emOrdem(raiz.esquerda) + " " + raiz.chave + " " + emOrdem(raiz.direita);
	}

	public String emOrdem() {
		return emOrdem(raiz);
	}

	/* 2) */
	public int numeroDeNos(No raiz) {
		if (raiz == null)
			return 0;
		else
			return numeroDeNos(raiz.esquerda) + numeroDeNos(raiz.direita) + 1;
	}

	/* 3) */
	public int somaDasChaves(No raiz) {
		if (raiz == null)
			return 0;
		else
			return raiz.chave + somaDasChaves(raiz.direita) + somaDasChaves(raiz.esquerda);
	}

	/* 4) */
	public void mostrarFolhas(No raiz) {
		if (raiz == null)
			return;
		mostrarFolhas(raiz.esquerda);
		if (raiz.numeroFilhos() == 0)
			System.out.println(raiz.chave);
		mostrarFolhas(raiz.direita);
	}

	/* 5) */
	public int alturaArvore(No raiz) {
		if (raiz == null)
			return 0;
		int a = alturaArvore(raiz.direita);
		int b = alturaArvore(raiz.esquerda);
		if (a > b)
			return a + 1;
		else
			return b + 1;
	}

	/* 6) */
	public int maiorElemento(No raiz) {
		if (raiz == null)
			return 0;
		if (raiz.direita == null)
			return raiz.chave;
		else
			return maiorElemento(raiz.direita);
	}

	public int menorElemento(No raiz) {
		if (raiz == null)
			return 0;
		if (raiz.esquerda == null)
			return raiz.chave;
		else
			return menorElemento(raiz.esquerda);
	}
}

public class Main {
	static int indice = 0;

	public static void emOrdemModificado(int vet[], No raiz) {
		if (raiz != null) {
			emOrdemModificado(vet, raiz.esquerda);
			vet[indice] = raiz.chave;
			indice++;
			emOrdemModificado(vet, raiz.direita);
		}
	}

	public static void ordenarVetor(int vet[]) {
		ArvoreBinaria ab = new ArvoreBinaria();

		for (int i = 0; i < vet.length; i++) {
			ab.insere(vet[i]);
		}

		emOrdemModificado(vet, ab.getRaiz());
	}

	public static void main(String[] args) {
		System.out.println("Arvore Binaria (de numeros inteiros)");
		ArvoreBinaria ab = new ArvoreBinaria();

		ab.insere(5);
		ab.insere(7);
		ab.insere(3);
		ab.insere(2);
		ab.insere(1);
		ab.insere(9);
		ab.insere(8);
		ab.insere(4);
		ab.insere(6);

		System.out.println("Inserindo 5, 7, 3, 2, 1, 9, 8, 4, 6\n\n" + "A arvore em ordem sera assim: " + ab.emOrdem());
		System.out.println(ab);
		/* 2) */System.out.println("Esta arvore tem " + ab.numeroDeNos(ab.getRaiz()) + " nós");
		/* 3) */System.out.println("Soma das chaves " + ab.somaDasChaves(ab.getRaiz()));
		/* 4) */System.out.println("Folhas desta arvore: ");
		ab.mostrarFolhas(ab.getRaiz());
		/* 5) */System.out.println("A altura da arvore é: " + ab.alturaArvore(ab.getRaiz()));
		/* 6) */System.out.println("O maior elemento da árvore é: " + ab.maiorElemento(ab.getRaiz()));
		/* 6) */System.out.println("O menor elemento da árvore é: " + ab.menorElemento(ab.getRaiz()));
		System.out.println("\nRemovendo o 5 ......");
		ab.remove(ab.procurar(5));
		System.out.println(ab);
		System.out.println("\nRemovendo o 8 ......");
		ab.remove(ab.procurar(8));
		System.out.println(ab);
		System.out.println("\nRemovendo o 3 ......");
		ab.remove(ab.procurar(3));
		System.out.println(ab);
		System.out.println("O antecessor de " + ab.getRaiz().chave + " eh " + ab.getRaiz().antecessor()
				+ " e o sucessor eh " + ab.getRaiz().sucessor());
		System.out.println("\nTestando o metodo ordenarVetor:\nAntes: ");
		int vet[] = { 6, 3, 8, -1, 10, 13, 7 };
		for (int i = 0; i < vet.length; i++)
			System.out.print(vet[i] + " ");
		ordenarVetor(vet);
		System.out.println("\nDepois: ");
		for (int i = 0; i < vet.length; i++)
			System.out.print(vet[i] + " ");
	}
}