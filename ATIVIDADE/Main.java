package main;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) { 
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int op = 1; //variavel para escolher as opcoes do menu
		//variaveis utilizada para mudar como auxiliar para a escrita com o scanner
		int x;
		int y;
		Produto aux; //um produto auxiliar para receber guardar um produto especifico do vetor
		
		System.out.println("\n \nAntes do programa iniciar, digite o tamanho total de Produtos que o prorama vai ter!");
		x = scan.nextInt();
		
		RevendaComArray revend = new RevendaComArray(x);
		
		while(op >= 1 && op <= 10) {
			printOpcoes();
			
			op = scan.nextInt();
			if(op == 1) {
				System.out.println("ADICIONE O NOVO PRODUTO");
				Produto produ = new Produto();
				System.out.println("Digite o Codigo: ");
				produ.setCodigo(scan.nextInt());
				System.out.println("Digite o Custo: ");
				produ.setCusto(scan.nextDouble());
				System.out.println("Digite a Descri��o: ");
				produ.setDescricao(scan.next());
				System.out.println("Digite a Margem de Lucro: ");
				produ.setMargemDeLucro(scan.nextDouble());
				System.out.println("Digite a Quantidade em Estoque: ");
				produ.setQtdEmEstoque(scan.nextInt());
				produ.setValorDeCompra(produ.calculaPrecoVenda());
				
				revend.inserirProduto(produ);
			}
			if(op == 2) {
				System.out.println("Digite o c�digo do produto que deseja comprar");
				x = scan.nextInt();
				System.out.println("Digite o n�mero de itens que ser� adicionado no produto!");
				y = scan.nextInt();
				revend.comprar(x, y);
			}
			if(op == 3) {
				System.out.println("Digite o c�digo do produto que deseja comprar");
				x = scan.nextInt();
				System.out.println("Digite o n�mero de itens que deseja vender do produto!");
				y = scan.nextInt();
				revend.vender(x, y);
			}
			if(op == 4) {
				revend.listarPrecos();
			}
			if(op == 5) {
				double preco;
				System.out.println("Digite o c�digo do produto que deseja ver o pre�o!");
				x = scan.nextInt();
				preco = revend.consultarPrecoVenda(x);
				System.out.println("O pre�o do produto " + x + " � " + preco + "\n");
			}
			if(op == 6) {
				System.out.println("Digite o c�digo do produto que deseja mudar o pre�o!");
				x = scan.nextInt();
				System.out.println("Digite  novo pre�o do produto!");
				y = scan.nextInt();
				aux = revend.procuraIndice(x);
				if(revend.isFind()) {
					aux.setValorDeCompra(y);
					System.out.println("O valor de compra foi mudado para " + y + "\n");
				}
				else {
					System.out.println("N�o existe o produto para poder mudar o pre�o! Procure por c�digos de produtos existentes! \n");
				}
				
			}
			if(op == 7) {
				System.out.println("Digite o c�digo do produto que deseja consultar o custo!");
				x = scan.nextInt();
				aux = revend.procuraIndice(x);
				if(revend.isFind()) {
					System.out.println("O valor do custo desse produto �: " + aux.getCusto() + "\n");
				}
				else {
					System.out.println("N�o existe o produto para poder consultar seu custo! Procure por c�digos de produtos existentes! \n");
				}
			}
			if(op == 8) {
				System.out.println("INFORMA��O: MUDANDO O CUSTO O PRE�O DO PRODUTO T�MBEM � ALTERADO!!");
				System.out.println("Digite o c�digo do produto que deseja mudar o custo!");
				x = scan.nextInt();
				System.out.println("Digite  novo pre�o do custo!");
				y = scan.nextInt();
				aux = revend.procuraIndice(x);
				if(revend.isFind()) {
					aux.setCusto(y);
					aux.setValorDeCompra(aux.calculaPrecoVenda());
					System.out.println("O valor do custo foi mudado para " + y + "\n");
				}
				else {
					System.out.println("N�o existe o produto para poder mudar o custo! Procure por c�digos de produtos existentes! \n");
				}
			}
			if(op == 9) {
				System.out.println("Digite o c�digo do produto que deseja consultar a Margem de lucro!");
				x = scan.nextInt();
				aux = revend.procuraIndice(x);
				if(revend.isFind()) {
					System.out.println("O valor da Margem de lucro desse produto �: " + aux.getMargemDeLucro() + "\n");
				}
				else {
					System.out.println("N�o existe o produto para poder consultar sua Magem de lucro! Procure por c�digos de produtos existentes! \n");
				}
			}
			if(op == 10) {
				System.out.println("INFORMA��O: MUDANDO A MARGEM DE LUCRO O PRE�O DO PRODUTO T�MBEM � ALTERADO!!");
				System.out.println("Digite o c�digo do produto que deseja mudar a Margem de lucro!");
				x = scan.nextInt();
				System.out.println("Digite  novo pre�o da Margem de lucro!");
				y = scan.nextInt();
				aux = revend.procuraIndice(x);
				if(revend.isFind()) {
					aux.setMargemDeLucro(y);
					aux.setValorDeCompra(aux.calculaPrecoVenda());
					System.out.println("A Margem de lucro foi mudado para " + y + "\n");
				}
				else {
					System.out.println("N�o existe o produto para poder mudar a Margem de lucro! Procure por c�digos de produtos existentes! \n");
				}
			}
		}
		
		System.out.println("SISTEMA FINALIZADO!!");

	}
	
	public static void printOpcoes() {
		System.out.println("Digite - 1 para criar um produto \nDigite - 2 para comprar um produto para o estoque \n"
				+ "Digite - 3 para vender um produto \nDigite - 4 para listar o pre�os \n"
				+ "Digite - 5 para consultar os pre�os \nDigite - 6 para alterar o valor de compra\n"
				+ "Digite - 7 para consultar o custo \nDigite - 8 para mudar o custo \n"
				+ "Digite - 9 para consutar a margem de lucro \nDigite - 10 para mudar a margem de lucro de um produto \n");
	}

}

