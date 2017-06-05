package Cadastro;

import java.util.InputMismatchException;
import java.util.Scanner;

import Tratamentos.TratamentoCpf;
import Tratamentos.TratamentoValor;

//**************************************************************************************
// O QUE AINDA FALTA?
//
// FALTA IMPLEMENTAR UM ERRO PARA QUANDO JÁ CADASTRADO
// ...
//**************************************************************************************

/**
 * Classe que implementa o cadastro e retorna a String para salvar no arquivo
 * 
 * Cadastros: Produto, Cliente e Vendedor
 * 
 * @author Allan Roque Barbosa da Silva - 1610013738
 *
 */

public class Cadastros {

	private static Scanner scanner = new Scanner(System.in);
	private static GeradorStr colecoes = new GeradorStr();
	
	/**
	 * Realiza o cadastro do produto
	 * @return Uma string com os dados em série para salvar no arquivo
	 */
	public String produto() {
		
		String msg = "";
		
		TratamentoValor tratamento = new TratamentoValor();
		
		System.out.print("Código de barras: ");
		String barras = scanner.nextLine();
		
		if(barras.length() != 13){
			msg = "Códigos de barras inválido\n Por favor, ultilize um código do tipo EAN-13 !\n";
		}else{

			try {
				
				
				
				System.out.print("Nome do produto: ");
				String nome = scanner.nextLine();
				
				System.out.print("Valor de custo: ");
				float valorCusto = scanner.nextFloat();
				
				System.out.print("Valor de venda: ");
				float valorVenda = scanner.nextFloat();

				msg = tratamento.verificarValores(valorCusto, valorVenda);
				
				if(msg == "ok"){
					
					// IF (JA EXISTE == FALSE)
					
					Produto produto = new Produto(barras, nome, valorCusto, valorVenda);
					msg = colecoes.addProduto(produto);
					
					// ELSE
						// msg = "Já existe"
					
				}
				
			} catch (InputMismatchException e) {
				msg = "Digite um valor correto e não ultilize \".\" , ultilize \",\" ";
			} catch (Exception e){
				msg = "Erro!";
			}
			
		}

		return msg;
		
	}
	
	/**
	 * Realiza o cadastro do cliente
	 * @return Uma string com os dados em série para salvar no arquivo
	 */
	public String cliente(){
		
		TratamentoCpf tratamentoCpf = new TratamentoCpf();
		
		String msg = "";
		
		System.out.print("Cpf: ");
		String cpf = scanner.nextLine();
		
		if(tratamentoCpf.cpfValido(cpf) == true){
			
			// IF (JA EXISTE == FALSE)
			
			System.out.print("Nome: ");
			String nome = scanner.nextLine();
			
			System.out.print("Endereço: ");
			String endereco = scanner.nextLine();
			
			Pessoa cliente = new Pessoa(nome, endereco, cpf);
			msg = colecoes.addCliente(cliente);
			
			// ELSE
				// msg = "Já existe"
			
		}else{
			msg = "Cpf incorreto!";
		}
		
		return msg;
		
	}
	
	/**
	 * Realiza o cadastro do vendedor 
	 * @return Uma string com os dados em série para salvar no arquivo
	 */
	public String vendedor(){
		
		TratamentoCpf tratamentoCpf = new TratamentoCpf();
		
		String msg =  "";
		
		System.out.print("Cpf: ");
		String cpf = scanner.nextLine();
		
		if(tratamentoCpf.cpfValido(cpf) == true){
		
			// IF (JA EXISTE == FALSE)
			
			System.out.print("Nome: ");
			String nome = scanner.nextLine();
			
			System.out.print("Endereço: ");
			String endereco = scanner.nextLine();
			
			System.out.print("Senha: ");
			String senha = scanner.nextLine();
			
			Vendedor vendedor = new Vendedor(nome, endereco, cpf, senha);
			msg = colecoes.addVendedor(vendedor);
			
			// ELSE
				// msg = "Já existe"
			
		}else{
			msg = "Cpf incorreto!";
		}
		
		return msg;
		
	}

}
