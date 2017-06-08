package Cadastro;

import java.util.InputMismatchException;
import java.util.Scanner;

import Principal.Arquivo;
import Principal.Compra;
import Tratamentos.TratamentoBarras;
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
	 * @return Uma string com os dados em série para salvar no arquivo
	 */
	public String produto() {
		
		String msg = "";
		TratamentoValor tratamento = new TratamentoValor();
		arquivo = new Arquivo();
		
		System.out.print("\nCÓDIGO DE BARRAS: ");
		String barras = scanner.nextLine();
		
		if(barras.length() != 13 || TratamentoBarras.verificarCaracteresInvalidos(barras) == true){
			msg = "\nCÓDIGO DE BARRAS INVÁLIDO\nPOR FAVOR, ULTILIZE UM CÓDIGO DO TIPO EAN-13 !\n";
		}else if(arquivo.verificarArquivoJaExistente(barras + ".txt") == false){

			try {
				
				System.out.print("NOME DO PRODUTO: ");
				String nome = scanner.nextLine();
				
				nome = Compra.encurtarNome(nome, 52);
				
				nome = nome.toUpperCase();
				
				System.out.print("VALOR DE CUSTO: ");
				float valorCusto = scanner.nextFloat();
				scanner.nextLine();
				
				System.out.print("VALOR DE VENDA: ");
				float valorVenda = scanner.nextFloat();
				scanner.nextLine();

				msg = tratamento.verificarValores(valorCusto, valorVenda);
				
				if(msg == "ok"){
						
					Produto produto = new Produto(barras, nome, valorCusto, valorVenda);
					msg = colecoes.addProduto(produto);
					msg = arquivo.salvarCadastro(barras + ".txt", msg);
					msg = "PRODUTO " + msg;
					
				}
				
			} catch (InputMismatchException e) {
				msg = "DIGITE UM VALOR CORRETO E NÃO UTILIZE \".\" , UTILIZE \",\" ";
			} catch (Exception e){
				msg = "OCORREU UM ERROR, TENTE NOVAMENTE !";
			}
			
		}else{
			msg = "PRODUTO JÁ CADASTRADO";
		}

		return msg;
		
	}
	
	/**
	 * Realiza o cadastro do cliente
	 * @return Uma string com os dados em série para salvar no arquivo
	 */
	public String cliente(){
		
		TratamentoCpf tratamentoCpf = new TratamentoCpf();
		arquivo = new Arquivo(); 
		
		String msg = "";
		
		System.out.print("\nCPF DO CLIENTE: ");
		String cpf = scanner.nextLine();
		
		if(tratamentoCpf.cpfValido(cpf) == true){
			
			if(arquivo.verificarArquivoJaExistente(cpf + "_cliente.txt") == false){
				
				System.out.print("NOME DO CLIENTE: ");
				String nome = scanner.nextLine();
				nome = nome.toUpperCase();
				
				System.out.print("ENDEREÇO DO CLIENTE: ");
				String endereco = scanner.nextLine();
				endereco = endereco.toUpperCase();
				
				Pessoa cliente = new Pessoa(nome, endereco, cpf);
				msg = colecoes.addCliente(cliente);
				msg = arquivo.salvarCadastro(cpf + "_cliente.txt", msg);
				msg = "CLIENTE " + msg;
				
			}else{
				msg = "CLIENTE JÁ CADASTRADO !";
			}
			
		}else{
			msg = "CPF INCORRETO !";
		}
		
		return msg;
		
	}
	
	/**
	 * Realiza o cadastro do vendedor 
	 * @return Uma string com os dados em série para salvar no arquivo
	 */
	public String vendedor(){
		
		TratamentoCpf tratamentoCpf = new TratamentoCpf();
		arquivo = new Arquivo();
		
		String msg =  "";
		
		System.out.print("\nCPF DO VENDEDOR: ");
		String cpf = scanner.nextLine();

		if(tratamentoCpf.cpfValido(cpf) == true){
		
			if(arquivo.verificarArquivoJaExistente(cpf + ".txt") == false){
				
				System.out.print("SENHA DO VENDEDOR: ");
				String senha = scanner.nextLine();
				
				System.out.print("NOME DO VENDEDOR: ");
				String nome = scanner.nextLine();
				nome = nome.toUpperCase();
				
				System.out.print("ENDEREÇO DO VENDEDOR: ");
				String endereco = scanner.nextLine();
				endereco = endereco.toUpperCase();
				
				Vendedor vendedor = new Vendedor(nome, endereco, cpf, senha);
				msg = colecoes.addVendedor(vendedor);
				msg = arquivo.salvarCadastro(cpf + ".txt", msg);
				msg = "VENDEDOR " + msg;
				
				
			}else{
				msg = "VENDEDOR JÁ CADASTRADO !";
			}
			
		}else{
			msg = "CPF INCORRETO !";
		}
		
		return msg;
		
	}

}
