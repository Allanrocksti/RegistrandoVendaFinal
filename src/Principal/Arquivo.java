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
 * @author Aluízio Barbosa Maciel Neto
 *
 */
public class Arquivo {

	public String salvarCadastro(String arquivo, String conteudo){
		
		FileWriter arq;
		String msg = "Erro arq";
		
		try {
				
			arq = new FileWriter(arquivo,true);
			PrintWriter gravarArq = new PrintWriter(arq);
		    gravarArq.write(conteudo);
		    gravarArq.close();
		    msg = "salvo com sucesso !";

		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		return msg;
		
	}
	
	// TESTE DO ERRO NULL POINTER EXCEPTION
	public static void main(String[] args) {
		
		Arquivo arquivo = new Arquivo();
		Venda venda = new Venda();
		
		boolean var = arquivo.verificarArquivoJaExistente("12345678909" + "_" + "123456" + ".txt");
		System.out.println(var);
		String cpf = "";
		// ERRO AQUI 
		try{
		cpf = venda.entrarComCpfVendedor();
		//****
		} catch (NullPointerException e){
			System.out.println("erro");
		}
		System.out.println(cpf);
		
		
	}
		
	public boolean verificarArquivoJaExistente(String arquivo) {
		
		boolean existe = false;
		
		try {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			br.close();
			fr.close();
			existe = true;
		} catch (FileNotFoundException e) {
			return existe;
		} catch (IOException e){
			return existe;
		} catch (NullPointerException e){
			return existe;
		}
		
		return existe;
		
	}
	
}
