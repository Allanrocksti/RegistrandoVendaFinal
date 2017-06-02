package ObjetosDeValor;
public class Nome
{
	public Nome(String primeiroNome, String ultimoNome)
	{
		PrimeiroNome = primeiroNome;
		UltimoNome = ultimoNome;
	}
	
	private String PrimeiroNome;
	private String UltimoNome;
	
	public String toString()
	{
		return PrimeiroNome + " " + UltimoNome;
	}
}