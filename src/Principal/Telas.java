package Principal;

/**
 * Classe com todas as "telas" que serão ultilizadas no prompt 
 * @author Allan Roque Barbosa da Silva - 1610013738
 *
 */ 

public class Telas {
	
	public static void menuInicial(){
		
		System.out.println("     PADARIA DO XICO\n");
		System.out.println("1 - INICIAR UMA VENDA");
		System.out.println("2 - CADASTROS");
		System.out.println("3 - SAIR\n");
		System.out.print("> ");
		
	}

	public static void menuCadastro() {
		
		System.out.println("     CADASTROS\n");
		System.out.println("1 - PRODUTO");
		System.out.println("2 - CLIENTE");
		System.out.println("3 - VENDEDOR");
		System.out.println("4 - VOLTAR\n");
		System.out.print("> ");
		
	}
	
	public static void msgError(){
		
		System.out.println("\nOpção incorreta!");
		System.out.println("Please, digite uma opção válida!");
		
	}


}
