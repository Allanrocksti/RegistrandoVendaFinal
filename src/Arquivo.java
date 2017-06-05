

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Cadastro.Pessoa;
import Cadastro.Produto;

/**
 *@date 1 de jun de 2017
 *@author  Neto
 *@time	19:01:25
 */

/**
 * @author Neto
 *
 */
public class Arquivo {

	public static String salvarObjeto(Produto produto) {
		
		String msg = "";
		String nome = produto.getNome();
		
		try {
			
			FileOutputStream fos = new FileOutputStream(nome + ".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(produto);

			oos.close();
			fos.close();
			
			msg = "Arquivo Salvo com sucesso";

		}catch (IOException e) {
			
			System.out.println("Erro ao salvar o arquivo: ");
			e.printStackTrace();
			
		}

		return msg;
		
	}

	public static Compra lerObjeto(String nome) {

		Compra novo = null;
		
		try {
			
			FileInputStream fis = new FileInputStream(nome + ".ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			novo = (Compra) ois.readObject();
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}

		return novo;
	}

	public String salvarCliente(Pessoa cliente){
		
		String msg = "";
		
		try{
			
			FileOutputStream fos = new FileOutputStream("Clientes.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cliente);

			oos.close();
			fos.close();
			
			msg = "Arquivo Salvo com sucesso";
			
		}catch (Exception e) {
			msg = "Erro ao salvar o cliente!"; 
		}
		
		return msg;
		
	}
	
}
