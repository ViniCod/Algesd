package Ex2;

import java.util.*;

public class PilhaPalindrome {
	public static void main(String[] args) {
		Pilha p1 = new Pilha(50);
		Scanner leitura = new Scanner(System.in);
		System.out.println("Entre com a palavra ou frase");
		String entrada = leitura.nextLine();

		for (int i = 0; i < entrada.length(); i++)
			p1.empilhar(entrada.charAt(i));

		String invertida = "";

		while (!p1.vazia()) {
			invertida += p1.desempilhar();
		}

		if (invertida.equals(entrada))
			System.out.println("É palindrome");
		else
			System.out.println("Não é palindrome");
	}
}