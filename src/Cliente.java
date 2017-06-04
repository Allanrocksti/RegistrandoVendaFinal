import ObjetosDeValor.Documento;
import ObjetosDeValor.Nome;
import ObjetosDeValor.Email;
import ObjetosDeValor.Senha;

public class Usuario extends Pessoa
{
	public Usuario(Nome nome, Documento documento, Email email, Senha senha)
	{
		Nome = nome;
		Documento = documento;
		Email = email;
		Senha = senha;
	}
	
	public Email Email;
	public Senha Senha;
	public Nome Nome;
	public Documento Documento;
}