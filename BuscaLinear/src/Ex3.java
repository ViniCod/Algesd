import javax.swing.*;

public class Ex3 {
	public static int buscarString(String[] vet, String procurado) {
		for (int i = 0; i < vet.length; ++i) {
			if (vet[i].equalsIgnoreCase(procurado)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		String x[] = { "Ana", "Bia", "Karol", "May" };

		String proc = JOptionPane.showInputDialog("Qual o nome procurado?");
		int resp = buscarString(x, proc);

		if (resp == -1)
			JOptionPane.showMessageDialog(null, "Não existe no vetor");
		else
			JOptionPane.showMessageDialog(null, "Está no índice " + resp);
	}
}