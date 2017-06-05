package Cadastro;

/**
 * Gera a string com dados em série para ser salvo no arquivo
 * @author Allan Roque Barbosa da Silva - 1610013738
 *
 */

public class GeradorStr {
	
	/**
	 * Gera uma string com os dados do cliente em serie ex: " ****-***-***-***\n "
	 * @param pessoa Cliente
	 * @return A string com dados em série
	 */
	public String addCliente(Pessoa pessoa){
		
		String lista = "";
		
		lista = pessoa.getCpf() + "-"
				+ pessoa.getNome() + "-"
				+ pessoa.getEndereco() + "\n";
		
		return lista;
		
	}
	
	/**
	 * Gera uma string com os dados do Vendedor em serie ex: " ****-***-***-***\n "
	 * @param vendedor
	 * @return A string com dados em série
	 */
	public String addVendedor(Vendedor vendedor){
		
		String lista = "";
		
		lista = vendedor.getCpf() + "-"
				+ vendedor.getSenha() + "-"
				+ vendedor.getNome() + "-"
				+ vendedor.getEndereco() + "\n";
		
		return lista;
		
	}
	
	/**
	 * Gera uma string com os dados do Vendedor em serie ex: " ****-***-***-***\n "
	 * @param produto
	 * @return A string com dados em série
	 */
	public String addProduto(Produto produto){
		
		String lista = "";
		
		lista = produto.getCodBarras() + "-" 
				+ produto.getNome() + "-" 
				+ produto.getValorCusto() + "-" 
				+ produto.getValorVenda() + "\n";
		
		return lista;
		
	}

	// MAIN PARA TESTE
	/*
	public static void main(String[] args) {
		
		Cadastros cadastro = new Cadastros();
		
		String msg = cadastro.cliente();
		
		System.out.println(msg);
		
	}
	*/
}
