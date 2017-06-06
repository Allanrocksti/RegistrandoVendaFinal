

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import Cadastro.Pessoa;
import Cadastro.Produto;

/**
 *@date 1 de jun de 2017
 *@author  Neto
 *@time	19:01:25
 */

/**
 * @author Aluízio Barbosa Maciel Neto
 *
 */
public class Arquivo {

	public void salvarCadastro(String str, String type){
		
		if(type == 1){
			
			FileWriter arq;
			
			try {
				arq = new FileWriter("Produto.txt",true);
				PrintWriter gravarArq = new PrintWriter(arq);
			    gravarArq.append(str);
			    gravarArq.close();
			    System.out.println("Produto cadastrado com sucesso!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     
		}else if(type == 2){
		 
			FileWriter arq;
			
			try {
				arq = new FileWriter("Cliente.txt");
				PrintWriter gravarArq = new PrintWriter(arq);
				gravarArq.write(str);
				gravarArq.close();
				System.out.println("Cliente cadastrado com sucesso!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(type == 3){
		 
			FileWriter arq;
			
			try {
				arq = new FileWriter("Vendedor.txt");
				PrintWriter gravarArq = new PrintWriter(arq);
				gravarArq.write(str);
				gravarArq.close();
				System.out.println("Vendedor cadastrado com sucesso!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(type == 4){
			FileWriter arq;
			
			try { 
				arq = new FileWriter("Venda.txt");
				PrintWriter gravarArq = new PrintWriter(arq);
				gravarArq.write(str);
				gravarArq.close();
				System.out.println("Venda Feita com sucesso!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
		
}
	
	public ArrayList<String> lerCadastro(String valor){
		
		ArrayList<String> valores = null;
		
		if(valor == "vendedor"){
			
			ArrayList<String> vendedores = new ArrayList<>();
			FileReader fr;
			
			try {
				fr = new FileReader("Vendedor.txt");
				BufferedReader lerArq = new BufferedReader(fr);
				vendedores.add(lerArq.readLine());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return vendedores;
			
		}
		
		if(valor == "produto"){
			
			ArrayList<String> produtos = new ArrayList<>();
			FileReader fr;
			
			try {
				fr = new FileReader("Produto.txt");
				BufferedReader lerArq = new BufferedReader(fr);
				
				for(int i = 0; i <100; i++)
					produtos.add(lerArq.readLine());
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return produtos;
			
		}
		
		if(valor == "cliente"){
			ArrayList<String> clientes = new ArrayList<>();
			FileReader fr;
			
			try {
				fr = new FileReader("Vendedor.txt");
				BufferedReader lerArq = new BufferedReader(fr);
				clientes.add(lerArq.readLine());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return clientes;
			
		}
		
		return valores;//SE NÃO ENTRAR EM NENHUM IF RETORNA NULL
	
	}
	
	
}
