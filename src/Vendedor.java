
import ObjetosDeValor.Senha;

public class Vendedor extends Pessoa {

	//********************************************************************************************************
	// ALUIZIO, ALTERA ESSA CLASSE
	// ELA HERDA DE PESSOA E N�O PRECISA NEM DE NOME, ENDERE�O E CPF
	// E ADD A COMISS�O POR VENDA
	// N�O SEI POR QUE EST� DANDO ERRO NO CONSTRUTOR
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