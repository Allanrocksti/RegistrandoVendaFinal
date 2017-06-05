import java.util.Scanner;
import Tratamentos.TratamentoCpf;

/**
 * Classe com todas as funções e o funcionamento da venda 
 * @author Allan Roque Barbosa da Silva - 1610013738
 *
 */

public class Venda {

	private static Scanner leitor;
	
	private float subTotal;
	private float total;
	private float desconto;

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

	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	
}
