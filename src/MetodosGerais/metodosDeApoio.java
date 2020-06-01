package MetodosGerais;

import java.util.List;
import java.util.Scanner;

public class MetodosDeApoio {

	public static Boolean isNullOrWhiteSpace(String texto) {
		if (texto == null)
			return true;
		if (texto.isEmpty())
			return true;

		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) != ' ') {
				return false;
			}
		}
		return true;
	}

	public static int obterInputTratado(int valorLimite1, int valorLimite2) {
		Scanner scan = new Scanner(System.in);
		Boolean valido = false;
		int valorFinal = -1;
		do {
			String valor = scan.nextLine();
			valido = isInteger(valor);
			if (valido) {
				valorFinal = Integer.parseInt(valor);
				if ((valorFinal < valorLimite1) || (valorFinal > valorLimite2)) {
					valido = false;
					System.out.println("O valor precisa estar dentro dos valores listados.");
				}
			} else {
				System.out.println("Por favor insira um valor correto.");
			}

		} while (!valido);
		scan.close();
		return valorFinal;
	}

	public static boolean isInteger(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			Integer.parseInt(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static boolean isChar(String strChar) {
		if (strChar == null)
			return false;
		else if (strChar.length() > 1)
			return false;
		else
			return true;
	}

	public static char obterInputTratado(char opcao1, char opcao2) {
		Scanner scan = new Scanner(System.in);
		Boolean valido = false;
		char valorFinal = ' ';
		do {
			String valor = scan.nextLine();
			valido = isChar(valor);
			if (valido) {
				valorFinal = valor.toLowerCase().charAt(0);
				if (valorFinal != opcao1 && valorFinal != opcao2) {
					System.out.println(String.format("O valor precisa ser %c ou %c.", opcao1, opcao2));
					valido = false;
				}
			} else {
				System.out.println("Por favor insira um valor correto.");
			}
		} while (!valido);
		scan.close();
		return valorFinal;
	}

	public static void listarMenu(List<String> listaMenu) {
		System.out.println("Informe o valor correspondente a operação que deseja realizar");
		int index = 1;
		for (String menu : listaMenu) {
			System.out.println(index + " - " + menu);
			index++;
		}
	}
}
