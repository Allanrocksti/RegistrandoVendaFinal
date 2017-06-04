import java.util.Scanner;
import Tratamentos.TratamentoCpf;

//**************************************************************************************
// O QUE AINDA FALTA?
//
// FALTA IMPLEMENTAR UM ERRO PARA QUANDO JÁ CADASTRADO
// ...
//**************************************************************************************

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

	//*********************************************************************
	// ANTES DE DORMIR PENSEI, NÃO É MELHOR FAZER UM WHILE EM CADA UM?
	// PARA A PESSOA NÃO TER QUE COMEÇAR DO ZERO NOVAMENTE
	//*********************************************************************
	
	public boolean produto() {
		
		boolean cadastroValido;
		
		System.out.print("Código de barras: ");
		String barras = scanner.nextLine();
		
		if(barras.length() != 13){
			System.out.println("Código de barras inválido!");
			cadastroValido = false;
		}else{

			System.out.print("Nome do produto: ");
			String nome = scanner.nextLine();
			
			System.out.print("Valor de custo: ");
			float valorCusto = scanner.nextFloat();
			
			System.out.print("Valor de venda: ");
			float valorVenda = scanner.nextFloat();
			
			// NÃO ENTENDI BEM A A CLASSE EXTRA
			// MAS SE ELA FOR PARA ERROS NO VALOR DIGITADO
			// CRIA UMA EXCESSÃO PARA O VALORVENDA NÃO SER MENOR QUE VALORCUSTO
			float valor = extra.verificarF(dado);
			
			//if(se der tudo certo){
				//Produto produto = new Produto(barras, nome, valorVenda, valor);
				// SALVAR CLIENTE EM ARQUIVO SEPARADO PARA CLIENTES
				// TEM ALGUMA FORMA DE SALVAR COM HASHMAP OU ALGO DO TIPO?
				//cadastroValido = true;
			//}else{
				//cadastroValido = false;
			//}
		}

		return cadastroValido;
		
	}
	
	// FALTA IMPLEMENTAR AS MENSAGENS DE ERRO CORRETAS
	/**
	 * Cadastra e salva em arquivo o cliente
	 * @return Retorna um valor booleano para confirmar o cadastro true = ok false = falhou
	 */
	public boolean cliente(){
		
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
	
	// FALTA IMPLEMENTAR AS MENSAGENS DE ERRO CORRETAS
	/**
	 * Cadastra e salva em arquivo o vendedor
	 * @return Retorna um valor booleano para confirmar o cadastro true = ok false = falhou
	 */
	public boolean vendedor(){
		
		TratamentoCpf tratamentoCpf = new TratamentoCpf();
		
		boolean cadastroValido;
		
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		
		System.out.print("Endereço: ");
		String endereco = scanner.nextLine();
		
		System.out.print("Cpf: ");
		String cpf = scanner.nextLine();
		
		//ENTRADA DA SENHA NÃO IMPLEMENTADA
		
		if(tratamentoCpf.cpfValido(cpf) == true)
			cadastroValido = true;
		else
			cadastroValido = false;
		
		if(cadastroValido == true){
			
			Vendedor vendedor = new Vendedor(nome, endereco, cpf, senha);
			// SALVAR VENDEDOR EM ARQUIVO SEPARADO PARA VENDEDORES
			// TEM ALGUMA FORMA DE SALVAR COM HASHMAP OU ALGO DO TIPO?
			
		}
		
		return cadastroValido;
		
	}

	/**
	 * Método para teste de cadastro, e printa o resultado
	 * @param status Valor booleano que informa se cadastrou ou não
	 */
	public void testeCadastro(boolean status){
		
		if(status == true)
			System.out.println("Cadastrado com sucesso!");
		else
			System.out.println("Erro no cadastro");
		
	}
}
