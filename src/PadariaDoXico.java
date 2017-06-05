
import java.util.Scanner;

import Cadastro.Cadastros;

/**
 * Classe da aplica��o principal, onde abriga o main
 * @author Allan Roque Barbosa da Silva - 1610013738
 *
 */

//*****************************************************************
// ALUIZIO, TEMOS QUE SALVAR OS DADOS DO CADASTRO PARA PODER CONTINUAR
// PENSEI NO SEGUINTE, SALVAMOS EM .TXT COM ARREYLIST
// FIZ TUDO QUE SE PODE FAZER SEM TOCAR NO ARQUIVO
// IA COME�AR A IMPLEMENTAR O SAVE, MAS T� TARDE E VOU DORMIR
// VAMOS DIVIDIR EM 4 ARQUIVOS:
//
//     CLIENTE.TXT
//     VENDEDOR.TXT
//     PRODUTOS.TXT
//     VENDAS.TXT
//
// O VENDAS.TXT SER� O UNICO EM QUE N�O PRECISA DE MANIPULA��O DOS ARQUIVOS
// � S� DA UM ADD E SALVAR, POIS A GENTE N�O VAI PRECISAR PEGAR OS ARQUIVOS
// � S� SALVAR NAQUELE ESTILO
// 
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
						String strCadastro;
						
						switch (option) {
						
							case "1":
							
								strCadastro = cadastros.produto();
								
								
								break;
								
							case "2":
								
								strCadastro = cadastros.cliente();
								
								break;
								
							case "3":
								
								strCadastro = cadastros.vendedor();
								
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
