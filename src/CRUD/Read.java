package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ConexaoBD.ConnectionFactory;
import MetodosGerais.MetodosDeApoio;
import Produto.Produto;

public class Read {
	public static void readMenu() {
		System.out.println("\nComo você deseja selecionar registros do banco?\n");
		listarOpcoes();
		int resposta = MetodosDeApoio.obterInputTratado(1, obterItensMenu().size());
		int quantidadeMaxima = resposta == 2 ? MetodosDeApoio.obterInputTratado(1, 1000) : 0;
		irParaOpcaoSelecionada(resposta, quantidadeMaxima);
		System.out.println("Gerando resultando...");
	}

	public static void listarOpcoes() {
		MetodosDeApoio.listarMenu(obterItensMenu());
	}

	public static List<String> obterItensMenu() {
		return Arrays.asList("Selecionar todos os registros.", "Selecionar uma quantidade limitada de registros.");
	}

	public static void irParaOpcaoSelecionada(int resposta, int quantidadeMaxima) {
		switch (resposta) {
		case 1:
			select(-1);
			break;
		case 2:
			select(quantidadeMaxima);
			break;
		}
	}

	public static void select(int limiteSolicitado) {
		gerarListaDeProduto(limiteSolicitado);
	}

	public static List<Produto> gerarListaDeProduto(int limiteSolicitado) {
		String selectQuery = montarQuerySelect(limiteSolicitado);

		List<Produto> listaDeProduto = new ArrayList<Produto>();
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement statement = con.prepareStatement(selectQuery);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();
				produto.setIdProduto(rs.getInt("id_Produto"));
				produto.setNomeProduto(rs.getString("nomeProduto"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setDataCadastro(rs.getDate("dataCadastro"));
				produto.setDataVencimento(rs.getDate("dataVencimento"));
				produto.setValorCompra(rs.getDouble("valorCompra"));
				listaDeProduto.add(produto);
				System.out.println(produto.toString());
			}
			con.close();
			System.out.println("\nResultados gerados com sucesso!\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaDeProduto;
	}

	public static String montarQuerySelect(int limite) {
		String queryInicial = "Select * from produto";
		String complementoLimit = String.format(" LIMIT %d", limite);
		queryInicial = limite >= 0 ? queryInicial + complementoLimit : queryInicial;

		return queryInicial;
	}
}
