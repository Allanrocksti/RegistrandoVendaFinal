package Principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Cadastro.Cadastros;


/**
 * Classe da aplicação principal, onde abriga o main
 * @author Allan Roque Barbosa da Silva - 1610013738
 * 
 */

//****************************************************************************************************
//
// GOOD NEWS
//
// ESTA SALVANDO, PENA QUE A CADA UMA COISA SALVA GERA UM .TXT, MAS FUNCIONA
//
//*****************************************************************************************************
// ERROS DURANTE TESTES PARA SER CORRIGIDOS
// 
// * VERIFICAR PQ O CPF 646.846.284-34 É INVÁLIDO
// * LIMPAR BUFFER DOS CADASTROS
// * ERRO DE NULL POINTER EXCEPTION NA CLASSE ARQUIVO, VENDA
// PF ALUIZIO, RESOLVE ESSES BUGS E PODE IR ADIANTANDO O RESTO
//
//*****************************************************************************************************

// ##################################################################
//
// 5:55 - 05/06/2017 - VENDA 1 - VENDEDORX - CPFX - ENDERX
// CLIENTEX - CPFX - ENDERX
// BARRASA - PRODUTOA - QTDA - VALORA - VALORTTA
// BARRASB - PRODUTOB - QTDB - VALORB - VALORTTB
// BARRASC - PRODUTOC - QTDC - VALORC - VALORTTC
// BARRASD - PRODUTOD - QTDD - VALORD - VALORTTD
// BARRASE - PRODUTOE - QTDE - VALORE - VALORTTE
// BARRASF - PRODUTOF - QTDF - VALORF - VALORTTF
// SUBTOTALX - DESCONTO - TOTALNOTAX
//
// ##################################################################
//
// 6:01 - 05/06/2017 - VENDA 1 - VENDEDORX - CPFX - ENDERX
// CLIENTEX - CPFX - ENDERX
// BARRASA - PRODUTOA - QTDA - VALORA - VALORTTA
// BARRASB - PRODUTOB - QTDB - VALORB - VALORTTB
// BARRASC - PRODUTOC - QTDC - VALORC - VALORTTC
// BARRASD - PRODUTOD - QTDD - VALORD - VALORTTD
// BARRASE - PRODUTOE - QTDE - VALORE - VALORTTE
// BARRASF - PRODUTOF - QTDF - VALORF - VALORTTF
// SUBTOTALX - DESCONTO - TOTALNOTAX
//
//##################################################################
//
//*****************************************************************

public class PadariaDoXico {
	
	private static Scanner scanner;

	public static void main(String[] args) {
		
		Arquivo arquivo = new Arquivo();
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
					
					Venda venda = new Venda();
					HashMap<String, Integer> carrinho = new HashMap<String, Integer>();
					
					String cpfVendedor = venda.entrarComCpfVendedor();
					String cpfCliente = venda.entrarComCpfCliente();
					
					cpfVendedor = cpfCliente;
					cpfCliente = cpfVendedor;
					//while()
					boolean exit = true;
					while(exit!=false){
						String barra = venda.coletarProduto();
						int qtd = venda.coletarQuantidade();
						carrinho.put(barra, qtd);
						
						System.out.println("Deseja adicionar novos produtos na venda? [1] - Sim [2] - Não");
						int opcao = Integer.parseInt(scanner.nextLine());
						if(opcao == 2){
							compra.compra(carrinho, cpfVendedor, cpfCliente);
							exit = false;
						}
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
