package ObjetosDeValor;

public class Senha {
	
	public Senha(String senha) {
		Senha = criptografar(senha);
	}

	private String Senha;

	private String criptografar(String senha) {
		return senha + "Est·Criptogr·fado";
	}

	public boolean verificarSenha(String senha) {
		
		boolean resposta = false;

		if (Senha == criptografar(senha))
			resposta = true;

		return resposta; 
		
	}
}