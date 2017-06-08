package Principal;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import Tratamentos.TratamentoBarras;
import Tratamentos.TratamentoCpf;

/**
 * Classe com todas as funções e o funcionamento da venda 
 * @author Allan Roque Barbosa da Silva - 1610013738
 *
 */ 

public class Venda {

	private static Scanner leitor;
	Arquivo arquivo = new Arquivo();
	
	private int quantidade;
	private float subTotal;
	private float total;

	/**
	 * Coleta e retorna um cpf válido
	 * @return CPF em String
	 */
	private static String coletarCpf(String pessoa){
		
		boolean valido = false;
		String cpf = "";
		
		leitor = new Scanner(System.in);
		TratamentoCpf tCpf = new TratamentoCpf();

		while(valido != true){
		
			System.out.print("\nDIGITE O CPF DO " + pessoa + " : ");
			cpf = leitor.nextLine();
			
			if(tCpf.cpfValido(cpf) == true)
				valido = true;
			else
				System.out.println("CPF INVÁLIDO, TENTE NOVAMENTE !");
				
		}
		
		return cpf;
		
	}
	
	/**
	 * Coleta a senha
	 * @param pessoa 
	 * @return String da senha
	 */
	private String coletarSenha(String pessoa) {
		
		
		System.out.print("DIGITE A SENHA DO " + pessoa + " : ");
		String senha = leitor.nextLine();
		
		return senha;
	}
	
	/**
	 * Verifica se o CPF do vendedor é válido e se está cadastrado
	 * @return O nome do arquivo salvo
	 */
	public String entrarComCpfVendedor(){
		
		boolean cadastrado = false;
		String cpf = "";
		String senha = "";
		
		while (cadastrado != true){
			
			cpf = coletarCpf("VENDEDOR");
			senha = coletarSenha("VENDEDOR");
			
			String str = cpf + "_" + senha + ".txt";
			
			cadastrado = arquivo.verificarArquivoJaExistente(str);
			
			if(cadastrado == false)
				return "vendedor não cadastrado";
			
		}
		
		return cpf + "_" + senha;
		
	}

	/**
	 * Verifica se o CPF do CLIENTE é válido e se está cadastrado
	 * @return O cpf do cliente valido
	 */
	public String entrarComCpfCliente(){
			
		boolean cadastrado = false;
		String cpf = "";
		
		while (cadastrado != true){
			
			cpf = coletarCpf("CLIENTE");
			
			cadastrado = arquivo.verificarArquivoJaExistente(cpf + "_cliente.txt");
			
			if(cadastrado == false)
				return "Cliente não cadastrado";
			
		}
		
		return cpf;
		
	}
	
	/**
	 * Verifica se o produto está cadastrado
	 * @return barras do produto cadastrado
	 */
	public String coletarProduto(){
		
		leitor = new Scanner(System.in);
		
		String barras = "";
		boolean cadastrado = false;
		
		while(cadastrado != true){
			
			System.out.print("BARRAS: ");
			barras = leitor.nextLine();
			
			if(barras.length() == 13 && TratamentoBarras.verificarCaracteresInvalidos(barras) == false){
				cadastrado = arquivo.verificarArquivoJaExistente(barras + ".txt");
				
				if(cadastrado == false)
					System.out.println("PRODUTO NÃO CADASTRADO!");
				
			}else{
				System.out.println("\nCÓDIGO DE BARRAS INVÁLIDO\nPOR FAVOR, ULTILIZE UM CÓDIGO DO TIPO EAN-13 !\n");
			}
			
		}
		
		return barras;
		
	}
	
	/**
	 * Coleta o nome do produto a partir do cod barras
	 * @param barra
	 * @return nome do produto
	 */
	public String nomeProduto(String barra){
		
		String str = "";
		
		try {
			
			FileReader fr = new FileReader(barra + ".txt");
			BufferedReader br = new BufferedReader(fr);
			
			str = br.readLine();
			
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
		
		} catch (IOException e) {
		
		} catch (Exception e) {
		
		}
		
		return str;
		
	}
	
	/**
	 * Coleta uma quantidade válida para atribuir aos produtos
	 * @return quantidade de itens
	 */
	public int coletarQuantidade(){
		
		int qtd = 1;
		boolean valido = false;
		
		leitor = new Scanner(System.in);
		
		while (valido != true) {

			try {
				
				System.out.print("\nQUANTIDADE (0 PARA ENCERRAR A VENDA): ");
				qtd = leitor.nextInt();
				
				if(qtd > -1 && qtd <= 100)
					valido = true;
				else
					System.out.println("\nDIGITE UMA QUANTIDADE ENTRE 1 E 100 !");
				
			} catch (InputMismatchException e) {
				System.out.println("\nDIGITE UM VALOR VÁLIDO !");
				leitor.nextLine();
			}
			
		}
		
		return qtd;
		
	}
	
	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
