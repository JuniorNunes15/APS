package Atores;

public class Cliente extends Pessoa {
	
	public Cliente(String nome, int matricula) {
		super(nome, matricula);
		// TODO Auto-generated constructor stub
	}
	
	private String endere�o;
	private int idade;
	private char sexo;
	
	
	public String getEndere�o() {
		return endere�o;
	}
	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	
}
