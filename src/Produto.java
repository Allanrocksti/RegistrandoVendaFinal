public class Produto
{
	private String Nome;
	private String Descricao;
	private float Valor;
	private String Codigo;
	private String QuantidadeDisponivel;
	
	
	
	public Produto(String nome, String descricao, float valor, String codigo, String quantidadeDisponivel) {
		super();
		Nome = nome;
		Descricao = descricao;
		Valor = valor;
		Codigo = codigo;
		QuantidadeDisponivel = quantidadeDisponivel;
	}
	
	
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public float getValor() {
		return Valor;
	}
	public void setValor(float valor) {
		Valor = valor;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getQuantidadeDisponivel() {
		return QuantidadeDisponivel;
	}
	public void setQuantidadeDisponivel(String quantidadeDisponivel) {
		QuantidadeDisponivel = quantidadeDisponivel;
	}
	
	
	
}