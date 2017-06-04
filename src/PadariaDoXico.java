
import java.util.Scanner;

public class PadariaDoXico {
	
	private static Scanner scanner;

	public static void main(String[] args) {
		
		//Arquivo arquivo = new Arquivo();
		//Produto produto;
		//Extra extra = new Extra();
		Cadastros cadastros = new Cadastros();
		scanner = new Scanner(System.in);
		boolean exitMenu = false;
		String option = "0";
		
		while(exitMenu != true){
			
			Telas.menuInicial();
			option = scanner.nextLine();
			
			switch (option) {
			
				case "1":
					
					// COLETAR VENDEDOR
					// VERIFICAR CADASTRO
					
					// WHILE CONTINUAR == TRUE
						
						// COLETAR CLIENTE
						// VERIFICAR CADASTRO
					
						// CALCULAR VENDA
						// SALVAR VENDA
						// IMPRIMIR
						// CONTINUAR?
					
					break;
					
				case "2":
					
					boolean exitCadastro = false;
					
					while(exitCadastro != true){
						
						Telas.menuCadastro();
						option = scanner.nextLine();
						boolean statusCadastro;
						
						switch (option) {
						
							case "1":
							
								statusCadastro = cadastros.produto();
								cadastros.testeCadastro(statusCadastro);
								
								break;
								
							case "2":
								
								statusCadastro = cadastros.cliente();
								cadastros.testeCadastro(statusCadastro);
								
								break;
								
							case "3":
								
								statusCadastro = cadastros.vendedor();
								cadastros.testeCadastro(statusCadastro);
								
								break;
								
							case "4":
								
								exitCadastro = true;
								
								break;
		
							default:
								
								Telas.msgError();
								
								break;	
						}
						
					}
					
					break;
					
				case "3":
					
					System.out.println("\nObrigado por comprar \"pão\" na padaria do xico!");
					exitMenu = true;
					
					break;
	
				default:
					
					Telas.msgError();
					
					break;
				
			}
			
		}
		
	}
	
}
