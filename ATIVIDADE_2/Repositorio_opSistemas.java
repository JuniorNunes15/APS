package Repositorios;

import java.util.HashMap;

import Atores.*;

public class Repositorio_opSistemas {
	
	
	HashMap<String, Op_sistema> OpSistemasMap = new HashMap<String, Op_sistema>();
	
	
	public void AddOpSistemas(Op_sistema opSistema) {
		OpSistemasMap.put(opSistema.getLogin(), opSistema);
	}
	
	public void RemoveOpSistema(String login) {
		OpSistemasMap.remove(login);
	}
	
	public Pessoa retorneOpSistema(String login) {
		return OpSistemasMap.get(login);
	}
	
	public Op_sistema retornaOpSistema(String login) {
		return OpSistemasMap.get(login);
	}
	
	public void printOpSistema() {
		for(String i : OpSistemasMap.keySet()) {
		      System.out.println("Login: " + i + " Nome: " + OpSistemasMap.get(i).getNome() + " Matricula: " 
		      + OpSistemasMap.get(i).getMatricula());
		}
	}
	
	public void printOpLogin() {
		System.out.println("\nEsses são os Operadores de Sistemas atuais, escolha qual é você: ");
		for(String i : OpSistemasMap.keySet()) {
		      System.out.println("Login: " + i);
		}
	}
	
	public boolean contem(String a) {
		return OpSistemasMap.containsKey(a);
	}

}
