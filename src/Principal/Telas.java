package Principal;

import java.util.HashMap;

/**
 * Classe com todas as "telas" que serão ultilizadas no prompt 
 * @author Allan Roque Barbosa da Silva - 1610013738
 *
 */ 


public class Telas {
	
	/**
	 * Função para "limpar" a tela do prompt
	 */
	public static void limpaTela(){
		
		for (int i = 0; i < 50; ++i)
		    System.out.println ();
		
	}
	
	/**
	 * Printa o menu inicial
	 */
	public static void menuInicial(){
		
		System.out.println("\n     PADARIA DO XICO\n");
		System.out.println("1 - INICIAR UMA VENDA");
		System.out.println("2 - CADASTROS");
		System.out.println("3 - SAIR\n");
		System.out.print("> ");
		
	}

	/**
	 * Printa o menu cadastro
	 */
	public static void menuCadastro() {
		
		System.out.println("\n     CADASTROS\n");
		System.out.println("1 - PRODUTO");
		System.out.println("2 - CLIENTE");
		System.out.println("3 - VENDEDOR");
		System.out.println("4 - VOLTAR\n");
		System.out.print("> ");
		
	}
	
	/**
	 * Printa uma mensagem de erro
	 */
	public static void msgError(){
		
		System.out.println("\nOPÇÃO INCORRETA !");
		System.out.println("POR FAVOR, DIGITE UMA OPÇÃO VÁLIDA !");
		
	}
	
	/**
	 * Seta a tela inicial de venda
	 * @return String com o conteudo
	 */
	public static String telaVenda(){
		
		String str = "\n##########################################################################################\n"
					+ "                                      PADARIA DO XICO                                     \n"
					+ "##########################################################################################\n"
					+ "QTD | DESCRIÇÃO                                            |  VALOR UN  |   VALOR TOTAL  |\n";
		
		return str;
		
	}

	/**
	 * Gera a linha de cada produto na NFC-E
	 * @param produtos Hashmap dos produtos
	 * @param quantidade Hashmap da quantidade de produtos
	 * @param valores Hashmap dos valores dos produtos
	 * @param indice indice atual do produto no hashmap	
	 * @return A string com a linha pronta
	 */
	public static String linhaProdutos(HashMap<Integer, String> produtos, HashMap<Integer, Integer> quantidade, HashMap<Integer, Float> valores, int indice){
		
		String str = String.format("%-3s", quantidade.get(indice)) + " | " 
				  + String.format("%-52s", produtos.get(indice)) + " | "
				  + "R$ " + String.format("%-7.2f", valores.get(indice)) + " | "
				  + "R$ " + String.format("%-11.2f", (quantidade.get(indice) * valores.get(indice)) ) + " |" +"\n";;
		
		return str;
		
	}
	
}


