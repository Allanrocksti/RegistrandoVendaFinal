import java.util.InputMismatchException;
import java.util.Scanner;
import Tratamentos.TratamentoCpf;

/**
 * Classe com todas as funções e o funcionamento da venda 
 * @author Allan Roque Barbosa da Silva - 1610013738
 *
 */

public class Venda {

	private static Scanner leitor;
	
	private int quantidade;
	private float subTotal;
	private float total;

	/**
	 * Coleta e retorna um cpf válido
	 * @return CPF em String
	 */
	private static String coletarCpf(){
		
		boolean valido = false;
		String cpf = "";
		
		leitor = new Scanner(System.in);
		TratamentoCpf tCpf = new TratamentoCpf();

		while(valido != true){
		
			System.out.print("Digite o CPF: ");
			cpf = leitor.nextLine();
			
			if(tCpf.cpfValido(cpf) == true)
				valido = true;
			else
				System.out.println("Cpf inválido, try again !");
				
		}
		
		return cpf;
		
	}
	
	// FALTA VERIFICAR SE ESTÁ CADASTRADO NO ARQUIVO
	/**
	 * Verifica se o CPF do vendedor é válido e se está cadastrado
	 * @return cpf do vendedor corretamente
	 */
	public String entrarComCpfVendedor(){
		
		boolean cadastrado = false;
		
		while (cadastrado != false){
			
			String cpf = coletarCpf();
			
			// IF (TÁ CADASTRADO? == SIM)
				//cadastrado = true;
			// ELSE
				// NAO CADASTRADO DIGITE DENOVO
			
		}
		
		return cpf;
		
	}
	
	// FALTA VERIFICAR SE ESTÁ CADASTRADO NO ARQUIVO
	/**
	 * Verifica se o CPF do CLIENTE é válido e se está cadastrado
	 * @return cpf do CLIENTE corretamente
	 */
	public String entrarComCpfCliente(){
			
		boolean cadastrado = false;
		
		while (cadastrado != false){
			
			String cpf = coletarCpf();
			
			// IF (TÁ CADASTRADO? == SIM)
				//cadastrado = true;
			// ELSE
				// NAO CADASTRADO DIGITE DENOVO
			
		}
		
		return cpf;
		
	}
	
	// FALTA VERIFICAR SE ESTÁ CADASTRADO NO ARQUIVO
	/**
	 * Verifica se o produto está cadastrado
	 * @return barras do produto cadastrado
	 */
	public String coletarProduto(){
		
		leitor = new Scanner(System.in);
		
		String barras = "";
		boolean cadastrado = false;
		
		while(cadastrado != false){
			
			System.out.println("Barras: ");
			barras = leitor.nextLine();
			
			// IF (TÁ CADASTRADO? == SIM)
				//cadastrado = true;
			// ELSE
				// NAO CADASTRADO DIGITE DENOVO
			
		}
		
		return barras;
		
	}
	
	/**
	 * Coleta uma quantidade válida para atribuir aos produtos
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
				System.out.println("Digite um valor válido");
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
