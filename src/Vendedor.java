import ObjetosDeValor.Documento;
import ObjetosDeValor.Senha;

public class Vendedor extends Pessoa {
	
	public String Nome;
	public Documento Documento;
	public Senha Senha;
	
	public Vendedor(String nome, Documento documento, Senha senha) {
		Nome = nome;
		Documento = documento;
		Senha = senha;
	}

	
}