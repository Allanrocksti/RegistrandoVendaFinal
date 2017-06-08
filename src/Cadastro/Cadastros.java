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
	private Scanner leitor;
	
	/**
	 * Realiza o cadastro do produto
	 * @return Uma string com os dados em s�rie para salvar no arquivo
	 */
	public String produto() {
		
		String msg = "";
		TratamentoValor tratamento = new TratamentoValor();
		arquivo = new Arquivo();
		
		System.out.print("\nC�DIGO DE BARRAS: ");
		String barras = scanner.nextLine();
		
		if(barras.length() != 13 || TratamentoBarras.verificarCaracteresInvalidos(barras) == true){
			msg = "\nC�DIGO DE BARRAS INV�LIDO\nPOR FAVOR, ULTILIZE UM C�DIGO DO TIPO EAN-13 !\n";
		}else if(arquivo.verificarArquivoJaExistente(barras + ".txt") == false){

			try {
				
				System.out.print("NOME DO PRODUTO: ");
				String nome = scanner.nextLine();
				
				nome = Compra.encurtarNome(nome, 52);
				
				nome = nome.toUpperCase();
				
				float valorCusto;
				float valorVenda;
				
				while (true) {
					
					valorCusto = nextFloat("CUSTO");
					valorVenda = nextFloat("VENDA");
					
					msg = tratamento.verificarValores(valorCusto, valorVenda);
					
					if(msg != "ok")
						System.out.println(msg);
					else
						break;
					
				}
				
				if(msg == "ok"){
						
					Produto produto = new Produto(barras, nome, valorCusto, valorVenda);
					msg = colecoes.addProduto(produto);
					msg = arquivo.salvarCadastro(barras + ".txt", msg);
					msg = "PRODUTO " + msg;
					
				}
				
			} catch (InputMismatchException e) {
				msg = "\nDIGITE UM VALOR CORRETO E N�O UTILIZE \".\" , UTILIZE \",\" ";
			} catch (Exception e){
				msg = "\nDIGITE UM VALOR CORRETO E N�O UTILIZE \".\" , UTILIZE \",\"";
			}
			
		}else{
			msg = "PRODUTO J� CADASTRADO";
		}

		return msg;
		
	}

	/**
	 * Fun��o para coletar valor sem ocorrer erro de buffer
	 * @param str nome do valor
	 * @return valor
	 */
	private float nextFloat(String str) {
		
		float num;
		String aux;
		leitor = new Scanner(System.in);
		
		while(true){
		
			try {
				
				System.out.print("\nDIGITE O VALOR DE " + str + ": ");
				aux = leitor.nextLine();
				num = Float.parseFloat(aux);
				break;
				
			} catch (InputMismatchException e) {
				System.out.println("\nDIGITE UM VALOR CORRETO E N�O UTILIZE \".\" , UTILIZE \",\" ");
			} catch (Exception e){
				System.out.println("\nDIGITE UM VALOR CORRETO E N�O UTILIZE \".\" , UTILIZE \",\" ");
			}

			
		}
		
		return num;
		
	}

	/**
	 * Realiza o cadastro do cliente
	 * @return Uma string com os dados em s�rie para salvar no arquivo
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
				
				System.out.print("ENDERE�O DO CLIENTE: ");
				String endereco = scanner.nextLine();
				endereco = endereco.toUpperCase();
				
				Pessoa cliente = new Pessoa(nome, endereco, cpf);
				msg = colecoes.addCliente(cliente);
				msg = arquivo.salvarCadastro(cpf + "_cliente.txt", msg);
				msg = "CLIENTE " + msg;
				
			}else{
				msg = "CLIENTE J� CADASTRADO !";
			}
			
		}else{
			msg = "CPF INCORRETO !";
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
		
		System.out.print("\nCPF DO VENDEDOR: ");
		String cpf = scanner.nextLine();

		if(tratamentoCpf.cpfValido(cpf) == true){
		
			if(arquivo.verificarArquivoJaExistente(cpf + ".txt") == false){
				
				System.out.print("SENHA DO VENDEDOR: ");
				String senha = scanner.nextLine();
				
				System.out.print("NOME DO VENDEDOR: ");
				String nome = scanner.nextLine();
				nome = nome.toUpperCase();
				
				System.out.print("ENDERE�O DO VENDEDOR: ");
				String endereco = scanner.nextLine();
				endereco = endereco.toUpperCase();
				
				Vendedor vendedor = new Vendedor(nome, endereco, cpf, senha);
				msg = colecoes.addVendedor(vendedor);
				msg = arquivo.salvarCadastro(cpf + ".txt", msg);
				msg = "VENDEDOR " + msg;
				
				
			}else{
				msg = "VENDEDOR J� CADASTRADO !";
			}
			
		}else{
			msg = "CPF INCORRETO !";
		}
		
		return msg;
		
	}

}
