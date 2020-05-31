package Produto;

import java.util.Date;

public class Produto {

	public Produto() {
		Date now = new Date();
		DataCadastro = new java.sql.Date(now.getTime());
		DataVencimento = new java.sql.Date(now.getTime());
	}

	private String nomeProduto;
	private String descricao;
	private Date DataCadastro;
	private Date DataVencimento;
	private double ValorCompra;

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCadastro() {
		return DataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		DataCadastro = dataCadastro;
	}

	public Date getDataVencimento() {
		return DataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		DataVencimento = dataVencimento;
	}

	public double getValorCompra() {
		return ValorCompra;
	}

	public void setValorCompra(double valorCompra) {
		ValorCompra = valorCompra;
	}

	public void listar() {
		System.out.println(Produto.class.getDeclaredFields());
	}
}
