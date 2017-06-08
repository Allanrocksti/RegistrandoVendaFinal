package Cadastro;

/**
 * Gera a string com dados em série para ser salvo no arquivo
 * @author Allan Roque Barbosa da Silva - 1610013738
 *
 */
 
public class GeradorStr {
	
	/**
	 * Gera uma string com os dados do cliente em serie ex: " ****\n***\n***\n***\n "
	 * @param pessoa Cliente
	 * @return A string com dados em série
	 */
	public String addCliente(Pessoa pessoa){
		
		String lista = "";
		
		lista = pessoa.getNome() + "\n"
				+ pessoa.getEndereco() + "\n";
		
		return lista;
		
	}
	
	/**
	 * Gera uma string com os dados do Vendedor em serie ex: " ****\n***\n***\n***\n "
	 * @param vendedor
	 * @return A string com dados em série
	 */
	public String addVendedor(Vendedor vendedor){
		
		String lista = "";
		
		lista = vendedor.getNome() + "\n"
				+ vendedor.getEndereco() + "\n"
				+ vendedor.getSenha() + "\n";
		
		return lista;
		
	}
	
	/**
	 * Gera uma string com os dados do Vendedor em serie ex: " ****\n***\n***\n***\n "
	 * @param produto
	 * @return A string com dados em série
	 */
	public String addProduto(Produto produto){
		
		String lista = "";
		
		lista = produto.getNome() + "\n" 
				+ produto.getValorCusto() + "\n" 
				+ produto.getValorVenda() + "\n";
		
		return lista;
		
	}

}
