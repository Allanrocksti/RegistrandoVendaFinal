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
// GOOD NEWS ALLAN,
//
// ESTA SALVANDO, PENA QUE A CADA UMA COISA SALVA GERA UM .TXT, MAS FUNCIONA
//COMPRA SÓ FALTAS AS FUNÇÕES, O ARMAZENAMENTO TÁ FLUINDO NORMARU DESU
//
//*****************************************************************************************************
// ERROS DURANTE TESTES PARA SER CORRIGIDOS
// 
// * VERIFICAR PQ O CPF 646.846.284-34 É INVÁLIDO
// * LIMPAR BUFFER DOS CADASTROS
// * ERRO DE NULL POINTER EXCEPTION NA CLASSE ARQUIVO, VENDA//ERRATA - JÁ RESOLVI
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
		Extra extra = new Extra();
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
				//VENDA
				case "1":
					
					Venda venda = new Venda();
					HashMap<String, Integer> carrinho = new HashMap<String, Integer>();
					
					// solução para nenhum cliente e vendedor cadastrado
					String cpfVendedor = venda.entrarComCpfVendedor();
					String cpfCliente = venda.entrarComCpfCliente();
					
					boolean exit = true;
					
					while(exit != false){
						
						int qtd = venda.coletarQuantidade();
						
						if (qtd == 0 && carrinho.isEmpty() != true){
							compra.compra(carrinho, cpfVendedor, cpfCliente);
							break;
						}else if(qtd == 0 && carrinho.isEmpty() == true){
							System.out.println("Impossivel fechar compra sem produtos...");
						}
							
						String barra = venda.coletarProduto();
						carrinho.put(barra, qtd);
							
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
