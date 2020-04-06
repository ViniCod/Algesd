package exercicios;

public class Ex5 {
	public static void main(String args[]) {

		String saida1 = "\nMetodo da Bolha 1\n";
		String saida2 = "\nMetodo da Bolha 2\n";
		String saida3 = "\nMetodo da Bolha 3\n";

		for (int tam = 5000; tam <= 40000; tam = tam + 5000) {
			int vet1[] = new int[tam];

			// Preenchendo o vetor com elementos aleatorios de 0 a 999
			for (int i = 0; i < tam; i++)
				vet1[i] = (int) (Math.random() * 1000);

			long tempoAntes = System.currentTimeMillis();
			bolha1(vet1);
			long tempoDepois = System.currentTimeMillis();
			saida1 += "Tamanho = " + tam + "  => Tempo = " + (tempoDepois - tempoAntes) + " ms\n";
		}

		System.out.println(saida1);

		for (int tam = 5000; tam <= 40000; tam = tam + 5000) {
			int vet1[] = new int[tam];

			// Preenchendo o vetor com elementos aleatorios de 0 a 999
			for (int i = 0; i < tam; i++)
				vet1[i] = (int) (Math.random() * 1000);

			long tempoAntes = System.currentTimeMillis();
			bolha2(vet1);
			long tempoDepois = System.currentTimeMillis();
			saida2 += "Tamanho = " + tam + "  => Tempo = " + (tempoDepois - tempoAntes) + " ms\n";
		}

		System.out.println(saida2);
		for (int tam = 5000; tam <= 40000; tam = tam + 5000) {
			int vet1[] = new int[tam];

			// Preenchendo o vetor com elementos aleatorios de 0 a 999
			for (int i = 0; i < tam; i++)
				vet1[i] = (int) (Math.random() * 1000);

			long tempoAntes = System.currentTimeMillis();
			bolha3(vet1);
			long tempoDepois = System.currentTimeMillis();
			saida3 += "Tamanho = " + tam + "  => Tempo = " + (tempoDepois - tempoAntes) + " ms\n";
		}

		System.out.println(saida3);
	}

	public static void bolha1(int vet[]) {
		for (int i = 1; i <= vet.length - 1; i++)
			for (int j = 0; j < vet.length - 1; j++)
				if (vet[j] > vet[j + 1]) {
					int aux = vet[j];
					vet[j] = vet[j + 1];
					vet[j + 1] = aux;
				}
	}

	public static void bolha2(int vet[]) {
		for (int i = 1; i <= vet.length - 1; i++)
			for (int j = 0; j < vet.length - i; j++)
				if (vet[j] > vet[j + 1]) {
					int aux = vet[j];
					vet[j] = vet[j + 1];
					vet[j + 1] = aux;
				}
	}

	public static void bolha3(int vet[]) {
		int aux;
		boolean troca;
		int j = vet.length - 1;

		do {
			troca = false;
			for (int i = 0; i < j; i++)
				if (vet[i] > vet[i + 1]) {
					aux = vet[i];
					vet[i] = vet[i + 1];
					vet[i + 1] = aux;
					troca = true;
				}
			j--;
		} while (troca);
	}
}