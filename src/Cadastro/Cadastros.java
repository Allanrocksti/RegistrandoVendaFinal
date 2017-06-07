package Cadastro;

import java.util.InputMismatchException;
import java.util.Scanner;

import Principal.Arquivo;
import Tratamentos.TratamentoCpf;
import Tratamentos.TratamentoValor;

/**
 * Classe que implementa o cadastro e retorna a String para salvar no arquivo
 * 
 * Cadastros: Produto, Cliente e Vendedor
 * 
 * @author Allan Roque Barbosa da Silva - 1610013738
 * 		   Aluizio Barbosa Maciel Neto - 1610015465
 *
 */

public class Cadastros {

	private static Scanner scanner = new Scanner(System.in);
	private static GeradorStr colecoes = new GeradorStr();
	private static Arquivo arquivo = new Arquivo();
	
	/**
	 * Realiza o cadastro do produto
	 * @return Uma string com os dados em s�rie para salvar no arquivo
	 */
	public String produto() {
		
		String msg = "";
		TratamentoValor tratamento = new TratamentoValor();
		arquivo = new Arquivo();
		
		System.out.print("C�digo de barras: ");
		String barras = scanner.nextLine();
		
		if(barras.length() != 13){
			msg = "C�digos de barras inv�lido\n Por favor, ultilize um c�digo do tipo EAN-13 !\n";
		}else if(arquivo.verificarArquivoJaExistente(barras + ".txt") == false){

			try {
				
				System.out.print("Nome do produto: ");
				String nome = scanner.nextLine();
				
				System.out.print("Valor de custo: ");
				float valorCusto = scanner.nextFloat();
				
				System.out.print("Valor de venda: ");
				float valorVenda = scanner.nextFloat();

				msg = tratamento.verificarValores(valorCusto, valorVenda);
				
				if(msg == "ok"){
						
					Produto produto = new Produto(barras, nome, valorCusto, valorVenda);
					msg = colecoes.addProduto(produto);
					msg = arquivo.salvarCadastro(barras + ".txt", msg);
					msg = "Produto " + msg;
					
				}
				
			} catch (InputMismatchException e) {
				msg = "Digite um valor correto e n�o ultilize \".\" , ultilize \",\" ";
			} catch (Exception e){
				msg = "Erro!";
			}
			
		}else{
			msg = "Produto J� cadastrado";
		}

		return msg;
		
	}
	
	/**
	 * Realiza o cadastro do cliente
	 * @return Uma string com os dados em s�rie para salvar no arquivo
	 */
	public String cliente(){
		
		TratamentoCpf tratamentoCpf = new TratamentoCpf();
		arquivo = new Arquivo(); 
		
		String msg = "";
		
		System.out.print("Cpf: ");
		String cpf = scanner.nextLine();
		
		if(tratamentoCpf.cpfValido(cpf) == true){
			
			if(arquivo.verificarArquivoJaExistente(cpf + ".txt") == false){
				
				System.out.print("Nome: ");
				String nome = scanner.nextLine();
				
				System.out.print("Endere�o: ");
				String endereco = scanner.nextLine();
				
				Pessoa cliente = new Pessoa(nome, endereco, cpf);
				msg = colecoes.addCliente(cliente);
				msg = arquivo.salvarCadastro(cpf + ".txt", msg);
				msg = "Cliente " + msg;
				
			}else{
				msg = "Cliente j� cadastrado !";
			}
			
		}else{
			msg = "Cpf incorreto!";
		}
		
		return msg;
		
	}
	
	/**
	 * Realiza o cadastro do vendedor 
	 * @return Uma string com os dados em s�rie para salvar no arquivo
	 */
	public String vendedor(){
		
		TratamentoCpf tratamentoCpf = new TratamentoCpf();
		arquivo = new Arquivo();
		
		String msg =  "";
		
		System.out.print("Cpf: ");
		String cpf = scanner.nextLine();
		
		
		
		if(tratamentoCpf.cpfValido(cpf) == true){
			System.out.print("Senha: ");
			String senha = scanner.nextLine();
		
			if(arquivo.verificarArquivoJaExistente(cpf + "_" + senha + ".txt") == false){
				
				System.out.print("Nome: ");
				String nome = scanner.nextLine();
				
				System.out.print("Endere�o: ");
				String endereco = scanner.nextLine();
				
				Vendedor vendedor = new Vendedor(nome, endereco, cpf, senha);
				msg = colecoes.addVendedor(vendedor);
				msg = arquivo.salvarCadastro(cpf + "_" + senha + ".txt", msg);
				msg = "Vendedor " + msg;
				
				
			}else{
				msg = "Vendedor j� Cadastrado";
			}
			
		}else{
			msg = "Cpf incorreto!";
		}
		
		return msg;
		
	}

}
