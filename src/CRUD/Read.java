package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			select(null, -1);
			break;
		case 2:
			select(null, 2);
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

	public static void select(int[] opcoesDesejadas, int limiteSolicitado) { // TODO
			gerarListaDeProduto(opcoesDesejadas, limiteSolicitado);
	}

	public static List<Produto> gerarListaDeProduto(int[] opcoesDesejadas, int limiteSolicitado) {
		String selectQuery = montarQuerySelect(limiteSolicitado);

		List<Produto> listaDeProduto = null;
		try {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement statement = con.prepareStatement(selectQuery);

		ResultSet rs = statement.executeQuery();

		Produto produto = null;

			while (rs.next()) {
				produto.setIdProduto(rs.getInt("id_produto"));
				produto.setNomeProduto(rs.getString("nome_produto"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setDataCadastro(rs.getDate("data_cadastro"));
				produto.setDataVencimento(rs.getDate("data_vencimento"));
				produto.setValorCompra(rs.getDouble("valor_compra"));
				listaDeProduto.add(produto);
			}
			con.close();
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
