package Repositorios;

import java.util.HashMap;

import Atores.Gerente;

public class Repositorio_pessoas {
	
	HashMap<String, Gerente> pessoasMap = new HashMap<String, Gerente>();
	
	
	public void AddPessoa(Gerente gerente) {
		pessoasMap.put(gerente.getLogin(), gerente);
	}
	public void RemovePessoa(String login) {
		pessoasMap.remove(login);
	}
	public Gerente retornePessoa(String login) {
		return pessoasMap.get(login);
	}
	
	public Gerente retge(String login) {
		return pessoasMap.get(login);
	}
	
	public void printPessoas() {
		System.out.println("\nEsses são os Gerentes atuais, escolha qual é você: ");
		for(String i : pessoasMap.keySet()) {
		      System.out.println("Login: " + i);
		}
	}
	
	public boolean contem(String a) {
		return pessoasMap.containsKey(a);
	}
}
