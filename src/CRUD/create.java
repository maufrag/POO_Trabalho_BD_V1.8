package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import Produto.Produto;
import ConexaoBD.ConnectionFactory;
import MetodosGerais.*;

public class Create {

	public static void menuCreate() {
		System.out.println("Gostaria de cadastrar um produto?(s/n)");
		char resposta = MetodosDeApoio.obterInputTratado('s', 'n');
		if (resposta == 's') {
			Scanner scan = new Scanner(System.in);
			Produto produto = new Produto(new Date());

			System.out.println("Informe o nome do produto:");
			produto.setNomeProduto(scan.nextLine());

			System.out.println("Informe a descrição do produto:");
			produto.setDescricao(scan.nextLine());

			System.out.println("Informe o valor de compra:");
			produto.setValorCompra(scan.nextDouble());
			
			System.out.println("Inserindo dados na tabela...");
			
			insertInto(produto);
			
		}
	}

	public static void insertInto(Produto produto) {
		try {
			Connection con = ConnectionFactory.getConnection();
			String insertQuery = String.format(
					"insert into produto(nome_produto, descricao, data_cadastro, data_vencimento, valor_compra) values (?, ?, ?, ?, ?)");
			PreparedStatement statement = con.prepareStatement(insertQuery);
			statement.setString(1, produto.getNomeProduto());
			statement.setString(2, produto.getDescricao());
			statement.setDate(3, (java.sql.Date) produto.getDataCadastro());
			statement.setDate(4, (java.sql.Date) produto.getDataVencimento());
			statement.setDouble(5, produto.getValorCompra());
			statement.execute();
			con.close();
			System.out.println("Valores inseridos com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
