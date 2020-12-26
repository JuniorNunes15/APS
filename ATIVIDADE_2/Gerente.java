package Atores;

import Entidades.Produtos;
import Repositorios.Repositori_clientes;
import Repositorios.Repositorio_opSistemas;
import Repositorios.Repositorio_pessoas;
import Repositorios.Repositorio_produtos;

public class Gerente extends Funcionario {

	public Gerente(String login, String senha, Pessoa pessoa) {
		super(login, senha, pessoa);
		// TODO Auto-generated constructor stub
	}
	
	
	//Adicionar um Cliente
	public void addCliente(Cliente cliente, Repositori_clientes rep) {
		rep.AddCliente(cliente);
	}
	//Adicionar um Produto qualquer
	public void addProduto(Produtos produto, Repositorio_produtos rep) {
		rep.AddProduto(produto);
	}
	//Adicionar um Operador
	public void addOpSistemas(Op_sistema operador, Repositorio_opSistemas rep) {
		rep.AddOpSistemas(operador);
	}
	
	
}
