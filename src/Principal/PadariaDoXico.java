package Principal;

import java.util.HashMap;
import java.util.Scanner;

import Cadastro.Cadastros;


/**
 * Classe da aplicação principal, onde abriga o main
 * @author Allan Roque Barbosa da Silva - 1610013738
 * 		   Aluizio Barbosa Maciel Neto - 1610015465
 * 
 */

//****************************************************************************************************
//JA RESOLVI O BUGZINHO DO CADASTRO DE VENDA, COISINHA BESTA, O PROBLEMA DE SAIR DO LOOP INFINITO SE
//NÃO EXISTIR NENHUM CLIENTE OU VENDEDOR JÁ FOI SANADO, O PROBLEMA QUE ENCONTREI NA HORA DA VENDA AINDA TÁ. 
//
//****************************************************************************************************
//
//Dear Allan,
//
//*****************************************************************************************************
//PLEASE, USER THIS PLACE FROM YOU TO COMMUNICATE WHAT NEED TO FINISH THE PROJECT:
// 
// * VERIFICAR PQ O CPF 646.846.284-34 É INVÁLIDO//ainda persiste
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
					HashMap<Integer, Float> valores = new HashMap<Integer, Float>();
					
					// solução para nenhum cliente e vendedor cadastrado
					String cpfVendedor = venda.entrarComCpfVendedor();
					if(cpfVendedor == "Vendedor não cadastrado!"){
						System.out.println("Vendedor não cadastrado, o cadastre e tente de novo!!");
						break;
					}
					String cpfCliente = venda.entrarComCpfCliente();
					if(cpfCliente == "Cliente não cadastrado!"){
						System.out.println("Cliente não cadastrado, o cadastre e tente novamente!!");
						break;
					}
					
					boolean exit = true;
					int indice = 0;
					
					while(exit != false){
						
						int qtd = venda.coletarQuantidade();
						
						if (qtd == 0 && produtos.isEmpty() != true){
							compra.compra(produtos, valores, cpfVendedor, cpfCliente);
							break;
						}else if(qtd == 0 && produtos.isEmpty() == true){
							System.out.println("Impossivel fechar compra sem produtos...");
						}
							
						String barra = venda.coletarProduto();
						String nomeProduto = venda.nomeProduto(barra);
						produtos.put(indice, nomeProduto);
						float valor = compra.coletarValor(barra);
						valores.put(indice, valor);
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
