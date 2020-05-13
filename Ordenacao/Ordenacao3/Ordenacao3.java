import java.util.*;

public class Ordenacao3 {

	public static void selecaoString(String vet[]) {

		for (int i = 0; i < vet.length - 1; i++) {
			int indMenor = i;
			for (int j = i + 1; j < vet.length; j++) {
				if (vet[j].compareTo(vet[indMenor]) < 0)
					indMenor = j;
			}
			String aux = vet[i];
			vet[i] = vet[indMenor];
			vet[indMenor] = aux;
			System.out.println("DEBUG: " + Arrays.toString(vet));

		}
	}

	public static void selecao(int vet[]) {
		int cont = 0;
		for (int i = 0; i < vet.length; i++) {
			for (int j = i + 1; j < vet.length; j++) {
				cont++;
				if (vet[j] > vet[i]) {
					int aux = vet[i];
					vet[i] = vet[j];
					vet[j] = aux;
				}
			}
		}
		System.out.println("=> Quantidade de comparações = " + cont);

	}

	public static void selecaoDecrescente(int vet[]) {
		for (int i = 0; i < vet.length - 1; i++) {
			int indMenor = i;
			for (int j = i + 1; j < vet.length; j++) {
				if (vet[j] > vet[indMenor])
					indMenor = j;
			}
			int aux = vet[i];
			vet[i] = vet[indMenor];
			vet[indMenor] = aux;
			System.out.println("DEBUG: " + Arrays.toString(vet));
		}

	}

	public static void selecao2(int vet[]) {
		for (int i = 0; i < vet.length; i++) {
			int menor = indiceMenorElemento(vet, i);
			int aux = vet[i];
			vet[i] = vet[menor];
			vet[menor] = aux;
		}

	}

	public static int indiceMenorElemento(int vet[], int inicio) {
		int menor = inicio;
		for (int i = inicio + 1; i < vet.length; i++) {
			if (vet[menor] > vet[i])
				menor = i;
		}
		return menor;
	}

	public static void main(String args[]) {
		/*
		 * int vet[] = { 10, 58, 96, 63, 23, 14, 75, 85, 27, 55, 9 };
		 * System.out.println("Antes: " + Arrays.toString(vet)); selecao(vet);
		 * System.out.println("Depois: " + Arrays.toString(vet));
		 * 
		 * // String String vet2[] = { "Daniel", "Marcos", "Ana", "Bia", "Viviane",
		 * "Julia", "Andressa", "Ricardo", "Bruna", "Luiz", "Rodolfo", "Danilo" };
		 * System.out.println("Antes: " + Arrays.toString(vet2)); selecaoString(vet2);
		 * System.out.println("Depois: " + Arrays.toString(vet2));
		 * 
		 * int resp = indiceMenorElemento(vet, 0); System.out.println("O menor é " +
		 * resp + " e está no indice ");
		 * 
		 * System.out.println("Antes: " + Arrays.toString(vet)); selecao2(vet);
		 * System.out.println("Depois: " + Arrays.toString(vet));
		 * 
		 * System.out.println("Antes: " + Arrays.toString(vet));
		 * selecaoDecrescente(vet); System.out.println("Depois: " +
		 * Arrays.toString(vet));
		 */

		String saida2 = "\nMetodo da Seleção\n";

		for (int tam = 5000; tam <= 40000; tam += 5000) {
			int vet1[] = new int[tam];
			int vet2[] = new int[tam];

			// Preenchendo os vetores com elementos aleatorios de 0 a 999
			for (int i = 0; i < tam; i++)
				vet1[i] = vet2[i] = (int) (Math.random() * 1000);

			long tempoAntes = System.currentTimeMillis();
			selecao(vet1);
			long tempoDepois = System.currentTimeMillis();
			saida2 += "Tamanho = " + tam + "  => Tempo = " + (tempoDepois - tempoAntes) + " ms\n";

		}
		System.out.println(saida2);
	}

}