package Atores;

import java.util.ArrayList;

import Entidades.Produtos;
import Repositorios.*;

public class Op_sistema extends Funcionario{

	
	
	public Op_sistema(String login, String senha, Pessoa pessoa) {
		super(login, senha, pessoa);
		// TODO Auto-generated constructor stub
	}

	
	//Fazer uma locação de um produto a um cliente
	public void fazerLocacao(ArrayList<Locacao> LocacaoAux, Locacao loc) {
		LocacaoAux.add(loc);
	}
	//Excluir uma locação
	public void excluirLocacao(ArrayList<Locacao> LocacaoAux, Locacao loc) {
		LocacaoAux.remove(loc);
	}
	//Fazer baixa de uma locação, cobrando as diárias e multas, caso existam.
	public Locacao baixaLocacao(ArrayList<Locacao> LocacaoAux, Locacao loc) {
		for(int i = 0; i < LocacaoAux.size(); i++) {
			if(LocacaoAux.get(i).getMatriculaCliente() == loc.getMatriculaCliente() && LocacaoAux.get(i).getCodigoProduto().equals(loc.getCodigoProduto())) {
				return LocacaoAux.get(i);
			}
		}
		return null;
	}
	
	//Procurar produtos por codigo
	public Produtos procurarProduto(String codigo, Repositorio_produtos repoAux) {
		return repoAux.retorneProduto(codigo);
	}
	//Procurar Clientes por matricula.
	public Cliente procurarCliente(int matricula, Repositori_clientes repoAux) {
		return repoAux.retornaCliente(matricula);
	}

	
}
