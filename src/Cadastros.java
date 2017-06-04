import java.util.Scanner;
import Tratamentos.TratamentoCpf;

/**
 *@date 3 de jun de 2017
 *@author  Neto
 *@time	21:41:50
 */

/**
 * @author Neto
 *
 */

public class Cadastros {

	private static Scanner scanner = new Scanner(System.in);

	Arquivo arquivo = new Arquivo();

	Extra extra = new Extra();

	public String produto() {
		Produto produto;
		String msg = "";
		System.out.println("Nome do produto: ");
		String nome = scanner.nextLine();
		System.out.println("Valor do produto: ");
		String dado = scanner.nextLine();
		float valor = extra.verificarF(dado);
		System.out.println("Codigo do produto: ");
		String codigo = scanner.nextLine();

		produto = new Produto(nome, valor, codigo);

		msg = Arquivo.salvarObjeto(produto);

		return msg;
	}
	
	public static boolean cliente(){
		
		// É CORRETO COLETAR UM OBJETO DESSA FORMA?
		//Pessoa cliente;
		TratamentoCpf tratamentoCpf = new TratamentoCpf();
		
		boolean cadastroValido;
		
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		
		System.out.print("Endereço: ");
		String endereco = scanner.nextLine();
		
		System.out.print("Cpf: ");
		String cpf = scanner.nextLine();
		
		if(tratamentoCpf.cpfValido(cpf) == true)
			cadastroValido = true;
		else
			cadastroValido = false;
		
		if(cadastroValido == true){
			
			Pessoa cliente = new Pessoa(nome, endereco, cpf);
			// SALVAR CLIENTE EM ARQUIVO SEPARADO PARA CLIENTES
			// TEM ALGUMA FORMA DE SALVAR COM HASHMAP OU ALGO DO TIPO?
			
		}
		
		return cadastroValido;
		
	}
	
}
