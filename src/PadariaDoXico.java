 
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
								/*System.out.println("Nome do produto: ");
								String nome = scanner.nextLine();
								System.out.println("Descrição do produto: ");
								String descricao = scanner.nextLine();
								System.out.println("Valor do produto: ");
								String dado = scanner.nextLine();
								float valor = extra.verificarF(dado);
								System.out.println("Codigo do produto: ");
								String codigo = scanner.nextLine();
								System.out.println("Quantidade do produto: ");
								String qtd_produto = scanner.nextLine();
								
								produto = new Produto(nome,descricao,valor,codigo,qtd_produto);
								
								String msg = arquivo.salvarObjeto(produto);
								System.out.println(msg);*/
								
								String msg = cadastros.produto();
								System.out.println(msg);
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
