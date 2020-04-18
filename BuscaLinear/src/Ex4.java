import javax.swing.*;

public class Ex4 {
	public static int buscaLinearReversa(int vet[], int procurado) {
		for (int i = vet.length - 1; i >= 0; i--) {
			if (vet[i] == procurado)
				return i;
		}
		return -1;
	}

	public static void main(String args[]) {
		int x[] = { -5, 0, 1, 2, 3, 4, 5, 8, 9 };

		int proc = Integer.parseInt(JOptionPane.showInputDialog("Qual o número procurado?"));
		int resp = buscaLinearReversa(x, proc);

		if (resp == -1)
			JOptionPane.showMessageDialog(null, "Não existe no vetor");
		else
			JOptionPane.showMessageDialog(null, "Está no índice " + resp);
	}
}