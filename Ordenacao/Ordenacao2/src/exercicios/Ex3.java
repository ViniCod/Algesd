package exercicios;

import java.util.Arrays;

public class Ex3 {
	public static void main(String[] args) {
		int vet[] = { 5, 6, 1, 3, 2, 4, 10, 7, 9, 8 };
		System.out.println("Antes: " + Arrays.toString(vet));
		selecao(vet);
		System.out.println("Depois: " + Arrays.toString(vet));
	}

	public static void selecao(int vet[]) {
		for (int i = 0; i < vet.length - 1; i++) {
			int indMaior = i;
			for (int j = i + 1; j < vet.length; j++) {
				if (vet[j] > vet[indMaior])
					indMaior = j;
			}
			int aux = vet[i];
			vet[i] = vet[indMaior];
			vet[indMaior] = aux;
		}
	}
}