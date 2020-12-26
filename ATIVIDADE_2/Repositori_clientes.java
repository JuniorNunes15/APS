package Repositorios;

import java.util.HashMap;

import Atores.*;

public class Repositori_clientes {

	HashMap<Integer, Cliente> clientsMap = new HashMap<Integer, Cliente>();
	
	
	public void AddCliente(Cliente cliente) {
		clientsMap.put(cliente.getMatricula(), cliente);
	}
	
	public void RemoveCliente(int matricula) {
		clientsMap.remove(matricula);
	}
	
	public Pessoa retorneCliente(int matricula) {
		return clientsMap.get(matricula);
	}
	
	public Cliente retornaCliente(int matricula) {
		return clientsMap.get(matricula);
	}
	
	public void printCliente() {
		for(Integer i : clientsMap.keySet()) {
		      System.out.println("Matricula: " + i + " Nome: " + clientsMap.get(i).getNome() + " Endereço: " 
		      + clientsMap.get(i).getEndereço() + " Idade: " + clientsMap.get(i).getIdade() + " Sexo:" 
		      + clientsMap.get(i).getSexo());
		}
	}
	
	public boolean contem(int a) {
		return clientsMap.containsKey(a);
	}
	
}
