package Repositorios;
import java.util.HashMap;

import Entidades.Produtos;

public class Repositorio_produtos {
	
	
	HashMap<String, Produtos> produtosMap = new HashMap<String, Produtos>();
	
	
	public void AddProduto(Produtos produto) {
		produtosMap.put(produto.getCodigo(), produto);
	}
	public void RemoveProduto(String codigo) {
		produtosMap.remove(codigo);
	}
	public Produtos retorneProduto(String codigo) {
		return produtosMap.get(codigo);
	}
	
	public void listarProdutos() {
		for(String i :  produtosMap.keySet()) {
		      System.out.println("codigo: " + i + " Titulo: " + produtosMap.get(i).getTitulo() + " Genero: " 
		      + produtosMap.get(i).getGenero() + " Alocado: " + produtosMap.get(i).isLocado());
		}
	}
	
	public boolean contem(String a) {
		return produtosMap.containsKey(a);
	}

}
