package Cadastro;

/**
 * Gera a string com dados em s�rie para ser salvo no arquivo
 * @author Allan Roque Barbosa da Silva - 1610013738
 *
 */

public class GeradorStr {
	
	/**
	 * Gera uma string com os dados do cliente em serie ex: " ****-***-***-***\n "
	 * @param pessoa Cliente
	 * @return A string com dados em s�rie
	 */
	public String addCliente(Pessoa pessoa){
		
		String lista = "";
		
		lista = pessoa.getNome() + "\n"
				+ pessoa.getEndereco() + "\n";
		
		return lista;
		
	}
	
	/**
	 * Gera uma string com os dados do Vendedor em serie ex: " ****-***-***-***\n "
	 * @param vendedor
	 * @return A string com dados em s�rie
	 */
	public String addVendedor(Vendedor vendedor){
		
		String lista = "";
		
		lista = vendedor.getNome() + "\n"
				+ vendedor.getEndereco() + "\n";
		
		return lista;
		
	}
	
	/**
	 * Gera uma string com os dados do Vendedor em serie ex: " ****-***-***-***\n "
	 * @param produto
	 * @return A string com dados em s�rie
	 */
	public String addProduto(Produto produto){
		
		String lista = "";
		
		lista = produto.getNome() + "\n" 
				+ produto.getValorCusto() + "\n" 
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
