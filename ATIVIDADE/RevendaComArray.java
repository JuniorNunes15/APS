package main;

public class RevendaComArray {
	
	private Produto[] produtos;
	private int indice = 0;
	
	private int maxIndice; //variavel auxiliar criada para manter o tamanho total que o vetor vai suportar
	private boolean find; //variavel auxiliar criada para em certos momentos dizer se foi alterado um valor, como a parte do metodo de comprar, que é utilizado para verificar se encontrou o produto, e assim não imprimir o print no final do metodo
	
	
	public RevendaComArray(int tam) { //construtor que inicia o vetor setando o tamanho e
		produtos = new Produto[tam];
		maxIndice = tam;
	}
	
	public void inserirProduto(Produto p) { //insere no vetor o produto
		if(indice < maxIndice) { //caso não estiver cheio, adiciona e incrementa o indice
			this.produtos[indice] = p;
			indice++;
		}
		else { //caso tiver cheio, não incrementa e mostra uma mensagem de erro
			System.out.println("O programa ja chegou em seu tamanho maximo, impossivel adicionar!! \n");
		}
	}
	
	public void comprar(int codigo, int qtdEmEstoque) { //metodo que compra mais quantidade do produto e incrementa
		find = false; //seta o find para falso, para o caso de ter sido modificado, e não dar a resposta errada
		for(int i = 0; i < indice; i++) {
			if(produtos[i].getCodigo() == codigo) { //quando encontra o produto que quero, adiciona no total da quantidade desse produto
				produtos[i].compra(qtdEmEstoque); //chama a funcão de comprar da classe produto, e adiciona na quantiddade
				find = true; //seta find para true para não entrar no if depois do for
				System.out.println("ADICIONADO " + qtdEmEstoque + " NO PRODUTO " + codigo + "\n");
			}
		}
		if(!find) {
			System.out.println("ERRO!! O PRODUTO NÃO EXISTE NO ESTOQUE \n");
		}
	}
	
	public void vender(int codigo, int qtdEmEstoque) {
		find = false;
		for(int i = 0; i < indice; i++) {
			if(produtos[i].getCodigo() == codigo) {
				if(qtdEmEstoque > produtos[i].getQtdEmEstoque()) { //caso a quantidade que queira tirar de produtos seja maior que o existente no esttoque, então ele apenas seta a quantidade para zero
					produtos[i].setQtdEmEstoque(0);
					System.out.println("COMPRADO APENAS "+ qtdEmEstoque + " ITENS DO PRODUTO " + codigo + " POIS NÃO EXISTEM MAIS NO ESTOQUE PARA VENDER!\n");
				}
				else { //caso a quanttidade seja maior que o numero existente no estoque
					produtos[i].venda(qtdEmEstoque); //chama o metodo venda da classe produto e decrementa o numero de itens do estoque
					System.out.println("VENDIDO "+ qtdEmEstoque + " ITENS DO PRODUTO " + codigo + "\n");
				}
				find = true;
			}
		}
		if(!find) {
			System.out.println("ERRO!! O PRODUTO NÃO EXISTE NO ESTOQUE! \n");
		}
	}
	
	public double consultarPrecoVenda(int codigo) { //consulta o preco passando por toda, ou quase todo o vetor procurando o que possui o codigo passado
		for(int i = 0; i < indice; i++) {
			if(produtos[i].getCodigo() == codigo) { //quando encontra retorna o atributo do valor da compra
				return produtos[i].getValorDeCompra();
			}
		}
		System.out.println("ERRO!! O PRODUTO NÃO EXISTE NO ESTOQUE");
		return 0; //se não encotrar, mostra uma mensagem de erro e retorna zero, mostrando que não ter valor
	}
	
	public void listarPrecos() {//lista os produtos
		for(int i = 0; i < indice; i++) {
			System.out.println("CÓDIGO: " + produtos[i].getCodigo() + " DESCRIÇÃO: " + produtos[i].getDescricao() 
					+ " VALOR DE VENDA:" + produtos[i].getValorDeCompra() + " QUANTIDADE EM ESTOQUE: " + produtos[i].getQtdEmEstoque());
		}
		System.out.println("\n"); 
	}
	
	public Produto procuraIndice(int codigo) { //funcao auxiliar criada para pegar um produto no vetor, utilixado nas opcoes 6 ate a 10 do menu da main
		find = false; //seta find para falso, para o caso de encotrar o produto, tranformar em true e na main poder mostrar mostrar ou não as mensagens
		for(int i = 0; i < indice; i++) {
			if(codigo == produtos[i].getCodigo()) {
				find = true;
				return produtos[i];
			}
		}
		return produtos[0];
	}

	
	public boolean isFind() { //get do atributo find, para poder pagar o valor na main
		return find;
	}
	
}
