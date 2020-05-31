package main;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import CRUD.*;

public class arquivoMain {

	public static void main(String[] args) {
		montarMenu();
	}

	public static void montarMenu() {
		int valor = -1;
		do {
			System.out.println("Informe o valor correspondente a operação que deseja realizar");
			List<String> listaMenu = listarMenu();
			int valorMenu = 1;
			for (String menu : listaMenu) {
				System.out.println(valorMenu + " - " + menu);
				valorMenu++;
			}

			valor = obterInputTratado(1, 5);
			irParaOpcaoSelecionada(valor);

		} while (valor != 5);
		System.out.println("Programa encerrado");
	}

	public static List<String> listarMenu() {
		return Arrays.asList("Create", "Read", "Update", "Delete", "Sair");
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
		return valorFinal;
	}

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
				if ((valorFinal >= valorLimite1) && (valorFinal <= valorLimite2)) {
					// valido = true;
				} else {
					valido = false;
					System.out.println("O valor precisa estar dentro dos valores listados.");
				}

			} else {
				System.out.println("Por favor insira um valor correto.");
			}

		} while (!valido);

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

	public static void irParaOpcaoSelecionada(int numeroOpcao) {
		switch (numeroOpcao) {
		case 1:
			create.menuCreate();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}
	}
}
