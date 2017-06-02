
import java.util.Scanner;
//OI LULUZINHO 13
public class PadariaDoXico {
	
	private static Scanner scanner;

	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);
		boolean exitMenu = false;
		String option = "0";
		
		while(exitMenu != true){
			
			Telas.menuInicial();
			//option = coletarOpcao;
			option = scanner.nextLine();
			
			switch (option) {
			
				case "1":
					
					//INICIAR A VENDA
					
					break;
					
				case "2":
					
					boolean exitCadastro = false;
					
					while(exitCadastro != true){
						
						Telas.menuCadastro();
						//option = coletarOpcao;
						option = scanner.nextLine();
						
						switch (option) {
						
							case "1":
								
								//PRODUTO
								
								break;
								
							case "2":
								
								//CLIENTE
								
								break;
								
							case "3":
								
								//VENDEDOR
								
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
