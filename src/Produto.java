public class Produto {

	private String CodBarras;
	private String Nome;
	private float ValorVenda;
	private float ValorCusto;

	public Produto(String codBarras, String nome, float valorVenda, float valorCusto) {
		super();
		CodBarras = codBarras;
		Nome = nome;
		ValorVenda = valorVenda;
		ValorCusto = valorCusto;
	}

	public String getCodBarras() {
		return CodBarras;
	}

	public void setCodBarras(String codBarras) {
		CodBarras = codBarras;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public float getValorVenda() {
		return ValorVenda;
	}

	public void setValorVenda(float valorVenda) {
		ValorVenda = valorVenda;
	}

	public float getValorCusto() {
		return ValorCusto;
	}

	public void setValorCusto(float valorCusto) {
		ValorCusto = valorCusto;
	}

}