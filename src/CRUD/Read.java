package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import ConexaoBD.ConnectionFactory;
import MetodosGerais.MetodosDeApoio;

public class Read {
	public static void readMenu() {
		System.out.println("\nGostaria de selecionar registros do banco?\n");
		listarOpcoes();
		int resposta = MetodosDeApoio.obterInputTratado(1, obterItensMenu().size());
		irParaOpcaoSelecionada(resposta);
	}

	public static void listarOpcoes() {

		MetodosDeApoio.listarMenu(obterItensMenu());
	}

	public static List<String> obterItensMenu() {
		return Arrays.asList("Selecionar todos os registros.", "Selecionar uma quantidade limitada de registros.",
				"Selecionar um registro especifico", "Selecionar elementos especificos de todos os registros",
				"Selecionar elementos especificos de uma quantidade limitada de registros",
				"Selecionar elementos especificos de um registro especifico");
	}

	public static void irParaOpcaoSelecionada(int resposta) {// TODO
		switch (resposta) {
		case 1:
			simpleSelectQuery("aa");
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		default:
			System.out.println("Como vim parar aqui?");
			break;
		}
	}

	public static void simpleSelectQuery(String query) { // TODO
		try {
			Connection con = ConnectionFactory.getConnection();
			String selectQuery = "Select * from produto";
			PreparedStatement statement = con.prepareStatement(selectQuery);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String nome = rs.getString("nome_produto");
				System.out.println(nome);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
