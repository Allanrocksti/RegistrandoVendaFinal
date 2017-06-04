
import ObjetosDeValor.Senha;

public class Vendedor extends Pessoa {

	//********************************************************************************************************
	// ALUIZIO, ALTERA ESSA CLASSE
	// ELA HERDA DE PESSOA E NÃO PRECISA NEM DE NOME, ENDEREÇO E CPF
	// E ADD A COMISSÃO POR VENDA
	// NÃO SEI POR QUE ESTÁ DANDO ERRO NO CONSTRUTOR
	//********************************************************************************************************
	
	public String Nome;
	public String Cpf;
	public Senha Senha;
	
	public Vendedor(String nome, String documento, Senha senha) {
		Nome = nome;
		Cpf = documento;
		Senha = senha;
	}

	
}