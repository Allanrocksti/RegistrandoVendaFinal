import java.util.Scanner;
public class PadariaDoXico {

	private static Scanner scanner;

	static String menu(){
		
		scanner = new Scanner(System.in);
		
		System.out.println("                                      PADARIA DO XICO\n\n");
		System.out.println("                                1 - INICIAR UMA VENDA");
		System.out.println("                                2 - CADASTROS");
		System.out.println("                                3 - SAIR\n");
		System.out.print("                                > ");
		
		return scanner.nextLine();
		
	}
	
	public static void main(String[] args) {
	
		boolean exit = false;
		String option;
		
		while(exit != true){
			
			option = menu();
			
			switch (option) {
			
			case "1":
				
				//INICIAR A VENDA
				
				break;
				
			case "2":
				
				// cadastros
				
				break;
				
			case "3":
				
				System.out.println("\n                                Obrigado por comprar \"p�o\" na padaria do xico!");
				exit = true;
				
				break;

			default:
				
				System.out.println("\nOp��o incorreta!");
				System.out.println("Please, digite uma op��o v�lida!");
				
				break;
				
			}
			
			
		}
		
	}
	
}
