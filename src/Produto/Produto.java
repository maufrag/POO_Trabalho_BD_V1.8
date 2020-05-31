package Produto;

import java.util.Date;

public class Produto {

	public Produto(Date now) {
		DataCadastro = new java.sql.Date(now.getTime());
		DataVencimento = new java.sql.Date(now.getTime());
	}
	public Produto() {}

	private int idProduto;
	private String nomeProduto;
	private String descricao;
	private Date DataCadastro;
	private Date DataVencimento;
	private double ValorCompra;

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

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
		this.ValorCompra = valorCompra;
	}
	
	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nomeProduto=" + nomeProduto + ", descricao=" + descricao
				+ ", DataCadastro=" + DataCadastro + ", DataVencimento=" + DataVencimento + ", ValorCompra="
				+ ValorCompra + "]";
	}
}
