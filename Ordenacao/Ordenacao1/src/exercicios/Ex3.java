package exercicios;

import java.util.Arrays;

public class Ex3 {
	public static void main(String[] args) {
		int vet[] = { 5, 6, 1, 3, 2, 4, 10, 7, 9, 8 };
		System.out.println("Antes: " + Arrays.toString(vet));
		bolha2(vet);
		System.out.println("Depois: " + Arrays.toString(vet));
	}

	public static void bolha2(int vet[]) {
		for (int i = 1; i <= vet.length - 1; i++)
			for (int j = 0; j < vet.length - i; j++)
				if (vet[j] < vet[j + 1]) {
					int aux = vet[j];
					vet[j] = vet[j + 1];
					vet[j + 1] = aux;
				}
	}
}