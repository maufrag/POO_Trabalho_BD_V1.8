package CRUD;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import ConexaoBD.ConnectionFactory;
import MetodosGerais.MetodosDeApoio;
import Produto.Produto;

public class Update {
	public static void updateMenu() {
		System.out.println("Deseja atualizar arquivos do banco?(s/n)");
		char resposta = MetodosDeApoio.obterInputTratado('s', 'n');
		if (resposta == 's') {
			System.out.println("Gerando lista de registros no banco...");

			List<Produto> listaDeProduto = Read.gerarListaDeProduto(null, -1);

			for (Produto produto : listaDeProduto) {
				produto.toString();
				System.out.println();
			}

			Produto produto = new Produto();
			System.out.println("Selecione o IdProduto do registro que deseja alterar\n");
			int idProdutoSelecionado = MetodosDeApoio.obterInputTratado(1, 999999999);
			
			
			
			int index = 1;
			Field[] listaAtributosObj = produto.getClass().getDeclaredFields();
			
			for (Field atributo : listaAtributosObj) {
				System.out.println(index + " - " + atributo.getName());
				index++;
			}
			
			System.out.println("Selecione o campo que deseja alterar:");
			int campoSelecionado = MetodosDeApoio.obterInputTratado(1, listaAtributosObj.length);
			
			
			
			//Read.select(null, -1);

		}
	}

	public static void update(int idProduto, Produto produtoOriginal, Produto novoProduto) {
		try {
			Connection con = ConnectionFactory.getConnection();
			String query = String.format("Update produto set ? = ? where id_produto = %d", idProduto);
			PreparedStatement statement = con.prepareStatement(query);

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
