package Principal;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *@date 1 de jun de 2017
 *@author  Neto
 *@time	19:01:25
 */

/**
 *@author Allan Roque Barbosa da Silva - 1610013738
 * 		   Aluizio Barbosa Maciel Neto - 1610015465
 *
 */
public class Arquivo {

	/**
	 * Metodo para salvar o cadastro 
	 * @param arquivo String com nome do arquivo
	 * @param conteudo O que será salvo
	 * @return Mensagem de status
	 */
	public String salvarCadastro(String arquivo, String conteudo){
		
		FileWriter arq;
		String msg;
		
		try {
				
			arq = new FileWriter(arquivo,true);
			PrintWriter gravarArq = new PrintWriter(arq);
		    gravarArq.write(conteudo);
		    gravarArq.close();
		    msg = "SALVO COM SUCESSO !";

		} catch (IOException e) {
			msg = "ERRO AO SALVAR O ARQUIVO";
		}
		
		return msg;
		
	}

	/**
	 * Faz um teste se o arquivo existe
	 * @param arquivo String com nome do arquivo
	 * @return Mensagem de status
	 */
	public boolean verificarArquivoJaExistente(String arquivo) {
		
		boolean existe;
		
		try {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			br.close();
			fr.close();
			existe = true;
		} catch (FileNotFoundException e) {
			existe = false;
		} catch (IOException e){
			existe = false;
		} catch (NullPointerException e){
			existe = false;
		}
		
		return existe;
		
	}
	
}
