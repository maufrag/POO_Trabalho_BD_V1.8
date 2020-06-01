package main;

import java.util.Arrays;
import java.util.List;
import CRUD.*;
import MetodosGerais.MetodosDeApoio;

public class ClasseMain {

	public static void main(String[] args) {
		System.out.println("Programa iniciado\n");
		montarMenu(obterItensMenu());
		System.out.println("\nPrograma encerrado");
	}

	public static void montarMenu(List<String> listaMenu) {
		int valor = -1;
		do {
			MetodosDeApoio.listarMenu(listaMenu);
			valor = MetodosDeApoio.obterInputTratado(1, listaMenu.size());
			irParaOpcaoSelecionada(valor);

		} while (valor != listaMenu.size());

	}

	public static List<String> obterItensMenu() {
		return Arrays.asList("Create", "Read", "Update", "Delete", "Sair");
	}

	public static void irParaOpcaoSelecionada(int numeroOpcao) {
		switch (numeroOpcao) {
		case 1:
			Create.menuCreate();
			break;
		case 2:
			Read.readMenu();
			break;
		case 3:
			Update.updateMenu();
			break;
		case 4:
			Delete.deleteMenu();
			break;
		}
	}
}
