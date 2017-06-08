package Principal;
import java.util.HashMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;


public class Compra {
	
	/**
	 * Função para encurtar uma String, ignorando as letras depois do indice passado
	 * @param nome String a ser encurtada
	 * @param num Indice final para ser encurtada
	 * @return String encurtada
	 */
	public static String encurtarNome(String nome, int num){
		
		if(nome.length() > num)
			nome = nome.substring(0, num);
		
		return nome;	
		
	}
	
	/**
	 * Função que cria uma string pronta de dados da pessoa para printar no NFC-E
	 * @param cpfPessoa Nome do arquivo (sem extensão)
	 * @return String pronta
	 */
	private static String stringPessoa(String cpfPessoa){
		
		String str = "";
		
		try {
			
			FileReader fr = new FileReader(cpfPessoa + ".txt");
			BufferedReader br = new BufferedReader(fr);
			String nome = br.readLine();
			String endereco = br.readLine();
			br.close();
			fr.close();
			
			nome = encurtarNome(nome, 80);
			
			endereco = encurtarNome(endereco, 80);
			
			str = String.format("%-80s", nome) + "\nENDEREÇO: " + String.format("%-80s", endereco) + "\n\n";
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		} catch (Exception e) {
			
		}
		
		return str;
		
	}
 
	/**
	 * Função que cria uma string pronta de dados do produto para printar no NFC-E
	 * @param produtos Hashmap dos produtos
	 * @param quantidade Hashmap da quantidade de produtos
	 * @param valores Hashmap dos valores dos produtos
	 * @return String pronta
	 */
	private static String stringProdutos(HashMap<Integer, String> produtos, HashMap<Integer, Integer> quantidade, HashMap<Integer, Float> valores){
		
		String str = "";
		
		for(int i = 0; i < produtos.size(); i++)	
			str += Telas.linhaProdutos(produtos, quantidade, valores, i);
		
		return str;
		
	}
	
	/**
	 * Função que cria uma string pronta do valor total da compra para printar no NFC-E
	 * @param valores Hashmap dos valores dos produtos
	 * @param quantidade Hashmap da quantidade de produtos
	 * @return String pronta
	 */
	private static String totalCompra(HashMap<Integer, Float> valores, HashMap<Integer, Integer> quantidade){
		
		String str = "";
		float total = 0;
		
		for(int i = 0; i < valores.size(); i++)
			total += quantidade.get(i) * valores.get(i);
		
		str = String.format("%.2f", total);
		
		return str;
		
	}
	
	/**
	 * Coleta o valor de venda do produto
	 * @param barra cod barras
	 * @return preço do produto
	 */
	public float coletarValor(String barra){
		
		String valorStr = "0";
		float valor = 0;
		
		try {
			
			FileReader fr = new FileReader(barra + ".txt");
			BufferedReader br = new BufferedReader(fr);
			
			for(int i = 0; i < 3; i++){
				
				br.readLine();
				
				if(i == 1)
					valorStr = br.readLine();
				
			}
			
			br.close();
			fr.close();
			
			valor = Float.parseFloat(valorStr);
			
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} catch (Exception e) {

		}
		
		return valor;
		
	}
	
	/**
	 * Gera uma interface de "NFC-E" e salva no arquivo
	 * @param produtos Hashmap dos produtos
	 * @param valores Hashmap dos valores dos produtos
	 * @param quantidade Hashmap da quantidade de produtos
	 * @param vendedor Nome do arquivo do vendedor (sem extensão)
	 * @param cliente Nome do arquivo do cliente (sem extensão)
	 */
	public void compra(HashMap<Integer, String> produtos, HashMap<Integer, Float> valores, HashMap<Integer, Integer> quantidade,String vendedor, String cliente){
		
		FileWriter arq;
		
		java.util.Date data = new Date();
		String strData = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(data);
		
		try {	
			
			arq = new FileWriter("Historicodevendas.txt",true);
			PrintWriter gravarArq = new PrintWriter(arq);
			
			String conteudo = "\n\n///////////////////////////////////////CORTE DA FITA//////////////////////////////////////\n"
							+ "\n##########################################################################################\n"
							+ "                                      PADARIA DO XICO                                     \n"
							+ "##########################################################################################\n"
							+ "\nVENDEDOR: " + stringPessoa(vendedor) 
							+ "CLIENTE: " + stringPessoa(cliente + "_cliente")
							+ "##########################################################################################\n"
							+ "\n\n__________________________________________________________________________________________"
							+ "\nQTD | DESCRIÇÃO                                            |  VALOR UN  |   VALOR TOTAL  |"
							+ "\n" + stringProdutos(produtos, quantidade, valores) 
							+ "\nTOTAL: R$ " + totalCompra(valores, quantidade)
							+ "\n\n" + strData
							+ "\n\n##########################################################################################";
					
		    
			gravarArq.write(conteudo);
		    gravarArq.close();
		    
		    System.out.println("\nNFC-E SALVA COM SUCESSO !");
			    
		} catch (IOException e) {
			System.out.println("\nERRO AO SALVAR A NFC-E !");
		} catch (Exception e) {
			System.out.println("\nERRO AO SALVAR A NFC-E !");
		}

	}

	/**
	 * Calcula o valor total da venda
	 * @param quantidade Hashmap da quantidade de produtos
	 * @param valores Hashmap dos valores dos produtos
	 * @return valor total da venda
	 */
	public float calcularValorTotal(HashMap<Integer, Integer> quantidade, HashMap<Integer, Float> valores) {
		
		float total = 0;
		
		for(int i = 0; i < quantidade.size(); i++){
			
			total += quantidade.get(i) * valores.get(i);
			
		}
		
		
		return total;
	}

	

}