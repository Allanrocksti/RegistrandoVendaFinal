public class Produto
{
	private String Nome;
	private float Valor;
	private String Codigo;
	
	public Produto(String nome, float valor, String codigo) {
		super();
		Nome = nome;
		Valor = valor;
		Codigo = codigo;
	}
	
	public void imprimir(Produto produto){
		System.out.println("Nome do produto: "+produto.getNome());
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
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
	

}