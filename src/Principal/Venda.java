package Principal;
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
	private static Arquivo arquivo;
	
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
	
	private String coletarSenha() {
		
		String senha = "";
		leitor = new Scanner(System.in);
		
		System.out.print("Senha: ");
		senha = leitor.nextLine();
		
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
		
		while (cadastrado != true){
			
			cpf = coletarCpf("Vendedor");
			String senha = coletarSenha();
			
			cadastrado = arquivo.verificarArquivoJaExistente(cpf + "_" + senha + ".txt");
			
			if(cadastrado == false)
				System.out.println("Vendedor n�o cadastrado!");
			
		}
		
		return cpf;
		
	}

	// FALTA VERIFICAR SE EST� CADASTRADO NO ARQUIVO
	/**
	 * Verifica se o CPF do CLIENTE � v�lido e se est� cadastrado
	 * @return cpf do CLIENTE corretamente
	 */
	public String entrarComCpfCliente(){
			
		boolean cadastrado = false;
		String cpf = "";
		
		while (cadastrado != false){
			
			cpf = coletarCpf("Cliente");
			
			cadastrado = arquivo.verificarArquivoJaExistente(cpf + ".txt");
			
			if(cadastrado == false)
				System.out.println("Cliente n�o cadastrado!");
			
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
		
		while(cadastrado != false){
			
			System.out.println("Barras: ");
			barras = leitor.nextLine();
			
			cadastrado = arquivo.verificarArquivoJaExistente(barras + ".txt");
			
			if(cadastrado == false)
				System.out.println("Produto n�o cadastrado!");
			
		}
		
		return barras;
		
	}
	
	/**
	 * Coleta uma quantidade v�lida para atribuir aos produtos
	 * @return quantidade de intens
	 */
	public int coletarQuantidade(){
		
		int qtd = 1;
		boolean valido = false;
		
		leitor = new Scanner(System.in);
		
		while (valido != false) {

			try {
				
				System.out.println("Quantidade: ");
				qtd = leitor.nextInt();
				
				if(qtd <= 1000 && qtd > 0)
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
