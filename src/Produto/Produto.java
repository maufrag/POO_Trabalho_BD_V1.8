package Produto;

import java.util.Date;

public class Produto {

	public Produto(Date now) {
		dataCadastro = new java.sql.Date(now.getTime());
		dataVencimento = new java.sql.Date(now.getTime());
	}
	public Produto() {}

	private int idProduto;
	private String nomeProduto;
	private String descricao;
	private Date dataCadastro;
	private Date dataVencimento;
	private double valorCompra;

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
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public double getValorCompra() {
		return valorCompra;
	}
	
	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
	
	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nomeProduto=" + nomeProduto + ", descricao=" + descricao
				+ ", DataCadastro=" + dataCadastro + ", DataVencimento=" + dataVencimento + ", ValorCompra="
				+ valorCompra + "]";
	}
}
