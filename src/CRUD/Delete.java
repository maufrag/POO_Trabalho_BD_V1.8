package CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ConexaoBD.ConnectionFactory;
import MetodosGerais.MetodosDeApoio;

public class Delete {
	public static void deleteMenu() {
		System.out.println("Tem certeza que deseja deletar algum registro?(s/n)");
		char resposta = MetodosDeApoio.obterInputTratado('s', 'n');
		if (resposta == 's') {
			System.out.println("Gerando lista de produtos...\n");

			Read.gerarListaDeProduto(-1);

			System.out.println("Selecione o IdProduto do registro que deseja deletar");
			int idProdutoSelecionado = MetodosDeApoio.obterInputTratado(1, 999999999);

			System.out.println("Tem certeza que deseja excluir o produto?(s/n)");
			char confirmacao = MetodosDeApoio.obterInputTratado('s', 'n');
			if (confirmacao == 's') {
				System.out.println("Excluindo dados...");
				delete(idProdutoSelecionado);
			}
		}
	}

	public static void delete(int idProduto) {
		String query = "delete from produto where id_produto = ?";
		try {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(1, idProduto);
		statement.execute();
		con.close();
		System.out.println("Dados excluidos com sucesso!");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
