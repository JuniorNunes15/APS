package Atores;

public class Cliente extends Pessoa {
	
	public Cliente(String nome, int matricula) {
		super(nome, matricula);
		// TODO Auto-generated constructor stub
	}
	
	private String enderešo;
	private int idade;
	private char sexo;
	
	
	public String getEnderešo() {
		return enderešo;
	}
	public void setEnderešo(String enderešo) {
		this.enderešo = enderešo;
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
