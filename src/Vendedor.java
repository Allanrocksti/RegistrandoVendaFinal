
import ObjetosDeValor.Senha;

public class Vendedor extends Pessoa {
	
	private Senha Senha;
	private static final float comissao = 10/100; 
	
	public Vendedor(String nome, String endereco, String cpf, Senha senha) {
		super(nome, endereco, cpf);
		Senha = senha;
	}

	public Senha getSenha() {
		return Senha;
	}

	public void setSenha(Senha senha) {
		Senha = senha;
	}
	
}