import java.util.Scanner;
import Tratamentos.TratamentoCpf;

//**************************************************************************************
// O QUE AINDA FALTA?
//
// FALTA IMPLEMENTAR UM ERRO PARA QUANDO J� CADASTRADO
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
	// ANTES DE DORMIR PENSEI, N�O � MELHOR FAZER UM WHILE EM CADA UM?
	// PARA A PESSOA N�O TER QUE COME�AR DO ZERO NOVAMENTE
	//*********************************************************************
	
	public boolean produto() {
		
		boolean cadastroValido;
		
		System.out.print("C�digo de barras: ");
		String barras = scanner.nextLine();
		
		if(barras.length() != 13){
			System.out.println("C�digo de barras inv�lido!");
			cadastroValido = false;
		}else{

			System.out.print("Nome do produto: ");
			String nome = scanner.nextLine();
			
			System.out.print("Valor de custo: ");
			float valorCusto = scanner.nextFloat();
			
			System.out.print("Valor de venda: ");
			float valorVenda = scanner.nextFloat();
			
			// N�O ENTENDI BEM A A CLASSE EXTRA
			// MAS SE ELA FOR PARA ERROS NO VALOR DIGITADO
			// CRIA UMA EXCESS�O PARA O VALORVENDA N�O SER MENOR QUE VALORCUSTO
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
		
		System.out.print("Endere�o: ");
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
		
		System.out.print("Endere�o: ");
		String endereco = scanner.nextLine();
		
		System.out.print("Cpf: ");
		String cpf = scanner.nextLine();
		
		//ENTRADA DA SENHA N�O IMPLEMENTADA
		
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
	 * M�todo para teste de cadastro, e printa o resultado
	 * @param status Valor booleano que informa se cadastrou ou n�o
	 */
	public void testeCadastro(boolean status){
		
		if(status == true)
			System.out.println("Cadastrado com sucesso!");
		else
			System.out.println("Erro no cadastro");
		
	}
}
