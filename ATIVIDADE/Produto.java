package main;

public class Produto {
	
	private int codigo;
	private String descricao;
	private double valorDeCompra; //valor de compra sera decidido pela funcao calculaPrecoVenda
	private double custo;
	private double margemDeLucro;
	private int qtdEmEstoque;
	
	
	public Produto() { //construtor padrão
		
	}
	
	public Produto(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Produto(int codigo, String descricao, double valorDeCompra, double custo, double margemDeLucro) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valorDeCompra = valorDeCompra;
		this.custo = custo;
		this.margemDeLucro = margemDeLucro;
	}

	public Produto(int codigo, String descricao, double valorDeCompra, double custo, double margemDeLucro, int qtdEmEstoque) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valorDeCompra = valorDeCompra;
		this.custo = custo;
		this.margemDeLucro = margemDeLucro;
		this.qtdEmEstoque = qtdEmEstoque;
	}
	

	public void compra(int quantidade) {
		qtdEmEstoque = qtdEmEstoque + quantidade;
	}
	
	public void venda(int quantidade) {
		qtdEmEstoque = qtdEmEstoque - quantidade;
	}
	
	public double calculaPrecoVenda() {
		return valorDeCompra + custo + margemDeLucro*(valorDeCompra + custo);
	}
	
	
	//geters e seters dos atributos
	public double getValorDeCompra() {
		return valorDeCompra;
	}

	public void setValorDeCompra(double valorDeCompra) {
		this.valorDeCompra = valorDeCompra;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	public double getMargemDeLucro() {
		return margemDeLucro;
	}

	public void setMargemDeLucro(double margemDeLucro) {
		this.margemDeLucro = margemDeLucro;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtdEmEstoque() {
		return qtdEmEstoque;
	}

	public void setQtdEmEstoque(int qtdEmEstoque) {
		this.qtdEmEstoque = qtdEmEstoque;
	}
	
}
