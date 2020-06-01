package CRUD;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import ConexaoBD.ConnectionFactory;
import MetodosGerais.MetodosDeApoio;
import Produto.Produto;

public class Update {
	public static void updateMenu() {
		System.out.println("Deseja atualizar arquivos do banco?(s/n)");

		char resposta = MetodosDeApoio.obterInputTratado('s', 'n');

		if (resposta == 's') {
			System.out.println("Gerando lista de registros no banco...\n");

			List<Produto> listaDeProduto = Read.gerarListaDeProduto(-1);

			System.out.println("Selecione o IdProduto do registro que deseja alterar");
			int idProdutoSelecionado = MetodosDeApoio.obterInputTratado(1, 999999999);

			Produto produtoSelecionado = null;

			for (Produto elemento : listaDeProduto) {
				if (elemento.getIdProduto() == idProdutoSelecionado) {
					produtoSelecionado = elemento;
					break;
				}
			}

			if (produtoSelecionado != null) {

				Produto produto = new Produto();
				System.out.println("Produto selecionado: " + produtoSelecionado.getNomeProduto());

				int index = 1;
				Field[] listaAtributosObj = produto.getClass().getDeclaredFields();

				for (Field atributo : listaAtributosObj) {
					System.out.println(index + " - " + atributo.getName());
					index++;
				}

				System.out.println("Selecione o campo que deseja alterar:");
				int campoSelecionado = MetodosDeApoio.obterInputTratado(1, listaAtributosObj.length);

				String nomeCampo = null;
				index = 1;

				for (Field campo : listaAtributosObj) {
					if (index == campoSelecionado) {
						nomeCampo = campo.getName();
						break;
					}
					index++;
				}
				Scanner scan = new Scanner(System.in);
				if (campoSelecionado == 1) {
					System.out.println("Não é possível alterar o idProduto de um produto\n");

				} else if (nomeCampo.contains("data")) {
					System.out.println("Infelizmente ainda não estamos atualizando datas.\nTecle Enter para continuar.\n");
					scan.nextLine();
				}
				else {
					System.out.println("Campo selecionado: " + nomeCampo);

					System.out.println("Informe o novo valor do campo " + nomeCampo);

					if (nomeCampo.equals("valorCompra")) {

						Double novoValor = scan.nextDouble();
						System.out.println("\nExecutando o update...");
						update(idProdutoSelecionado, nomeCampo, novoValor);

					} else {
						String novoValor = scan.nextLine();
						System.out.println("\nExecutando o update...");
						update(idProdutoSelecionado, nomeCampo, novoValor);
					}

				}
			} else {
				System.out.println("Não foi encontrado nenhum produto com o id escolhido.\n");
			}
		}
	}

	public static void update(int idProduto, String nomeCampo, String novoValor) {
		try {
			Connection con = ConnectionFactory.getConnection();

			String query = String.format("Update produto set %s = ? where id_produto = ?", nomeCampo);

			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, novoValor);
			statement.setInt(2, idProduto);

			statement.executeUpdate();

			System.out.println("Valores atualizados com sucesso.");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void update(int idProduto, String nomeCampo, Double novoValor) {
		try {
			Connection con = ConnectionFactory.getConnection();

			String query = String.format("Update produto set %s = ? where id_produto = ?", nomeCampo);

			PreparedStatement statement = con.prepareStatement(query);
			statement.setDouble(1, novoValor);
			statement.setInt(2, idProduto);

			statement.executeUpdate();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
