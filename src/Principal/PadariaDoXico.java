package Principal;

import java.util.HashMap;
import java.util.Scanner;

import Cadastro.Cadastros;


/**
 * Classe da aplica��o principal, onde abriga o main
 * @author Allan Roque Barbosa da Silva - 1610013738
 * 		   Aluizio Barbosa Maciel Neto - 1610015465
 * 
 */

//****************************************************************************************************
//JA RESOLVI O BUGZINHO DO CADASTRO DE VENDA, COISINHA BESTA, O PROBLEMA DE SAIR DO LOOP INFINITO SE
//N�O EXISTIR NENHUM CLIENTE OU VENDEDOR J� FOI SANADO, O PROBLEMA QUE ENCONTREI NA HORA DA VENDA AINDA T�. 
//
//****************************************************************************************************
//
//Dear Allan,
//
//*****************************************************************************************************
//PLEASE, USER THIS PLACE FROM YOU TO COMMUNICATE WHAT NEED TO FINISH THE PROJECT:
// 
// * VERIFICAR PQ O CPF 646.846.284-34 � INV�LIDO//ainda persiste
// * LIMPAR BUFFER DOS CADASTROS//aparentemente solucionado
// * IMPLEMENTAR A TELA DE VENDA//ESPECIFIQUE
/*THIS PLACE
 *
 * 
 */
// TESTAR ALOPRADAMENTE PARA ACHAR ERROS !//OBVIAMENTE
//
//*****************************************************************************************************

public class PadariaDoXico {
	
	private static Scanner scanner;

	public static void main(String[] args) {
		
		Cadastros cadastros = new Cadastros();
		Compra compra = new Compra();
		scanner = new Scanner(System.in);
		boolean exitMenu = false;
		String option = "0";
		
		while(exitMenu != true){
			
			Telas.menuInicial();
			option = scanner.nextLine();
			
			switch (option) {
				//VENDA
				case "1":
					
					Venda venda = new Venda();
					HashMap<Integer, String> produtos = new HashMap<Integer, String>();
					HashMap<Integer, Integer> quantidade = new HashMap<Integer, Integer>(); 
					HashMap<Integer, Float> valores = new HashMap<Integer, Float>();
					
					// solu��o para nenhum cliente e vendedor cadastrado
					String cpfVendedor = venda.entrarComCpfVendedor();
					if(cpfVendedor == "Vendedor n�o cadastrado"){
						System.out.println("\n*=====================================================");
						System.out.println("Credenciais do Vendedor incorretas, cadastre-as e logue novamente");
						System.out.println("*=====================================================\n");
						break;
					}
					
					String cpfCliente = venda.entrarComCpfCliente();
					if(cpfCliente == "Cliente n�o cadastrado"){
						System.out.println("\n*=====================================================");
						System.out.println("Credenciais do Cliente incorretas, cadastre-as e logue novamente");
						System.out.println("*=====================================================\n");
						break;
					}
					
					boolean exit = true;
					int indice = 0;
					float valorTotal = 0;
					String telaVenda = "\n*=====================================================\n\n" 
										+ "Quantidade | Produto                      | Valor\n";
					
					while(exit != false){
						
						int qtd = venda.coletarQuantidade();
						
						if (qtd == 0 && produtos.isEmpty() != true){
							compra.compra(produtos, valores, quantidade, cpfVendedor, cpfCliente);
							break;
						}else if(qtd == 0 && produtos.isEmpty() == true){
							System.out.println("Impossivel fechar compra sem produtos...");
						}
							
						
						String barra = venda.coletarProduto();
						String nomeProduto = venda.nomeProduto(barra);
						float valor = compra.coletarValor(barra);
						
						quantidade.put(indice, qtd);
						produtos.put(indice, nomeProduto);
						valores.put(indice, valor);
						
						valorTotal = compra.calcularValorTotal(quantidade, valores);
						
						telaVenda += quantidade.get(indice) + " - " + produtos.get(indice) + "             " 
								+ (quantidade.get(indice) * valores.get(indice)) + "\n";
						
						System.out.println(telaVenda);
						System.out.printf("\nTotal: %.2f \n\n", valorTotal);
						
						indice++;
							
					}
				
					
					break;
					
				case "2":
					
					boolean exitCadastro = false;
					
					while(exitCadastro != true){
						
						Telas.menuCadastro();
						option = scanner.nextLine();
						String strCadastro = "";
						
						switch (option) {
						
							case "1":
									
								strCadastro = cadastros.produto();
								System.out.println(strCadastro);
								
								break;
								
							case "2":
							
								strCadastro = cadastros.cliente();
								System.out.println(strCadastro);
							
								break;
								
							case "3":
								
								strCadastro = cadastros.vendedor();
								System.out.println(strCadastro);
								
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
					
					System.out.println("\nObrigado por comprar \"p�o\" na padaria do xico!");
					exitMenu = true;
					
					break;
	
				default:
					
					Telas.msgError();
					
					break;
				
			}
			
		}
		
	}
	
}
