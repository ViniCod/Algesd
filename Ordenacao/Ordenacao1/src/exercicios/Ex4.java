package exercicios;

import java.util.Arrays;

public class Ex4 {
	public static void main(String[] args) {
		int vet1[] = { 5, 6, 1, 3, 2, 4, 10, 7, 9, 8 };
		System.out.println("Vetor 1: " + Arrays.toString(vet1));
		int vet2[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("Vetor 2: " + Arrays.toString(vet2));
	}

	public static boolean ordenado(int vet[]) {
		for (int i = 1; i < vet.length; i++) {
			if (vet[i - 1] > vet[i]) {
				return false;
			}
		}
		return true;
	}
}