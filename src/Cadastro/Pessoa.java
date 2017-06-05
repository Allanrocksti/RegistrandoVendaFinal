package Cadastro;

/**
 * Classe contendo os dados de uma pessoa
 * @author Allan Roque Barbosa da Silva - 1610013738
 *
 */

public class Pessoa {

	private String Nome;
	private String Endereco;
	private String Cpf;
	
	public Pessoa(String nome, String endereco, String cpf) {
		super();
		Nome = nome;
		Endereco = endereco;
		Cpf = cpf;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

}