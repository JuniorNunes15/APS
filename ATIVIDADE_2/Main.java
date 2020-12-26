package Main;
import java.util.ArrayList;
import java.util.Scanner;

import Atores.*;
import Entidades.Produtos;
import Repositorios.Repositori_clientes;
import Repositorios.Repositorio_locacao;
import Repositorios.Repositorio_opSistemas;
import Repositorios.Repositorio_pessoas;
import Repositorios.Repositorio_produtos;

public class Main {

	public static void main(String[] args) {
		
		
		// auxiliares
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int op = 1;
		int op2 = 0;
		String aux;
		boolean gerente_acess = false;
		boolean opsistemas_acess = false;
		
		//criando um gerente para acessar o programa
		Pessoa pessoa = new Pessoa("Kurumi", 12);
		Gerente gerente = new Gerente("1212", "1110", pessoa);
		gerente.setNome(pessoa.getNome());
		
		//criando outro gerente
		Pessoa pessoa2 = new Pessoa("Miiko", 15);
		Gerente gerente2 = new Gerente("2020", "2340", pessoa2);
		gerente2.setNome(pessoa2.getNome());

		//criando outro gerente
		Pessoa pessoa3 = new Pessoa("Miyu", 18);
		Gerente gerente3 = new Gerente("2287", "4570", pessoa3);
		gerente3.setNome(pessoa3.getNome());
		
		//criando outro gerente
		Pessoa pessoa4 = new Pessoa("Haruna", 21);
		Gerente gerente4 = new Gerente("3021", "9870", pessoa4);
		gerente4.setNome(pessoa4.getNome());
		
		Produtos produAux = new Produtos();
		Op_sistema opAux = null;
		Locacao locaAux = new Locacao();
		Cliente cliente;
		Produtos produto;
		
		Repositorio_pessoas repositorio = new Repositorio_pessoas();
		Repositorio_produtos repoProdu = new Repositorio_produtos();
		Repositori_clientes repoCli = new Repositori_clientes();
		Repositorio_opSistemas repoOpSis = new Repositorio_opSistemas();
		ArrayList<Locacao> LocacaoList = new ArrayList();
		
		repositorio.AddPessoa(gerente);
		repositorio.AddPessoa(gerente2);
		repositorio.AddPessoa(gerente3);
		repositorio.AddPessoa(gerente4);
		
		//Repositorio_locacao repoAloc = new Repositorio_locacao();
		
		
		
		while(op != 3) {
			opcoes1();
			op = scanner.nextInt();
			
			if(op == 1) {
				
				repositorio.printPessoas();
				System.out.println("****Faça seu Login**** \n Digite seu Login: ");
				aux = scanner.next();
				if(!repositorio.contem(aux)) {
					System.out.println("Esse Login de Gerente não existe!! Tente novamente!!");
				}
				else {
					gerente = repositorio.retornePessoa(aux);
					
					//System.out.println(gerente.getSenha());
					while((!gerente_acess) && (!aux.equals("sair"))) {
						System.out.println("Digite sua Senha: ");
						aux = scanner.next();
						
						if(gerente.getSenha().equals(aux)) {
							gerente_acess = true;
						}
						else if(aux.equals("sair")) {
							System.out.println("Saindo para tela de seleção de login!");
						}
						else {
							System.out.println("Acesso negado! Tente novamente ou digite \"sair\" para sair. ");
						}
					}
				}
				
				
				while(gerente_acess) {
					opGerente(gerente);
					op2 = scanner.nextInt();
					if(op2 == 1) { //cadastra o produto
						Produtos produt = new Produtos();
						System.out.println("Digite o codigo do produto: ");
						produt.setCodigo(scanner.next());
						System.out.println("Digite o titulo do produto: ");
						produt.setTitulo(scanner.next());
						System.out.println("Digite o genero do produto: ");
						produt.setGenero(scanner.next());
						produt.setLocado(false);
						
						gerente.addProduto(produt, repoProdu);
						System.out.println("Adicinado com sucesso!!\n");
					}
					else if(op2 == 2) { //cadastra cliente
						System.out.println("Digite o nome do Cliente: ");
						aux = scanner.next();
						System.out.println("Digite a matricula do Cliente: ");
						op = scanner.nextInt();
						cliente = new Cliente(aux, op);
						
						System.out.println("Digite o endereço do Cliente:");
						cliente.setEndereço(scanner.next());
						System.out.println("Digite a idade do Cliente:");
						cliente.setIdade(scanner.nextInt());
						System.out.println("Digite o sexo do Cliente(M ou F):");
						cliente.setSexo(scanner.next().charAt(0));
						
						gerente.addCliente(cliente, repoCli);
						System.out.println("Adicinado com sucesso!!\n");
					}
					else if(op2 == 3) { // Cadastrar Operador
						System.out.println("Digite o nome do Operador de Sistemas: ");
						aux = scanner.next();
						System.out.println("Digite a matricula do Operador de Sistemas: ");
						op = scanner.nextInt();
						pessoa.setMatricula(op);
						pessoa.setNome(aux);
						
						Op_sistema opSistema = new Op_sistema(null, null, pessoa);
						opSistema.setNome(pessoa.getNome());
						
						System.out.println("Digite o Login para o Operador de Sistemas: ");
						opSistema.setLogin(scanner.next());
						System.out.println("Digite uma senha para o Operador de Sistemas: ");
						opSistema.setSenha(scanner.next());
						
						gerente.addOpSistemas(opSistema, repoOpSis);
						System.out.println("Operador cadastrado com sucesso!\n");
					}
					else if(op2 == 4) { //Listar Produtos
						repoProdu.listarProdutos();
					}
					else if(op2 == 5) { //– Listar Clientes
						repoCli.printCliente();
					}
					else if(op2 == 6) { //– Listar Operadores
						repoOpSis.printOpSistema();
					}
					else if(op2 == 7) { //– Procurar Produto
						System.out.println("Digite o codigo do Produto para procurar: ");
						aux = scanner.next();
						if(repoProdu.contem(aux)) {
							produAux = repoProdu.retorneProduto(aux);
							System.out.println("codigo: " + produAux.getCodigo() + " Titulo: " + produAux.getTitulo() + " Genero: " 
								      + produAux.getGenero() + " Alocado: " + produAux.isLocado());
						}
						else {
							System.out.println("O produto não existe!!!");
						}
					}
					else if(op2 == 8) { //– Procurar Cliente
						System.out.println("Digite a matricula do Cliente para procurar: ");
						op = scanner.nextInt();
						if(repoCli.contem(op)) {
							Cliente clienteAux = repoCli.retornaCliente(op);
							System.out.println("Matricula: " + clienteAux.getMatricula() + " Nome: " + clienteAux.getNome() + " Endereço: " 
								      + clienteAux.getEndereço() + " Idade: " + clienteAux.getIdade() + " Sexo:" 
								      + clienteAux.getSexo());
						}
						else {
							System.out.println("O cliente não existe!!!");
						}
					}
					else if(op2 == 9) { //Procurar Operador
						System.out.println("Digite o Login do Operador de Sistemas para procurar: ");
						aux = scanner.next();
						if(repoOpSis.contem(aux)) {
							Op_sistema OpAux = repoOpSis.retornaOpSistema(aux);
							System.out.println("Matricula: " + OpAux.getMatricula() + " Nome: " + OpAux.getNome() + " Login: " + OpAux.getLogin());
						}
						else {
							System.out.println("O operador de sistemas não existe!!!");
						}
					}
					else if(op2 == 10) {
						gerente_acess = false;
					}
					else {
						System.out.println("Escolha uma opção valida!");
					}
				}
				
			}
			else if(op == 2) {
				repoOpSis.printOpLogin();
				System.out.println("****Faça seu Login**** \n Digite seu Login: ");
				aux = scanner.next();
				if(!repoOpSis.contem(aux)) {
					System.out.println("Esse Login de Operador de Sistemas não existe!! Tente novamente!!");
				}
				else {
					opAux = repoOpSis.retornaOpSistema(aux);
					while(!opsistemas_acess && !aux.equals("sair")) {
						//System.out.println(opAux.getSenha());
						
						System.out.println("Digite sua Senha: ");
						aux = scanner.next();
						
						if(opAux.getSenha().equals(aux)) {
							opsistemas_acess = true;
						}
						else {
							System.out.println("Acesso negado! Tente novamente ou digite \"sair\" para sair.");
						}
					}
				}
				
				
				while(opsistemas_acess) {
					opOpSistemas(opAux);
					op2 = scanner.nextInt();
					
					if(op2 == 1) { //matrícula do cliente e o código do produto
						//Fazer locação
						System.out.println("Digite a matricula do Cliente que deseja alugar: ");
						op = scanner.nextInt();
						System.out.println("Digite o codigo do produto que o Cliente deseja pegar: ");
						aux = scanner.next();
						
						if(!repoCli.contem(op) || !repoProdu.contem(aux)) {
							System.out.println("O cliente ou o produto desejado não existe!!\n");
						}
						else {
							cliente = repoCli.retornaCliente(op);
							produto = repoProdu.retorneProduto(aux);
							
							locaAux.setCodigoProduto(produto.getCodigo());
							locaAux.setMatriculaCliente(cliente.getMatricula());
							
							System.out.println("digite o Dia da locação do produto: ");
							locaAux.setDay(scanner.nextInt());
							System.out.println("digite o Mes da locação do produto: ");
							locaAux.setMonth(scanner.nextInt());
							System.out.println("digite o Ano da locação do produto: ");
							locaAux.setYear(scanner.nextInt());
							
							opAux.fazerLocacao(LocacaoList, locaAux);
							System.out.println("Locação feita com sucesso!!!");
						}
						
					}
					else if(op2 == 2) {
						//Dar baixa em locação
						System.out.println("Digite a matricula do Cliente que deseja dar Baixa: ");
						op = scanner.nextInt();
						System.out.println("Digite o codigo do produto que o Cliente deseja dar baixa: ");
						aux = scanner.next();
						
						if(!repoCli.contem(op) || !repoProdu.contem(aux)) {
							System.out.println("O cliente ou o produto desejado não existe!!\n");
						}
						else {
							locaAux.setCodigoProduto(aux);
							locaAux.setMatriculaCliente(op);
							
							locaAux = opAux.baixaLocacao(LocacaoList, locaAux);
							
							if(locaAux == null) {
								System.out.println("Esse produto não existe para fazer a baixa!");
							}
							else {
								System.out.println("Digite o dia de hoje para calcular a multa:");
								op = scanner.nextInt();
								System.out.println("Digite o mes de hoje para calcular a multa:");
								op2 = scanner.nextInt();
								
								double taxa = locaAux.calculaMulta(op, locaAux.getDay(), op2, locaAux.getMonth());
								
								if(taxa == 0) {
									System.out.println("Sem multa para pagar!");
								}
								else {
									System.out.println("O valor da multa é: " + taxa);
								}
								System.out.println("pedido entregue novamente para o estoque! \n");
							}
						}
						
					}
					else if(op2 == 3) {
						//Excluir locação
						System.out.println("Digite a matricula do Cliente que deseja para excluir: ");
						op = scanner.nextInt();
						System.out.println("Digite o codigo do produto que o Cliente deseja para excluir: ");
						aux = scanner.next();
						
						if(!repoCli.contem(op) || !repoProdu.contem(aux)) {
							System.out.println("O cliente ou o produto desejado não existe!!\n");
						}
						else {
							locaAux.setCodigoProduto(aux);
							locaAux.setMatriculaCliente(op);
							
							locaAux = opAux.baixaLocacao(LocacaoList, locaAux);
							
							opAux.excluirLocacao(LocacaoList, locaAux);
							System.out.println("Locação excluido com sucesso!!");
						}
					}
					else if(op2 == 4) {
						//Procurar Produto
						System.out.println("Digite codigo do produto que deseja procurar: ");
						aux = scanner.next();
						
						if(!repoProdu.contem(aux)) {
							System.out.println("O produto não existe!!!");
						}
						else {
							Produtos prod = opAux.procurarProduto(aux, repoProdu);
							System.out.println("produto: \nCodigo: " + prod.getCodigo() + " Titulo: " + prod.getTitulo() + " Genero: " + prod.getGenero() + " Alocado: " + prod.isLocado());
						}
						
					}
					else if(op2 == 5) {
						//Procurar Cliente
						System.out.println("Digite o codigo do Cliente que deseja procurar: ");
						op = scanner.nextInt();
						
						if(!repoCli.contem(op)) {
							System.out.println("O Cliente não existe!!!");
						}
						else {
							Cliente cli = opAux.procurarCliente(op, repoCli);
							System.out.println("Cliente: \nMatricula: " + cli.getMatricula() + " Nome: " + cli.getNome() + " Endereço: " + cli.getEndereço() + " Idade: " + cli.getIdade() + " Sexo: " + cli.getSexo());
						}
					}
					else if(op2 == 6) {
						//Sair
						opsistemas_acess = false;
					}
					else {
						System.out.println("Escolha uma opção valida!");
					}
				}
				
			}
			else if(op == 3) {
				System.out.println("Obrigado por utilizar meu sistema!!");
			}
			else {
				System.out.println("Ação invalida, tente novamente!! \n");
			}
		}
		
	}
	
	
	public static void opcoes1() {
		System.out.println("****Bem vindo, escolha um perfil a baixo: \n "
				+ "1 - Gerente \n 2 - Operador de Sistema \n 3 - Sair");
	}
	
	public static void opGerente(Gerente gerente) {
		System.out.println("****Olá Gerente " + gerente.getNome() + " *****\r\n" + "1 – Cadastrar Produto\r\n" + "2 – Cadastrar Cliente\r\n" + 
				"3 – Cadastrar Operador\r\n" + "4 – Listar Produtos\r\n" + "5 – Listar Clientes\r\n" + 
				"6 – Listar Operadores\r\n" + "7 – Procurar Produto\r\n" + "8 – Procurar Cliente\r\n" + 
				"9 – Procurar Operador\r\n" + "10 – Sair\r\n" + "Digite a opção:");
	}
	
	public static void opOpSistemas(Op_sistema opSistemas) {
		System.out.println("****Olá Operador " + opSistemas.getNome() + " ****\r\n" + 
				"1 – Fazer locação\r\n" + 
				"2 – Dar baixa em locação\r\n" + 
				"3 – Excluir locação\r\n" + 
				"4 – Procurar Produto\r\n" + 
				"5 – Procurar Cliente\r\n" + 
				"6 – Sair\r\n" + 
				"Digite a opção: ");
	}

}
