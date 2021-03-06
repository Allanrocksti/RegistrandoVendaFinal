package Principal;

import java.util.HashMap;
import java.util.Scanner;

import Cadastro.Cadastros;
import Tratamentos.CadastroNaoExisteException;


/**
 * Classe da aplica��o principal, onde abriga o main
 * @author Allan Roque Barbosa da Silva - 1610013738
 * 		   Aluizio Barbosa Maciel Neto - 1610015465
 * 
 */

//****************************************************************************************************
// * O QUE FALTA PARA FINALIZAR O PROJETO?
//
// * TESTAR ALOPRADAMENTE PARA ACHAR ERROS !
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
				
				case "1":
					
					Telas.limpaTela();
					
					Venda venda = new Venda();
					HashMap<Integer, String> produtos = new HashMap<Integer, String>();
					HashMap<Integer, Integer> quantidade = new HashMap<Integer, Integer>(); 
					HashMap<Integer, Float> valores = new HashMap<Integer, Float>();
					
					String cpfVendedor = venda.entrarComCpfVendedor();
					
					if(cpfVendedor == "vendedor n�o cadastrado")
						try {
							throw new CadastroNaoExisteException("Vendedor n�o encontrado",1);
						} catch (CadastroNaoExisteException e) {
							// TODO Auto-generated catch block
							System.out.println("\nCREDENCIAIS DO VENDEDOR INCORRETAS, CADASTRE-O E LOGUE NOVAMENTE\n");
							break;
						}
					
					String cpfCliente = venda.entrarComCpfCliente();
					
					if(cpfCliente == "Cliente n�o cadastrado")
						try {
							throw new CadastroNaoExisteException("Cliente n�o encontrado",2);
						} catch (CadastroNaoExisteException e) {
							// TODO Auto-generated catch block
							System.out.println("\nCREDENCIAIS DO CLIENTE INCORRETAS, CADASTRE-O E LOGUE NOVAMENTE\n");
							break;
						}
					
					boolean exit = true;
					int indice = 0;
					float valorTotal = 0;
					
					String telaVenda = Telas.telaVenda();
					
					while(exit != false){
						
						int qtd = venda.coletarQuantidade();
						
						if (qtd == 0 && produtos.isEmpty() != true){
							compra.compra(produtos, valores, quantidade, cpfVendedor, cpfCliente);
							break;
						}else if(qtd == 0 && produtos.isEmpty() == true){
							System.out.println("\nCOMPRA CANCELADA!");
							break;
						}
							
						
						String barra = venda.coletarProduto();
						String nomeProduto = venda.nomeProduto(barra);
						float valor = compra.coletarValor(barra);
						
						quantidade.put(indice, qtd);
						produtos.put(indice, nomeProduto);
						valores.put(indice, valor);
						
						valorTotal = compra.calcularValorTotal(quantidade, valores);
						
						telaVenda += Telas.linhaProdutos(produtos, quantidade, valores, indice);
						
						Telas.limpaTela();
						System.out.println(telaVenda);
						System.out.printf("\nTOTAL: %.2f \n\n", valorTotal);
						
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
								
								Telas.limpaTela();
								
								strCadastro = cadastros.produto();
								System.out.println(strCadastro);
								
								break;
								
							case "2":
							
								Telas.limpaTela();
								
								strCadastro = cadastros.cliente();
								System.out.println(strCadastro);
							
								break;
								
							case "3":
								
								Telas.limpaTela();
								
								strCadastro = cadastros.vendedor();
								System.out.println(strCadastro);
								
								break;
								
							case "4":
								
								Telas.limpaTela();
								
								exitCadastro = true;
								
								break;
		
							default:
								
								Telas.limpaTela();
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
