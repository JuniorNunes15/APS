package Atores;

public class Funcionario extends Pessoa { // String: login e String: senha
	
	private String login;
	private String senha;
	private Pessoa pessoa;
	

	public Funcionario(String login, String senha, Pessoa pessoa) {
		super(senha, pessoa.getMatricula());
		this.login = login;
		this.senha = senha;
		this.pessoa = pessoa;
	}



	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	

}
