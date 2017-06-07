package Principal;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import Tratamentos.TratamentoCpf;

/**
 * Classe com todas as fun��es e o funcionamento da venda 
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
	 * Coleta e retorna um cpf v�lido
	 * @return CPF em String
	 */
	private static String coletarCpf(String pessoa){
		
		boolean valido = false;
		String cpf = "";
		
		leitor = new Scanner(System.in);
		TratamentoCpf tCpf = new TratamentoCpf();

		while(valido != true){
		
			System.out.print("Digite o CPF do " + pessoa + " : ");
			cpf = leitor.nextLine();
			
			if(tCpf.cpfValido(cpf) == true)
				valido = true;
			else
				System.out.println("Cpf inv�lido, try again !");
				
		}
		
		return cpf;
		
	}
	
	private String coletarSenha(String pessoa) {
		
		
		System.out.print("Digite a senha do " + pessoa + " : ");
		String senha = leitor.nextLine();
		
		return senha;
	}
	
	// FALTA VERIFICAR SE EST� CADASTRADO NO ARQUIVO
	/**
	 * Verifica se o CPF do vendedor � v�lido e se est� cadastrado
	 * @return cpf do vendedor corretamente
	 */
	public String entrarComCpfVendedor(){
		
		boolean cadastrado = false;
		String cpf = "";
		String senha = "";
		
		while (cadastrado != true){
			
			cpf = coletarCpf("Vendedor");
			senha = coletarSenha("Vendedor");
			
			String str = cpf + "_" + senha + ".txt";
			
			cadastrado = arquivo.verificarArquivoJaExistente(str);
				// TODO: handle exception
			
			if(cadastrado == false)
				return "As informa��es n�o conferem!";
			
		}
		
		return cpf + "_" + senha;
		
	}

	// FALTA VERIFICAR SE EST� CADASTRADO NO ARQUIVO
	/**
	 * Verifica se o CPF do CLIENTE � v�lido e se est� cadastrado
	 * @return cpf do CLIENTE corretamente
	 */
	public String entrarComCpfCliente(){
			
		boolean cadastrado = false;
		String cpf = "";
		
		while (cadastrado != true){
			
			cpf = coletarCpf("Cliente");
			
			cadastrado = arquivo.verificarArquivoJaExistente(cpf + ".txt");
			
			if(cadastrado == false)
				return "As informa��es n�o conferem!";
			
		}
		
		return cpf;
		
	}
	
	// FALTA VERIFICAR SE EST� CADASTRADO NO ARQUIVO
	/**
	 * Verifica se o produto est� cadastrado
	 * @return barras do produto cadastrado
	 */
	public String coletarProduto(){
		
		leitor = new Scanner(System.in);
		
		String barras = "";
		boolean cadastrado = false;
		
		while(cadastrado != true){
			
			System.out.println("Codigo de barra do produto: ");
			barras = leitor.nextLine();
			
			cadastrado = arquivo.verificarArquivoJaExistente(barras + ".txt");
			
			if(cadastrado == false)
				System.out.println("Produto n�o cadastrado!");
			
		}
		
		return barras;
		
	}
	
	public String nomeProduto(String barra){
		
		String str = "";
		
		try {
			
			FileReader fr = new FileReader(barra + ".txt");
			BufferedReader br = new BufferedReader(fr);
			
			str = br.readLine();
			
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return str;
		
	}
	
	/**
	 * Coleta uma quantidade v�lida para atribuir aos produtos
	 * @return quantidade de intens
	 */
	public int coletarQuantidade(){
		
		int qtd = 1;
		boolean valido = false;
		
		leitor = new Scanner(System.in);
		
		while (valido != true) {

			try {
				
				System.out.print("Quantidade do Produto (0 para encerrar a venda): ");
				qtd = leitor.nextInt();
				
				if(qtd > -1 && qtd <= 1000)
					valido = true;
				else
					System.out.println("Digite uma quantidade entre 1 e 1000");
				
			} catch (InputMismatchException e) {
				System.out.println("Digite um valor v�lido");
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
