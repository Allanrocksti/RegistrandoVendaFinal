package Principal;

import java.util.ArrayList;
import java.util.Scanner;

import Cadastro.Cadastros;

/**
 * Classe da aplicação principal, onde abriga o main
 * @author Allan Roque Barbosa da Silva - 1610013738
 *
 */

//*****************************************************************
// ALUIZIO, TEMOS QUE SALVAR OS DADOS DO CADASTRO PARA PODER CONTINUAR
// PENSEI NO SEGUINTE, SALVAMOS EM .TXT COM ARREYLIST
// FIZ TUDO QUE SE PODE FAZER SEM TOCAR NO ARQUIVO
// IA COMEÇAR A IMPLEMENTAR O SAVE, MAS TÁ TARDE E VOU DORMIR
// VAMOS DIVIDIR EM 4 ARQUIVOS:
//
//     CLIENTE.TXT
//     VENDEDOR.TXT
//     PRODUTOS.TXT
//     VENDAS.TXT
//
// O VENDAS.TXT SERÁ O UNICO EM QUE NÃO PRECISA DE MANIPULAÇÃO DOS ARQUIVOS
// É SÓ DA UM ADD E SALVAR, POIS A GENTE NÃO VAI PRECISAR PEGAR OS ARQUIVOS
// É SÓ SALVAR NAQUELE ESTILO
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
		
		Arquivo arquivo = new Arquivo();
		ArrayList<String> retorno = new ArrayList<String>();
		Cadastros cadastros = new Cadastros();
		scanner = new Scanner(System.in);
		boolean exitMenu = false;
		String option = "0";
		
		while(exitMenu != true){
			
			Telas.menuInicial();
			option = scanner.nextLine();
			
			switch (option) {
			
				case "1":
					//VOU PASSAR O TIPO DO ARQUIVO QUE EU QUERO, PARA CADA MOMENTO DA EXECUÇÃO, ATRAVES DO LER CADASTRO
					String vendedor = "vendedor";
					String produto = "produto";
					String cliente = "cliente";
					// COLETAR VENDEDOR
					//retorno = arquivo.lerCadastro(produto);//RETORNA O ARRAYLIST COM OS VALORES DO ARQUIVO
					if(retorno == null){
						System.out.println("Erro ao retonar o Array");//SE FOR NULL É POR QUE NÃO ENTROU EM NENHUM IF
					}else{
						for (String string : retorno) {//PRINTO CADA STRING DENTRO DA MINHA COLEÇÃO
							if(string != null)			//PODE COMPARAR O PRODUTO AQUI E PEGAR AS INFORMAÇÕES.
								System.out.println(string);
						}
						// VERIFICAR CADASTRO
						
						// WHILE CONTINUAR == TRUE
							
							// COLETAR CLIENTE
							// VERIFICAR CADASTRO
					}
					
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
								System.out.println(strCadastro);
								break;
								
							case "2":
								
								strCadastro = cadastros.cliente();
								//arquivo.salvarCadastro(strCadastro, "Cliente.txt");
								break;
								
							case "3":
								
								strCadastro = cadastros.vendedor();
								//arquivo.salvarCadastro(strCadastro, "Vendedor.txt");
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
