package Cadastro;

/**
 * Classe contendo os dados dos vendedores
 * @author Allan Roque Barbosa da Silva - 1610013738
 *
 */

public class Vendedor extends Pessoa {
	
	private String Senha; 
	
	public Vendedor(String nome, String endereco, String cpf, String senha) {
		super(nome, endereco, cpf);
		setSenha(senha);
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	
	
}